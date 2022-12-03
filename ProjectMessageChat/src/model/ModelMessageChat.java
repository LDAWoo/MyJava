package model;

import javax.swing.Icon;

public class ModelMessageChat {
	private Icon icon;
	private String userName;
	private String name;
	private String date;
	private String message;
	

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ModelMessageChat(Icon icon,String username, String name, String date, String message) {
		this.userName = username;
		this.icon = icon;
		this.name = name;
		this.date = date;
		this.message = message;
	}

	public ModelMessageChat() {

	}
}
