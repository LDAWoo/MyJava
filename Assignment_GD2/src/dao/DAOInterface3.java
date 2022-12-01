package dao;

import java.util.ArrayList;

public interface DAOInterface3<D> {
	
	public int Delete(String Code);

	
	public int Update(String Code,String Name, String Email, String PhoneNumber,
			boolean Sex,String Address);

	public ArrayList<D> SelectAll();

}
