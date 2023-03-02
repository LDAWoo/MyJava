package model;

import javax.swing.Icon;

public class ModelMenu {
	private Icon icon;
	private String menuName;
	private int index;
	private String[] subMenu;
	
	public ModelMenu(Icon icon, String menuName,int index, String... subMenu) {
		this.icon = icon;
		this.index = index;
		this.menuName = menuName;
		this.subMenu = subMenu;
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

	public String[] getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String[] subMenu) {
		this.subMenu = subMenu;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
}
