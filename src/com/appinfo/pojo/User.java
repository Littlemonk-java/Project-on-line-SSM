package com.appinfo.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String grade;
	private String jurisdiction;
	private String balance;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date registration;
	private String pwd;
	private String picture;

	public User(){};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public User(int id, String name, String email, String phone, String grade,
			String jurisdiction, String balance, Date registration, String pwd,
			String picture) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.grade = grade;
		this.jurisdiction = jurisdiction;
		this.balance = balance;
		this.registration = registration;
		this.pwd = pwd;
		this.picture = picture;
	}



}
