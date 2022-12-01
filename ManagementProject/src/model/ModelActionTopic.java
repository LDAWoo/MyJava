package model;

import interfaces.EventActionTopic;

public class ModelActionTopic {
	ModelTopic topic;
	EventActionTopic event;

	public ModelActionTopic(ModelTopic topic, EventActionTopic event) {
		this.topic = topic;
		this.event = event;
	}

	public ModelActionTopic() {

	}

	public ModelTopic getTopic() {
		return topic;
	}

	public void setTopic(ModelTopic topic) {
		this.topic = topic;
	}

	public EventActionTopic getEvent() {
		return event;
	}

	public void setEvent(EventActionTopic event) {
		this.event = event;
	}
	
	

}
