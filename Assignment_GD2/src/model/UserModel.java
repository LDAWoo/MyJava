package model;

public class UserModel {
	private String Username;
	private String Password;
	private String Role;

	public UserModel(String username, String password,String role) {
		Username = username;
		Password = password;
		Role = role;
	}
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	
	
}
