package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceStaticalRevenue<EntityType, KeyType> {
	public ArrayList<EntityType> SelectAll(KeyType K);
}
