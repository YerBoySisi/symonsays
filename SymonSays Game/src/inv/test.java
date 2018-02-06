package inv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shopmenu.ShopMain;

public class test {
	public static void main(String[] args) {
		
        
        
        ArrayList<Items> itemL = new ArrayList<Items>();
        itemL.add(new Items("001","100"));
        itemL.add(new Items("002","100"));
        itemL.add(new Items("Def","100"));
        itemL.add(new Items("Def","100"));
        itemL.add(new Items("004","100"));
        itemL.add(new Items("Def","100"));
 
        //Get the occurrence of "new Employee("003", "Sahana")" from empLists
        int itemCount = Collections.frequency(itemL, new Items("Def","100"));
        System.out.println("Count of this item is : " +itemCount);
	}
}
