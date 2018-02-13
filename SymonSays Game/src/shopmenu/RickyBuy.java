package shopmenu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
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

public class RickyBuy extends FullFunctionScreen implements RickyShopText {

	private static final long serialVersionUID = 1777676794745848898L;
	public static final int BUYING_COST = 200;
	
	private Button buyDef;
	private Button buyHP;
	private Button buyAtk;
	private Button buyDodge;
	
	private int coins;
	static TextArea numOfCoins;
	
	private int def;
	private int hp;
	private int dodge;
	private int atk;
	
	static TextArea multiplierDef;
	static TextArea multiplierHP;
	static TextArea multiplierDodge;
	static TextArea multiplierAtk;
	
	public RickyBuy(int width, int height) {
		super(width, height);
		//System.out.println((ShopMain.inventory.getCurrency()));
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(false);
		update();
		setOrbitron();
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		setCustomFont();
		
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.LIGHT_GRAY,"Back",new Action() {
			
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
				inBetween();
				updateQuant();

			}
		});
			
		viewObjects.add(backButton);
		setOrbitron();
		TextArea title =  new TextArea(600,50,300,50,"MERCHANT");
		title.setCustomTextColor(Color.MAGENTA);
		viewObjects.add(title);
		
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE 25 Defense");
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE by 5%");
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 10");
		
		def = DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def"));
	     multiplierDef = new TextArea(500,150,300,100,"x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def"))));
		viewObjects.add(multiplierDef);
		
		hp = DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp"));
		 multiplierHP = new TextArea(500,275,300,100,"x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp"))));
		viewObjects.add(multiplierHP);
		
		dodge = DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge"));
		 multiplierDodge = new TextArea(500,400,300,100,"x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge"))));
		viewObjects.add(multiplierDodge);
		
		atk = DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk"));
		 multiplierAtk = new TextArea(500,525,300,100,"x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk"))));
		viewObjects.add(multiplierAtk);
		
		viewObjects.add(desc1);
		viewObjects.add(desc2);
		viewObjects.add(desc3);
		viewObjects.add(desc4);
		
		buyDef = new Button(900,200,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				buyDef.setEnabled(true);
				if (ShopMain.inventory.getCurrency() >= BUYING_COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def")) < 10) {
					buyDef.setBackground(Color.GREEN);
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency() - RickyBuy.BUYING_COST);
						//def++;
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						//setCoins(coins);
						ShopMain.inventory.itemlist.add(new Items("def"));
						inBetween();
						ShopMain.s4.inBetween();
						multiplierDef.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def"))));
					if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def")) == 10) {
						buyDef.setEnabled(false);
						buyDef.setBackground(Color.RED);
						buyDef.update();
						inBetween();
					}
				}
			}
		});
		viewObjects.add(buyDef);
		buyDef.setForeground(Color.GRAY);
		
		buyHP = new Button(900,325,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				buyHP.setEnabled(true);
				if (ShopMain.inventory.getCurrency() >= BUYING_COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp")) < 10) {
					buyDef.setBackground(Color.GREEN);
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency() - RickyBuy.BUYING_COST);
						//hp++;
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						ShopMain.inventory.itemlist.add(new Items("hp"));
						inBetween();
						ShopMain.s4.inBetween();
						multiplierHP.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp"))));
					if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp")) == 10) {
						buyHP.setEnabled(false);
						buyHP.setBackground(Color.RED);
						buyHP.update();
						inBetween();
					}
				}
			}
		});
		
		viewObjects.add(buyHP);
		buyHP.setForeground(Color.GRAY);
		
		buyDodge = new Button(900,450,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				buyDodge.setEnabled(true);
				if (ShopMain.inventory.getCurrency() >= BUYING_COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge")) < 10) {
					buyDef.setBackground(Color.GREEN);
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.BUYING_COST);
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						ShopMain.inventory.itemlist.add(new Items("dodge"));
						inBetween();
						ShopMain.s4.inBetween();
						multiplierDodge.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge"))));
					if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge"))== 10) {
						buyDodge.setEnabled(false);
						buyDodge.setBackground(Color.RED);
						buyDodge.update();
						inBetween();
					}
				}
			}
		});
		viewObjects.add(buyDodge);
		buyDodge.setForeground(Color.GRAY);
		
		buyAtk = new Button(900,575,100,50,"Buy", Color.GREEN, new Action() {

			@Override
			public void act() {
				buyAtk.setEnabled(true);
				if (ShopMain.inventory.getCurrency() >= BUYING_COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk")) < 10) {
					buyDef.setBackground(Color.GREEN);
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency() - BUYING_COST);
						inBetween();
						ShopMain.s4.inBetween();
						ShopMain.inventory.itemlist.add(new Items("atk"));
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						multiplierAtk.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk")) ));
						if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk")) == 10) {
							buyAtk.setEnabled(false);
							buyAtk.setBackground(Color.RED);
							buyAtk.update();
							inBetween();
							
						}
					}
			}
		});
		viewObjects.add(buyAtk);
		buyAtk.setForeground(Color.GRAY);
		viewObjects.add(new Graphic(400, 150, 100, 100,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(400, 250, 100 , 100,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(400, 400, 100 , 100,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(400, 500, 100 , 100,"shopUpgradeResources/strength.png"));
		
		coins = ShopMain.inventory.getCurrency();
		numOfCoins = new TextArea(1200,20,150,50, Integer.toString(coins));
		numOfCoins.setCustomTextColor(Color.ORANGE);
		numOfCoins.setText(Integer.toString(ShopMain.inventory.getCurrency()));
		viewObjects.add(numOfCoins);
		inBetween();
		viewObjects.add(new Graphic(1340, 25, 50 , 50,"shopUpgradeResources/coin.png"));
		
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
		private void setCustomFont(){	
			try {
				File fontFile = new File("resources/bankgothic_medium_bt.ttf");
				Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);
				StyledComponent.setBaseFont(font);
	 				} catch (Exception e) {
						e.printStackTrace();
					}
			}

		public void inBetween() {
			if(ShopMain.inventory.getCurrency() >= 0 && ShopMain.inventory.getCurrency() < 10) {
				if(ShopMain.inventory.getCurrency() % 10 != 1) {
					numOfCoins.setX(1300);
					System.out.println(numOfCoins.getX());
				}
				else numOfCoins.setX(1310);
				System.out.println(numOfCoins.getX());
			}
			else if(ShopMain.inventory.getCurrency() >= 10 && ShopMain.inventory.getCurrency() < 100) {
				if(ShopMain.inventory.getCurrency() % 10 != 1) {
					numOfCoins.setX(1275);
					System.out.println(numOfCoins.getX());
				}
				else numOfCoins.setX(1285);
				System.out.println(numOfCoins.getX());
			}
			else if(ShopMain.inventory.getCurrency() >= 100 && ShopMain.inventory.getCurrency() < 1000) {
				if(ShopMain.inventory.getCurrency() % 10 != 1) {
					numOfCoins.setX(1250);
					System.out.println(numOfCoins.getX());
				}
				else numOfCoins.setX(1260);
				System.out.println(numOfCoins.getX());
			}
			else if(ShopMain.inventory.getCurrency() >= 1000 && ShopMain.inventory.getCurrency() < 10000) {
				if(ShopMain.inventory.getCurrency() % 10 != 1) {
					numOfCoins.setX(1225);
					System.out.println(numOfCoins.getX());
				}
				else numOfCoins.setX(1235);
				System.out.println(numOfCoins.getX());
			}
			else if(ShopMain.inventory.getCurrency() >= 10000 && ShopMain.inventory.getCurrency() < 100000) {
				numOfCoins.setX(1200);
				System.out.println(numOfCoins.getX());
			}
		}
		public void updateQuant() {
			RickyBuy.multiplierDef.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("def"))));
			RickyBuy.multiplierHP.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("hp"))));
			RickyBuy.multiplierDodge.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("dodge"))));
			RickyBuy.multiplierAtk.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("atk"))));
			RickyBuy.numOfCoins.setText(Integer.toString(ShopMain.inventory.getCurrency()));
			
			DavidSell.quant1.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("def"))));
			DavidSell.quant2.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("hp"))));
			DavidSell.quant3.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("dodge"))));
			DavidSell.quant4.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist,new Items("atk"))));
			DavidSell.currency.setText(Integer.toString(ShopMain.inventory.getCurrency()));	
		}	
		
		public void updateDefBuy() {
			buyDef.setEnabled(true);
			buyDef.setBackground(Color.GREEN);
			buyDef.update();
		}
		
		public void updateHPBuy() {
			buyHP.setEnabled(true);
			buyHP.setBackground(Color.GREEN);
			buyHP.update();
		}
		
		public void updateAtkBuy() {
			buyAtk.setEnabled(true);
			buyAtk.setBackground(Color.GREEN);
			buyAtk.update();
		}
		
		public void updateDodgeBuy() {
			buyDodge.setEnabled(true);
			buyDodge.setBackground(Color.GREEN);
			buyDodge.update();
		}
}
