package inv;

import java.util.ArrayList;

import shopmenu.GarrettInterface;


public class Inventory implements GarrettInterface{
	
	public ArrayList<Items> itemlist;
	private int currency;
	private int up;
   
	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public Inventory() {
		itemlist =  new ArrayList<Items>();		
	}
}
