package com.kungfu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENTS")
public class Payments {
	
	@Id
	@Column(name="pay_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="pay_category")
	private String category;
	
	@Column(name="pay_sub_category")
	private String subCategory;
	
	@Column(name="pay_fees")
	private long fees;
	
	@Column(name="pay_description")
	private String description;

	public Payments(){
	}
	
	public Payments(String category, String subCategory, long fees, String description) {
		super();
		this.category = category;
		this.subCategory = subCategory;
		this.fees = fees;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Payments [id=" + id + ", category=" + category + ", subCategory=" + subCategory + ", fees="
				+ fees + ", description=" + description + "]";
	}
	
}
