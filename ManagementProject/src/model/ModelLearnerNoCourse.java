package model;

public class ModelLearnerNoCourse {
	private String codeStudent;
	private String Name;

	

	public ModelLearnerNoCourse(String codeStudent, String name) {
		this.codeStudent = codeStudent;
		Name = name;
	}



	public String getCodeStudent() {
		return codeStudent;
	}



	public void setCodeStudent(String codeStudent) {
		this.codeStudent = codeStudent;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public ModelLearnerNoCourse() {

	}
	
	
}
