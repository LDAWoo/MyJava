package model;

import interfaces.EventActionTopic;

public class ModelTopic {
	private String CodeTopic;
	private String NameTopic;
	private Double Tuition;
	private Integer Time;
	private String Describer;
	private String Logo;

	
	public Object[] toRowTable(EventActionTopic event) {
		return new Object[] {
				CodeTopic, NameTopic, Tuition, Time, Describer, Logo, new ModelActionTopic(this, event)
		};
	}
		

	
	public ModelTopic() {
		
	}
	
	
	public ModelTopic(String codeTopic, String nameTopic, Double tuition, Integer time, String describer, String logo) {
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


	public String getDescriber() {
		return Describer;
	}


	public void setDescriber(String describer) {
		Describer = describer;
	}


	public String getLogo() {
		return Logo;
	}


	public void setLogo(String logo) {
		Logo = logo;
	}
	
	
	
}
