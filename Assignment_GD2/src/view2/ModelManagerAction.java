package view2;

public class ModelManagerAction {
	ModelManager manager;
	EventActionManager event;
	
	
	
	public ModelManager getManager() {
		return manager;
	}

	public void setManager(ModelManager manager) {
		this.manager = manager;
	}

	public EventActionManager getEvent() {
		return event;
	}

	public void setEvent(EventActionManager event) {
		this.event = event;
	}

	public ModelManagerAction() {
		
	}

	public ModelManagerAction(ModelManager manager, EventActionManager event) {
		super();
		this.manager = manager;
		this.event = event;
	}

	
	
	
}
