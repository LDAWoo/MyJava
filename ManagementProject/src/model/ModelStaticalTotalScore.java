package model;

public class ModelStaticalTotalScore {
	private String nameTopic;
	private int countLearner;
	private double lowestScore;
	private double highestScore;
	private double mediumScore;

	public ModelStaticalTotalScore(String nameTopic, int countLearner, double lowestScore, double highestScore,
			double mediumScore) {
		this.nameTopic = nameTopic;
		this.countLearner = countLearner;
		this.lowestScore = lowestScore;
		this.highestScore = highestScore;
		this.mediumScore = mediumScore;
	}
	
	public ModelStaticalTotalScore() {
		// TODO Auto-generated constructor stub
	}

	public String getNameTopic() {
		return nameTopic;
	}

	public void setNameTopic(String nameTopic) {
		this.nameTopic = nameTopic;
	}

	public int getCountLearner() {
		return countLearner;
	}

	public void setCountLearner(int countLearner) {
		this.countLearner = countLearner;
	}

	public double getLowestScore() {
		return lowestScore;
	}

	public void setLowestScore(double lowestScore) {
		this.lowestScore = lowestScore;
	}

	public double getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(double highestScore) {
		this.highestScore = highestScore;
	}

	public double getMediumScore() {
		return mediumScore;
	}

	public void setMediumScore(double mediumScore) {
		this.mediumScore = mediumScore;
	}
	
	
}
