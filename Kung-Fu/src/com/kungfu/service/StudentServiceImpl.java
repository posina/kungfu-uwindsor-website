
package com.kungfu.service;

import com.kungfu.dao.StudentDao;
import com.kungfu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getStudents();
    }

    @Override
    @Transactional
    public Student saveStudentDetails(Student theStudent, int rank, String level) {
        Date currentDate = getCurrentDate();
        theStudent.setJoinDate(currentDate);
        theStudent = studentDao.saveStudent(theStudent, rank, level);
        return theStudent;
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.getTime().getTime());
    }

    @Override
    @Transactional
    public String captureAttendanceInfo(int studentId) {
        String today = getToday();
        int timeNow = getCurrentTime();
        List<Attendance> todayAttendance = studentDao.getTimeTableForToday(today);
        for (Attendance schedule : todayAttendance) {
            String time = schedule.getTime();
            int fromTime = Integer.parseInt(time.substring(0, 2));
            int toTime = Integer.parseInt(time.substring(6, time.length() - 3));

            if (timeNow == fromTime || timeNow == toTime) {
                Boolean checkDuplicateAttendance = studentDao.checkDuplicateAttendance(studentId, schedule.getId());
                if (!checkDuplicateAttendance) {
                    studentDao.recordAttendance(studentId, schedule);
                    return "Attendance Recorded Successfully";
                } else {
                    return "Attendance already Recorded";
                }
            }
        }
        return "Out of Class hours";
    }

    public static String getToday() {
        Calendar c = Calendar.getInstance();
        return c.getTime().toString().substring(0, 3);
    }

    public static int getCurrentTime() {
        Calendar c = Calendar.getInstance();
        return Integer.parseInt(c.getTime().toString().substring(11, 13));
    }

    @Override
    @Transactional
    public List<Student> searchForStudent(String searchString) {
        return studentDao.searchStudent(searchString);
    }

    @Override
    @Transactional
    public Student getStudentDetails(int studentId) {
        return studentDao.getStudentDetails(studentId);
    }

    @Override
    @Transactional
    public String addFinancialInfo(int studentId, int serviceCatalogueId) {
        return "Captured Financial Information for Student : " + studentDao.addPayments(studentId, serviceCatalogueId);
    }


    @Override
    @Transactional
    public List<AttendanceAttributes> getStudentAttendanceDetails(Student theStudent) {
        List<StudentAttendance> theStudentAttendance = studentDao.getStudentAttendanceSummary(theStudent);
        List<AttendanceAttributes> attendance = new ArrayList<>();
        for (StudentAttendance attend : theStudentAttendance) {
            AttendanceAttributes tmpAtt = new AttendanceAttributes();
            tmpAtt.setLevel(attend.getAttendance().getLevel());
            tmpAtt.setRank(attend.getAttendance().getRank());
            tmpAtt.setDay(attend.getAttendance().getDay());
            tmpAtt.setTime(attend.getAttendance().getTime());
            tmpAtt.setDateAttended(attend.getDateAttended());
            attendance.add(tmpAtt);
        }
        return attendance;
    }

    @Override
    public List<ProgressAttributes> getStudentProgressSummary(Student theStudent) {
        List<StudentProgress> progress = theStudent.getStudentProgress();
        List<ProgressAttributes> theProgress = new ArrayList<>();
        for (StudentProgress prog : progress) {
            ProgressAttributes tmpProg = new ProgressAttributes();
            tmpProg.setStudentId(theStudent.getId());
            tmpProg.setProgressId(prog.getId());
            tmpProg.setRank(prog.getRank().getBelt());
            tmpProg.setLevel(prog.getLevel());
            tmpProg.setDateAwarded(prog.getDateAwarded());
            theProgress.add(tmpProg);
        }
        return theProgress;
    }

    @Override
    @Transactional
    public String awardBelt(int studentId, int progressId) {
        return studentDao.awardBelt(studentId, progressId);
    }

    @Override
    @Transactional
    public List<FinanceAttributes> searchFinanceRange(Student theStudent,
                                                      Date fromDate, Date toDate) {
        List<AccountSummary> theAccountSummary = studentDao.searchFinanceRange(theStudent, fromDate, toDate);
        return getFinanceAttributes(theStudent, theAccountSummary);
    }


    @Override
    @Transactional
    public List<FinanceAttributes> getStudentFinancialDetails(Student theStudent) {
        List<AccountSummary> theAccountSummary = studentDao.getStudentAccountSummary(theStudent);
        return getFinanceAttributes(theStudent, theAccountSummary);
    }


    private List<FinanceAttributes> getFinanceAttributes(Student theStudent, List<AccountSummary> theAccountSummary) {
        List<FinanceAttributes> finances = new ArrayList<>();
        for (AccountSummary acc : theAccountSummary) {
            FinanceAttributes tmpFin = new FinanceAttributes();
            tmpFin.setStudentId(theStudent.getId());
            tmpFin.setCategory(acc.getPayments().getCategory());
            tmpFin.setSubCategory(acc.getPayments().getSubCategory());
            tmpFin.setFees(acc.getPayments().getFees());
            tmpFin.setDatePaid(acc.getDatePaid());
            finances.add(tmpFin);
        }
        return finances;
    }


    @Override
    public Boolean verifyAge(String dob) {
        String date = dob.substring(0, 10);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date newDate = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(newDate);
            int age = getAge(cal);
            return age <= 18;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //returns age if provided a date
    public static int getAge(Calendar dob) {
        Calendar today = Calendar.getInstance();
        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);
        int age = curYear - dobYear;
        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) { // this year can't be counted!
            age--;
        } else if (dobMonth == curMonth) { // same month? check for day
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) { // this year can't be counted!
                age--;
            }
        }
        return age;
    }

}


