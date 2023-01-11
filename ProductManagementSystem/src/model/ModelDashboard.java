package model;

import javax.swing.Icon;

public class ModelDashboard {
	 private int countCustomers;

	public int getCountCustomers() {
		return countCustomers;
	}

	public void setCountCustomers(int countCustomers) {
		this.countCustomers = countCustomers;
	}


	public ModelDashboard(int countCustomers) {
		this.countCustomers = countCustomers;
	}
	 
	 public ModelDashboard() {
		// TODO Auto-generated constructor stub
	}
}
