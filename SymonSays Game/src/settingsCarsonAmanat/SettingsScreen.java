package settingsCarsonAmanat;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JSlider;

import creditsCarsonAmanat.Credits;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SettingsScreen extends FullFunctionScreen{
	public ArrayList<MoveInterfaceAmanat> array;
	public Button volumeSlider;
	public Button volumeRect;

	public ButtonInterfaceAmanat[] allButtons;

	public int oldButton;
	Color[] colors;

	public TextLabel displayRound;
	private Graphics g;

	public SettingsScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/earth.jpg"));
		TextArea title = new TextArea(getWidth()/2-50, getHeight() - 300, 200, 200, "Settings");
		Button creditt = new Button(100,250,100,50,"Credits",Color.GRAY,new Action() {

			@Override
			public void act() {
				Settings.symon.setScreen(Credits.credits);
			}
		});
		Button exit = new Button(300,250,100,50,"Exit",Color.GRAY,new Action() {

			@Override
			public void act() {
			}
		});
		volumeSlider = new Button(100, 100, 15, 15, "",Color.WHITE, null);
		volumeRect = new Button(80, 80, 800, 100, "", Color.BLACK, new Action() {
			
			@Override
			public void act() {
					
				
			}
			
		});
		Button settingGear = new ButtonAmanat(400, 400, 200, 200, "", new Action() {
			
			@Override
			public void act() {
				Settings.symon.setScreen(Settings.screen);

				
			}
		});
		viewObjects.add(title);
		viewObjects.add(creditt);
		viewObjects.add(exit);
		viewObjects.add(volumeSlider);
		viewObjects.add(settingGear);

	}
	
	public void mouseDragged(MouseEvent m) {
		super.mouseDragged(m);
		if(volumeSlider.getX()>99) 
		volumeSlider.setX(m.getX());
		if(volumeSlider.getX()<100)
			volumeSlider.setX(100);
		if(getY()==100) 
		volumeSlider.setY(m.getY());
	}

}
