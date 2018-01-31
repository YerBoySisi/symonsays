package resultScreen;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ResultScreen extends FullFunctionScreen implements ShareableInfoNabeel  {
	public String bossName;
	public int bossLVL;
	
	public ResultScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	public void defineValues() {
		bossName =  BossName;
		bossLVL =  bossLVL1;
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

}
