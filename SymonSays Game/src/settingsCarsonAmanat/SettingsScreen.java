package settingsCarsonAmanat;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;

import creditsCarsonAmanat.Credits;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SettingsScreen extends FullFunctionScreen implements Runnable{
	public ArrayList<MoveInterfaceAmanat> array;


	public boolean input;
	
	public ButtonInterfaceAmanat[] allButtons;

	public int oldButton;
	Color[] colors;
	
	public TextLabel displayRound;

	
	public SettingsScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	@Override
	public void run() {
		input = false;
		input = true;

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/earth.jpg"));
		Button credit = new Button(150,100,150,200,"Credits",new Action() {
			
			@Override
			public void act() {
				Settings.sample.setScreen(Credits.credits);
			}
		});
		for(int i = 0; i < 10; i++){
			viewObjects.add(new Comet(getWidth(), getHeight()));
		}
		viewObjects.add(credit);
		}
	

}
