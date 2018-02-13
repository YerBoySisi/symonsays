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
import mainMenuAndStartScreen.ButtonDavid;

public class GarrettUpgradeScreen extends FullFunctionScreen {

	private ButtonDavid backButton;
	private ButtonDavid nextButton;
	private TextLabel upgradeName1;
	private TextLabel upgradeName2;
	private TextLabel upgradeName3;
	private TextLabel title;
	private TextLabel pointsDisplay;
	private int upgradePoints;
	private ArrayList<Button> buttons;
	private Upgrade riposte;
	private Upgrade regeneration;
	private Upgrade agility;
	private int riposteLevel = 0;
	private int regenerationLevel = 0;
	private int agilityLevel = 0;
	private Upgrade[] upgrades;
	private int[] costs;

	public GarrettUpgradeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.WHITE);
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		setOrbitron();
		title = new TextLabel(550, 50, 250, 50, "UPGRADES");
		title.setCustomTextColor(Color.MAGENTA);
		viewObjects.add(title);
		upgradeName1 = new TextLabel(175, 100, 200, 50, "Riposte");
		Graphic icon = new Graphic(125, 105, 40, 40,"shopUpgradeResources/riposte.png");
		upgradeName2 = new TextLabel(575, 100, 270, 50, "Regeneration");
		Graphic icon2 = new Graphic(540, 110, 30, 30,"shopUpgradeResources/heal.png");
		upgradeName3 = new TextLabel(1100, 100, 150, 50, "Agility");
		Graphic icon3 = new Graphic(1070, 110, 30, 30,"shopUpgradeResources/agility.png");
		viewObjects.add(upgradeName1);
		viewObjects.add(upgradeName2);
		viewObjects.add(upgradeName3);
		viewObjects.add(icon);
		viewObjects.add(icon2);
		viewObjects.add(icon3);
		setBankGothic();
		addBackgrounds(viewObjects);
		addDescriptions(viewObjects);
		setUpgradePoints(300);
		pointsDisplay = new TextLabel(1200, 20, 200, 50, "UP: " + getUpgradePoints());
		pointsDisplay.setCustomTextColor(Color.CYAN);
		viewObjects.add(pointsDisplay);
		backButton = new ButtonDavid(30, 700, 100, Color.LIGHT_GRAY, "Back", new Action() {

			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}

		});
		viewObjects.add(backButton);
		addbuttons();
		setButtonActions();
		for(Button b: buttons) {
			viewObjects.add(b);
		}
		nextButton = new ButtonDavid(1200, 700, 100, Color.LIGHT_GRAY, "Next", new Action() {

			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s6);
				}

		});
		viewObjects.add(nextButton);
	}

	private void addBackgrounds(List<Visible> viewObjects) {
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j <= 3; j++) {
				Button b = new Button(50 + 450 * i, 175 * j, 370, 160, "", new Action() {

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

	public void addbuttons() {
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
						b.setBackground(Color.WHITE);
						b.setText("Upgraded");
						b.update();
						if((buttons.indexOf(b) + 1) % 3 != 0) {
							Button nextButton = buttons.get(buttons.indexOf(b) + 1);
							nextButton.setEnabled(true);
							nextButton.setBackground(Color.GREEN);
							nextButton.update();
						}
						if(buttons.indexOf(b) >= 0 && buttons.indexOf(b) <= 2) {
							riposteLevel++;
						}
						if(buttons.indexOf(b) >= 3 && buttons.indexOf(b) <= 5) {
							regenerationLevel++;
						}
						if(buttons.indexOf(b) >= 6 && buttons.indexOf(b) <= 8) {
							agilityLevel++;
						}
					}
				}
			});
		}
	}

	public void addDescriptions(List<Visible> viewObjects) {
		createUpgradeList();
		costs = new int[9];
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j <= 3; j++) {
				String desc = upgrades[i].getDesc();
				int cost = upgrades[i].getCost();
				TextArea upgradeDescription = new TextArea(50 + 450 * i, 175 * j, 350, 300, "+" + upgrades[i].getMultiple() * j + desc);
				viewObjects.add(upgradeDescription);
				TextLabel upgradeCost = new TextLabel(50 + 450 * i, 100 + 175 * j, 300, 50, cost * j + "UP");
				upgradeCost.setCustomTextColor(Color.CYAN);
				viewObjects.add(upgradeCost);
				costs[i * 3 + (j - 1)] = cost * j;
			}
		}
	}

	public void createUpgradeList() {
		riposte = new Upgrade(5, 50, "% chance to attack again");
		regeneration = new Upgrade(50, 40, "HP healed each turn");
		agility = new Upgrade(2, 25, "% chance to dodge an attack");
		upgrades = new Upgrade[3];
		upgrades[0] = riposte;
		upgrades[1] = regeneration;
		upgrades[2] = agility;
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
