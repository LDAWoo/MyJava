package view2;

import javax.swing.Icon;

public class Model_Card {
	private Icon icon;
	private String title;
	private String values;
	private String Description;

	public Model_Card() {
		
	}

	public Model_Card(Icon icon, String title, String values, String description) {

		this.icon = icon;
		this.title = title;
		this.values = values;
		Description = description;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
