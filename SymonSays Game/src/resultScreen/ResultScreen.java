 package resultScreen;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import mainMenuAndStartScreen.ButtonDavid;
import mainMenuAndStartScreen.GameStarter;
<<<<<<< HEAD
import mainMenuAndStartScreen.MainMenuScreen;
=======
>>>>>>> refs/remotes/origin/Develop
import guiTeacher.GUIApplication;

public class ResultScreen extends FullFunctionScreen {
<<<<<<< HEAD
	public String bossName;
	public boolean outcome;
=======
	public int bossLevel;
	public boolean outcome;
	//values
	public int goldValue;
	public int upPoints;
>>>>>>> refs/remotes/origin/Develop
	
	public ResultScreen(int width, int height) {
		super(width, height);
		
		// TODO Auto-generated constructor stub
	}
	public void defineValues() {
<<<<<<< HEAD
		//bossName = sisi.bossName();
		//outcome =  sisi.determineWinner();
=======
		//bossLevel = GameStarter.battleScreen.bossLevel();
		//outcome =  GameStarter.battleScreen.determineWinner();
		goldValue= (int) (100*(Math.random()*3)+100);
		upPoints = (int) (10*(Math.random()*10)+50);
>>>>>>> refs/remotes/origin/Develop
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/black.jpg");
		viewObjects.add(backGround);
		//Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/"+bossName+".jpg");
		//viewObjects.add(backGround);
		if(outcome) {
			TextLabel result = new TextLabel(570, 20, 200, 200, "You Win");
			result.setCustomTextColor(Color.WHITE);
			result.setSize(50);
			viewObjects.add(result);
<<<<<<< HEAD
			
		}
		//else {
			TextLabel resultL = new TextLabel(570, 20, 250, 200, "You Lose");
			resultL.setCustomTextColor(Color.WHITE);
			resultL.setSize(50);
			viewObjects.add(resultL);
		//}
		AnimatedComponent main = new Main(100, 450, 150, 150);
		viewObjects.add(main);
		ButtonDavid bossSelect = new ButtonDavid(1200, 680, 150, Color.WHITE, "Boss Select", new Action(){
			
			@Override
			public void act() {
				GameStarter.setScreen(GameStarter.mainMenuScreen);
			}
		}) ;
		viewObjects.add(bossSelect);
=======
			TextLabel loot = new TextLabel(1150, 250, 150, 150, "Loot");
			loot.setCustomTextColor(Color.WHITE);
			loot.setSize(40);
			viewObjects.add(loot);
			//up points
			TextLabel up = new TextLabel(1150, 250, 150, 150, "UP Points: "+ );
			loot.setCustomTextColor(Color.WHITE);
			loot.setSize(20);
			viewObjects.add(up);
			//gold
			TextLabel gold = new TextLabel(1150, 250, 150, 150, "Gold: "+ goldValue);
			loot.setCustomTextColor(Color.WHITE);
			loot.setSize(40);
			viewObjects.add(gold);
		}
		//else {
			TextLabel resultL = new TextLabel(570, 20, 250, 200, "You Lose");
			resultL.setCustomTextColor(Color.WHITE);
			resultL.setSize(50);
			viewObjects.add(resultL);
		//}
		AnimatedComponent main = new Main(100, 450, 150, 150);
		viewObjects.add(main);
		ButtonDavid bossSelect = new ButtonDavid(1200, 680, 150, Color.WHITE, "Boss Select", new Action(){
			
			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
			}
		}) ;
		viewObjects.add(bossSelect);
		
		ButtonDavid Shop = new ButtonDavid(1000, 680, 150, Color.WHITE, "Shop", new Action(){
			
			@Override
			public void act() {
				
				GameStarter.start.setScreen(GameStarter.shopScreen);
			}
		}) ;
		viewObjects.add(Shop);
>>>>>>> refs/remotes/origin/Develop
		
		ButtonDavid Shop = new ButtonDavid(1000, 680, 150, Color.WHITE, "Shop", new Action(){
			
			@Override
			public void act() {
				
				GameStarter.start.setScreen(GameStarter.shopScreen);
			}
		}) ;
		viewObjects.add(Shop);
	}
}
