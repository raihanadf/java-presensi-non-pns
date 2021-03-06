package com.presensikeun.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelMenu {

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MenuType getType() {
		return type;
	}

	public void setType(MenuType type) {
		this.type = type;
	}

	public ModelMenu(String icon, String name, MenuType type) {
		this.icon = icon;
		this.name = name;
		this.type = type;
	}

	public ModelMenu() {
	}

	String icon;
	String name;
	private MenuType type;

	public Icon toIcon() {
		return new ImageIcon(getClass().getResource("/com/presensikeun/images/icon/" + icon + ".png"));
	}

	public Icon toIconSelected() {
		return new ImageIcon(getClass().getResource("/com/presensikeun/images/icon/" + icon + "_selected.png"));
	}

	public static enum MenuType {
		MENU, EMPTY
	}
}
