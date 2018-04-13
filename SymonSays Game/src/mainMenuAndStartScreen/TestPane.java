package mainMenuAndStartScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

//David Yashayev

public class TestPane extends Pane{

	
	private TextArea text;

	public TestPane(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextArea(0, 0, 100, 100, "TEST");
		viewObjects.add(text);
		
	}

}
