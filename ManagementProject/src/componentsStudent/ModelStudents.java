package componentsStudent;

import com.raven.table.model.TableRowData;

import interfaces.EventAction;

public class ModelStudents extends TableRowData{
	
	
	private int ID;
	ModelStudent CodeStudent;
	ModelCourse CodeCourse;
	ModelLearner CodeLearner;
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

	
	

	public ModelStudents(int iD,ModelStudent codeStudent, ModelCourse codeCourse, ModelLearner codeLearner, ModelName name, ModelSex gender,
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

	public ModelCourse getCodeCourse() {
		return CodeCourse;
	}

	public void setCodeCourse(ModelCourse codeCourse) {
		CodeCourse = codeCourse;
	}

	public ModelLearner getCodeLearner() {
		return CodeLearner;
	}

	public void setCodeLearner(ModelLearner codeLearner) {
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
