package mainMenuAndStartScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainMenuScreen extends FullFunctionScreen{

	public MainMenuScreen(int width, int height) {
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
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.lightGray,"Back",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.startScreen);
			}
		});
		
		ButtonDavid shopButton = new ButtonDavid(500,680,100,Color.lightGray,"Shop",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.shopScreen);
			}
		});
		
		ButtonDavid upgradeButton = new ButtonDavid(650,680,180,Color.lightGray,"Upgrade",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.upgradeScreen);
			}
		});
		ButtonDavid startGameButton = new ButtonDavid(200,680,250,Color.lightGray,"Select Boss",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.selectScreen);
			}
		}); 
		//pane.update();
	//	viewObjects.add(pane);
		viewObjects.add(upgradeButton);
		viewObjects.add(shopButton);
		viewObjects.add(startGameButton);
		viewObjects.add(backButton);
	}

}