package componentsStudent;

public class ModelStudent {
	private String CodeStudent;

	public String getCodeStudent() {
		return CodeStudent;
	}

	public void setCodeStudent(String codeStudent) {
		CodeStudent = codeStudent;
	}

	public ModelStudent(String codeStudent) {
		CodeStudent = codeStudent;
	}
	
	public ModelStudent() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return CodeStudent;
	}
}
