package resultScreen;

import guiTeacher.GUIApplication;

public class ResultGui extends GUIApplication {
	
	
	public static ResultGui main;
	public static ResultScreen screen;
	public ResultGui(int width, int height) {
		super(width, height);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		main = new ResultGui(1400, 780);
		screen = new ResultScreen(1400, 780);
		Thread go = new Thread(main);
		go.start();
	}
	@Override
	public void initScreen() {
		screen = new ResultScreen(getWidth(), getHeight());
		setScreen(screen);
		
	}
	
	
	
}
