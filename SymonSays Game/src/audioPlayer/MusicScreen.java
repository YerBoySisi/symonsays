package audioPlayer;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import audioPlayer.AudioPlayer;
import audioPlayer.AudioTest;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;

//David Yashayev

public class MusicScreen extends FullFunctionScreen{

	public MusicScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
	//	TestPane pane = new TestPane(this,0,0,300,200);
		try {
			File fontFile = new File("resources/orbitron-medium.otf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(48f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TextLabel title = new TextLabel((getWidth()/2)-200,20,500,100,"Music Selecter");
		Graphic background = new Graphic(0,0, getWidth(),getHeight(),"resources/earth.jpg");
		title.setCustomTextColor(Color.lightGray);
		viewObjects.add(background);
		viewObjects.add(title);
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.lightGray,"Back",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
				AudioTest.playSound("resources/ButtonSound.wav");
			}
		});
		
		viewObjects.add(backButton);
	}

}