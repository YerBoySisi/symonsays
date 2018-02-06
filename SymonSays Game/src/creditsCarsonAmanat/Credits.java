package creditsCarsonAmanat;

import guiTeacher.GUIApplication;
import mainMenuAndStartScreen.MainMenuScreen;
import settingsCarsonAmanat.SettingsScreen;

public class Credits extends GUIApplication{

	private static final long serialVersionUID = 1L;
	public static Credits sample;
	public static CreditsScreen credits;
	public static SettingsScreen settings;
	public static MainMenuScreen mainMenu;

	public Credits(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args){
		sample = new Credits(1400, 780);
		Thread go = new Thread(sample);
		go.start();
	}

	public void initScreen() {
		mainMenu = new MainMenuScreen(getWidth(), getHeight());
		settings = new SettingsScreen(getWidth(), getHeight());
		credits = new CreditsScreen(getWidth(), getHeight());
		setScreen(credits);
	}
}