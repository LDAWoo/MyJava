package model;

public class ModelStaticalTableScoreGetCourse {
	private String codeCourse;
	private String codeTopic;
	private String dayOpening;

	public ModelStaticalTableScoreGetCourse(String codeCourse, String codeTopic, String dayOpening) {
		this.codeCourse = codeCourse;
		this.codeTopic = codeTopic;
		this.dayOpening = dayOpening;
	}

	public String getCodeCourse() {
		return codeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		this.codeCourse = codeCourse;
	}

	public String getCodeTopic() {
		return codeTopic;
	}

	public void setCodeTopic(String codeTopic) {
		this.codeTopic = codeTopic;
	}

	public String getDayOpening() {
		return dayOpening;
	}

	public void setDayOpening(String dayOpening) {
		this.dayOpening = dayOpening;
	}
	
	public ModelStaticalTableScoreGetCourse() {
		// TODO Auto-generated constructor stub
	}
	
}
