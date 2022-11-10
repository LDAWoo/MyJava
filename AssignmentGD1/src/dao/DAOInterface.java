package dao;

import java.util.ArrayList;

public interface DAOInterface<D> {
	
	public ArrayList<D> SelectTopThree();
	
	public boolean Insert(D d);
	
	public int Delete(String Code);
	
	public int Update(int ID,String Code,double English,double Technology,double Pysical);
	
	public int Update(String Code,String Name, String Email, String PhoneNumber,
			boolean Sex,String Address, String Img);
	
	public  ArrayList<D> Find(String Code);
	
	public ArrayList<D> FindByCode(D d);
	
	public void LoadData(String Code);
	
	public ArrayList<D> SelectAll();

}
