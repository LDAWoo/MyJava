package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceInformation <EntityType>{

	public ArrayList<EntityType> SelectInformation(String email);
}
