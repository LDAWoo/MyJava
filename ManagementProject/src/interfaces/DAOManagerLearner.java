package interfaces;

import java.util.ArrayList;

public interface DAOManagerLearner <EntityType, KeyType>{

	public int Insert(EntityType E);
	
	public int Update(EntityType E);
	
	public int Delete(KeyType K);
	
	public ArrayList<EntityType> SelectAll();
	
	public ArrayList<EntityType> SelectAllGrade(String code);
	
	public ArrayList<EntityType> SelectAllNoGrade(String code);
	
	public ArrayList<EntityType> SelectBySql(String sql, Object...args);
	

	
}
