package shopmenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class UpgradeScreen extends FullFunctionScreen {
	
	private Button backButton;
	private Button upgradeButton;
	private TextArea upgradeDescription;
	private TextLabel upgradeName;
	private TextLabel title;
	private int upgradePoints;

	public UpgradeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		title.setTextColor(Color.WHITE);
		title = new TextLabel(600, 50, 200, 50, "Upgrades");
		title.setBodyAlign(0);
		viewObjects.add(title);
		upgradeName = new TextLabel(150, 100, 200, 50, "Riposte");
		viewObjects.add(upgradeName);
		upgradeName = new TextLabel(600, 100, 200, 50, "Regeneration");
		viewObjects.add(upgradeName);
		Graphic icon2 = new Graphic(595, 100, 25, 25,"shopUpgradeResources/heal.png");
		viewObjects.add(icon2);
		upgradeName = new TextLabel(1050, 100, 100, 50, "Agility");
		viewObjects.add(upgradeName);
		Graphic icon = new Graphic(1035, 100, 25, 25,"shopUpgradeResources/agility.png");
		viewObjects.add(icon);
		backButton.setTextColor(Color.WHITE);
		backButton = new Button(0, 20, 100, 50, "Back", new Action() {

			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
			
		});
		viewObjects.add(backButton);
	}

}
