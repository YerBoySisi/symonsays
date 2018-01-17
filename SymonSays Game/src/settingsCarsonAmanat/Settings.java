package settingsCarsonAmanat;

import java.io.File;

import creditsCarsonAmanat.Credits;
import guiTeacher.GUIApplication;

public class Settings extends GUIApplication{

	public static Settings sample;
	public static SettingsScreen symon;
	public static Credits credits;
	
	public Settings(int width, int height) {
		super(width, height);
		setVisible(true);	}

	public static void main(String[] args){
		sample = new Settings(500, 350);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	@Override
	public void initScreen() {
		symon = new SettingsScreen(getWidth(), getHeight());
		setScreen(symon);		
	}

}
