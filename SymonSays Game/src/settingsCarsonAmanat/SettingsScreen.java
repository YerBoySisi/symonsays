package settingsCarsonAmanat;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JSlider;

import creditsCarsonAmanat.Credits;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
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
		Button creditt = new Button(100,250,100,50,"Credits",Color.GRAY,new Action() {

			@Override
			public void act() {
				Settings.symon.setScreen(Credits.credits);
			}
		});
		ImageIcon gearIcon = createImageIcon("resources/gear.png");
		Button exit = new Button(300,250,100,50,"Exit",Color.GRAY,new Action() {

			@Override
			public void act() {
			}
		});
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {

			e.printStackTrace();
		}

		TextLabel title = new TextLabel(getWidth()/2-100,getHeight()-750,300,200,"Settings");
		title.setCustomTextColor(Color.lightGray);
		volumeSlider = new Button(100, 100, 15, 15, "",Color.WHITE, null);
		volumeRect = new Button(80, 80, 200, 100, "", Color.BLACK, new Action() {

			@Override
			public void act() {


			}

		});
		ButtonAmanat settingGear = new ButtonAmanat(400, 400, 120, 120, gearIcon);
		viewObjects.add(title);
		viewObjects.add(creditt);
		viewObjects.add(exit);
		viewObjects.add(volumeSlider);
		viewObjects.add(settingGear);

	}

	public static ImageIcon createImageIcon(String path) {
		return new ImageIcon("resources/gear.png");
	}

	public void mouseDragged(MouseEvent m) {
		super.mouseDragged(m);
		super.mouseClicked(m);
		if(m.getY() >95 && m.getY()<150) {
			if(volumeSlider.getX()>99) 
				volumeSlider.setX(m.getX());
			if(volumeSlider.getX()<100)
				volumeSlider.setX(100);
			if(getY()==100) 
				volumeSlider.setY(m.getY());
		}
	}

}
