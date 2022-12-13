package model;


public class ModelTopic {
	private String CodeTopic;
	private String NameTopic;
	private double Tuition;
	private int Time;
	private String Describer;
	private byte[] Logo;
		
	public ModelTopic() {
		
	}
	
	public ModelTopic(String codeTopic, String nameTopic, double tuition, int time, String describer, byte[] logo) {
		CodeTopic = codeTopic;
		NameTopic = nameTopic;
		Tuition = tuition;
		Time = time;
		Describer = describer;
		Logo = logo;
	}



	public String getCodeTopic() {
		return CodeTopic;
	}

	public void setCodeTopic(String codeTopic) {
		CodeTopic = codeTopic;
	}

	public String getNameTopic() {
		return NameTopic;
	}

	public void setNameTopic(String nameTopic) {
		NameTopic = nameTopic;
	}

	public double getTuition() {
		return Tuition;
	}

	public void setTuition(double tuition) {
		Tuition = tuition;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}

	public String getDescriber() {
		return Describer;
	}

	public void setDescriber(String describer) {
		Describer = describer;
	}

	public byte[] getLogo() {
		return Logo;
	}

	public void setLogo(byte[] logo) {
		Logo = logo;
	}
	
	
	
}
