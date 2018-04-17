package creditsCarsonAmanat;

import guiTeacher.GUIApplication;
import mainMenuAndStartScreen.MainMenuScreen;

public class CarsonCustodioProject extends GUIApplication{

	private static final long serialVersionUID = 1L;
	public static CarsonCustodioProject sample;
	public static CarsonCustodioProjectScreen screen;
	public static MainMenuScreen mainMenu;

	public CarsonCustodioProject(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args){
		sample = new CarsonCustodioProject(1400, 780);
		Thread go = new Thread(sample);
		go.start();
	}

	public void initScreen() {
		mainMenu = new MainMenuScreen(getWidth(), getHeight());
		screen = new CarsonCustodioProjectScreen(getWidth(), getHeight());
		setScreen(screen);
	}
}