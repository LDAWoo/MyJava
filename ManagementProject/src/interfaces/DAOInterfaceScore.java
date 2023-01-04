package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceScore<EntityType>{
	
	public ArrayList<EntityType> SelectScoreStudents(String email);
}
