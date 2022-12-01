package view2;

import java.text.DecimalFormat;

import javax.swing.Icon;

public class ModelManager {
	private String Code;
	private String Name;
	private String Email;
	private String Phone;
	private String Sex;
	private String Address;
	
	
	
	public Object[] toRowTable(EventActionManager event) {
		return new Object[] {
				Code,Name,Email,Phone,Sex,Address,new ModelManagerAction(this,event)
		};
	}


	public ModelManager() {

	}

	public ModelManager(String code, String name, String email, String phone, String sex, String address) {
		Code = code;
		Name = name;
		Email = email;
		Phone = phone;
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


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getSex() {
		return Sex;
	}


	public void setSex(String sex) {
		Sex = sex;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	
	
	
	
	
}
