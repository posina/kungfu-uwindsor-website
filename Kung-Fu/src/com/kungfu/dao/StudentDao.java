package com.kungfu.dao;

import java.sql.Date;
import java.util.List;

import com.kungfu.entity.AccountSummary;
import com.kungfu.entity.Attendance;
import com.kungfu.entity.Student;
import com.kungfu.entity.StudentAttendance;

public interface StudentDao {

    List<Student> getStudents();

    Student saveStudent(Student theStudent, int rank, String level);

    List<Attendance> getTimeTableForToday(String today);

    void recordAttendance(int studentId, Attendance schedule);

    List<Student> searchStudent(String searchString);

    Boolean checkDuplicateAttendance(int studentId, int id);

    Student getStudentDetails(int studentId);

    String addPayments(int studentId, int serviceCatalogueId);

    List<AccountSummary> getStudentAccountSummary(Student theStudent);

    List<StudentAttendance> getStudentAttendanceSummary(Student theStudent);

    String awardBelt(int studentId, int progressId);

    List<AccountSummary> searchFinanceRange(Student theStudent, Date fromDate, Date toDate);

}
