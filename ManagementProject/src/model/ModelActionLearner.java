package model;

import interfaces.EventActionLeaner;

public class ModelActionLearner {
	ModelLearner learner;
	EventActionLeaner event;
	
	
	public ModelLearner getLearner() {
		return learner;
	}
	public void setLearner(ModelLearner learner) {
		this.learner = learner;
	}
	public EventActionLeaner getEvent() {
		return event;
	}
	public void setEvent(EventActionLeaner event) {
		this.event = event;
	}

	public ModelActionLearner() {
		
	}
	
	public ModelActionLearner(ModelLearner learner, EventActionLeaner event) {
		this.learner = learner;
		this.event = event;
	}
	
	
	
}
