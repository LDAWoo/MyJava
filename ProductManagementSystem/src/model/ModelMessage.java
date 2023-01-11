package model;

public class ModelMessage {
	private String icon;
	private String name;
	private String comment;
	private String bieuTuong;
	private String email;
	private String time;
	public ModelMessage() {
		// TODO Auto-generated constructor stub
	}

	public ModelMessage(String icon, String name, String comment, String bieuTuong, String email, String time) {
		super();
		this.icon = icon;
		this.name = name;
		this.comment = comment;
		this.bieuTuong = bieuTuong;
		this.email = email;
		this.time = time;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBieuTuong() {
		return bieuTuong;
	}
	public void setBieuTuong(String bieuTuong) {
		this.bieuTuong = bieuTuong;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
