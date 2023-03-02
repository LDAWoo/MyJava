package model;

public class ModelCourses {
	private String CodeCourse;

	public String getCodeCourse() {
		return CodeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		CodeCourse = codeCourse;
	}

	public ModelCourses(String codeCourse) {
		CodeCourse = codeCourse;
	}
	
	public ModelCourses() {
		
	}
	
	@Override
	public String toString() {
		return CodeCourse;
	}
}
