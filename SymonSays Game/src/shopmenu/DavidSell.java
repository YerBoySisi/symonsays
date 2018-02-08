package shopmenu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
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
import mainMenuAndStartScreen.ButtonDavid;

public class DavidSell extends FullFunctionScreen {
	
	private TextArea title;
	private Button buyD;
	private Button buyHP;
	private Button buyA;
	private Button buyDd;	
	static TextArea quant1;
	static TextArea quant2;
	static TextArea quant3;
	static TextArea quant4;
	static TextArea currency;

	public DavidSell(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//title.setTextColor(Color.WHITE);
		title =  new TextArea(600,50,300,50,"MERCHANT");
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		quant1 = new TextArea(500,150,300,100,"-");
		quant1.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("def"))));
		
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
	    quant2 = new TextArea(500,275,300,100,"-");
		quant2.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("hp"))));
		
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
        quant3 = new TextArea(500,400,300,100,"-");
		quant3.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("dodge"))));
		
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
        quant4 = new TextArea(500,525,300,100,"-");
		quant4.setText("x"+Integer.toString(countOccurences(ShopMain.inventory.itemlist,new Items("atk"))));
		
		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(400, 150, 100, 100,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(400, 250, 100 , 100,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(400, 400, 100 , 100,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(400, 500, 100 , 100,"shopUpgradeResources/strength.png"));
		viewObjects.add(new Graphic(1340, 25, 50 , 50,"shopUpgradeResources/coin.png"));
		
	     currency = new TextArea(1155,25,150,150,"-");
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
		
		   buyD = new Button(900,200,100,50,"Sell",Color.GREEN, new Action() {
			public void act() {
				buyD.setEnabled(true);
				if (countOccurences(ShopMain.inventory.itemlist,new Items("def")) >0) {
					ArrayList<Items>iteml = ShopMain.inventory.itemlist;
					removeItem(ShopMain.inventory.itemlist,new Items("def"));
					int count = countOccurences(ShopMain.inventory.itemlist,new Items("def"));
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()+RickyBuy.COST);
					inBetween();
					quant1.setText("x"+Integer.toString(count));
					currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
					System.out.println(ShopMain.inventory.getCurrency());
					 printList(ShopMain.inventory.itemlist);
					   
					System.out.println("Def: " +count);
					/*
					if(count == 0) {
						buyD.setEnabled(false);
						buyD.setBackground(Color.RED);
						buyD.update();
					}
					*/
				}
				
			  
			}
		});
		   /*
		   if(countOccurences(ShopMain.inventory.itemlist,new Items("def")) == 0) {
				buyD.setEnabled(false);
				buyD.setBackground(Color.RED);
				buyD.update();
			}
			*/
		buyD.setForeground(Color.GRAY);
		viewObjects.add(buyD);
		
		
		 buyHP = new Button(900,325,100,50,"Sell",Color.GREEN, new Action() {
			public void act() {
				buyHP.setEnabled(true);
				if (countOccurences(ShopMain.inventory.itemlist,new Items("hp")) >0) {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				removeItem(ShopMain.inventory.itemlist,new Items("hp"));
				int count = countOccurences(iteml,new Items("hp"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()+RickyBuy.COST);
				inBetween();
				quant2.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Health: " +count);
				/*
				if(count == 0) {
					buyHP.setEnabled(false);
					buyHP.setBackground(Color.RED);
					buyHP.update();
				}
				*/
				
				}
			}
		});
		 /*
		if(countOccurences(ShopMain.inventory.itemlist,new Items("hp")) == 0) {
				buyHP.setEnabled(false);
				buyHP.setBackground(Color.RED);
				buyHP.update();
			}
			*/
		buyHP.setForeground(Color.GRAY);
		viewObjects.add(buyHP);
		
		
		  buyDd = new Button(900,450,100,50,"Sell",Color.GREEN, new Action() {
			public void act() {
				buyDd.setEnabled(true);
				if (countOccurences(ShopMain.inventory.itemlist,new Items("dodge")) >0) {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				removeItem(ShopMain.inventory.itemlist,new Items("dodge"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("dodge"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()+RickyBuy.COST);
				inBetween();
				quant3.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(ShopMain.inventory.getCurrency());
				System.out.println("Speed: " +count);
				/*
				if(count == 0) {
					buyDd.setEnabled(false);
					buyDd.setBackground(Color.RED);
					buyDd.update();
				}
				*/
				}
			}
		});
		  /*
		  if(countOccurences(ShopMain.inventory.itemlist,new Items("dodge")) == 0) {
				buyDd.setEnabled(false);
				buyDd.setBackground(Color.RED);
				buyDd.update();
			}
			*/
		buyDd.setForeground(Color.GRAY);
		viewObjects.add(buyDd);
		
		
		 buyA = new Button(900,575,100,50,"Sell",Color.GREEN, new Action() {
			public void act() {
				buyA.setEnabled(true);
				if (countOccurences(ShopMain.inventory.itemlist,new Items("atk"))>0) {
				ArrayList<Items>iteml = ShopMain.inventory.itemlist;
				removeItem(ShopMain.inventory.itemlist,new Items("atk"));
				int count = countOccurences(ShopMain.inventory.itemlist,new Items("atk"));
				ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()+RickyBuy.COST);
				inBetween();
				quant4.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));
				System.out.println(+ShopMain.inventory.getCurrency());
				System.out.println("Atk: " +count);
				/*
				if(count == 0) {
					buyA.setEnabled(false);
					buyA.setBackground(Color.RED);
					buyA.update();
				}
				*/
				}
			}
		});
		 /*
		 if(countOccurences(ShopMain.inventory.itemlist,new Items("atk")) == 0) {
				buyA.setEnabled(false);
				buyA.setBackground(Color.RED);
				buyA.update();
			}
		 */
		buyA.setForeground(Color.GRAY);
		viewObjects.add(buyA);
		
		
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
	
	public void printList(ArrayList<Items> list){
	    for(Items elem : list){
	        System.out.println(elem+"  ");
	    }
	}
	
	public void removeItem(ArrayList<Items> list,Items x) {
		for (int i = 0; i < list.size(); i++) { 		      
          	if(x.getItemN() ==(list.get(i).getItemN())) {
          		list.remove(i);
          		return;
          	}
		}
	}
	
	public void inBetween() {
		if(ShopMain.inventory.getCurrency() >= 0 && ShopMain.inventory.getCurrency() < 10) {
			if(ShopMain.inventory.getCurrency() % 10 != 1) {
				currency.setX(1300);
			}
			else currency.setX(1310);
		}
		else if(ShopMain.inventory.getCurrency() >= 10 && ShopMain.inventory.getCurrency() < 100) {
			if(ShopMain.inventory.getCurrency() % 10 != 1) {
				currency.setX(1275);
			}
			else currency.setX(1285);
		}
		else if(ShopMain.inventory.getCurrency() >= 100 && ShopMain.inventory.getCurrency() < 1000) {
			if(ShopMain.inventory.getCurrency() % 10 != 1) {
				currency.setX(1250);
			}
			else currency.setX(1260);
		}
		else if(ShopMain.inventory.getCurrency() >= 1000 && ShopMain.inventory.getCurrency() < 10000) {
			if(ShopMain.inventory.getCurrency() % 10 != 1) {
				currency.setX(1225);
			}
			else currency.setX(1235);
		}
		else if(ShopMain.inventory.getCurrency() >= 10000 && ShopMain.inventory.getCurrency() < 100000) {
			currency.setX(1200);
		}
	}
}
