package mainMenuAndStartScreen;

import java.util.ArrayList;

import guiTeacher.components.*;
import guiTeacher.interfaces.*;

public abstract class PaneDavid extends Pane{

	private ArrayList<ButtonDavid> buttons;
	
	public PaneDavid(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		ArrayList<ButtonDavid> buttons = getButtons();
		for(ButtonDavid b: buttons) {
			addObject(b);
		}
	}
	
	
	public abstract ArrayList<ButtonDavid> getButtons();


	public void formatButtons() {
		
	}

	public void addButton(ButtonDavid button) {
		buttons.add(button);
		formatButtons();
	}
}
