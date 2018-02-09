package mainMenuAndStartScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StartScreen extends FullFunctionScreen{

	public StartScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {try {
		File fontFile = new File("resources/orbitron-medium.otf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(48f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
	}
	TextLabel title = new TextLabel(20,20,500,100,"Symon Says");
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
	ButtonDavid startButton = new ButtonDavid(50,680,250,Color.lightGray,"Start Game",new Action() {
		
		public void act() {
			GameStarter.start.setScreen(GameStarter.mainMenuScreen);
		}
	});
	
	ButtonDavid creditsButton = new ButtonDavid(350,680,160,Color.lightGray,"Credits",new Action() {
		
		public void act() {
			GameStarter.start.setScreen(GameStarter.creditsScreen);
		}
	}); 
	viewObjects.add(creditsButton);
	viewObjects.add(startButton);
	}
	
}
