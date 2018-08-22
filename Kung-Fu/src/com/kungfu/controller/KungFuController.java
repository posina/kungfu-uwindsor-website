package com.kungfu.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.kungfu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kungfu.entity.Payments;
import com.kungfu.service.FinanceService;
import com.kungfu.service.StudentService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Controller
@RequestMapping("/kungfu")
@Component
public class KungFuController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FinanceService financeService;

    @Value("#{ranks}")
    private Map<String, String> ranks;

    @GetMapping("list")
    public String listStudents(Model theModel) {
        List<Student> students = studentService.getAllStudents();
        theModel.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("ranks", ranks);
        theModel.addAttribute("theStudent", theStudent);
        return "student-form";
    }

    @GetMapping("/showStudentDetails")
    public String showStudentDetails(@ModelAttribute("studentId") int studentId,
                                     Model theModel) {
        Student theStudent = studentService.getStudentDetails(studentId);
        theModel.addAttribute("theStudent", theStudent);
        return "student-details";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("theStudent") Student theStudent,
                              HttpServletRequest request, BindingResult theBindingResult,
                              Model theModel) {
        String level = request.getParameter("level");
        int rank = Integer.parseInt(request.getParameter("rank"));
        theStudent = studentService.saveStudentDetails(theStudent, rank, level);
        Boolean underAge = studentService.verifyAge(theStudent.getDob());
        if (underAge && theStudent.getPrimaryContact() == null) {
            theModel.addAttribute("theStudent", theStudent);
            return "under-age";
        } else {
            if (theBindingResult.hasErrors()) {
                return "student-form";
            } else {
                return "redirect:/kungfu/list";
            }
        }
    }

    @GetMapping("/captureAttendance")
    public String captureAttendance(@ModelAttribute("studentId") int studentId,
                                   Model theModel) {
        Student theStudent = new Student();
        theStudent.setId(studentId);
        String result = studentService.captureAttendanceInfo(studentId);
        theModel.addAttribute("result", result);
        return "redirect:/kungfu/list?result=" + result;
    }

    @PostMapping("/searchForStudent")
    public String searchForStudent(@ModelAttribute("theSearchString") String searchString,
                                Model theModel) {
        List<Student> students = studentService.searchForStudent(searchString);
        theModel.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/showPaymentDetails")
    public String showPayments(@ModelAttribute("studentId") int studentId,
                               Model theModel) {
        List<Payments> payments = financeService.getFinancialDetails();
        Student student = studentService.getStudentDetails(studentId);
        theModel.addAttribute("services", payments);
        theModel.addAttribute("student", student);
        return "finance-form";
    }

    @GetMapping("/showAchievements")
    public String showAchievements(@ModelAttribute("studentId") int studentId
            , Model theModel) {
        Student theStudent = studentService.getStudentDetails(studentId);
        List<ProgressAttributes> theStudentProgress = studentService.getStudentProgressSummary(theStudent);
        theModel.addAttribute("theStudentProgress", theStudentProgress);
        return "student-progress-form";

    }

    @PostMapping("/awardBelt")
    public String awardBelt(@ModelAttribute("progressId") int progressId
            , @ModelAttribute("studentId") int studentId, Model theModel) throws MySQLIntegrityConstraintViolationException {
        String result = studentService.awardBelt(studentId, progressId);
        return "redirect:/kungfu/list?result=" + result;
    }

    @GetMapping("/addPayments")
    public String addPayments(@ModelAttribute("studentId") int studentId,
                              @ModelAttribute("serviceId") int serviceCatalogueId, Model theModel) {
        String result = studentService.addFinancialInfo(studentId, serviceCatalogueId);
        return "redirect:/kungfu/list?result=" + result;
    }

    @GetMapping("/getStudentFinances")
    public String getStudentFinances(@ModelAttribute("studentId") int studentId,
                                     Model theModel) {
        Student theStudent = studentService.getStudentDetails(studentId);
        List<FinanceAttributes> finances = studentService.getStudentFinancialDetails(theStudent);
        theModel.addAttribute("theAccountSummary", finances);
        return "student-finances";
    }

    @GetMapping("/searchFinanceRange")
    public String searchFinanceRange(@ModelAttribute("studentId") int studentId,
                                     @ModelAttribute("fromDate") Date fromDate,
                                     @ModelAttribute("toDate") Date toDate,
                                     Model theModel) {
        Student theStudent = studentService.getStudentDetails(studentId);
        List<FinanceAttributes> finances = studentService.searchFinanceRange(theStudent, fromDate, toDate);
        theModel.addAttribute("theAccountSummary", finances);
        return "student-finances";
    }


    @GetMapping("/getStudentAttendance")
    public String getStudentAttendance(@ModelAttribute("studentId") int studentId,
                                       Model theModel) {
        Student theStudent = studentService.getStudentDetails(studentId);
        List<AttendanceAttributes> attendance = studentService.getStudentAttendanceDetails(theStudent);
        theModel.addAttribute("theStudentAttendance", attendance);
        return "student-attendance";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
