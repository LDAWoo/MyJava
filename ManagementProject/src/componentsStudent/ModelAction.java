package componentsStudent;

import interfaces.EventAction;

public class ModelAction {
	ModelStudents students;
	EventAction event;
	public ModelStudents getStudents() {
		return students;
	}
	public void setStudents(ModelStudents students) {
		this.students = students;
	}
	public EventAction getEvent() {
		return event;
	}
	public void setEvent(EventAction event) {
		this.event = event;
	}

	public ModelAction(ModelStudents students, EventAction event) {
		this.students = students;
		this.event = event;
	}

	public ModelAction() {
	}
	
	
}
