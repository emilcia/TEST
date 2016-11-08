package com.example.vaadindemo.domain;

import java.util.UUID;

import com.vaadin.ui.Notification;

public class Person {
	
	private UUID id;
	private String firstName;
	private int yob;
	private String lastName;
	private String address;
	private int phoneNumber;
	private String month;
	private int day;
	private String login;
	private String password;
	
	public Person(String firstName, int yob, String lastName, String address, int phoneNumber, String month, int day, String login, String password) {
		super();
		this.firstName = firstName;
		this.yob = yob;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.month = month;
		this.day = day;
		this.login = login;
		this.password = password;

	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String mounth) {
		this.month = mounth;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", yob=" + yob
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ",]";
	}
	public boolean validPhone(){
		
	if((Integer.toString(getPhoneNumber()).length())>9 || (Integer.toString(getPhoneNumber()).length())<9)
		{
		return false;
		}
	else
		return true;
		
	}
	public boolean validEmail(){
	
			if(getAddress().contains("@"))
			{
				return true;
			}
			else
				return false;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
