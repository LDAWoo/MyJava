package model;

import java.util.Date;

import interfaces.EventActionLeaner;

public class ModelLearner {
	private String personCode;
	private String name;
	private String date;
	private boolean sex;
	private String phoneNumber;
	private String email;
	private String dateOfRegister;
	private String note;
	
	private String DayOfBirth;
	private String MonthOfBirth;
	private String YearOfBirth;
	
	private String DayOfRegister;
	private String MonthOfRegister;
	private String YearOfRegister;
	
	public Object[] toRowTable(EventActionLeaner event) {
		return new Object[] {
				personCode,name,date,sex,phoneNumber,email,dateOfRegister,note, new ModelActionLearner(this,event)
		};
	}
	
	public ModelLearner(String personCode, String name, String date, boolean sex, String phoneNumber, String email,
			String note, String dayOfBirth,String monthOfBirth, String yearOfBirth, String dayOfRegister,String monthOfRegister, String yearOfRegister) {
		this.personCode = personCode;
		this.name = name;
		this.date = date;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
		this.DayOfBirth = dayOfBirth;
		this.MonthOfBirth = monthOfBirth;
		this.YearOfBirth = yearOfBirth;
		this.DayOfRegister = dayOfRegister;
		this.MonthOfRegister =	monthOfRegister;
		this.YearOfRegister = yearOfRegister;
	}
	
	
	public ModelLearner() {
		
	}
	
	public ModelLearner(String personCode, String name, String date, boolean sex, String phoneNumber, String email,String dateOfRegister,
			String note) {
		this.personCode = personCode;
		this.name = name;
		this.date = date;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfRegister = dateOfRegister;
		this.note = note;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDayOfBirth() {
		return DayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		DayOfBirth = dayOfBirth;
	}

	public String getMonthOfBirth() {
		return MonthOfBirth;
	}

	public void setMonthOfBirth(String monthOfBirth) {
		MonthOfBirth = monthOfBirth;
	}

	public String getYearOfBirth() {
		return YearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		YearOfBirth = yearOfBirth;
	}

	public String getDateOfRegister() {
		return dateOfRegister;
	}

	public void setDateOfRegister(String dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}

	public String getDayOfRegister() {
		return DayOfRegister;
	}

	public void setDayOfRegister(String dayOfRegister) {
		DayOfRegister = dayOfRegister;
	}

	public String getMonthOfRegister() {
		return MonthOfRegister;
	}

	public void setMonthOfRegister(String monthOfRegister) {
		MonthOfRegister = monthOfRegister;
	}

	public String getYearOfRegister() {
		return YearOfRegister;
	}

	public void setYearOfRegister(String yearOfRegister) {
		YearOfRegister = yearOfRegister;
	}
	
	
}
