package shopmenu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
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
	private int upgradePoints;
	private ArrayList<Button> buttons;
	private int[] costs;

	public UpgradeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		setOrbitron();
		title = new TextLabel(550, 50, 250, 50, "UPGRADES");
		title.setCustomTextColor(Color.MAGENTA);
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
		setBankGothic();
		addBackgrounds(viewObjects);
		addDescriptions(viewObjects);
		setUpgradePoints(300);
		pointsDisplay = new TextLabel(1200, 20, 200, 50, "UP: " + getUpgradePoints());
		pointsDisplay.setCustomTextColor(Color.CYAN);
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
	
	private void addBackgrounds(List<Visible> viewObjects) {
		Color[] colors = {new Color (60,0,0), new Color (0,60,0), new Color (0,0,60)};
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				Button b = new Button(50 + 450 * (i - 1), 175 * j, 370, 160, "", colors[i - 1] , new Action() {

					@Override
					public void act() {
						// TODO Auto-generated method stub
						
					}
					
				});
				b.setEnabled(false);
				viewObjects.add(b);
			}
		};
	}

	public void addButtons() {
		buttons = new ArrayList<Button>();
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				Button b = new Button(200 + 450 * (i - 1), 100 + 175 * j, 200, 50, "Upgrade", Color.GREEN, new Action() {

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
					if(getUpgradePoints() >= costs[buttons.indexOf(b)]) {
						setUpgradePoints(getUpgradePoints() - costs[buttons.indexOf(b)]);
						pointsDisplay.setText("UP: " + getUpgradePoints());
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
				}
				
			});
		}
	}
	
	public void addDescriptions(List<Visible> viewObjects) {
		costs = new int[9];
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j <= 3; j++) {
				String desc = "";
				int cost = 50 - 10 * i;
				if(i == 0) {
					desc = "+" + j * 5 + "% chance to attack again";
				}
				if(i == 1) {
					desc = "Heal " + j * 50 + "HP every turn";
				}
				if(i == 2) {
					desc = "+" + j * 2 + "% chance to dodge an attack";
				}
				TextArea upgradeDescription = new TextArea(50 + 450 * i, 175 * j, 350, 300, desc);
				viewObjects.add(upgradeDescription);
				TextLabel upgradeCost = new TextLabel(50 + 450 * i, 100 + 175 * j, 300, 50, cost * j + "UP");
				upgradeCost.setCustomTextColor(Color.CYAN);
				viewObjects.add(upgradeCost);
				costs[i * 3 + (j - 1)] = cost * j;
			}
		}
	}

	public int getUpgradePoints() {
		return upgradePoints;
	}

	public void setUpgradePoints(int upgradePoints) {
		this.upgradePoints = upgradePoints;
	}
	
	public void setOrbitron() {
		try {
			File fontFile = new File("shopUpgradeResources//Orbitron-Black.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);
			StyledComponent.setBaseFont(font);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBankGothic() {
		try {
			File fontFile = new File("resources//bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);
			StyledComponent.setBaseFont(font);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
