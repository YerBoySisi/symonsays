package inv;

import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.interfaces.Clickable;

public class Items  {
	
	private String itemN;
	private int amount;
	

	public Items(String name) {
		this.itemN = name;
		this.amount = amount;
	}
	public String toString() {
		return itemN + ", "+ amount;
	}



}
