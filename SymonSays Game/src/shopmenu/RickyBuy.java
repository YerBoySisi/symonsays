package shopmenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class RickyBuy extends ClickableScreen {

	public RickyBuy(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static final int COST = 200;
	private int quantityOwned;
	private Button minus;
	private Button plus;
	private Button buy;
	private Button back;
	private TextLabel desc;
	private TextLabel youown;
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		back = new Button(0,100,20,50,"Back",new Action() {
			
			@Override
			public void act() {
				//goes to MainMenu Screen
			}
		});
		back.setForeground(Color.BLACK);
		back.update();
		viewObjects.add(back);
	}



}
