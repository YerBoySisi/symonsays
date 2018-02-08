 package resultScreen;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ResultScreen extends FullFunctionScreen{
	public String bossName;
	public boolean outcome;
	
	public ResultScreen(int width, int height) {
		super(width, height);
		
		// TODO Auto-generated constructor stub
	}
	public void defineValues() {
		//bossName = sisi.bossName();
		//outcome =  sisi.determineWinner();
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/black.jpg");
		viewObjects.add(backGround);
		//Graphic backGround = new Graphic(0 , 0, getWidth(), getHeight(), "resources/"+bossName+".jpg");
		//viewObjects.add(backGround);
		if(outcome) {
			TextLabel result = new TextLabel(570, 20, 200, 200, "You Win");
			result.setCustomTextColor(Color.WHITE);
			result.setSize(50);
			viewObjects.add(result);
			
		}
		//else {
			TextLabel resultL = new TextLabel(570, 20, 250, 200, "You Lose");
			resultL.setCustomTextColor(Color.WHITE);
			resultL.setSize(50);
			viewObjects.add(resultL);
		//}
		mainCharacter
	}

}