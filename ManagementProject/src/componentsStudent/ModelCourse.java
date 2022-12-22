package componentsStudent;

public class ModelCourse {
	private String CodeCourse;

	public String getCodeCourse() {
		return CodeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		CodeCourse = codeCourse;
	}

	public ModelCourse(String codeCourse) {
		CodeCourse = codeCourse;
	}
	
	public ModelCourse() {
		
	}
	
	@Override
	public String toString() {
		return CodeCourse;
	}
}
