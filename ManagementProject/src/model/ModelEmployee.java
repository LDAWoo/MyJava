package model;

import interfaces.EventActionEmployee;

public class ModelEmployee {
	private String CodeEmployee;
	private String Name;
	private String Date;
	private boolean Sex;
	private String Role;
	private String Password;
	private String DateOpening;
	private byte[] img;
	private String Note;
	private String DayOfBirth;
	private String MonthOfBirth;
	private String YearOfBirth;
	
	private String DayOpening;
	private String MonthOpening;
	private String YearOpening;


	public ModelEmployee() {
		
	}

	public ModelEmployee(String codeEmployee, String name, String date, boolean sex,String dateOpening, String role, String password, byte[] img, String note,String dayOfBirth, String monthOfBirth, String yearOfBirth, 
			String dayOpening,String monthOpening,String yearOpening) {
		CodeEmployee = codeEmployee;
		Name = name;
		Date = date;
		Sex = sex;
		Role = role;
		Password = password;
		DateOpening = dateOpening;
		this.img = img;
		Note = note;
		DayOfBirth = dayOfBirth;
		MonthOfBirth = monthOfBirth;
		YearOfBirth = yearOfBirth;
		DayOpening = dayOpening;
		MonthOpening = monthOpening;
		YearOpening = yearOpening;
	}
	
	
	public ModelEmployee(String codeEmployee, String name, String date, boolean sex, String role, String password,String dateOpening,byte[] img
			,  String note) {
		CodeEmployee = codeEmployee;
		Name = name;
		Date = date;
		Sex = sex;
		Role = role;
		Password = password;
		DateOpening = dateOpening;
		this.img = img;
		Note = note;
	}
	public String getCodeEmployee() {
		return CodeEmployee;
	}
	public void setCodeEmployee(String codeEmployee) {
		CodeEmployee = codeEmployee;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public boolean isSex() {
		return Sex;
	}
	public void setSex(boolean sex) {
		Sex = sex;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDateOpening() {
		return DateOpening;
	}
	public void setDateOpening(String dateOpening) {
		DateOpening = dateOpening;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}

	public String getDayOpening() {
		return DayOpening;
	}

	public void setDayOpening(String dayOpening) {
		DayOpening = dayOpening;
	}

	public String getMonthOpening() {
		return MonthOpening;
	}

	public void setMonthOpening(String monthOpening) {
		MonthOpening = monthOpening;
	}

	public String getYearOpening() {
		return YearOpening;
	}

	public void setYearOpening(String yearOpening) {
		YearOpening = yearOpening;
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
	
	
}
