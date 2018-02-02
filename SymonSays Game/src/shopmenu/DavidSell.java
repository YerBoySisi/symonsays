package shopmenu;

import java.awt.Color;
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
		// TODO Auto-generated constructor 
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//title.setTextColor(Color.WHITE);
		title =  new TextArea(600,50,300,50,"MERCHANT");
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		TextArea quant1 = new TextArea(500,150,300,100,"x10");
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		TextArea quant2 = new TextArea(500,275,300,100,"x10");
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
		TextArea quant3 = new TextArea(500,400,300,100,"x10");
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
		TextArea quant4 = new TextArea(500,525,300,100,"x10");
		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(420, 150, 75,75,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(420, 250, 75,75,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(420, 400, 75,75,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(420, 500, 75,75,"shopUpgradeResources/strength.png"));
		viewObjects.add(new Graphic(1325, 25, 50 , 50,"shopUpgradeResources/coin.png"));
		TextArea currency = new TextArea(1155,25,150,150,"1500");
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
				ShopMain.inventory.itemlist.add(new Items("Def"));
				int occurences = Collections.frequency(ShopMain.inventory.itemlist, new Items("Def"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()+100);
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println(occurences);
			}
		});
		buyH.setForeground(Color.GRAY);
		viewObjects.add(buyH);
		Button buyS = new Button(900, 300, 100, 100, "Sell", new Action() {
			public void act() {
				
			}
		});
		buyS.setForeground(Color.GRAY);
		viewObjects.add(buyS);
		Button buyR = new Button(900, 425, 100, 100, "Sell", new Action() {
			public void act() {
			
			}
		});
		buyR.setForeground(Color.GRAY);
		viewObjects.add(buyR);
		Button buyHM = new Button(900, 525, 100, 100, "Sell", new Action() {
			public void act() {
				
			}
		});
		buyHM.setForeground(Color.GRAY);
		viewObjects.add(buyHM);
	}
}
