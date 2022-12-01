package model;

import javax.swing.Icon;

public class ModelMenu {
	Icon icon;
	String menuName;
	String sudMenu[];

	public ModelMenu(Icon icon, String menuName, String... sudMenu) {
		this.icon = icon;
		this.menuName = menuName;
		this.sudMenu = sudMenu;
	}

	public ModelMenu() {
	
	}
	
	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String[] getSudMenu() {
		return sudMenu;
	}

	public void setSudMenu(String[] sudMenu) {
		this.sudMenu = sudMenu;
	}
	
	
	
	
}
