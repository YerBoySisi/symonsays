package bossSelect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;

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
	private TextArea title; 

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
		title = new TextArea(20, 20, 300, 150,"Boss Select");
		initGothicFont(30f);
//		createButtons(viewObjects);
//		Button boss1Button = new Button(20, y, wh, wh, "", new Action() {
//			public void act() {
//				changeText(viewObjects,"Ridley","resources/Ridley.png",5,1,0);
//				changeColor(title,txt,Color.MAGENTA);
//			}
//		});
//		Button boss2Button = new Button(140, y, wh, wh, "", new Action() {
//			public void act() {
//				changeText(viewObjects,"Rambo Lun","resources/Soldier.jpg",5,1,1);
//				changeColor(title,txt,new Color(139, 0, 0));
//			}
//		});
//		Button boss3Button = new Button(260, y, wh, wh, "", new Action() {
//			public void act() {
//				changeText(viewObjects,"Boss 3","resources/Turtle.jpg",5,1,2);
//				changeColor(title,txt,Color.green);
//			}
//		});
//		Button boss4Button = new Button(380, y, wh, wh, "", new Action() {
//			public void act() {
//				changeText(viewObjects,"Boss 4","resources/Shark.jpg",5,1,3);
//				changeColor(title,txt,Color.cyan);
//			}
//		});
//		Button boss5Button = new Button(500, y, wh, wh, "", new Action() {
//			public void act() {
//				changeText(viewObjects,"Boss 5","resources/Simon.jpg",5,1,4);
//				changeColor(title,txt,Color.white);
//			}
//		});
//		Button boss6Button = new Button(620, y, wh, wh, "", new Action() {
//			public void act() {
//				changeText(viewObjects,"Symon","resources/Void.jpg",5,1,5);
//				txt.setText("Name: " + name + "\n\nLevel: ???\n\nLevel Rec: ???");
//				changeColor(title,txt,Color.pink);
//			}
//		});
		initGothicFont(36f);
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.lightGray,"Back",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
				AudioTest.playSound("resources/ButtonSound.wav");
			}
		});
		ButtonDavid startButton = new ButtonDavid(1060,680,260,Color.lightGray,"Start Battle",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.battleScreen);
				AudioTest.stopSound(AudioTest.getClip());
				AudioTest.playSound("resources/ButtonSound.wav");
				AudioTest.changeVolume(.01);
				AudioTest.playSound("resources/BattleMusic.wav");
			}
		});
		initGothicFont(36f);
		background = new Graphic(0, 0, getWidth(), getHeight(), link);
		txt = new TextArea(20, 250, 500, 300,"Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
		viewObjects.add(background);
		addIcons(viewObjects);
		viewObjects.add(title);
		createButtons(viewObjects);
//		viewObjects.add(boss1Button);
//		viewObjects.add(boss2Button);
//		viewObjects.add(boss3Button);
//		viewObjects.add(boss4Button);
//		viewObjects.add(boss5Button);
//		viewObjects.add(boss6Button);
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
	
	public void createButtons(List<Visible> viewObjects) {
		String[] names = {"Ridley","Rambo Lun","Turtle","Shark","Simon","Symon"};
		String[] links = {"resources/Ridley.png","resources/Soldier.jpg","resources/Turtle.jpg","resources/Shark.jpg","resources/Simon.jpg","resources/Void.jpg"};
		Color[] colors= {Color.MAGENTA, new Color(139, 0, 0), Color.green,Color.cyan,Color.white,Color.pink};
		int x = 20;
		Button button;
		for(int i = 0; i< names.length; i++) {
			final int temp = i;
			if(i<names.length-1) {
				button = new Button(x, y, wh, wh, "", new Action() {
					public void act() {
						changeText(viewObjects,names[temp],links[temp],temp);
						changeColor(title,txt,colors[temp]);
					}
				});
			}
			else {
				button = new Button(x, y, wh, wh, "", new Action() {
					public void act() {
						changeText(viewObjects,names[temp],links[temp],temp);
						changeColor(title,txt,colors[temp]);
						txt.setText("Name: " + name + "\n\nLevel: ???\n\nLevel Rec: ???");
					}
				});
			}
			viewObjects.add(button);
			x= x +120;
			update();
		}
	}

	public void changeText(List<Visible> viewObjects, String string, String string2, int j) {
		name = string;
		link = string2;
		bossNumber=j;
		txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
		background = new Graphic(0, 0, getWidth(), getHeight(), link);
		viewObjects.add(0, background);
		viewObjects.remove(1);
	}


	public void addIcons(List<Visible> viewObjects) {
		String[] links = {"Ridley","Soldier","Turtle", "Shark","Simon","Symon"};
		int x = 20;
		for(int i = 0; i < links.length; i++) {
			Graphic icon = new Graphic(x, y, wh, wh, "resources/" + links[i] + " Icon.png");
			x = x + 120;
			viewObjects.add(icon);
		}
	}

	public void changeColor(TextArea title, TextArea txt, Color textColor) {
		title.setCustomTextColor(textColor);
		txt.setCustomTextColor(textColor);
	}

}
