package creditsCarsonAmanat;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;

public class Credits extends GUIApplication{

	public static Credits sample;
	public static CreditsScreen credits;
	
	public Credits(int width, int height) {
		super(width, height);
		setVisible(true);	}

	public static void main(String[] args){
		sample = new Credits(1000, 1000);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	@Override
	public void initScreen() {
		credits = new CreditsScreen(getWidth(), getHeight());
		setScreen(credits);		
	}

}