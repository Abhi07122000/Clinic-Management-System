package com.entity;

public class Appointment {
	private int id;
	private int userID;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String ailment;
	private int doctorID;
	private String date;
	private int contactno;
	private String status;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(int userID, String name, int age, String gender, String address, String ailment, int doctorID, String date,
			int contactno, String status) {
		super();
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.ailment = ailment;
		this.doctorID = doctorID;
		this.date = date;
		this.contactno = contactno;
		this.status = status;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAilment() {
		return ailment;
	}
	public void setAilment(String ailment) {
		this.ailment = ailment;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
}
