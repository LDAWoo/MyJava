package model;

public class ModelInformation {
	private String fullName;
	private String codeStudent;
	private boolean sex;
	private String email;
	private String phoneNumber;
	private String status;
	private String addRess;
	private String codeAccount;
	private String course;
	private String Specialized;
	private String registrationDate;
	
	

	public ModelInformation(String fullName, String codeStudent, boolean sex, String email, String phoneNumber,
			String status, String addRess, String codeAccount, String course, String specialized,
			String registrationDate) {
		this.fullName = fullName;
		this.codeStudent = codeStudent;
		this.sex = sex;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.addRess = addRess;
		this.codeAccount = codeAccount;
		this.course = course;
		Specialized = specialized;
		this.registrationDate = registrationDate;
	}




	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public String getCodeStudent() {
		return codeStudent;
	}




	public void setCodeStudent(String codeStudent) {
		this.codeStudent = codeStudent;
	}




	public boolean isSex() {
		return sex;
	}




	public void setSex(boolean sex) {
		this.sex = sex;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getAddRess() {
		return addRess;
	}




	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}




	public String getCodeAccount() {
		return codeAccount;
	}




	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}




	public String getCourse() {
		return course;
	}




	public void setCourse(String course) {
		this.course = course;
	}




	public String getSpecialized() {
		return Specialized;
	}




	public void setSpecialized(String specialized) {
		Specialized = specialized;
	}




	public String getRegistrationDate() {
		return registrationDate;
	}




	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}




	public ModelInformation() {
	
	}
	
	
	
	
}
