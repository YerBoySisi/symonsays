package settingsCarsonAmanat;

import creditsCarsonAmanat.Credits;
import guiTeacher.GUIApplication;

public class Settings extends GUIApplication{

	public static Settings symon;
	public static SettingsScreen screen;
	public static Credits credits;
	
	public Settings(int width, int height) {
		super(width, height);
		setVisible(true);	}

	public static void main(String[] args){
		symon = new Settings(1400, 780);
		Thread go = new Thread(symon);
		go.start();
		
		
	}
	@Override
	public void initScreen() {
		screen = new SettingsScreen(getWidth(), getHeight());
		credits = new Credits(1400, 780);
		setScreen(screen);		
	}

}
