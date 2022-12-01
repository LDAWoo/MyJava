package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceEmployee<M>{
	
	public ArrayList<M> SellectALl();
	
	public boolean Insert(M t);
	
	public boolean Update(Object...arg);
	
	public boolean Delete(String Code);
	
	public ArrayList<M> FindByCode(String Code);
	
	public void LoadData(String Code);
	
	public ArrayList<M> SellectALlDayMonthYear();
}
