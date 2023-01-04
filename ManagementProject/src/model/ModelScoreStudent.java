package model;

public class ModelScoreStudent {
	private int id;
	private String period;
	private String semester;
	private String subject;
	private String subjectCode;
	private String conversionCode;
	private String numberOfCredits;
	private double scores;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getConversionCode() {
		return conversionCode;
	}
	public void setConversionCode(String conversionCode) {
		this.conversionCode = conversionCode;
	}
	public String getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(String numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	public double getScores() {
		return scores;
	}
	public void setScores(double scores) {
		this.scores = scores;
	}
	public String getStatus() {
		if(scores >= 5) {
			return "Đạt";
		}
		return "Chưa đạt";
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public ModelScoreStudent(int id, String period, String semester, String subject, String subjectCode,
			String conversionCode, String numberOfCredits, double scores, String status) {

		this.id = id;
		this.period = period;
		this.semester = semester;
		this.subject = subject;
		this.subjectCode = subjectCode;
		this.conversionCode = conversionCode;
		this.numberOfCredits = numberOfCredits;
		this.scores = scores;
		this.status = status;
	}

	public ModelScoreStudent() {

	}
	
	
	
}
