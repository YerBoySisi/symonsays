package shopmenu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import inv.Inventory;
import inv.Items;

public class DavidSell extends FullFunctionScreen {
	
	private TextArea title;

	public DavidSell(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//title.setTextColor(Color.WHITE);
		title =  new TextArea(600,50,300,50,"MERCHANT");
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		TextArea quant1 = new TextArea(500,150,300,100,"x0");
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		TextArea quant2 = new TextArea(500,275,300,100,"x0");
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
		TextArea quant3 = new TextArea(500,400,300,100,"x0");
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
		TextArea quant4 = new TextArea(500,525,300,100,"x0");
		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(420, 150, 75,75,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(420, 250, 75,75,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(420, 400, 75,75,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(420, 500, 75,75,"shopUpgradeResources/strength.png"));
		viewObjects.add(new Graphic(1325, 25, 50 , 50,"shopUpgradeResources/coin.png"));
		TextArea currency = new TextArea(1155,25,150,150,"-");
		currency.setCustomTextColor(Color.orange);
		viewObjects.add(title);
		viewObjects.add(desc1);
		viewObjects.add(quant1);
		viewObjects.add(desc2);
		viewObjects.add(quant2);
		viewObjects.add(desc3);
		viewObjects.add(quant3);
		viewObjects.add(desc4);
		viewObjects.add(quant4);
		viewObjects.add(currency);
		//hahaha
		//countOccurences(ShopMain.inventory.itemlist,new Items("Speed"));
		//Integer.toString(count)
		
		Button back = new Button(0,20,125,50,"Back",new Action() {

			
			@Override
			public void act() {
				 ShopMain.s1.setScreen(ShopMain.s2);
			}
		});
		
		back.setForeground(Color.WHITE);
		viewObjects.add(back);
		
		Button buyH = new Button(900, 175, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.add(new Items("Def"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Def"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-100);
				quant1.setText("x"+Integer.toString(count));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Def: " +count);
			  
			}
		});
		buyH.setForeground(Color.GRAY);
		viewObjects.add(buyH);
		Button buyS = new Button(900, 300, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.add(new Items("Health"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Health"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-100);
				quant2.setText("x"+Integer.toString(count));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Health: " +count);
			}
		});
		buyS.setForeground(Color.GRAY);
		viewObjects.add(buyS);
		Button buyR = new Button(900, 425, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.add(new Items("Speed"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Speed"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-100);
				quant3.setText("x"+Integer.toString(count));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Speed: " +count);
			}
		});
		buyR.setForeground(Color.GRAY);
		viewObjects.add(buyR);
		Button buyHM = new Button(900, 525, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.add(new Items("Revive"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Revive"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-100);
				quant4.setText(Integer.toString(count));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Revive: " +count);
			}
		});
		buyHM.setForeground(Color.GRAY);
		viewObjects.add(buyHM);
		
	}
	
	public static int countOccurences(ArrayList<Items> list, Items x) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) { 		      
	          	if(x.getItemN() ==(list.get(i).getItemN())) {
	          		count++;
	          	}
	      }
		return count;
		}
		
	
}
