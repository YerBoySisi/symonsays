package shopmenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class RickyBuy extends ClickableScreen {

	public static final int COST = 200;
	private Button back;
	private int coins;
	private TextArea numOfCoins;
	
	public RickyBuy(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
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
		for(int i = 0; i < 4; i++) {
			TextArea multiplier = new TextArea(500,150 + i*125,300,100,"x10");
			viewObjects.add(multiplier);
		}
		
		viewObjects.add(desc1);
		viewObjects.add(desc2);
		viewObjects.add(desc3);
		viewObjects.add(desc4);
		Button buyDef = new Button(900,200,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyDef);
		buyDef.setForeground(Color.GRAY);
		
		Button buyHP = new Button(900,325,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyHP);
		buyHP.setForeground(Color.GRAY);
		
		Button buyDodge = new Button(900,450,100,50,"Buy",Color.GREEN, new Action() {
			
			@Override
			public void act() {
			
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyDodge);
		buyDodge.setForeground(Color.GRAY);
		
		Button buyAtk = new Button(900,575,100,50,"Buy", Color.GREEN, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
				
			}
		});
		viewObjects.add(buyAtk);
		buyAtk.setForeground(Color.GRAY);
		viewObjects.add(new Graphic(400, 150, 100, 100,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(400, 250, 100 , 100,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(400, 400, 100 , 100,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(400, 500, 100 , 100,"shopUpgradeResources/strength.png"));
		
		/*Test*/coins = 20;
		
		numOfCoins = new TextArea(1200,20,150,50, Integer.toString(coins));
		numOfCoins.setCustomTextColor(Color.ORANGE);
		viewObjects.add(numOfCoins);
		inBetween();
		viewObjects.add(new Graphic(1340, 25, 50 , 50,"shopUpgradeResources/coin.png"));
		
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
		}
}