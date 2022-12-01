package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceLearner<M>{
	
	public ArrayList<M> SelectAll();
	
	public ArrayList<M> SellectALlDayMonthYear();
	
	public boolean Insert(M m);
	
	public boolean Update(Object... arg);
	
	public boolean Delete(String Code);
	
	public ArrayList<M> FindByCode(String Code);
	
	public void LoadData(String Code);
	
	
 }
