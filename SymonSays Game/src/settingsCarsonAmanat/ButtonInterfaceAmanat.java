package settingsCarsonAmanat;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceAmanat extends Clickable{
	
	void dim();
	
	void highlight();
 
	void setAction(Action action);

	void setColor(Color color);
}
