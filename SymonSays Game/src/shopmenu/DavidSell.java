package shopmenu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import inv.Items;
import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;

public class DavidSell extends FullFunctionScreen  implements RickyShopText {

	public static final int  SELLING_COST = 160;
	private TextArea title;
	private Button buyD;
	private Button buyHP;
	private Button buyA;
	private Button buyDd;	
	private Button buyR;
	static TextArea quant1;
	static TextArea quant2;
	static TextArea quant3;
	static TextArea quant4;
	static TextArea quant5;
	static TextArea currency;
	private String[] itemName = {"def","hp","dodge","atk","revive"};
	private TextArea[] quant = {quant1,quant2,quant3,quant4,quant5};
	private ArrayList<Button> sellButtons;
	int y =0;

	public DavidSell(int width, int height) {
		super(width, height);

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		update();
		//title.setTextColor(Color.WHITE);z
		title =  new TextArea(600,50,400,50,"MERCHANT - SELL");
		
		
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		
		quant1 = new TextArea(500,150,300,100,"-");
		quant1.setText("x"+Integer.toString(countOccurences(GameStarter.inventory.itemlist,new Items("def"))));

		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		quant2 = new TextArea(500,275,300,100,"-");
		quant2.setText("x"+Integer.toString(countOccurences(GameStarter.inventory.itemlist,new Items("hp"))));

		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
		quant3 = new TextArea(500,400,300,100,"-");
		quant3.setText("x"+Integer.toString(countOccurences(GameStarter.inventory.itemlist,new Items("dodge"))));

		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
		quant4 = new TextArea(500,525,300,100,"-");
		quant4.setText("x"+Integer.toString(countOccurences(GameStarter.inventory.itemlist,new Items("atk"))));
		
		TextArea desc5 = new TextArea(600,655,450,100,"REVIVES PLAYER WITH FULL HP");
		quant5 = new TextArea(500,650,300,100,"-");
		quant5.setText("x"+Integer.toString(countOccurences(GameStarter.inventory.itemlist,new Items("revive"))));
		
		

		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(400, 150, 100, 100,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(400, 250, 100 , 100,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(400, 400, 100 , 100,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(400, 500, 100 , 100,"shopUpgradeResources/strength.png"));
		viewObjects.add(new Graphic(400, 630, 100 , 100,"shopUpgradeResources/revive.png"));
		viewObjects.add(new Graphic(1340, 25, 50 , 50,"shopUpgradeResources/coin.png"));

		currency = new TextArea(1200,20,150,50,Integer.toString(GameStarter.inventory.getCurrency()));
		currency.setCustomTextColor(Color.orange);
		currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));

		setbankG();
		ButtonDavid back = new ButtonDavid(50,680,100,Color.LIGHT_GRAY,"Back",new Action() {



			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.shopScreen);
				inBetween();
				updateQuant();
				
			}
		});

		back.setForeground(Color.WHITE);
		viewObjects.add(back);
		setOrbitron();
		


		viewObjects.add(title);
		viewObjects.add(desc1);
		viewObjects.add(quant1);
		viewObjects.add(desc2);
		viewObjects.add(quant2);
		viewObjects.add(desc3);
		viewObjects.add(quant3);
		viewObjects.add(desc4);
		viewObjects.add(quant4);
		viewObjects.add(desc5);
		viewObjects.add(quant5);
		viewObjects.add(currency);
		
		
		createButtons();
		for(Button b: sellButtons) {
			b.setForeground(Color.GRAY);
			b.setEnabled(true);
			viewObjects.add(b);
		}

		viewObjects.add(new Graphic(1030, 210, 35 , 35,"shopUpgradeResources/coin.png"));
		viewObjects.add(new Graphic(1030, 335, 35 , 35,"shopUpgradeResources/coin.png"));
		viewObjects.add(new Graphic(1030, 460, 35 , 35,"shopUpgradeResources/coin.png"));
		viewObjects.add(new Graphic(1030, 585, 35 , 35,"shopUpgradeResources/coin.png"));
		viewObjects.add(new Graphic(1060, 710, 35 , 35,"shopUpgradeResources/coin.png"));
      
	}
	
	public void createButtons() {
		sellButtons = new ArrayList<Button>();
		for(int i =0;i<=4;i++) {
			int x =i;
			Button b = new Button(900,200+(i*125),175,50,Integer.toString(SELLING_COST), Color.GREEN, new Action() {

				@Override
				public void act() {
					sellButtons.get(y).setEnabled(true);
					if (countOccurences(GameStarter.inventory.itemlist,new Items(itemName[x]))>0) {
						ArrayList<Items>iteml = GameStarter.inventory.itemlist;
						removeItem(GameStarter.inventory.itemlist,new Items(itemName[x]));
						int count = countOccurences(GameStarter.inventory.itemlist,new Items(itemName[x]));
						GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ SELLING_COST);
						inBetween();
						GameStarter.buyScreen.inBetween();
						quant[x].setText("x"+Integer.toString(count));
						currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));

					}
					
				}

			});
			sellButtons.add(b);
		} 
	}

	
	//TextArea quant, TextArea currency, String itemN
	/*
	
	public void setButtonActions() {

		for(int i=0;i<=4;i++) {
			int x =i;

			sellButtons.get(i).setAction(new Action() {
		
				@Override
				public void act() {
					sellButtons.get(y).setEnabled(true);
					if (countOccurences(GameStarter.inventory.itemlist,new Items(itemName[x]))>0) {
						ArrayList<Items>iteml = GameStarter.inventory.itemlist;
						removeItem(GameStarter.inventory.itemlist,new Items(itemName[x]));
						int count = countOccurences(GameStarter.inventory.itemlist,new Items(itemName[x]));
						GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ SELLING_COST);
						inBetween();
						GameStarter.buyScreen.inBetween();
						quant[x].setText("x"+Integer.toString(count));
						currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));

					}

					
				}
			});

		}

	}
	*/

	public static int countOccurences(ArrayList<Items> list, Items x) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) { 		      
			if(x.getItemN() ==(list.get(i).getItemN())) {
				count++;
			}
		}
		return count;
	}

	
	/* public void printList(ArrayList<Items> list){
		for(Items elem : list){
			System.out.println(elem+"  ");
		}
	} */

	public void removeItem(ArrayList<Items> list,Items x) {
		for (int i = 0; i < list.size(); i++) { 		      
			if(x.getItemN() ==(list.get(i).getItemN())) {
				list.remove(i);
				return;
			}
		}
	}

	public void inBetween() {
		if(GameStarter.inventory.getCurrency() >= 0 && GameStarter.inventory.getCurrency() < 10) {
			if(GameStarter.inventory.getCurrency() % 10 != 1) {
				currency.setX(1300);
			}
			else currency.setX(1310);
		}
		else if(GameStarter.inventory.getCurrency() >= 10 && GameStarter.inventory.getCurrency() < 100) {
			if(GameStarter.inventory.getCurrency() % 10 != 1) {
				currency.setX(1275);
			}
			else currency.setX(1285);
		}
		else if(GameStarter.inventory.getCurrency() >= 100 && GameStarter.inventory.getCurrency() < 1000) {
			if(GameStarter.inventory.getCurrency() % 10 != 1) {
				currency.setX(1250);
			}
			else currency.setX(1260);
		}
		else if(GameStarter.inventory.getCurrency() >= 1000 && GameStarter.inventory.getCurrency() < 10000) {
			if(GameStarter.inventory.getCurrency() % 10 != 1) {
				currency.setX(1225);
			}
			else currency.setX(1235);
		}
		else if(GameStarter.inventory.getCurrency() >= 10000 && GameStarter.inventory.getCurrency() < 100000) {
			currency.setX(1200);
		}
	}

	private void setOrbitron() {
		try {
			File fontFile = new File("shopUpgradeResources//Orbitron-Black.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);
			StyledComponent.setBaseFont(font);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	private void setbankG(){	
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);
			StyledComponent.setBaseFont(font);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateQuant() {
		RickyBuy.multiplierDef.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"))));
		RickyBuy.multiplierHP.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"))));
		RickyBuy.multiplierDodge.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"))));
		RickyBuy.multiplierAtk.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"))));
		RickyBuy.numOfCoins.setText(Integer.toString(GameStarter.inventory.getCurrency()));
		
		DavidSell.quant1.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"))));
		DavidSell.quant2.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"))));
		DavidSell.quant3.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"))));
		DavidSell.quant4.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"))));
		DavidSell.quant5.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("revive"))));
		DavidSell.currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));	
	}	
	/*
	buyD = new Button(900,200,175,50,Integer.toString(SELLING_COST),Color.GREEN, new Action() {
		public void act() {
			buyD.setEnabled(true);
			if (countOccurences(GameStarter.inventory.itemlist,new Items("def")) >0) {
				ArrayList<Items>iteml = GameStarter.inventory.itemlist;
				removeItem(GameStarter.inventory.itemlist,new Items("def"));
				int count = countOccurences(GameStarter.inventory.itemlist,new Items("def"));
				GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ SELLING_COST);

				inBetween();

				quant1.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));
			
			}


		}
	});
	
	buyD.setForeground(Color.GRAY);
	viewObjects.add(buyD);


	buyHP = new Button(900,325,175,50,Integer.toString(SELLING_COST),Color.GREEN, new Action() {
		public void act() {
			buyHP.setEnabled(true);
			if (countOccurences(GameStarter.inventory.itemlist,new Items("hp")) >0) {
				ArrayList<Items>iteml = GameStarter.inventory.itemlist;
				removeItem(GameStarter.inventory.itemlist,new Items("hp"));
				int count = countOccurences(iteml,new Items("hp"));
				GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ SELLING_COST);
				GameStarter.buyScreen.inBetween();
				inBetween();

				quant2.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));
				

			}
		}
	});
	
	buyHP.setForeground(Color.GRAY);
	viewObjects.add(buyHP);


	buyDd = new Button(900,450,175,50,Integer.toString(SELLING_COST),Color.GREEN, new Action() {
		public void act() {
			buyDd.setEnabled(true);
			if (countOccurences(GameStarter.inventory.itemlist,new Items("dodge")) >0) {
				ArrayList<Items>iteml = GameStarter.inventory.itemlist;
				removeItem(GameStarter.inventory.itemlist,new Items("dodge"));
				int count = countOccurences(GameStarter.inventory.itemlist,new Items("dodge"));
				GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ SELLING_COST);
				GameStarter.buyScreen.inBetween();
				inBetween();

				quant3.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));
				
			}
		}
	});

	buyDd.setForeground(Color.GRAY);
	viewObjects.add(buyDd);


	buyA = new Button(900,575,175,50,Integer.toString(SELLING_COST),Color.GREEN, new Action() {
		public void act() {
			buyA.setEnabled(true);
			if (countOccurences(GameStarter.inventory.itemlist,new Items("atk"))>0) {
				ArrayList<Items>iteml = GameStarter.inventory.itemlist;
				removeItem(GameStarter.inventory.itemlist,new Items("atk"));
				int count = countOccurences(GameStarter.inventory.itemlist,new Items("atk"));
				GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ SELLING_COST);
				GameStarter.buyScreen.inBetween();
				inBetween();
				quant4.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));
				
			}
		}
	});

	buyA.setForeground(Color.GRAY);
	viewObjects.add(buyA);
	
	buyR = new Button(900,700,200,50,Integer.toString(2000),Color.GREEN, new Action() {
		public void act() {
			buyR.setEnabled(true);
			if (countOccurences(GameStarter.inventory.itemlist,new Items("revive"))>0) {
				ArrayList<Items>iteml = GameStarter.inventory.itemlist;
				removeItem(GameStarter.inventory.itemlist,new Items("revive"));
				int count = countOccurences(GameStarter.inventory.itemlist,new Items("revive"));
				GameStarter.inventory.setCurrency(GameStarter.inventory.getCurrency()+ 2000);
				inBetween();
				GameStarter.buyScreen.inBetween();

				quant5.setText("x"+Integer.toString(count));
				currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));
				
			}
		}
	});

	buyR.setForeground(Color.GRAY);
	viewObjects.add(buyR);
	*/
}
