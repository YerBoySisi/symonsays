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

public class RickyBuy extends ClickableScreen {

	public static final int COST = 200;
	private Button back;
	private Button buyDef;
	private Button buyHP;
	private Button buyAtk;
	private Button buyDodge;
	
	private int coins;
	private int def;
	private int hp;
	private int dodge;
	private int atk;
	private TextArea numOfCoins;
	
	
	public RickyBuy(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setOrbitron();
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		back = new Button(0,20,125,50,"Back",new Action() {
			
			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
		});
		back.setForeground(Color.BLUE);
		viewObjects.add(back);
		
		TextArea title =  new TextArea(600,50,300,50,"MERCHANT");
		title.setCustomTextColor(Color.MAGENTA);
		viewObjects.add(title);
		
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
		
		TextArea multiplierDef = new TextArea(500,150,300,100,"x"+Integer.toString(def));
		viewObjects.add(multiplierDef);
		
		TextArea multiplierHP = new TextArea(500,275,300,100,"x"+Integer.toString(hp));
		viewObjects.add(multiplierHP);
		
		TextArea multiplierDodge = new TextArea(500,400,300,100,"x"+Integer.toString(dodge));
		viewObjects.add(multiplierDodge);
		
		TextArea multiplierAtk = new TextArea(500,525,300,100,"x"+Integer.toString(atk));
		viewObjects.add(multiplierAtk);
		
		viewObjects.add(desc1);
		viewObjects.add(desc2);
		viewObjects.add(desc3);
		viewObjects.add(desc4);
		
		buyDef = new Button(900,200,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				buyDef.setEnabled(true);
				if (coins >= COST && def < 10) {
						coins -= COST;
						def++;
						numOfCoins.setText(Integer.toString(coins));
						inBetween();
						multiplierDef.setText("x"+Integer.toString(def));
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
				if (coins >= COST && hp < 10) {
						coins -= COST;
						hp++;
						//System.out.println(hp + ". HP");
						numOfCoins.setText(Integer.toString(coins));
						inBetween();
						multiplierHP.setText("x"+Integer.toString(hp));
					if(hp == 10) {
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
				buyAtk.setEnabled(true);
				if (coins >= COST && dodge < 10) {
						coins -= COST;
						dodge++;
						//System.out.println(dodge + ". Dodge");
						numOfCoins.setText(Integer.toString(coins));
						inBetween();
						multiplierDodge.setText("x"+Integer.toString(dodge));
					if(dodge== 10) {
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
				if (coins >= COST && atk < 10) {
						coins -= COST;
						atk++;
						//System.out.println(atk + ". Attack");
						numOfCoins.setText(Integer.toString(coins));
						inBetween();
						multiplierAtk.setText("x"+Integer.toString(atk));
						if(atk == 10) {
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
		
		coins = 8000;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

		public void inBetween() {
			if(coins >= 0 && coins < 10) {
				numOfCoins.setX(1300);
			}
			else if(coins >= 10 && coins < 100) {
				numOfCoins.setX(1275);
			}
			else if(coins >= 100 && coins < 1000) {
				numOfCoins.setX(1250);
			}
			else if(coins >= 1000 && coins < 10000) {
				numOfCoins.setX(1225);
			}
			else if(coins >= 10000 && coins < 100000) {
				numOfCoins.setX(1200);
			}
		}
}