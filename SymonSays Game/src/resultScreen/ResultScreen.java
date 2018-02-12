 package resultScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import inv.Inventory;
import mainMenuAndStartScreen.ButtonDavid;
import mainMenuAndStartScreen.GameStarter;
import guiTeacher.GUIApplication;

public class ResultScreen extends FullFunctionScreen {
	public int Xp;
	
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
//		Inventory inv =  new Inventory();
//		int gold1 = inv.getCurrency();
//		inv.setCurrency(gold1+goldValue);
		Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/Black.jpg");
		viewObjects.add(backGround);
		//Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/"+bossName+".jpg");
		//viewObjects.add(backGround);
		//if(outcome) {
			//Result
			TextLabel result = new TextLabel(570, 20, 200, 200, "Victory");
			result.setCustomTextColor(Color.WHITE);
			result.setSize(50);
			viewObjects.add(result);
			//loot
			TextLabel loot = new TextLabel(1100, 150, 150, 150, "Loot");
			loot.setCustomTextColor(Color.lightGray);
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
			TextLabel up = new TextLabel(1100, 250, 150, 150, "UP Points: "+ upPoints);
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
		AnimatedComponent main = new MainCharacterAnimated(100, 170, 250, 250);
		viewObjects.add(main);
		
		ButtonDavid bossSelect = new ButtonDavid(1200, 680, 150, Color.WHITE, "Shop", new Action(){
			
			@Override
			public void act() {
				ResultGui.main.setScreen(ResultGui.shopScreen);
			}
		}) ;
		viewObjects.add(bossSelect);
		
		ButtonDavid Shop = new ButtonDavid(1000, 680, 150, Color.WHITE, "Boss Select", new Action(){
			
			@Override
			public void act() {
				
				ResultGui.main.setScreen(ResultGui.selectScreen);
			}
		}) ;
		viewObjects.add(Shop);
		ButtonDavid UpG = new ButtonDavid(800, 680, 150, Color.WHITE, "Upgrade Menu", new Action(){
			
			@Override
			public void act() {
				
				ResultGui.main.setScreen(ResultGui.upgradeScreen);
			}
		}) ;
		viewObjects.add(UpG);
		ButtonDavid mainMe = new ButtonDavid(600, 680, 150, Color.WHITE, "Main Menu", new Action(){
			
			@Override
			public void act() {
				
				ResultGui.main.setScreen(ResultGui.mainMenuScreen);
			}
		}) ;
		viewObjects.add(mainMe);
	}
}
