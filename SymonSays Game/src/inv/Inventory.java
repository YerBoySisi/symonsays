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
		itemlist.add(new Items("Def",100));
		itemlist.add(new Items("Def",100));
		this.currency = 1000;

		
	}

	
}
