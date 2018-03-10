 package resultScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import inv.Inventory;
import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;
import guiTeacher.GUIApplication;

public class ResultScreen extends FullFunctionScreen implements Runnable {
	public int Xp;
	public ButtonDavid lootAttempt;
	public int bossLevel;
	public boolean outcome;
	//values
	public int goldValue;
	public int upPoints;
	
	public ResultScreen(int width, int height) {
		super(width, height);
		
		// TODO Auto-generated constructor stub
	}
		
	
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		try {
			File fontFile = new File("resources/orbitron-medium.otf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(48f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//bossLevel = ResultGui.battleScreen.bossLevel();
		//outcome =  GameStarter.battleScreen.determineWinner();
		goldValue= (int) (100*(Math.random()*3)+100);
		upPoints = (int) (10*(Math.random()*10)+50);
		Xp =100;
		//XP.determineXP();
		int gold1 = GameStarter.inventory.getCurrency();
		GameStarter.inventory.setCurrency(gold1+goldValue);
		Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/space.jpg");
		viewObjects.add(backGround);
		//Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/"+bossName+".jpg");
		//viewObjects.add(backGround);
		//if(outcome) {
			//button background
//			TextArea backGroundLabel = new TextArea(900, 100, 400, 500, null);
//			backGroundLabel.setBackground(Color.WHITE);
//			viewObjects.add(backGroundLabel);
			//Result
			TextLabel result = new TextLabel(570, 20, 250, 200, "Victory");
			result.setCustomTextColor(Color.WHITE);
			result.setSize(50);
			viewObjects.add(result);
			//loot
			TextLabel loot = new TextLabel(1100, 150, 150, 150, "Loot");
			loot.setCustomTextColor(Color.WHITE);
			loot.setSize(40);
			viewObjects.add(loot);
			try {
				File fontFile = new File("resources/bankgothic_medium_bt.ttf");
				Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
				Font baseFont=font.deriveFont(36f);
				StyledComponent.setBaseFont(baseFont);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//up points
			TextLabel up = new TextLabel(1100, 250, 200, 150, "UP Points: "+ upPoints);
			up.setCustomTextColor(Color.WHITE);
			up.setSize(20);
			viewObjects.add(up);
			//gold
			TextLabel gold = new TextLabel(1100, 300, 150, 150, "Gold: "+ goldValue);
			gold.setCustomTextColor(Color.WHITE);
			gold.setSize(20);
			viewObjects.add(gold);
			//XP
			TextLabel XpTag =  new TextLabel(200, 450, 100, 100, "XP: " + Xp);
			XpTag.setCustomTextColor(Color.WHITE);
			XpTag.setSize(20);
			viewObjects.add(XpTag);
			//XP BAR
			
			//1-3 Potions
			
			//ULTRA RARE POTION CHANCE + add to inventory
			
			
		//}
		//else {
//			TextLabel resultL = new TextLabel(570, 20, 250, 200, "Defeat");
//			resultL.setCustomTextColor(Color.WHITE);
//			resultL.setSize(50);
//			viewObjects.add(resultL);
		//}
//		AnimatedComponent main = new MainCharacterAnimated(100, 170, 250, 250);
//		viewObjects.add(main);
		
		Graphic still = new Graphic(100 , 170, 250, 250, "resources/Slot.png");
		viewObjects.add(still);
		lootAttempt = new ButtonDavid(400,250, 100, Color.BLUE, "Spin", new Action(){
			
			@Override
			public void act() {
				Thread thread = new Thread(ResultScreen.this);
				thread.start();
				
				
		}

			}) ;
		viewObjects.add(lootAttempt);
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ButtonDavid bossSelect = new ButtonDavid(1200, 680, 100, Color.lightGray, "Shop", new Action(){
			
			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.shopScreen);
		}}) ;
		viewObjects.add(bossSelect);
		
		ButtonDavid Shop = new ButtonDavid(900, 680, 250, Color.lightGray, "Boss Select", new Action(){
			
			@Override
			public void act() {
				
				GameStarter.start.setScreen(GameStarter.selectScreen);
			}
		}) ;
		viewObjects.add(Shop);
		ButtonDavid UpG = new ButtonDavid(650, 680, 200, Color.lightGray, "Upgrades", new Action(){
			
			@Override
			public void act() {
				
				GameStarter.start.setScreen(GameStarter.upgradeScreen);
			}
		}) ;
		viewObjects.add(UpG);
		
}



	@Override
	public void run() {
		int a =0;
		while( a  !=20) {
			try {
				Thread.sleep(time(a));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int firstNumber = (int) ((Math.random()*9));
			int secondNumber = (int) ((Math.random()*10)-1);
			int thirdNumber = (int) ((Math.random()*10)-1);
			Button button1 = new Button(130, 200, 40, 120, String.valueOf(firstNumber), Color.WHITE, null);
			getViewObjects().add(button1);
			Button button2 = new Button(210, 200, 40, 120, String.valueOf(secondNumber), Color.WHITE, null);
			getViewObjects().add(button2);
			Button button3 = new Button(290, 200, 40, 120, String.valueOf(thirdNumber), Color.WHITE, null);
			getViewObjects().add(button3);
			int gold2 = GameStarter.inventory.getCurrency();
			GameStarter.inventory.setCurrency(gold2+goldValue);
			button1.setCustomTextColor(Color.RED);
			lootAttempt.setVisible(false);
			button2.setCustomTextColor(Color.RED);
			button3.setCustomTextColor(Color.RED);
			a++;
			}
	}



	public int time(int a) {
		int x =0;
		x = (int) Math.pow(0.99999999999999999, a);
		return x*1000;
	}}
