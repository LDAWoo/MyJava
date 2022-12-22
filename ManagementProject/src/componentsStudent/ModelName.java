package componentsStudent;

import javax.swing.Icon;

public class ModelName {
	private String FullName;
	
	public ModelName() {
		
	}
	
	public ModelName(String fullName) {
		FullName = fullName;

	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}

	
	@Override
	public String toString() {
		return FullName;
	}
	
}
