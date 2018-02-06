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
	
	
	private String name;
	private int wh;
	private int y;
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
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
		Button boss1Button = new Button(20, y, wh, wh, "Boss 1", new Action() {
			public void act() {
				name = "Boss 1";
				link = "resources/Ridley.png";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss2Button = new Button(140, y, wh, wh, "Boss 2", new Action() {
			public void act() {
				name = "Boss 2";
				link = "resources/Xeno.jpg";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss3Button = new Button(260, y, wh, wh, "Boss 3", new Action() {
			public void act() {
				name = "Boss 3";
				link = "resources/Ghaul.jpg";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss4Button = new Button(380, y, wh, wh, "Boss 4", new Action() {
			public void act() {
				name = "Boss 4";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss5Button = new Button(500, y, wh, wh, "Boss 5", new Action() {
			public void act() {
				name = "Boss 5";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss6Button = new Button(620, y, wh, wh, "Boss 6", new Action() {
			public void act() {
				name = "Boss 6";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		initGothicFont(36f);
		ButtonDavid backButton = new ButtonDavid(50,680,100,Color.lightGray,"Back",new Action() {
			
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
			}
		});
		initGothicFont(30f);
		background = new Graphic(0, 0, 1400, 780, link);
		txt = new TextArea(20, 250, 300, 300,"Name: " + name + "\n\nLevel: " + level + "\n\nLevel Rec: " + levelRec);
		viewObjects.add(background);
		addIcons(viewObjects);
		viewObjects.add(boss1Button);
		viewObjects.add(boss2Button);
		viewObjects.add(boss3Button);
		viewObjects.add(boss4Button);
		viewObjects.add(boss5Button);
		viewObjects.add(boss6Button);
		viewObjects.add(backButton);
		viewObjects.add(txt);
		boss1Button.setForeground(Color.white);
		boss2Button.setForeground(Color.white);
		boss3Button.setForeground(Color.white);
		boss4Button.setForeground(Color.white);
		boss5Button.setForeground(Color.white);
		boss6Button.setForeground(Color.white);
		txt.setCustomTextColor(Color.white);
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


	public void initValues() {
		wh = 100;
		y = getHeight() / 15;
		name = "Boss 1";
		link = "resources/Ridley.png";
		level = 5;
		levelRec = 1;
		
	}


	public void addIcons(List<Visible> viewObjects) {
		String[] links = {"resources/Dragon Icon.png","resources/Xeno Icon.png","resources/Ghaul Icon.png"};
		int x = 20;
		for(int i = 0; i < links.length; i++) {
			Graphic icon = new Graphic(x, y, wh, wh, links[i]);
			x = x + 120;
			viewObjects.add(icon);
		}
	}

}
