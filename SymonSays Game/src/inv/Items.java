package inv;

import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.interfaces.Clickable;

public class Items  {
	
	private String itemN;
	private int cost;
	

	public Items(String name) {
		this.itemN = name;
	    this.cost = cost;
	}
	public Items() {
	}
	public String toString() {
		return itemN + ", "+ cost;
	}
	public String getItemN() {
		return itemN;
	}
	public void setItemN(String itemN) {
		this.itemN = itemN;
	}
	



}
