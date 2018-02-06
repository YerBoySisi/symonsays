package inv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shopmenu.ShopMain;

public class test {
	public static void main(String[] args) {
		
        
        
        ArrayList<Items> itemL = new ArrayList<Items>();
        itemL.add(new Items("001"));
        itemL.add(new Items("002"));
        itemL.add(new Items("Def"));
        itemL.add(new Items("Def"));
        itemL.add(new Items("004"));
        itemL.add(new Items("Def"));
 
        //Get the occurrence of "new Employee("003", "Sahana")" from empLists
        int itemCount = Collections.frequency(itemL, new Items("001"));
        System.out.println("Count of sahana is : " +itemCount);
	}
}
