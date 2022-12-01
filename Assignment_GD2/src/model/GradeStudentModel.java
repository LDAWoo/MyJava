package model;

public class GradeStudentModel {
	private int ID;
	private String Name;
	private String Code;;
	private double English;
	private double InForTechnology;
	private double Pysical;
	private double MediumScore;


	public GradeStudentModel(int id, String code,String name, double english, double inForTechnology, double pysical,
			double mediumScore) {
		ID = id;
		Code = code;
		Name = name;
		English = english;
		InForTechnology = inForTechnology;
		Pysical = pysical;
		MediumScore = mediumScore;
	}

	public GradeStudentModel(String code,String name, double english, double inForTechnology, double pysical,
			double mediumScore) {
		Code = code;
		Name = name;
		English = english;
		InForTechnology = inForTechnology;
		Pysical = pysical;
		MediumScore = mediumScore;
	}
	
	public GradeStudentModel(String code, double english, double inForTechnology, double pysical) {
		Code = code;
		English = 0;
		InForTechnology = 0;
		Pysical = 0;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public double getEnglish() {
		return English;
	}

	public void setEnglish(double english) {
		English = english;
	}

	public double getInForTechnology() {
		return InForTechnology;
	}

	public void setInForTechnology(double inForTechnology) {
		InForTechnology = inForTechnology;
	}

	public double getPysical() {
		return Pysical;
	}

	public void setPysical(double pysical) {
		Pysical = pysical;
	}

	public double getMediumScore() {
		return MediumScore;
	}

	public void setMediumScore(double mediumScore) {
		MediumScore = mediumScore;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
	
}
