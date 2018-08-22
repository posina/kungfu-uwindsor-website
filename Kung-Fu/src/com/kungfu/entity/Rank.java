package com.kungfu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RANK_MASTER")
public class Rank {
	
	@Id
	@Column(name="rank_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="belt")
	private String belt;
	
	@OneToMany(mappedBy="rank",
			cascade={CascadeType.DETACH,CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH})
	private List<StudentProgress> studentProgress;
	
	public Rank(){
		
	}

	public Rank(int id, String belt) {
		super();
		this.id = id;
		this.belt = belt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBelt() {
		return belt;
	}

	public void setBelt(String belt) {
		this.belt = belt;
	}

	public List<StudentProgress> getStudentProgress() {
		return studentProgress;
	}

	public void setStudentProgress(List<StudentProgress> studentProgress) {
		this.studentProgress = studentProgress;
	}

	@Override
	public String toString() {
		return "Rank [id=" + id + ", belt=" + belt + "]";
	}
	
		
}
