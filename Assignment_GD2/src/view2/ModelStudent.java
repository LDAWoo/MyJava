package view2;

import java.text.DecimalFormat;

import javax.swing.Icon;

public class ModelStudent {
	private int ID;
	private String Name;
	private String Code;;
	private double English;
	private double InForTechnology;
	private double Pysical;
	private double MediumScore;
	
	
	public Object[] toRowTable(EventAction event) {
		return new Object[] {
				ID,Code,Name,English,InForTechnology,Pysical,MediumScore,new ModelAction(this,event)
		};
	}
	
	
	
	
	public ModelStudent(int iD, String code, String name, double english, double inForTechnology,
			double pysical, double mediumScore) {
		ID = iD;
		Name = name;
		Code = code;
		English = english;
		InForTechnology = inForTechnology;
		Pysical = pysical;
		MediumScore = mediumScore;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
	
	public ModelStudent() {
		
	}
	
	
	
}
