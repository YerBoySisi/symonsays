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
import mainMenuAndStartScreen.GameStarter;

public class GarrettUpgradeScreen2 extends FullFunctionScreen {

	private ButtonDavid backButton;
	private ButtonDavid nextButton;
	private TextLabel upgradeName1;
	private TextLabel upgradeName2;
	private TextLabel upgradeName3;
	private TextLabel title;
	private TextLabel pointsDisplay;
	private ArrayList<Button> buttons;
	private Upgrade attack;
	private Upgrade defense;
	private Upgrade magic;
	private Upgrade[] upgrades;
	private int[] costs;
	
	public GarrettUpgradeScreen2(int width, int height) {
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
		upgradeName1 = new TextLabel(150, 100, 200, 50, "Power Up");
		Graphic icon = new Graphic(110, 105, 40, 40,"shopUpgradeResources/sword.png");
		upgradeName2 = new TextLabel(620, 100, 270, 50, "Harden");
		Graphic icon2 = new Graphic(575, 105, 40, 40,"shopUpgradeResources/shield.png");
		upgradeName3 = new TextLabel(1050, 100, 250, 50, "Magic Boost");
		Graphic icon3 = new Graphic(1000, 100, 40, 40,"shopUpgradeResources/staff.png");
		viewObjects.add(upgradeName1);
		viewObjects.add(upgradeName2);
		viewObjects.add(upgradeName3);
		viewObjects.add(icon);
		viewObjects.add(icon2);
		viewObjects.add(icon3);
		setBankGothic();
		addBackgrounds(viewObjects);
		addDescriptions(viewObjects);
		pointsDisplay = new TextLabel(1200, 20, 200, 50, "UP: " + GameStarter.inventory.getUp());
		pointsDisplay.setCustomTextColor(Color.CYAN);
		viewObjects.add(pointsDisplay);
		backButton = new ButtonDavid(30, 700, 100, Color.LIGHT_GRAY, "Back", new Action() {

			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
			}

		});
		viewObjects.add(backButton);
		addbuttons();
		setButton1Actions();
		for(Button b: buttons) {
			viewObjects.add(b);
		}
		nextButton = new ButtonDavid(1200, 700, 100, Color.LIGHT_GRAY, "Next", new Action() {

			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.upgradeScreen);
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

	public void setButton1Actions() {
		for(Button b: buttons) {
			b.setAction(new Action() {

				@Override
				public void act() {
					if(GameStarter.inventory.getUp() >= costs[buttons.indexOf(b)]) {
						GameStarter.inventory.setUp(GameStarter.inventory.getUp() - costs[buttons.indexOf(b)]);
						pointsDisplay.setText("UP: " + GameStarter.inventory.getUp());
						GameStarter.upgradeScreen.updatePoints();
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
							attack.setLevel(attack.getLevel() + 1);
						}
						if(buttons.indexOf(b) >= 3 && buttons.indexOf(b) <= 5) {
							defense.setLevel(defense.getLevel() + 1);
						}
						if(buttons.indexOf(b) >= 6 && buttons.indexOf(b) <= 8) {
							magic.setLevel(magic.getLevel() + 1);
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
		attack = new Upgrade(5, 35, 0, " ATK");
		defense = new Upgrade(10, 25, 0, " DEF");
		magic = new Upgrade(15, 15, 0, " MAG");
		upgrades = new Upgrade[3];
		upgrades[0] = attack;
		upgrades[1] = defense;
		upgrades[2] = magic;
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

	public void updatePoints() {
		pointsDisplay.setText("UP: " + GameStarter.inventory.getUp());
	}
	
	public int getAttackLevel() {
		return attack.getLevel();
	}
	
	public int getDefenseLevel() {
		return defense.getLevel();
	}
	
	public int getMagicLevel() {
		return magic.getLevel();
	}
}
