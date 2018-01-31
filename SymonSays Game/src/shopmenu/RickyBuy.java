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
	private int quantityOwned;
	private Button minus;
	private Button plus;
	private Button buy;
	private Button back;
	private TextLabel desc;
	private TextLabel youown;
	
	public RickyBuy(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth() * 2, getHeight() * 2,"shopUpgradeResources/bgrnd.jpg");
		viewObjects.add(background);
		back = new Button(0,20,125,50,"Back",Color.BLUE, new Action() {
			
			@Override
			public void act() {
				ShopMain.s1.setScreen(ShopMain.s2);
			}
		});
		//back.setForeground(Color.BLACK);
		//back.update();
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

	}



}
