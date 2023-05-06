package com.entity;

public class Doctor {
	private int id;
	private String name;
	private int age;
	private String specialisation;
	private int experience;
	private String availability;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor( String name, int age, String specialisation, int experience, String availability) {
		super();
		
		this.name = name;
		this.age = age;
		this.specialisation = specialisation;
		this.experience = experience;
		this.availability = availability;
	}
	
	public Doctor(int id, String name, int age, String specialisation, int experience, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.specialisation = specialisation;
		this.experience = experience;
		this.availability = availability;
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
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
		
}
