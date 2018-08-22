package com.kungfu.entity;

import java.sql.Date;

public class FinanceAttributes {
	
	private int studentId;
	
	private String category;
	
	private String subCategory;
	
	private long fees;
	
	private Date datePaid;
	
	public FinanceAttributes(){
		
	}

	public FinanceAttributes(int studentId, String category, String subCategory, long fees, Date datePaid) {
		super();
		this.studentId = studentId;
		this.category = category;
		this.subCategory = subCategory;
		this.fees = fees;
		this.datePaid = datePaid;
	}

	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public long getFees() {
		return fees;
	}

	public void setFees(long fees) {
		this.fees = fees;
	}

	public Date getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	@Override
	public String toString() {
		return "FinanceAttributes [studentId=" + studentId + ", category=" + category + ", subCategory=" + subCategory
				+ ", fees=" + fees + ", datePaid=" + datePaid + "]";
	}
	
}
