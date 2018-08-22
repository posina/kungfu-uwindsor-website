package com.kungfu.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kungfu.entity.AttendanceAttributes;
import com.kungfu.entity.FinanceAttributes;
import com.kungfu.entity.ProgressAttributes;
import com.kungfu.entity.Student;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
public interface StudentService {

	List<Student> getAllStudents();

	Student saveStudentDetails(Student theStudent, int rank, String level);

	List<Student> searchForStudent(String searchString);

	Student getStudentDetails(int studentId);

	Boolean verifyAge(String dob);

	String captureAttendanceInfo(int studentId);

	String addFinancialInfo(int studentId, int serviceCatalogueId);

	String awardBelt(int studentId, int progressId);

	List<FinanceAttributes> searchFinanceRange(Student theStudent, Date fromDate, Date toDate);

	List<FinanceAttributes> getStudentFinancialDetails(Student theStudent);

	List<AttendanceAttributes> getStudentAttendanceDetails(Student theStudent);

	List<ProgressAttributes> getStudentProgressSummary(Student theStudent);

}
