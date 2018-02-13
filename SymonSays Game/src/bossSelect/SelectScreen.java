package bossSelect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAndStartScreen.ButtonDavid;
import mainMenuAndStartScreen.GameStarter;

public class SelectScreen extends FullFunctionScreen {
	//Fahad
	
	
	private String name;
	private int wh;
	private int y;
	private int bossNumber;
	private Graphic background;
	private String link;
	private TextArea txt;
	private int level;
	private int levelRec; 

	public SelectScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		initGothicFont(24f);
		initValues();
		//StyledComponent.setButtonOutline(true);
		//StyledComponent.setActiveBorderColor(Color.white);
		initOrbitronFont(40f);
		TextArea title = new TextArea(20, 20, 300, 150,"Boss Select");
		initGothicFont(30f);
		Button boss1Button = new Button(20, y, wh, wh, "", new Action() {
			public void act() {
				changeText(viewObjects,"Ridley",1,"resources/Ridley.png",5,1,0);
				changeColor(title,txt,Color.MAGENTA);
			}
		});
		Button boss2Button = new Button(140, y, wh, wh, "", new Action() {
			public void act() {
				changeText(viewObjects,"Rambo Lun",1,"resources/Soldier.jpg",5,1,1);
				changeColor(title,txt,Color.black);
			}
		});
		Button boss3Button = new Button(260, y, wh, wh, "", new Action() {
			public void act() {
				changeText(viewObjects,"Boss 3",1,"resources/Turtle.jpg",5,1,2);
				changeColor(title,txt,Color.white);
			}
		});
		Button boss4Button = new Button(380, y, wh, wh, "", new Action() {
			public void act() {
				changeText(viewObjects,"Boss 4",1,"resources/Shark.jpg",5,1,3);
				changeColor(title,txt,Color.white);
			}
		});
		Button boss5Button = new Button(500, y, wh, wh, "", new Action() {
			public void act() {
				changeText(viewObjects,"Boss 5",1,"resources/Simon.jpg",5,1,4);
				changeColor(title,txt,Color.white);
			}
		});
		Button boss6Button = new Button(620, y, wh, wh, "", new Action() {
			public void act() {
				changeText(viewObjects,"Boss 6",1,"resources/Shark.jpg",5,1,5);
				changeColor(title,txt,Color.white);
			}
		});
		initGothicFont(36f);
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.lightGray,"Back",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
			}
		});
		ButtonDavid startButton = new ButtonDavid(1060,680,260,Color.lightGray,"Start Battle",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.battleScreen);
			}
		});
		initGothicFont(36f);
		background = new Graphic(0, 0, getWidth(), getHeight(), link);
		txt = new TextArea(20, 250, 500, 300,"Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
		viewObjects.add(background);
		addIcons(viewObjects);
		viewObjects.add(title);
		viewObjects.add(boss1Button);
		viewObjects.add(boss2Button);
		viewObjects.add(boss3Button);
		viewObjects.add(boss4Button);
		viewObjects.add(boss5Button);
		viewObjects.add(boss6Button);
		viewObjects.add(backButton);
		viewObjects.add(startButton);
		viewObjects.add(txt);
		//boss1Button.setForeground(Color.white);
		//boss2Button.setForeground(Color.white);
		//boss3Button.setForeground(Color.white);
		//boss4Button.setForeground(Color.white);
		//boss5Button.setForeground(Color.white);
		//boss6Button.setForeground(Color.white);
		txt.setCustomTextColor(Color.MAGENTA);
		title.setCustomTextColor(Color.MAGENTA);
	}


	public void initGothicFont(float f) {
		try {
		File fontFile = new File("resources/bankgothic_medium_bt.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}


	public void initOrbitronFont(float f) {
		try {
		File fontFile = new File("resources/orbitron-bold.otf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}


	public void initValues() {
		wh = 100;
		y = getHeight() / 10;
		name = "Boss 1";
		bossNumber = 0;
		link = "resources/Ridley.png";
		level = 5;
		levelRec = 1;
	}

	public void changeText(List<Visible> viewObjects, String string, int i, String string2, int j, int k, int l) {
		name = string;
		bossNumber = i;
		link = string2;
		level = j;
		levelRec = k;
		bossNumber=l;
		txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
		background = new Graphic(0, 0, getWidth(), getHeight(), link);
		viewObjects.add(0, background);
		viewObjects.remove(1);
	}


	public void addIcons(List<Visible> viewObjects) {
		String[] links = {"resources/Ridley Icon.png","resources/Soldier Icon.png","resources/Turtle Icon.png","resources/Shark Icon.png","resources/Simon Icon.png"};
		int x = 20;
		for(int i = 0; i < links.length; i++) {
			Graphic icon = new Graphic(x, y, wh, wh, links[i]);
			x = x + 120;
			viewObjects.add(icon);
		}
	}

	public void changeColor(TextArea title, TextArea txt, Color textColor) {
		title.setCustomTextColor(textColor);
		txt.setCustomTextColor(textColor);
	}

}
