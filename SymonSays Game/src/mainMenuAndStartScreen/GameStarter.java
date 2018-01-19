package mainMenuAndStartScreen;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class GameStarter extends GUIApplication{
	
	public static StartScreen startScreen;
	public static MainMenuScreen mainMenuScreen;
	public static GameStarter start;
	
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
		setScreen(mainMenuScreen);
	}

}
