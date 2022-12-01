package model;

import interfaces.EventActionCourses;
import view.ActionCourses;

public class ModelActionCourses {
	ModelCourse course;
	EventActionCourses event;

	public ModelActionCourses(ModelCourse course, EventActionCourses event) {
		this.course = course;
		this.event = event;
	}

	public ModelCourse getCourse() {
		return course;
	}

	public void setCourse(ModelCourse course) {
		this.course = course;
	}

	public EventActionCourses getEvent() {
		return event;
	}

	public void setEvent(EventActionCourses event) {
		this.event = event;
	}
	
	
	
	
	
}
