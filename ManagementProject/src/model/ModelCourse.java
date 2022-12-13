package model;


public class ModelCourse {
	private String CodeCourse;
	private String CodeTopic;
	private Double Tuition;
	private Integer Time;
	private String DayOpening;
	private String DayCreate;
	private String Note;
	private String CreatePerson;
	private String DayOfOpening;
	private String MonthOfOpening;
	private String YearOfOpening;
	
	private String DayOfCreatePerson;
	private String MonthOfCreatePerson;
	private String YearOfCreatePerson;
	
	
	public ModelCourse() {
	}
	
	public ModelCourse(String codeCourse, String codeTopic, Double tuition, Integer time, String dayOpening, String dayCreate, String note,
			String createPerson, String dayOfOpening, String monthOfOpening, String yearOfOpening,
			String dayOfCreatePerson, String monthOfCreatePerson, String yearOfCreatePerson) {
		CodeCourse = codeCourse;
		CodeTopic = codeTopic;
		Tuition = tuition;
		Time = time;
		DayOpening = dayOpening;
		DayCreate = dayCreate;
		CreatePerson = createPerson;
		Note = note;
		DayOfOpening = dayOfOpening;
		MonthOfOpening = monthOfOpening;
		YearOfOpening = yearOfOpening;
		DayOfCreatePerson = dayOfCreatePerson;
		MonthOfCreatePerson = monthOfCreatePerson;
		YearOfCreatePerson = yearOfCreatePerson;
	}
	public String getCodeCourse() {
		return CodeCourse;
	}
	public void setCodeCourse(String codeCourse) {
		CodeCourse = codeCourse;
	}
	public String getCodeTopic() {
		return CodeTopic;
	}
	public void setCodeTopic(String codeTopic) {
		CodeTopic = codeTopic;
	}
	public Double getTuition() {
		return Tuition;
	}
	public void setTuition(Double tuition) {
		Tuition = tuition;
	}
	public Integer getTime() {
		return Time;
	}
	public void setTime(Integer time) {
		Time = time;
	}
	public String getDayOpening() {
		return DayOpening;
	}
	public void setDayOpening(String dayOpening) {
		DayOpening = dayOpening;
	}
	public String getCreatePerson() {
		return CreatePerson;
	}
	public void setCreatePerson(String createPerson) {
		CreatePerson = createPerson;
	}
	public String getDayOfOpening() {
		return DayOfOpening;
	}
	public void setDayOfOpening(String dayOfOpening) {
		DayOfOpening = dayOfOpening;
	}
	public String getMonthOfOpening() {
		return MonthOfOpening;
	}
	public void setMonthOfOpening(String monthOfOpening) {
		MonthOfOpening = monthOfOpening;
	}
	public String getYearOfOpening() {
		return YearOfOpening;
	}
	public void setYearOfOpening(String yearOfOpening) {
		YearOfOpening = yearOfOpening;
	}
	public String getDayOfCreatePerson() {
		return DayOfCreatePerson;
	}
	public void setDayOfCreatePerson(String dayOfCreatePerson) {
		DayOfCreatePerson = dayOfCreatePerson;
	}
	public String getMonthOfCreatePerson() {
		return MonthOfCreatePerson;
	}
	public void setMonthOfCreatePerson(String monthOfCreatePerson) {
		MonthOfCreatePerson = monthOfCreatePerson;
	}
	public String getYearOfCreatePerson() {
		return YearOfCreatePerson;
	}
	public void setYearOfCreatePerson(String yearOfCreatePerson) {
		YearOfCreatePerson = yearOfCreatePerson;
	}

	public String getDayCreate() {
		return DayCreate;
	}

	public void setDayCreate(String dayCreate) {
		DayCreate = dayCreate;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}
	
	
	
}
