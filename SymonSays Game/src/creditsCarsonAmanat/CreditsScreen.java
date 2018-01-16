package creditsCarsonAmanat;

import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class CreditsScreen extends ClickableScreen implements Runnable{

	private static final long serialVersionUID = 1L;

	public CreditsScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	
	public void run() {
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		TextLabel title = new TextLabel(100, 100, 200, 100, "Credits");
		viewObjects.add(title);
	}

}