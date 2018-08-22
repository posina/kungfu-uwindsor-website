package com.kungfu.entity;

import java.sql.Date;

public class ProgressAttributes {
	
	private int studentId;
	
	private int progressId;
	
	private String rank;
	
	private String level;
	
	private Date dateAwarded;
	
	public ProgressAttributes(){
		
	}

	public ProgressAttributes(int studentId, int progressId, String rank, String level, Date dateAwarded) {
		super();
		this.studentId = studentId;
		this.progressId = progressId;
		this.rank = rank;
		this.level = level;
		this.dateAwarded = dateAwarded;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getProgressId() {
		return progressId;
	}

	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
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
		return "ProgressAttributes [studentId=" + studentId + ", progressId=" + progressId + ", rank=" + rank
				+ ", level=" + level + ", dateAwarded=" + dateAwarded + "]";
	}
}
