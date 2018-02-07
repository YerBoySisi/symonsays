package shopmenu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import inv.Inventory;
import inv.Items;
import mainMenuAndStartScreen.ButtonDavid;

public class DavidSell extends FullFunctionScreen {
	
	private static final long serialVersionUID = 6577268248251558487L;
	private TextArea title;
	private int def;
	private Inventory inv;

	public DavidSell(int width, int height) {
		super(width, height);
		inv = ShopMain.inventory;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//title.setTextColor(Color.WHITE);
		title =  new TextArea(600,50,300,50,"MERCHANT");
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		TextArea quant1 = new TextArea(500,150,300,100,"-");
		quant1.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("Def"))));
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		TextArea quant2 = new TextArea(500,275,300,100,"-");
		quant2.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("Health"))));
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
		TextArea quant3 = new TextArea(500,400,300,100,"-");
		quant3.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("Speed"))));
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
		TextArea quant4 = new TextArea(500,525,300,100,"-");
		quant4.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("Revive"))));
		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(420, 150, 100,100,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(420, 250, 100,100,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(420, 400, 100,100,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(420, 500, 100,100,"shopUpgradeResources/strength.png"));
		viewObjects.add(new Graphic(1325, 25, 50, 50,"shopUpgradeResources/coin.png"));
		TextArea currency = new TextArea(1155,25,150,150,"1500");
		currency.setCustomTextColor(Color.orange);
		currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));

		//hahaha
		//countOccurences(ShopMain.inventory.itemlist,new Items("Speed"));
		//Integer.toString(count)
		
		ButtonDavid back = new ButtonDavid(50,680,100,Color.LIGHT_GRAY,"Back",new Action() {

			
			
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
				iteml.remove(new Items("Def"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Def"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
				quant1.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Def: " +count);
			  
			}
		});
		buyH.setForeground(Color.GRAY);
		viewObjects.add(buyH);
		Button buyS = new Button(900, 300, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.remove(new Items("Health"));
				int count = countOccurences(iteml,new Items("Health"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
				quant2.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Health: " +count);
			}
		});
		buyS.setForeground(Color.GRAY);
		viewObjects.add(buyS);
		Button buyR = new Button(900, 425, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.remove(new Items("Speed"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Speed"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
				quant3.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Speed: " +count);
			}
		});
		buyR.setForeground(Color.GRAY);
		viewObjects.add(buyR);
		Button buyHM = new Button(900, 525, 100, 100, "Sell", new Action() {
			public void act() {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				iteml.remove(new Items("Revive"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("Revive"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
				quant4.setText(Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Revive: " +count);
			}
		});
		buyHM.setForeground(Color.GRAY);
		viewObjects.add(buyHM);
		
		
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
