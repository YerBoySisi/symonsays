 package resultScreen;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ResultScreen extends FullFunctionScreen {
	public String bossName;
	public int bossLVL;
	
	public ResultScreen(int width, int height) {
		super(width, height);
		
		// TODO Auto-generated constructor stub
	}
	public void defineValues() {
		bossName = sisi.bossName();
		bossLVL =  ;
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/black.jpg");
		viewObjects.add(backGround);
		
	}

}
