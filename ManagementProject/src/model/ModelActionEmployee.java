package model;

import interfaces.EventActionEmployee;

public class ModelActionEmployee {
	ModelEmployee employee;
	EventActionEmployee event;

	public ModelActionEmployee(ModelEmployee employee, EventActionEmployee event) {
		this.employee = employee;
		this.event = event;
	}
	
	public ModelActionEmployee() {
		
	}

	public ModelEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(ModelEmployee employee) {
		this.employee = employee;
	}

	public EventActionEmployee getEvent() {
		return event;
	}

	public void setEvent(EventActionEmployee event) {
		this.event = event;
	}
	
	
}	
