package componentsStudent;

public class ModelAge {
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public ModelAge(String age) {
		this.age = age;
	}


	public ModelAge() {

	}
	
	@Override
	public String toString() {
		return age;
	}
	
}
