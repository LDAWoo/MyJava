package model;

public class ModelStaticalRevenue {
	private String nameTopic;
	private int numberOfCourse;
	private int countLearner;
	private double revenue;
	private double highestRevenue;
	private double lowestRevenue;
	private double mediumRevenue;
	public String getNameTopic() {
		return nameTopic;
	}
	public void setNameTopic(String nameTopic) {
		this.nameTopic = nameTopic;
	}
	public int getNumberOfCourse() {
		return numberOfCourse;
	}
	public void setNumberOfCourse(int numberOfCourse) {
		this.numberOfCourse = numberOfCourse;
	}
	public int getCountLearner() {
		return countLearner;
	}
	public void setCountLearner(int countLearner) {
		this.countLearner = countLearner;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getHighestRevenue() {
		return highestRevenue;
	}
	public void setHighestRevenue(double highestRevenue) {
		this.highestRevenue = highestRevenue;
	}
	public double getLowestRevenue() {
		return lowestRevenue;
	}
	public void setLowestRevenue(double lowestRevenue) {
		this.lowestRevenue = lowestRevenue;
	}
	public double getMediumRevenue() {
		return mediumRevenue;
	}
	public void setMediumRevenue(double mediumRevenue) {
		this.mediumRevenue = mediumRevenue;
	}

	public ModelStaticalRevenue(String nameTopic, int numberOfCourse, int countLearner, double revenue,
			double highestRevenue, double lowestRevenue, double mediumRevenue) {
		this.nameTopic = nameTopic;
		this.numberOfCourse = numberOfCourse;
		this.countLearner = countLearner;
		this.revenue = revenue;
		this.highestRevenue = highestRevenue;
		this.lowestRevenue = lowestRevenue;
		this.mediumRevenue = mediumRevenue;
	}
	
	public ModelStaticalRevenue() {
		// TODO Auto-generated constructor stub
	}
}
