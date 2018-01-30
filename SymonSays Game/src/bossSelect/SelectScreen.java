package bossSelect;

import java.awt.Color;
import java.util.List;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SelectScreen extends FullFunctionScreen {
	
	
	private String name;
	private String link;
	private TextArea txt;
	private int level;
	private int levelRec; 

	public SelectScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		
		Button boss1Button = new Button(20, 20, 75, 75, "Boss 1", new Action() {
			public void act() {
				name = "Boss 1";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
			}
		});
		Button boss2Button = new Button(120, 20, 75, 75, "Boss 2", new Action() {
			public void act() {
				name = "Boss 2";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
			}
		});
		Button boss3Button = new Button(220, 20, 75, 75, "Boss 3", new Action() {
			public void act() {
				name = "Boss 3";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
			}
		});
		Button boss4Button = new Button(320, 20, 75, 75, "Boss 4", new Action() {
			public void act() {
				name = "Boss 4";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
			}
		});
		Button boss5Button = new Button(420, 20, 75, 75, "Boss 5", new Action() {
			public void act() {
				name = "Boss 5";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
			}
		});
		Button boss6Button = new Button(520, 20, 75, 75, "Boss 6", new Action() {
			public void act() {
				name = "Boss 6";
				link = "";
				level = 5;
				levelRec = 1;
				txt.setText("Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
			}
		});
		txt = new TextArea(20, 250, 300, 300,"Name: " + name + "\nLevel: " + level + "\nLevel Rec: " + levelRec);
		viewObjects.add(boss1Button);
		viewObjects.add(boss2Button);
		viewObjects.add(boss3Button);
		viewObjects.add(boss4Button);
		viewObjects.add(boss5Button);
		viewObjects.add(boss6Button);
		viewObjects.add(txt);
	}

}
