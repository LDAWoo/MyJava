package model;

public class ModelStaticalStudent {
	private String year;
	private int countStudent;
	private String first;
	private String last;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getCountStudent() {
		return countStudent;
	}
	public void setCountStudent(int countStudent) {
		this.countStudent = countStudent;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}

	public ModelStaticalStudent(String year, int countStudent, String first, String last) {
		this.year = year;
		this.countStudent = countStudent;
		this.first = first;
		this.last = last;
	}

	public ModelStaticalStudent() {

	}
	
	
	
}
