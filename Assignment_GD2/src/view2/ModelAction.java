package view2;

public class ModelAction {
	ModelStudent student;
	EventAction event;

	
	public ModelStudent getStudent() {
		return student;
	}
	public void setStudent(ModelStudent student) {
		this.student = student;
	}
	public EventAction getEvent() {
		return event;
	}
	public void setEvent(EventAction event) {
		this.event = event;
	}

	public ModelAction() {
		
	}

	public ModelAction(ModelStudent student, EventAction event) {
		this.student = student;
		this.event = event;
		
	}
	
	
}
