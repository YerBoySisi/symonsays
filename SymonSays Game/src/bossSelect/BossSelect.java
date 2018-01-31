package bossSelect;

import guiTeacher.GUIApplication;

public class BossSelect extends GUIApplication {

	public BossSelect(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SelectScreen s = new SelectScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		BossSelect sample = new BossSelect(1400, 780);
		Thread go = new Thread(sample);
		go.start();
	}

}
