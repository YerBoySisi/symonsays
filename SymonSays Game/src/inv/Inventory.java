package inv;

import java.util.ArrayList;






public class Inventory {
	
	public ArrayList<Items> itemlist;
	private int currency;
   
	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public Inventory() {
		itemlist =  new ArrayList<Items>();
		this.currency = 1000;

		
	}
}