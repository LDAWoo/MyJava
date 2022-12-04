package model;

import javax.swing.Icon;

public class ModelMessage {
	private Icon icon;
	private String name;
	private String date;
	private String message;
	
	private String status;

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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ModelMessage(Icon icon, String name, String status) {
		this.icon = icon;
		this.name = name;
		this.status = status;
	}

	public ModelMessage(Icon icon, String name, String date, String message) {
		this.icon = icon;
		this.name = name;
		this.date = date;
		this.message = message;
	}

	public ModelMessage() {

	}
}
