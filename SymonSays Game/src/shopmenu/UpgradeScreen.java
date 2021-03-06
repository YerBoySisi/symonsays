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
import startGame.GameStarter;

public class UpgradeScreen extends FullFunctionScreen {

	private ButtonDavid backButton;
	private ButtonDavid nextButton;
	private TextLabel upgradeName1;
	private TextLabel upgradeName2;
	private TextLabel upgradeName3;
	private TextLabel upgradeName4;
	private TextLabel upgradeName5;
	private TextLabel upgradeName6;
	private TextLabel title;
	private TextLabel pointsDisplay;
	private int upgradePoints;
	private ArrayList<Button> buttons1;
	private ArrayList<Button> buttons2;
	private Upgrade riposte;
	private Upgrade regeneration;
	private Upgrade agility;
	private Upgrade attack;
	private Upgrade defense;
	private Upgrade magic;
	private int riposteLevel = 0;
	private int regenerationLevel = 0;
	private int agilityLevel = 0;
	private int attackLevel = 0;
	private int defenseLevel = 0;
	private int magicLevel = 0;
	private Upgrade[] upgrades1;
	private Upgrade[] upgrades2;
	private int[] costs1;
	private int[] costs2;
	private boolean front = true;

	public UpgradeScreen(int width, int height) {
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
		upgradeName1 = new TextLabel(150, 100, 200, 50, "Riposte");
		Graphic icon = new Graphic(110, 105, 40, 40,"shopUpgradeResources/riposte.png");
		upgradeName2 = new TextLabel(550, 100, 270, 50, "Regeneration");
		Graphic icon2 = new Graphic(515, 110, 30, 30,"shopUpgradeResources/heal.png");
		upgradeName3 = new TextLabel(1100, 100, 150, 50, "Agility");
		Graphic icon3 = new Graphic(1070, 110, 30, 30,"shopUpgradeResources/agility.png");
		upgradeName4 = new TextLabel(150, 100, 200, 50, "Power Up");
		Graphic icon4 = new Graphic(110, 105, 40, 40,"shopUpgradeResources/sword.png");
		upgradeName5 = new TextLabel(620, 100, 270, 50, "Harden");
		Graphic icon5 = new Graphic(575, 105, 40, 40,"shopUpgradeResources/shield.png");
		upgradeName6 = new TextLabel(1050, 100, 250, 50, "Magic Boost");
		Graphic icon6 = new Graphic(1000, 100, 40, 40,"shopUpgradeResources/staff.png");
		viewObjects.add(upgradeName1);
		viewObjects.add(upgradeName2);
		viewObjects.add(upgradeName3);
		viewObjects.add(icon);
		viewObjects.add(icon2);
		viewObjects.add(icon3);
		setBankGothic();
		addBackgrounds(viewObjects);
		addDescriptions1(viewObjects);
		setUpgradePoints(300);
		pointsDisplay = new TextLabel(1200, 20, 200, 50, "UP: " + getUpgradePoints());
		pointsDisplay.setCustomTextColor(Color.CYAN);
		viewObjects.add(pointsDisplay);
		backButton = new ButtonDavid(30, 700, 100, Color.LIGHT_GRAY, "Back", new Action() {

			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.mainMenuScreen);
			}

		});
		viewObjects.add(backButton);
		addbuttons1();
		setButton1Actions();
		for(Button b: buttons1) {
			viewObjects.add(b);
		}
		/*nextButton = new ButtonDavid(1200, 700, 100, Color.LIGHT_GRAY, "Next", new Action() {

			@Override
			public void act() {
				if(front){
					viewObjects.add(background);
					viewObjects.add(title);
					viewObjects.add(upgradeName4);
					viewObjects.add(upgradeName5);
					viewObjects.add(upgradeName6);
					viewObjects.add(icon4);
					viewObjects.add(icon5);
					viewObjects.add(icon6);
					setBankGothic();
					viewObjects.add(backButton);
					viewObjects.add(pointsDisplay);
					addBackgrounds(viewObjects);
					addDescriptions2(viewObjects);
					for(Button b: buttons1) {
						viewObjects.remove(b);
						b.setEnabled(false);
					}
					addbuttons2();
					setButton2Actions();
					for(Button b: buttons2) {
						viewObjects.add(b);
					}
				}
			}

		});
		viewObjects.add(nextButton);*/
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

	public void addbuttons1() {
		buttons1 = new ArrayList<Button>();
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
				buttons1.add(b);
			}
		}
	}

	public void addbuttons2() {
		buttons2 = new ArrayList<Button>();
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
				buttons2.add(b);
			}
		}
	}

	public void setButton1Actions() {
		for(Button b: buttons1) {
			b.setAction(new Action() {

				@Override
				public void act() {
					if(getUpgradePoints() >= costs1[buttons1.indexOf(b)]) {
						setUpgradePoints(getUpgradePoints() - costs1[buttons1.indexOf(b)]);
						pointsDisplay.setText("UP: " + getUpgradePoints());
						b.setEnabled(false);
						b.setBackground(Color.WHITE);
						b.setText("Upgraded");
						b.update();
						if((buttons1.indexOf(b) + 1) % 3 != 0) {
							Button nextButton = buttons1.get(buttons1.indexOf(b) + 1);
							nextButton.setEnabled(true);
							nextButton.setBackground(Color.GREEN);
							nextButton.update();
						}
						if(buttons1.indexOf(b) >= 0 && buttons1.indexOf(b) <= 2) {
							riposteLevel++;
						}
						if(buttons1.indexOf(b) >= 3 && buttons1.indexOf(b) <= 5) {
							regenerationLevel++;
						}
						if(buttons1.indexOf(b) >= 6 && buttons1.indexOf(b) <= 8) {
							agilityLevel++;
						}
					}
				}
			});
		}
	}

	public void setButton2Actions() {
		for(Button b: buttons2) {
			b.setAction(new Action() {

				@Override
				public void act() {
					if(getUpgradePoints() >= costs2[buttons2.indexOf(b)]) {
						setUpgradePoints(getUpgradePoints() - costs2[buttons2.indexOf(b)]);
						pointsDisplay.setText("UP: " + getUpgradePoints());
						b.setEnabled(false);
						b.setBackground(Color.WHITE);
						b.setText("Upgraded");
						b.update();
						if((buttons2.indexOf(b) + 1) % 3 != 0) {
							Button nextButton = buttons2.get(buttons2.indexOf(b) + 1);
							nextButton.setEnabled(true);
							nextButton.setBackground(Color.GREEN);
							nextButton.update();
						}
						if(buttons2.indexOf(b) >= 0 && buttons2.indexOf(b) <= 2) {
							attackLevel++;
						}
						if(buttons2.indexOf(b) >= 3 && buttons2.indexOf(b) <= 5) {
							defenseLevel++;
						}
						if(buttons2.indexOf(b) >= 6 && buttons2.indexOf(b) <= 8) {
							magicLevel++;
						}
						System.out.println(riposteLevel + " " + regenerationLevel + " " + agilityLevel);
					}
				}
			});
		}
	}

	public void addDescriptions1(List<Visible> viewObjects) {
		createUpgradeList1();
		costs1 = new int[9];
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j <= 3; j++) {
				String desc = upgrades1[i].getDesc();
				int cost = upgrades1[i].getCost();
				TextArea upgradeDescription = new TextArea(50 + 450 * i, 175 * j, 350, 300, "+" + upgrades1[i].getMultiple() * j + desc);
				viewObjects.add(upgradeDescription);
				TextLabel upgradeCost = new TextLabel(50 + 450 * i, 100 + 175 * j, 300, 50, cost * j + "UP");
				upgradeCost.setCustomTextColor(Color.CYAN);
				viewObjects.add(upgradeCost);
				costs1[i * 3 + (j - 1)] = cost * j;
			}
		}
	}

	public void createUpgradeList1() {
		riposte = new Upgrade(5, 50, "% chance to attack again");
		regeneration = new Upgrade(50, 40, "HP healed each turn");
		agility = new Upgrade(2, 30, "% chance to dodge an attack");
		upgrades1 = new Upgrade[3];
		upgrades1[0] = riposte;
		upgrades1[1] = regeneration;
		upgrades1[2] = agility;
	}

	public void addDescriptions2(List<Visible> viewObjects) {
		createUpgradeList2();
		costs2 = new int[9];
		for(int i = 0; i < 3; i++) {
			for(int j = 1; j <= 3; j++) {
				String desc = upgrades2[i].getDesc();
				int cost = upgrades2[i].getCost();
				TextArea upgradeDescription = new TextArea(50 + 450 * i, 175 * j, 350, 300, "+" + upgrades2[i].getMultiple() * j + desc);
				viewObjects.add(upgradeDescription);
				TextLabel upgradeCost = new TextLabel(50 + 450 * i, 100 + 175 * j, 300, 50, cost * j + "UP");
				upgradeCost.setCustomTextColor(Color.CYAN);
				viewObjects.add(upgradeCost);
				costs2[i * 3 + (j - 1)] = cost * j;
			}
		}
	}

	public void createUpgradeList2() {
		attack = new Upgrade(20, 50, " POW");
		defense = new Upgrade(10, 40, " DEF");
		magic = new Upgrade(20, 30, " MP");
		upgrades2 = new Upgrade[3];
		upgrades2[0] = attack;
		upgrades2[1] = defense;
		upgrades2[2] = magic;
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
