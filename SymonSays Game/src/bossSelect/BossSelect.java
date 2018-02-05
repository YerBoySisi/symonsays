package bossSelect;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;
import mainMenuAndStartScreen.MainMenuScreen;

public class BossSelect extends GUIApplication {
	
	public static Screen backScreen;
	public static BossSelect boss;

	public BossSelect(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SelectScreen s = new SelectScreen(getWidth(), getHeight());
		backScreen = new MainMenuScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		boss = new BossSelect(1400, 780);
		Thread go = new Thread(boss);
		go.start();
	}

}
