package settingsCarsonAmanat;

import java.util.ArrayList;
import java.awt.Color;
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


	public ButtonInterfaceAmanat[] allButtons;

	public int oldButton;
	Color[] colors;

	public TextLabel displayRound;


	private JSlider slider;


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
		//slider = new JSlider(0,100,100);
		//slider.setMajorTickSpacing(10);
		//slider.setMinorTickSpacing(1);
		//slider.setPaintTicks(true);
		//slider.setPaintLabels(true);
		//viewObjects.add(slider);
		viewObjects.add(title);
		viewObjects.add(creditt);
		viewObjects.add(exit);

	}

}
