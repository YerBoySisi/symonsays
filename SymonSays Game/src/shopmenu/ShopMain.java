package shopmenu;

import guiTeacher.GUIApplication;

public class ShopMain extends GUIApplication {
	
	public static ShopScreen s1;

	public ShopMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	public static void main(String[] args) {
		ShopMain shop = new ShopMain(800, 550);
		Thread runner = new Thread(shop);
		runner.start();
	}

	@Override
	public void initScreen() {
		s1 = new ShopScreen(getWidth(), getHeight());
		setScreen(s1);
		
	}

}
