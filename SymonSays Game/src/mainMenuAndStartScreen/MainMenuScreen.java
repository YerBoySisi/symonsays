package mainMenuAndStartScreen;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainMenuScreen extends FullFunctionScreen{

	public MainMenuScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TextLabel title = new TextLabel(20,20,200,100,"Symon Says");
		Graphic background = new Graphic(0,0, getWidth(),getHeight(),"resources/earth.jpg");
		viewObjects.add(background);
		viewObjects.add(title);
		ButtonDavid startGameButton = new ButtonDavid(20,200 , 100,50 ,"Back",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.startScreen);
			}
		}); 
		viewObjects.add(startGameButton);
	}

}
