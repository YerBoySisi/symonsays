package mainMenuAndStartScreen;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceDavid extends Clickable{

	void dim();
	
	void highlight();
	
	void setColor(Color c);
}
