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
import guiTeacher.userInterfaces.ClickableScreen;
import inv.Items;
import mainMenuAndStartScreen.ButtonDavid;

public class buyTest extends ClickableScreen {

	private static final long serialVersionUID = 1777676794745848898L;
	public static final int COST = 200;
	
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
	
	public buyTest(int width, int height) {
		super(width, height);
		System.out.println((ShopMain.inventory.getCurrency()));
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setOrbitron();
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		setCustomFont();
		
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.LIGHT_GRAY,"Back",new Action() {
			
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
		});
			
		viewObjects.add(backButton);
		setOrbitron();
		TextArea title =  new TextArea(600,50,300,50,"MERCHANT");
		title.setCustomTextColor(Color.MAGENTA);
		viewObjects.add(title);
		
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE 100 Defense"
				+ "");
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
				if (ShopMain.inventory.getCurrency() >= COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def")) < 10) {
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
						//def++;
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						//setCoins(coins);
						ShopMain.inventory.itemlist.add(new Items("def"));
						inBetween();
						multiplierDef.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("def"))));
					if(def == 10) {
						buyDef.setEnabled(false);
						buyDef.setBackground(Color.RED);
						buyDef.update();
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
				if (ShopMain.inventory.getCurrency() >= COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp")) < 10) {
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
						//hp++;
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						ShopMain.inventory.itemlist.add(new Items("hp"));
						inBetween();
						multiplierHP.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp"))));
					if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("hp")) == 10) {
						buyHP.setEnabled(false);
						buyHP.setBackground(Color.RED);
						buyHP.update();
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
				if (ShopMain.inventory.getCurrency() >= COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge")) < 10) {
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
						//dodge++;
						//System.out.println(dodge + ". Dodge");
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						ShopMain.inventory.itemlist.add(new Items("dodge"));
						inBetween();
						multiplierDodge.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge"))));
					if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("dodge"))== 10) {
						buyDodge.setEnabled(false);
						buyDodge.setBackground(Color.RED);
						buyDodge.update();
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
				if (ShopMain.inventory.getCurrency() >= COST && DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk")) < 10) {
					ShopMain.inventory.setCurrency(ShopMain.inventory.getCurrency()-RickyBuy.COST);
						//atk++;
						ShopMain.inventory.itemlist.add(new Items("atk"));
						//System.out.println(atk + ". Attack");
						numOfCoins.setText(Integer.toString((ShopMain.inventory.getCurrency())));
						inBetween();
						multiplierAtk.setText("x"+Integer.toString(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk")) ));
						if(DavidSell.countOccurences(ShopMain.inventory.itemlist, new Items("atk")) == 10) {
							buyAtk.setEnabled(false);
							buyAtk.setBackground(Color.RED);
							buyAtk.update();
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
			if(coins >= 0 && coins < 10) {
				if(coins % 10 != 1) {
					numOfCoins.setX(1300);
				}
				else numOfCoins.setX(1310);
			}
			else if(coins >= 10 && coins < 100) {
				if(coins % 10 != 1) {
					numOfCoins.setX(1275);
				}
				else numOfCoins.setX(1285);
			}
			else if(coins >= 100 && coins < 1000) {
				if(coins % 10 != 1) {
					numOfCoins.setX(1250);
				}
				else numOfCoins.setX(1260);
			}
			else if(coins >= 1000 && coins < 10000) {
				if(coins % 10 != 1) {
					numOfCoins.setX(1225);
				}
				else numOfCoins.setX(1235);
			}
			else if(coins >= 10000 && coins < 100000) {
				numOfCoins.setX(1200);
			}
		}

		public int getCoins() {
			return coins;
		}

		public void setCoins(int coins) {
			this.coins = coins;
		}
}
