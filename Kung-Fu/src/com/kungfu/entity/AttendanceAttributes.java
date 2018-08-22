package com.kungfu.entity;

import java.sql.Date;

public class AttendanceAttributes {

	private String level;
	
	private String rank;
	
	private String day;
	
	private String time;
	
	private Date dateAttended;
	
	public AttendanceAttributes(){
		
	}

	public AttendanceAttributes(String level, String rank, String day, String time, Date dateAttended) {
		super();
		this.level = level;
		this.rank = rank;
		this.day = day;
		this.time = time;
		this.dateAttended = dateAttended;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDateAttended() {
		return dateAttended;
	}

	public void setDateAttended(Date dateAttended) {
		this.dateAttended = dateAttended;
	}
	
}
