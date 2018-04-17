package creditsCarsonAmanat;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;

public class CarsonCustodioProjectScreen extends ClickableScreen implements Runnable{

	private static final long serialVersionUID = 1L;
	public String[] roles = {"Fahadullah created the boss select screen.", "David Yashayev created the main menu and the startup screen.", "Sisiame was in charge of the games mechanics.", "Siddeeq created the HUD and the layout of the battle screen.", "Nabeel created the results screen for after the battles.", "Ricky was in charge of the buy menu", "David Li was in charge of the sell menu", "Garrett was in charge of the upgrades menu.", "Amanat created the settings page.", "Carson created the credits page."};
	public String[] buttonNames = {"fahadullah", "davidY", "sisiame", "siddeeq", "nabeel", "ricky", "davidL", "garrett", "amanat", "carson"};
	public boolean setText;
	public int getText;

	public CarsonCustodioProjectScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {
			
	}

	public void initAllObjects(List<Visible> viewObjects) {
		setText = false;
		ArrayList<Button> buttonList = new ArrayList<Button>();
		ArrayList<TextField> fieldList = new ArrayList<TextField>();
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/earth.jpg");
		viewObjects.add(background);
		
		ButtonDavid backButton = new ButtonDavid(50, 680, 100, Color.lightGray,"Back", new Action() {
			public void act() {
				GameStarter.start.setScreen(GameStarter.startScreen);
			}
		});
		viewObjects.add(backButton);
		
		Button returnToContributors = new Button(1100, 650, 200, 75, "Return", Color.lightGray, new Action() {
			public void act() {
				for(int i = 0; i < buttonList.size(); i++) {
					viewObjects.add(buttonList.get(i));
					setText = false;
				}
				for(int j = 0; j < fieldList.size(); j++) {
					viewObjects.remove(fieldList.get(j));
				}
			}
		});
		viewObjects.add(returnToContributors);
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * */
		
		Button fahadullah = new Button(25, 50, 400, 75, "Fahadullah Asif", Color.lightGray, new Action() {
			public void act() {
				getText = 0;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(fahadullah);
		viewObjects.add(fahadullah);
		
		Button davidY = new Button(25, 150, 400, 75, "David Yashayev", Color.lightGray, new Action() {
			public void act() {
				getText = 1;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(davidY);
		viewObjects.add(davidY);
		
		Button sisiame = new Button(25, 250, 400, 75, "Sisiame Sakasamo", Color.lightGray, new Action() {
			public void act() {
				getText = 2;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(sisiame);
		viewObjects.add(sisiame);
		
		Button siddeeq = new Button(875, 250 , 400, 75, "Siddeeq Rasheed", Color.lightGray,new Action() {
			public void act() {
				getText = 3;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(siddeeq);
		viewObjects.add(siddeeq);

		Button nabeel = new Button(450, 50, 400, 75, "Nabeel Amin", Color.lightGray, new Action() {
			public void act() {
				getText = 4;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(nabeel);
		viewObjects.add(nabeel);
		
		Button ricky = new Button(450, 150, 400, 75, "Ricky Pong", Color.lightGray, new Action() {
			public void act() {
				getText = 5;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(ricky);
		viewObjects.add(ricky);
		
		Button davidL = new Button(450, 250, 400, 75, "David Li", Color.lightGray, new Action() {
			public void act() {
				getText = 6;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(davidL);
		viewObjects.add(davidL);
		
		Button garrett = new Button(450, 350, 400, 75, "Garrett Chen", Color.lightGray, new Action() {
			public void act() {
				getText = 7;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(garrett);
		viewObjects.add(garrett);
		
		Button amanat = new Button(875, 50, 400, 75, "Amanat Hossain", Color.lightGray,new Action() {
			public void act() {
				getText = 8;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(amanat);
		viewObjects.add(amanat);
		
		Button carson = new Button(875, 150, 400, 75, "Carson Custodio", Color.lightGray, new Action() {
			public void act() {
				getText = 9;
				if(setText == false) {
					for(int i = viewObjects.size() - 1; i > 2; i--) {
						viewObjects.remove(i);
					}
					setText = true;
				}
				TextField field = new TextField(50, 100, 1300, 100, roles[getText]);
				fieldList.add(field);
				viewObjects.add(field);
			}
		});
		buttonList.add(carson);
		viewObjects.add(carson);
	}
}