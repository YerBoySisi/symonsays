package settingsCarsonAmanat;

import guiTeacher.components.ClickableGraphic;

public class GearIcon extends ClickableGraphic{

	public GearIcon(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);

	}

	public void act() {
		Settings.symon.setScreen(Settings.screen);
	}

	public void setGraphic(String location,int w, int h) {
		//graphic = new Graphic(0,0,1.0,location);
		loadImages(location, w, h);
		update();
	}

}
