package shopUpgrade;

import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class UpgradeScreen extends FullFunctionScreen {
	
	private Button backButton;
	private Button upgradeButton;
	private TextArea upgradeDescription;
	private TextLabel upgradeName;
	private int upgradePoints;

	public UpgradeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}

}
