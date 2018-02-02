package shopmenu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class UpgradeScreen extends FullFunctionScreen {
	
	private Button backButton;
	private TextLabel upgradeName1;
	private TextLabel upgradeName2;
	private TextLabel upgradeName3;
	private TextLabel title;
	private TextLabel pointsDisplay;
	private int upgradePoints = 0;
	private ArrayList<Button> buttons;

	public UpgradeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		//title.setTextColor(Color.BLUE);
		title = new TextLabel(550, 50, 200, 50, "Upgrades");
		viewObjects.add(title);
		upgradeName1 = new TextLabel(150, 100, 200, 50, "Riposte");
		viewObjects.add(upgradeName1);
		Graphic icon = new Graphic(110, 105, 40, 40,"shopUpgradeResources/riposte.png");
		viewObjects.add(icon);
		upgradeName2 = new TextLabel(550, 100, 270, 50, "Regeneration");
		upgradeName2.setForeground(Color.GREEN);
		viewObjects.add(upgradeName2);
		Graphic icon2 = new Graphic(515, 110, 30, 30,"shopUpgradeResources/heal.png");
		viewObjects.add(icon2);
		upgradeName3 = new TextLabel(1100, 100, 150, 50, "Agility");
		viewObjects.add(upgradeName3);
		Graphic icon3 = new Graphic(1070, 110, 30, 30,"shopUpgradeResources/agility.png");
		viewObjects.add(icon3);
		for(int i = 1; i < 4; i++) {
			TextArea upgradeDescription = new TextArea(100, 175 * i, 300, 300, "+ " + i * 5 + "% chance to attack again");
			viewObjects.add(upgradeDescription);
			TextLabel upgradeCost = new TextLabel(100, 100 + 175 * i, 300, 50, 50 * i + "UP");
			viewObjects.add(upgradeCost);
		}
		for(int i = 1; i < 4; i++) {
			TextArea upgradeDescription = new TextArea(550, 175 * i, 300, 300, "Heal " + i * 50 + "HP every turn");
			viewObjects.add(upgradeDescription);
			TextLabel upgradeCost = new TextLabel(550, 100 + 175 * i, 300, 50, 40 * i + "UP");
			viewObjects.add(upgradeCost);
		}
		for(int i = 1; i < 4; i++) {
			TextArea upgradeDescription = new TextArea(1000, 175 * i, 350, 300, "+ " + i * 2 + "% chance to dodge an attack");
			viewObjects.add(upgradeDescription);
			TextLabel upgradeCost = new TextLabel(1000, 100 + 175 * i, 300, 50, 30 * i + "UP");
			viewObjects.add(upgradeCost);
		}
		pointsDisplay = new TextColoredLabel(1200, 20, 200, 50, "UP: " + upgradePoints, Color.YELLOW, Color.CYAN);
		viewObjects.add(pointsDisplay);
		backButton = new Button(0, 20, 100, 50, "Back", new Action() {

			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
			
		});
		backButton.setForeground(Color.BLUE);
		viewObjects.add(backButton);
		addButtons();
		setButtonActions();
		for(Button b: buttons) {
			viewObjects.add(b);
		}
	}
	
	public void addButtons() {
		buttons = new ArrayList<Button>();
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				Button b = new Button(250 + 450 * (i - 1), 100 + 175 * j, 200, 50, "Upgrade", Color.GREEN, new Action() {

					@Override
					public void act() {
						
					}
					
				});
				if(j != 1) {
					b.setEnabled(false);
					b.setBackground(Color.RED);
					b.update();
				}
				buttons.add(b);
			}
		}
	}
	
	public void setButtonActions() {
		for(Button b: buttons) {
			b.setAction(new Action() {

				@Override
				public void act() {
					b.setEnabled(false);
					b.setBackground(null);
					b.setText("");
					b.update();
					if((buttons.indexOf(b) + 1) % 3 != 0) {
						Button nextButton = buttons.get(buttons.indexOf(b) + 1);
						nextButton.setEnabled(true);
						nextButton.setBackground(Color.GREEN);
						nextButton.update();
					}
				}
				
			});
		}
	}

}
