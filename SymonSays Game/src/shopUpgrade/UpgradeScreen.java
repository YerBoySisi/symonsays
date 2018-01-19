package shopUpgrade;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import shopmenu.ShopMain;

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
		backButton.setTextColor(Color.BLACK);
		backButton = new Button(0,20,100,50,"Back", new Action() {

			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
			
		});
		viewObjects.add(backButton);
	}

}
