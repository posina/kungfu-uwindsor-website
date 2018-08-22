package com.kungfu.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@Column(name="s_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="s_first_name")
	@NotNull(message="is required")
	private String firstName;
	
	@Column(name="s_last_name")
	@NotNull(message="is required")
	private String lastName;
	
	@Column(name="s_dob")
	@NotNull(message="is required")
	private String dob;
	
	@Column(name="s_join_date")
	private Date joinDate;
	
	@Column(name="s_mobile")
	@NotNull(message="is required")
	@Pattern(regexp="^[0-9]{10}", message="only 10 digits")
	private String mobile;
	
	@Column(name="s_email")
	@NotNull(message="is required")
	private String email;
	
	@Column(name="s_apt_no")
	@Pattern(regexp="^[0-9]", message="only digits")
	private int doorNo;
	
	@Column(name="s_street")
	private String street;
	
	@Column(name="s_city")
	private String city;
	
	@Column(name="s_province")
	private String province;
	
	@Column(name="s_postal_code")
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
	@Column(name="s_primary_contact")
	private String primaryContact;
	
	@Column(name="s_primary_contact_mobile")
	private String primaryContactMobile;
	
	@Column(name="s_primary_contact_email")
	private String primaryContactEmail;
	
	@Column(name="s_secondary_contact")
	private String secondaryContact;
	
	@Column(name="s_secondary_contact_mobile")
	private String secondaryContactMobile;
	
	@Column(name="s_secondary_contact_email")
	private String secondaryContactEmail;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="student", 
			cascade={CascadeType.DETACH,CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH})
	private List<StudentProgress> studentProgress;
	
	public void addStudentProgress(StudentProgress theStudentProgress){
		if(studentProgress==null){
			studentProgress=new ArrayList<>();
		}
		studentProgress.add(theStudentProgress);
		theStudentProgress.setStudent(this);
	}
	
	@OneToMany(mappedBy="student",
			cascade={CascadeType.ALL})
	private List<StudentAttendance> studentAttendance;
	
	public void addStudentAttendance(StudentAttendance theStudentAttendance){
		if(studentAttendance==null){
			studentAttendance=new ArrayList<>();
		}
		studentAttendance.add(theStudentAttendance);
		theStudentAttendance.setStudent(this);
	}
	
	@OneToMany(mappedBy="studentInfo", 
			cascade={CascadeType.ALL})
	private List<AccountSummary> accountSummary;
	
	public void addAccountSummary(AccountSummary theAccountSummary){
		if(accountSummary==null){
			accountSummary=new ArrayList<>();
		}
		accountSummary.add(theAccountSummary);
		theAccountSummary.setStudentInfo(this);
	}
	
	public Student(){
		
	}

	public Student(String firstName, String lastName, String dob, Date joinDate, String mobile, String email,
			int doorNo, String street, String city, String province, String postalCode, String primaryContact,
			String primaryContactMobile, String primaryContactEmail, String secondaryContact,
			String secondaryContactMobile, String secondaryContactEmail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.joinDate = joinDate;
		this.mobile = mobile;
		this.email = email;
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.primaryContact = primaryContact;
		this.primaryContactMobile = primaryContactMobile;
		this.primaryContactEmail = primaryContactEmail;
		this.secondaryContact = secondaryContact;
		this.secondaryContactMobile = secondaryContactMobile;
		this.secondaryContactEmail = secondaryContactEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getPrimaryContactMobile() {
		return primaryContactMobile;
	}

	public void setPrimaryContactMobile(String primaryContactMobile) {
		this.primaryContactMobile = primaryContactMobile;
	}

	public String getPrimaryContactEmail() {
		return primaryContactEmail;
	}

	public void setPrimaryContactEmail(String primaryContactEmail) {
		this.primaryContactEmail = primaryContactEmail;
	}

	public String getSecondaryContact() {
		return secondaryContact;
	}

	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	public String getSecondaryContactMobile() {
		return secondaryContactMobile;
	}

	public void setSecondaryContactMobile(String secondaryContactMobile) {
		this.secondaryContactMobile = secondaryContactMobile;
	}

	public String getSecondaryContactEmail() {
		return secondaryContactEmail;
	}

	public void setSecondaryContactEmail(String secondaryContactEmail) {
		this.secondaryContactEmail = secondaryContactEmail;
	}
	
	

	public List<StudentProgress> getStudentProgress() {
		return studentProgress;
	}

	public void setStudentProgress(List<StudentProgress> studentProgress) {
		this.studentProgress = studentProgress;
	}
	
	
	public List<StudentAttendance> getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(List<StudentAttendance> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	
	
	public List<AccountSummary> getAccountSummary() {
		return accountSummary;
	}

	public void setAccountSummary(List<AccountSummary> accountSummary) {
		this.accountSummary = accountSummary;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", joinDate=" + joinDate + ", mobile=" + mobile + ", email=" + email + ", doorNo=" + doorNo
				+ ", street=" + street + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode
				+ ", primaryContact=" + primaryContact + ", primaryContactMobile=" + primaryContactMobile
				+ ", primaryContactEmail=" + primaryContactEmail + ", secondaryContact=" + secondaryContact
				+ ", secondaryContactMobile=" + secondaryContactMobile + ", secondaryContactEmail="
				+ secondaryContactEmail + "]";
	}
	
}
