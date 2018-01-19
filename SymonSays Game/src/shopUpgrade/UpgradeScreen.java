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
	private TextLabel title;
	private int upgradePoints;

	public UpgradeScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextLabel(400,50,100,50,"Upgrades");
		title.setTextColor(Color.WHITE);
		viewObjects.add(title);
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"shopUpgradeResources/bgrnd.jpg"));
		backButton = new Button(0,20,100,50,"Back", new Action() {

			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
			
		});
		viewObjects.add(backButton);
	}

}
