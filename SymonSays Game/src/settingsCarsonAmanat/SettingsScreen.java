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
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import javax.sound.sampled.*;


import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;

public class SettingsScreen extends FullFunctionScreen{
	public Button volumeSlider;
	public static int volume;

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

		TextArea title = new TextArea(getWidth()/2-100,getHeight()-750,300,200,"Settings");
		ButtonDavid creditt = new ButtonDavid(900,680,250, Color.lightGray, "Credits",new Action() {

			public void act() {
				GameStarter.start.setScreen(GameStarter.creditsScreen);
			}
		});
		ButtonDavid exit = new ButtonDavid(300,680,250,Color.lightGray,"Exit",new Action() {

			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.startScreen);
			}
		});
		TextLabel volumeTitle = new TextLabel(250,250,200,100,"Volume");
		title.setCustomTextColor(Color.lightGray);
		volumeTitle.setCustomTextColor(Color.lightGray);
		

		volumeSlider = new Button(1100, 275, 15, 15, "",Color.WHITE, null);
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
