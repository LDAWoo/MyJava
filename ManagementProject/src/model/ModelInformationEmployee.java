package model;

public class ModelInformationEmployee {
	private String fullName;
	private String email;
	private String status;
	private String codeEmployee;
	private boolean gender;
	private String addRess;
	private String dayOfBirth;
	private String codeAccount;
	private String dayOfOpening;
	private byte[] img;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return "Đang tham gia";
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCodeEmployee() {
		return codeEmployee;
	}
	public void setCodeEmployee(String codeEmployee) {
		this.codeEmployee = codeEmployee;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAddRess() {
		return addRess;
	}
	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getCodeAccount() {
		return codeAccount;
	}
	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}
	public String getDayOfOpening() {
		return dayOfOpening;
	}
	public void setDayOfOpening(String dayOfOpening) {
		this.dayOfOpening = dayOfOpening;
	}
	

	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public ModelInformationEmployee(String fullName, String email,  String status,
			String codeEmployee, boolean gender, String addRess, String dayOfBirth, String codeAccount,
			String dayOfOpening,byte[] img) {
		this.fullName = fullName;
		this.email = email;
		this.status = status;
		this.codeEmployee = codeEmployee;
		this.gender = gender;
		this.addRess = addRess;
		this.dayOfBirth = dayOfBirth;
		this.codeAccount = codeAccount;
		this.dayOfOpening = dayOfOpening;
		this.img =img;
	}
	
	public ModelInformationEmployee() {
		// TODO Auto-generated constructor stub
	}
	
}
