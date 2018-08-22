package com.kungfu.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUD_ATTENDANCE")
public class StudentAttendance {
	
	@Id
	@Column(name="satt_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="satt_stu_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="satt_att_id")
	private Attendance attendance;
	
	@Column(name="satt_date_attended")
	private Date dateAttended;

	public StudentAttendance(){
		
	}

	public StudentAttendance(Date dateAttended) {
		super();
		this.dateAttended = dateAttended;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public Date getDateAttended() {
		return dateAttended;
	}

	public void setDateAttended(Date dateAttended) {
		this.dateAttended = dateAttended;
	}

	@Override
	public String toString() {
		return "StudentAttendance [id=" + id + ", dateAttended=" + dateAttended + "]";
	}
	
		
}
