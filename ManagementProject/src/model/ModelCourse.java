package model;

import interfaces.EventActionCourses;

public class ModelCourse {
	private String CodeCourse;
	private String CodeTopic;
	private Double Tuition;
	private Integer Time;
	private String DayOpening;
	private String CreatePerson;

	public Object[] toRowTable(EventActionCourses event) {
		return new Object[] {
				CodeCourse,CodeTopic,Tuition,Time,DayOpening,CreatePerson,new ModelActionCourses(this, event)
		};
	}
	
	public ModelCourse(String codeCourse, String codeTopic, Double tuition, Integer time, String dayOpening,
			String createPerson) {
		CodeCourse = codeCourse;
		CodeTopic = codeTopic;
		Tuition = tuition;
		Time = time;
		DayOpening = dayOpening;
		CreatePerson = createPerson;
	}
	
	public ModelCourse() {
		
	}

	public String getCodeCourse() {
		return CodeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		CodeCourse = codeCourse;
	}

	public String getCodeTopic() {
		return CodeTopic;
	}

	public void setCodeTopic(String codeTopic) {
		CodeTopic = codeTopic;
	}

	public Double getTuition() {
		return Tuition;
	}

	public void setTuition(Double tuition) {
		Tuition = tuition;
	}

	public Integer getTime() {
		return Time;
	}

	public void setTime(Integer time) {
		Time = time;
	}

	public String getDayOpening() {
		return DayOpening;
	}

	public void setDayOpening(String dayOpening) {
		DayOpening = dayOpening;
	}

	public String getCreatePerson() {
		return CreatePerson;
	}

	public void setCreatePerson(String createPerson) {
		CreatePerson = createPerson;
	}
	
	
	
	
	
}
