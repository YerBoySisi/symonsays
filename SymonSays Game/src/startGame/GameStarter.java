package startGame;

import javax.sound.sampled.Clip;

import audioPlayer.AudioTest;
import audioPlayer.MusicScreen;
import bossSelect.SelectScreen;
import creditsCarsonAmanat.CreditsScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;
import inv.Inventory;
import mainMenuAndStartScreen.MainMenuScreen;
import mainMenuAndStartScreen.StartScreen;
import resultScreen.ResultScreen;
import settingsCarsonAmanat.SettingsScreen;
import shopmenu.DavidSell;
import shopmenu.GarrettUpgradeScreen;
import shopmenu.GarrettUpgradeScreen2;
import shopmenu.RickyBuy;
import shopmenu.ShopScreen;
import shopmenu.UpgradeScreen;
import sisiKneeBattle.BattleScreen;

public class GameStarter extends GUIApplication{
	
	private static final long serialVersionUID = 1L;
	
	public static StartScreen startScreen;
	public static MainMenuScreen mainMenuScreen;
	public static GameStarter start;
	public static SelectScreen selectScreen;
	public static ShopScreen shopScreen;
	public static RickyBuy buyScreen;
	public static DavidSell sellScreen;
	public static GarrettUpgradeScreen upgradeScreen;
	public static GarrettUpgradeScreen2 upgradeScreen2;
	public static CreditsScreen creditsScreen;
	public static BattleScreen battleScreen;
	public static Inventory inventory;
	public static ResultScreen resultScreen;
	public static MusicScreen musicScreen;
	public static SettingsScreen settingsScreen;
	public static ClickableScreen source;

	
	
	public GameStarter(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		inventory = new Inventory();
		inventory.setCurrency(1000);
		start = new GameStarter(1400,780);
		Thread go = new Thread(start);
		go.start();
		AudioTest.changeVolume(.6);
	}

	public static void setSource(ClickableScreen clickableScreen) {
		source = clickableScreen;
	}
	
	public void initScreen() {
		startScreen = new StartScreen(getWidth(),getHeight());
		mainMenuScreen = new MainMenuScreen(getWidth(),getHeight());
		selectScreen = new SelectScreen(getWidth(),getHeight());
		shopScreen = new ShopScreen(getWidth(),getHeight());
		upgradeScreen = new GarrettUpgradeScreen(getWidth(),getHeight());
		upgradeScreen2 = new GarrettUpgradeScreen2(getWidth(),getHeight());
		creditsScreen = new CreditsScreen(getWidth(),getHeight());
		battleScreen = new BattleScreen(getWidth(),getHeight());
		buyScreen = new RickyBuy(getWidth(),getHeight());
		sellScreen = new DavidSell(getWidth(),getHeight());
		resultScreen = new ResultScreen(getWidth(), getHeight());
		settingsScreen = new SettingsScreen(getWidth(),getHeight());
		GameStarter.musicScreen = new MusicScreen(getWidth(), getHeight(), source);
		setScreen(startScreen);
		AudioTest.playSound("resources/MainMenuMusic.wav");
	}
	
	public static Clip getStartSong() {
		return AudioTest.getClip();
	}
}