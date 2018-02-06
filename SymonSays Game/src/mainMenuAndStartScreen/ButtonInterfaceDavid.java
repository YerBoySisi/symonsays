package mainMenuAndStartScreen;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceDavid extends Clickable{

	void dim();
	
	void highlight();
	
	void setAction(Action action);
	
	void setColor(Color c);
}
