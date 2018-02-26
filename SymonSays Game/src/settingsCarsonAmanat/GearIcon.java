package settingsCarsonAmanat;

import creditsCarsonAmanat.Credits;
import guiTeacher.components.ClickableGraphic;

public class GearIcon extends ClickableGraphic{

	public GearIcon(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);

	}

	public void act() {
		Settings.symon.setScreen(Credits.credits);
	}

	public void setGraphic(String location,int w, int h) {
		loadImages(location, w, h);
		update();
	}

}
