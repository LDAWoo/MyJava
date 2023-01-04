package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceStaticalTableScore <EntityType>{

	public ArrayList<EntityType> SelectByCodeCourse(String codeCourse);
}
