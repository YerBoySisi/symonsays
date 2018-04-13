package settingsCarsonAmanat;

import audioPlayer.AudioTest;
import guiTeacher.components.ClickableGraphic;
import startGame.GameStarter;

public class GearIcon extends ClickableGraphic{

	public GearIcon(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);

	}

	public void act() {
		GameStarter.start.setScreen(GameStarter.settingsScreen);
		AudioTest.playSound("resources/ButtonSound.wav");

	}

	public void setGraphic(String location,int w, int h) {
		loadImages(location, w, h);
		update();
	}

}
