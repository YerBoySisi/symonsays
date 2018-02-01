package bossSelect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

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
		initFont();
		initValues();
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
		BossButton boss1Button = new BossButton(20, y, wh, wh, "Boss 1", new Action() {
			public void act() {
				name = "Boss 1";
				link = "resources/Dragon.jpg";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss2Button = new BossButton(140, y, wh, wh, "Boss 2", new Action() {
			public void act() {
				name = "Boss 2";
				link = "resources/Xeno.jpg";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss3Button = new BossButton(260, y, wh, wh, "Boss 3", new Action() {
			public void act() {
				name = "Boss 3";
				link = "resources/Ghaul.jpg";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss4Button = new BossButton(380, y, wh, wh, "Boss 4", new Action() {
			public void act() {
				name = "Boss 4";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss5Button = new BossButton(500, y, wh, wh, "Boss 5", new Action() {
			public void act() {
				name = "Boss 5";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
		Button boss6Button = new BossButton(620, y, wh, wh, "Boss 6", new Action() {
			public void act() {
				name = "Boss 6";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
				background = new Graphic(0, 0, getWidth(), getHeight(), link);
				viewObjects.add(0, background);
				viewObjects.remove(1);
			}
		});
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
		viewObjects.add(txt);
		boss1Button.setForeground(Color.white);
		boss2Button.setForeground(Color.white);
		boss3Button.setForeground(Color.white);
		boss4Button.setForeground(Color.white);
		boss5Button.setForeground(Color.white);
		boss6Button.setForeground(Color.white);
	}
	
	public void initFont() {
		try {
		File fontFile = new File("resources/orbitron-bold.otf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(24f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}


	public void initValues() {
		wh = 100;
		y = getHeight() / 15;
		name = "Boss 1";
		link = "resources/Dragon.jpg";
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
