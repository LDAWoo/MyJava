package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceLearner<EntityType, Keytype>{
	
	public int Insert(EntityType E);
	
	public int Update(EntityType E);
	
	public int Delete(Keytype K);
	
	public ArrayList<EntityType> SelectAll();
	
	public ArrayList<EntityType> FindById(Keytype K);
	
	public ArrayList<EntityType> SelectBySql(String sql, Object... args);
	
	
 }
