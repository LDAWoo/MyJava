package interfaces;

import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

public interface DAOCustomersList<EntityType,KeyType>{
	
	public ArrayList<EntityType> SelectAll(); 
	
	public ArrayList<EntityType> SelectByName(KeyType k);
}
