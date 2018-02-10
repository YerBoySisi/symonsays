package resultScreen;

import bossSelect.SelectScreen;
import creditsCarsonAmanat.CreditsScreen;
import guiTeacher.GUIApplication;
import mainMenuAndStartScreen.GameStarter;
import mainMenuAndStartScreen.MainMenuScreen;
import mainMenuAndStartScreen.StartScreen;
import shopmenu.ShopScreen;
import shopmenu.UpgradeScreen;
import sisiKneeBattle.BattleScreen;

public class ResultGui extends GUIApplication {
	
	public static StartScreen startScreen;
	public static MainMenuScreen mainMenuScreen;
	public static GameStarter start;
	public static SelectScreen selectScreen;
	public static ShopScreen shopScreen;
	public static UpgradeScreen upgradeScreen;
	public static CreditsScreen creditsScreen;
	public static BattleScreen battleScreen;
	public static ResultGui main;
	public static ResultScreen screen;
	public ResultGui(int width, int height) {
		super(width, height);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		main = new ResultGui(1400, 780);
		screen = new ResultScreen(1400, 780);
		Thread go = new Thread(main);
		go.start();
	}
	@Override
	public void initScreen() {
		screen = new ResultScreen(getWidth(), getHeight());
		setScreen(screen);
		startScreen = new StartScreen(getWidth(),getHeight());
		mainMenuScreen = new MainMenuScreen(getWidth(),getHeight());
		selectScreen = new SelectScreen(getWidth(),getHeight());
		shopScreen = new ShopScreen(getWidth(),getHeight());
		upgradeScreen = new UpgradeScreen(getWidth(),getHeight());
		creditsScreen = new CreditsScreen(getWidth(),getHeight());
		battleScreen = new BattleScreen(getWidth(),getHeight());
	}
	
	
	
}
