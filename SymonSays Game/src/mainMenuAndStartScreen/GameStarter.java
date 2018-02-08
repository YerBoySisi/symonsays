package mainMenuAndStartScreen;

import java.awt.Font;
import java.io.File;

import bossSelect.SelectScreen;
import creditsCarsonAmanat.CreditsScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import shopmenu.ShopScreen;
import shopmenu.UpgradeScreen;
import sisiKneeBattle.BattleScreen;

public class GameStarter extends GUIApplication{
	
	public static StartScreen startScreen;
	public static MainMenuScreen mainMenuScreen;
	public static GameStarter start;
	public static SelectScreen selectScreen;
	public static ShopScreen shopScreen;
	public static UpgradeScreen upgradeScreen;
	public static CreditsScreen creditsScreen;
	public static BattleScreen battleScreen;
	
	
	public GameStarter(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		start = new GameStarter(1400,780);
		Thread go = new Thread(start);
		go.start();
	}

	public void initScreen() {
		startScreen = new StartScreen(getWidth(),getHeight());
		mainMenuScreen = new MainMenuScreen(getWidth(),getHeight());
		selectScreen = new SelectScreen(getWidth(),getHeight());
		shopScreen = new ShopScreen(getWidth(),getHeight());
		upgradeScreen = new UpgradeScreen(getWidth(),getHeight());
		creditsScreen = new CreditsScreen(getWidth(),getHeight());
		battleScreen = new BattleScreen(getWidth(),getHeight());
		setScreen(startScreen);
	}

}
