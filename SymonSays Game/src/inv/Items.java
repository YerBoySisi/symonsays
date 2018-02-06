package inv;

import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.interfaces.Clickable;

public class Items  {
	
	private String itemN;
	private int cost;
	

	public Items(String name,int cost) {
		this.itemN = name;
		
	}
	public String toString() {
		return itemN + ", "+ amount;
	}



}
