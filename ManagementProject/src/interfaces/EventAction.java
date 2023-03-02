package interfaces;

import model.ModelStudents;

public interface EventAction {
	
	public void Delete(ModelStudents event);
	public void Edit(ModelStudents event);
}
