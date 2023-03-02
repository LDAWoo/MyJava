package model;

public class ModelGrade {
	private Double grade;

	public double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}


	public ModelGrade(Double grade) {
		this.grade = grade;
	}
	
	public ModelGrade() {
		
	}
	@Override
	public String toString() {
		return grade +"";
	}
}
