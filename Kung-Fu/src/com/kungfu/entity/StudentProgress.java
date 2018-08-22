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
@Table(name="STUD_PROGRESS")
public class StudentProgress {

	@Id
	@Column(name="pr_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="pr_stu_id")
	private Student student;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="pr_stu_rank")
	private Rank rank;
	
	@Column(name="pr_stu_level")
	private String level;
	
	@Column(name="pr_date_awarded")
	private Date dateAwarded;
	
	
	public StudentProgress(){
		
	}


	public StudentProgress(String level, Date dateAwarded) {

		this.level = level;
		this.dateAwarded = dateAwarded;
	}
	
	public StudentProgress(String level) {

		this.level = level;
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


	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public Date getDateAwarded() {
		return dateAwarded;
	}


	public void setDateAwarded(Date dateAwarded) {
		this.dateAwarded = dateAwarded;
	}


	@Override
	public String toString() {
		return "StudentProgress [id=" + id + ", rank=" + rank + ", level=" + level + ", dateAwarded=" + dateAwarded
				+ "]";
	}
	
		
}
