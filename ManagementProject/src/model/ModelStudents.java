package model;

import com.raven.table.model.TableRowData;

import interfaces.EventAction;

public class ModelStudents extends TableRowData{
	
	
	private int ID;
	ModelStudent CodeStudent;
	ModelCourses CodeCourse;
	ModelLearners CodeLearner;
	ModelName name;
	ModelSex gender;
	ModelAge age;
	ModelGrade grade;
	
	
	
	@Override
	public Object[] toTableRow() {
		return new Object[] {CodeStudent,CodeCourse,CodeLearner,name,gender,age,grade};
	}

	public ModelStudents() {
		// TODO Auto-generated constructor stub
	}

	
	

	public ModelStudents(int iD,ModelStudent codeStudent, ModelCourses codeCourse, ModelLearners codeLearner, ModelName name, ModelSex gender,
			ModelAge age, ModelGrade grade) {
		ID = iD;
		CodeStudent = codeStudent;
		CodeCourse = codeCourse;
		CodeLearner = codeLearner;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ModelCourses getCodeCourse() {
		return CodeCourse;
	}

	public void setCodeCourse(ModelCourses codeCourse) {
		CodeCourse = codeCourse;
	}

	public ModelLearners getCodeLearner() {
		return CodeLearner;
	}

	public void setCodeLearner(ModelLearners codeLearner) {
		CodeLearner = codeLearner;
	}

	public ModelName getName() {
		return name;
	}

	public void setName(ModelName name) {
		this.name = name;
	}

	public ModelSex isGender() {
		return gender;
	}

	public void setGender(ModelSex gender) {
		this.gender = gender;
	}

	public ModelAge getAge() {
		return age;
	}

	public void setAge(ModelAge age) {
		this.age = age;
	}

	public ModelGrade getGrade() {
		return grade;
	}

	public void setGrade(ModelGrade grade) {
		this.grade = grade;
	}

	public ModelStudent getCodeStudent() {
		return CodeStudent;
	}

	public void setCodeStudent(ModelStudent codeStudent) {
		CodeStudent = codeStudent;
	}

	public ModelSex getGender() {
		return gender;
	}
	
	
	
}
