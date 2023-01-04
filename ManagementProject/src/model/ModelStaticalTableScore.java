package model;

public class ModelStaticalTableScore {
	private String codeLearner;
	private String fullName;
	private double point;
	private String classification;
	
	public String getCodeLearner() {
		return codeLearner;
	}
	public void setCodeLearner(String codeLearner) {
		this.codeLearner = codeLearner;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getClassification() {
		if(point >= 9) {
			return "Xuất sắc";
		}else if(point >= 8) {
			return "Giỏi";
		}else if(point >= 8) {
			return "Giỏi";
		}else if(point >= 7) {
			return "Khá";
		}else if(point >= 5) {
			return "Trung bình";
		}else if(point >= 4) {
			return "Yếu";
		}else if(point == -1) {
			return "Chưa nhập";
		}	
		return "Kém";
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}

	public ModelStaticalTableScore(String codeLearner, String fullName, double point, String classification) {
		this.codeLearner = codeLearner;
		this.fullName = fullName;
		this.point = point;
		this.classification = classification;
	}

	public ModelStaticalTableScore() {

	}
	
	
}
