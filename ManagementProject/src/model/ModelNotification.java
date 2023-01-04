package model;

public class ModelNotification {
	private int id;
	private String Notification;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNotification() {
		return Notification;
	}
	public void setNotification(String notification) {
		Notification = notification;
	}

	public ModelNotification(int id, String notification) {
		this.id = id;
		Notification = notification;
	}
	public ModelNotification() {
		// TODO Auto-generated constructor stub
	}
}
