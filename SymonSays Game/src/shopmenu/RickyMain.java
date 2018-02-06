package shopmenu;

import guiTeacher.GUIApplication;

public class RickyMain extends GUIApplication {

	private static final long serialVersionUID = -5266639749714480096L;

	public RickyMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		RickyMain main = new RickyMain(800,550);
		Thread runner = new Thread(main);
		runner.start();
		
	}

	@Override
	public void initScreen() {
		RickyBuy screen = new RickyBuy(getWidth(),getHeight());
		setScreen(screen);
	}

}
