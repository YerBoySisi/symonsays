package inv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shopmenu.ShopMain;

public class test {
	public static void main(String[] args) {
		
		  ArrayList<String> stringLists = new ArrayList<String>();
	        stringLists.add("one");
	        stringLists.add("two");
	        stringLists.add("three");
	        stringLists.add("one");
	        stringLists.add("one");
	 
	        //Get the occurrence of "one" from stringLists
	 
	        int oneCount = Collections.frequency(stringLists, "one");
	        System.out.println("Count of one is:  "+ oneCount);
        
        
        ArrayList<Items> itemL = new ArrayList<Items>();
        itemL.add(new Items("HP"));
        itemL.add(new Items("HP"));
        itemL.add(new Items("Def"));
        itemL.add(new Items("Def"));
        itemL.add(new Items("SPD"));
        itemL.add(new Items("Def"));
 
        int itemCount = countOccurences(itemL,new Items("Def"));
        System.out.println("Count of this item is : " +itemCount);
        System.out.println(itemL.get(3));
	}
	public static int countOccurences(ArrayList<Items> list, Items x) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) { 		      
	          	if(x.getItemN() ==(list.get(i).getItemN())) {
	          		count++;
	          		System.out.println(count);
	          	}
	      }
		return count;
	
		
	}
}
