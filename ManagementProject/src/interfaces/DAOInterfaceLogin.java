package interfaces;

public interface DAOInterfaceLogin {
	
	public String SellectAll(String email, String password);
	
	public int Insert(String codeStudent, String email, String password, String role);
	
	
	
}
