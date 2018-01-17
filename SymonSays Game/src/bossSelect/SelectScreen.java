package bossSelect;

import java.awt.Color;
import java.util.List;


import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SelectScreen extends FullFunctionScreen {
	
	private String name;
	private String link;
	private int level;
	private int levelRec; 

	public SelectScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		
		Button bossButton = new Button(20, 20, 300, 100, "Leviathan", new Action() {
			
			
			public void act() {
				name = "Leviathan";
				link = "";
				level = 5;
				levelRec = 1;
			}
		});
		bossButton.setForeground(Color.BLACK);
		bossButton.update();
		viewObjects.add(bossButton);
	}

}
