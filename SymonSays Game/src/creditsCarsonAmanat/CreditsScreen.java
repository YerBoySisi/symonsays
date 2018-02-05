package creditsCarsonAmanat;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import mainMenuAndStartScreen.ButtonDavid;

public class CreditsScreen extends ClickableScreen implements Runnable{

	private static final long serialVersionUID = 1L;

	public CreditsScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {

	}

	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/earth.jpg");
		viewObjects.add(background);
		TextLabel title = new TextLabel(20, 20, 200, 100, "Credits");
		viewObjects.add(title);
		ScrollingText s = new ScrollingText(-800);
		viewObjects.add(s);
		ButtonDavid settingsButton = new ButtonDavid(50, 680, 250, Color.WHITE, "Settings", new Action() {
			public void act() {
				Credits.sample.setScreen(Credits.settings);
			}
		});
		viewObjects.add(settingsButton);
		ButtonDavid mainMenuButton = new ButtonDavid(50, 630, 250, Color.WHITE, "Main Menu", new Action() {
			public void act() {
				Credits.sample.setScreen(Credits.mainMenu);
			}
		});
		viewObjects.add(mainMenuButton);
	}
	
}