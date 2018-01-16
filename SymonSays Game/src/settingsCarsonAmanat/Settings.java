package settingsCarsonAmanat;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;

public class Settings extends GUIApplication{

	public static Settings sample;
	public static SettingsScreen symon;
	
	public Settings(int width, int height) {
		super(width, height);
		setVisible(true);	}

	public static void main(String[] args){
		sample = new Settings(1000, 1000);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	@Override
	public void initScreen() {
		symon = new SettingsScreen(getWidth(), getHeight());
		setScreen(symon);		
	}

}
