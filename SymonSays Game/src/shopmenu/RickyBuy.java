package shopmenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class RickyBuy extends ClickableScreen {

	public static final int COST = 200;
	private Button back;
	private TextLabel youown;
	
	public RickyBuy(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		back = new Button(0,20,125,50,"Back",new Action() {
			
			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
		});
		back.setForeground(Color.BLUE);
		viewObjects.add(back);
		TextArea title =  new TextArea(600,50,300,50,"MERCHANT");
		viewObjects.add(title);
		TextArea desc1 = new TextArea(600,150,400,100,"USED TO INCREASE DEFENSE");
		TextArea desc2 = new TextArea(600,275,400,100,"HEALS PLAYER FOR 100HP");
		TextArea desc3 = new TextArea(600,400,450,100,"INCREASES DODGE RATE");
		TextArea desc4 = new TextArea(600,525,300,100,"INCREASES ATK BY 50Pts");
		for(int i = 0; i < 4; i++) {
			TextArea multiplier = new TextArea(500,150 + i*125,300,100,"x10");
			viewObjects.add(multiplier);
		}
		viewObjects.add(desc1);
		viewObjects.add(desc2);
		viewObjects.add(desc3);
		viewObjects.add(desc4);
		Button buyDef = new Button(900,175,100,100,"Buy", new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyDef);
		buyDef.setForeground(Color.GRAY);
		
		Button buyHP = new Button(900,300,100,100,"Buy", new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyHP);
		buyHP.setForeground(Color.GRAY);
		
		Button buyDodge = new Button(900,425,100,100,"Buy", new Action() {
			
			@Override
			public void act() {
			
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyDodge);
		buyDodge.setForeground(Color.GRAY);
		
		Button buyAtk = new Button(900,550,100,100,"Buy", new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(buyAtk);
		buyAtk.setForeground(Color.GRAY);
	}



}
