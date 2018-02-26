package settingsCarsonAmanat;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import creditsCarsonAmanat.Credits;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAndStartScreen.GameStarter;

public class SettingsScreen extends FullFunctionScreen{
	public Button volumeSlider;
	private int volume;

	public SettingsScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/earth.jpg"));
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Button creditt = new Button(800,600,250,100,"Credits",Color.GRAY,new Action() {

			@Override
			public void act() {
				Settings.symon.setScreen(Credits.credits);
			}
		});
		Button exit = new Button(400,600,250,100,"Exit",Color.GRAY,new Action() {

			@Override
			public void act() {
				Settings.symon.setScreen(GameStarter.startScreen);
			}
		});
		TextLabel title = new TextLabel(getWidth()/2-100,getHeight()-750,300,200,"Settings");
		TextLabel volumeTitle = new TextLabel(250,250,200,100,"Volume");
		title.setCustomTextColor(Color.lightGray);
		volumeTitle.setCustomTextColor(Color.lightGray);
		

		volumeSlider = new Button(450, 275, 15, 15, "",Color.WHITE, null);
		viewObjects.add(title);
		viewObjects.add(creditt);
		viewObjects.add(exit);
		viewObjects.add(volumeSlider);
		viewObjects.add(volumeTitle);
	}

	public void mouseDragged(MouseEvent m) {
		super.mouseDragged(m);
		if(m.getY() >270 && m.getY()<325) {
			if(volumeSlider.getX()>449) 
				volumeSlider.setX(m.getX());
			if(volumeSlider.getX()<450)
				volumeSlider.setX(450);
			if(volumeSlider.getX()>1100)
			volumeSlider.setX(1100);
			volume = (int) ((volumeSlider.getX()-450)/6.5);
			if(getY()==275) 
				volumeSlider.setY(m.getY());
		}
	}

}
