package interfaces;

import java.util.ArrayList;

public interface DAOProductList<EntityType,KeyType> {
	
	public ArrayList<EntityType> SelectAll(); 
	
	public ArrayList<EntityType> SelectByName(KeyType k);
	
	public int delete(KeyType k);
	
	public int update(EntityType e);
}
