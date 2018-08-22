package com.kungfu.dao;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import com.kungfu.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> theQuery = currentSession.createQuery("from Student order by firstName,lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public Student saveStudent(Student theStudent, int rank, String level) {
        Session currentSession = sessionFactory.getCurrentSession();
        Rank theRank = currentSession.get(Rank.class, rank);
        if (theStudent.getId() == 0) {
            StudentProgress studentProgress = new StudentProgress(level);
            studentProgress.setRank(theRank);
            theStudent.addStudentProgress(studentProgress);
            currentSession.saveOrUpdate(studentProgress);
        }
        currentSession.saveOrUpdate(theStudent);
        return theStudent;
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();

        return new Date(calendar.getTime().getTime());
    }

    @Override
    public List<Attendance> getTimeTableForToday(String today) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Attendance where day like :day");
        query.setParameter("day", "%" + today + "%");
        //noinspection unchecked
        return (List<Attendance>) query.getResultList();
    }

    @Override
    public void recordAttendance(int studentId, Attendance schedule) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student theStudent = currentSession.get(Student.class, studentId);
        StudentAttendance theStudentAttendance = new StudentAttendance(getCurrentDate());
        theStudentAttendance.setAttendance(schedule);
        theStudent.addStudentAttendance(theStudentAttendance);
        currentSession.save(theStudentAttendance);
        currentSession.save(theStudent);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> searchStudent(String searchString) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Student where firstName like :search " +
                " OR lastName like :search " +
                " OR mobile like :search " +
                " OR email like :search " +
                " OR city like :search " +
                " OR province like :search " +
                " OR postalCode like :search " +
                " OR dob like :search " +
                " OR joinDate like :search order by firstName,lastName"
        );
        query.setParameter("search", "%" + searchString + "%");
        //noinspection unchecked
        return (List<Student>) query.getResultList();
    }

    @Override
    public Boolean checkDuplicateAttendance(int studentId, int attendanceId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student theStudent = currentSession.get(Student.class, studentId);
        Attendance theAttendance = currentSession.get(Attendance.class, attendanceId);
        Query query = currentSession.createQuery("from StudentAttendance sa where sa.student like :studentId "
                + " and sa.attendance like :attendanceId and dateAttended like :currentDate");
        query.setParameter("studentId", theStudent);
        query.setParameter("attendanceId", theAttendance);
        query.setParameter("currentDate", getCurrentDate());
        @SuppressWarnings("unchecked") List<StudentAttendance> studentAttendance = query.getResultList();
        return !studentAttendance.isEmpty();
    }

    @Override
    public Student getStudentDetails(int studentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Student.class, studentId);
    }

    @Override
    public String addPayments(int studentId, int paymentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student theStudent = currentSession.get(Student.class, studentId);
        Payments thePayments = currentSession.get(Payments.class, paymentId);
        AccountSummary accountSummary = new AccountSummary(getCurrentDate());
        accountSummary.setPayments(thePayments);
        theStudent.addAccountSummary(accountSummary);
        currentSession.save(accountSummary);
        currentSession.save(theStudent);
        return theStudent.getFirstName() + " " + theStudent.getLastName();
    }

    @Override
    public List<AccountSummary> getStudentAccountSummary(Student theStudent) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from AccountSummary where studentInfo = :student ");
        query.setParameter("student", theStudent);
        //noinspection unchecked
        return (List<AccountSummary>) query.getResultList();
    }

    @Override
    public List<StudentAttendance> getStudentAttendanceSummary(Student theStudent) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from StudentAttendance sa where sa.student = :student ");
        query.setParameter("student", theStudent);
        //noinspection unchecked
        return (List<StudentAttendance>) query.getResultList();
    }

    @Override
    public String awardBelt(int studentId, int progressId) {
        Session currentSession = sessionFactory.getCurrentSession();
        StudentProgress theProgress = currentSession.get(StudentProgress.class, progressId);
        theProgress.setDateAwarded(getCurrentDate());
        theProgress.setLevel("Advanced");
        int rankId = theProgress.getRank().getId() + 1;
        if (rankId < 10) {
            Student theStudent = currentSession.get(Student.class, studentId);
            StudentProgress newProgress = new StudentProgress("Beginner");
            Rank newRank = currentSession.get(Rank.class, theProgress.getRank().getId() + 1);
            newProgress.setRank(newRank);
            theStudent.addStudentProgress(newProgress);
            currentSession.save(newProgress);
            currentSession.save(theStudent);
        }
        return "New Rank has been Awarded to Student ID :" + studentId ;
    }

    @Override
    public List<AccountSummary> searchFinanceRange(Student theStudent, Date fromDate, Date toDate) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from AccountSummary where studentInfo = :student and "
                + "	datePaid >= :fromDate and datePaid <= :toDate ");
        query.setParameter("student", theStudent);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        //noinspection unchecked
        return (List<AccountSummary>) query.getResultList();
    }

}
