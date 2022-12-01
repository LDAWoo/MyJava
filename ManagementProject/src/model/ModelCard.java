package model;

import javax.swing.Icon;

public class ModelCard {
	private String Title;
	private int Values;
	private int percentage;
	private Icon icon;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getValues() {
		return Values;
	}
	public void setValues(int values) {
		Values = values;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	public ModelCard(String title, int values, int percentage, Icon icon) {
		Title = title;
		Values = values;
		this.percentage = percentage;
		this.icon = icon;
	}

	public ModelCard() {

	}
	
	
	
}
