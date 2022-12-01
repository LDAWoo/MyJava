package model;

public class ManagerStudentModel {
	private String Code;
	private String Name;
	private String Email;
	private String PhoneNumber;
	private boolean Sex;
	private String Address;
	private String Img;

	public ManagerStudentModel() {
		super();
	}

	public ManagerStudentModel(String code, String name, String email, String phoneNumber, boolean sex, String address,
			String img) {
		super();
		Code = code;
		Name = name;
		Email = email;
		PhoneNumber = phoneNumber;
		Sex = sex;
		Address = address;
		Img = img;
	}
	
	public ManagerStudentModel(String code, String name, String email, String phoneNumber, boolean sex, String address
			) {
		Code = code;
		Name = name;
		Email = email;
		PhoneNumber = phoneNumber;
		Sex = sex;
		Address = address;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public boolean isSex() {
		return Sex;
	}

	public void setSex(boolean sex) {
		Sex = sex;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}
	
	
}
