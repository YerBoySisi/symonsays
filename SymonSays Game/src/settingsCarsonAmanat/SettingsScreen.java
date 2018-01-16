package settingsCarsonAmanat;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SettingsScreen extends ClickableScreen implements Runnable{
	public ArrayList<MoveInterfaceAmanat> array;


	public boolean input;
	
	public ButtonInterfaceAmanat[] allButtons;

	public int oldButton;
	Color[] colors;
	
	public TextLabel displayRound;

	
	public SettingsScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	@Override
	public void run() {
		input = false;
		input = true;

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		array = new ArrayList<MoveInterfaceAmanat>();
		oldButton = -1;
		allButtons = new ButtonInterfaceAmanat[5];
		colors = new Color[5];
		colors[0] = Color.BLACK;
		colors[1] = Color.PINK;
		colors[2] = Color.ORANGE;
		colors[3] = Color.MAGENTA;
		colors[4] = Color.CYAN;

		input = true;
		displayRound = new TextLabel(200,200,400,200,"How's Your Memory?");
		viewObjects.add(displayRound);

		for (int i = 0;i <allButtons.length;i++) {

			final ButtonInterfaceAmanat button = getButton(i*150+150,350,150,100);
			allButtons[i] = button;
			button.setColor(colors[i]);
			button.setAction(new Action() {

				@Override
				public void act() {
					if (input) {
						Thread light  = new Thread(new Runnable() {

							@Override
							public void run() {
								button.highlight();
								input = false;
								try {
									Thread.sleep(800);
								}catch(InterruptedException e ) {
									e.printStackTrace();
								}
								input = true;
								button.dim();
							}
						});
						light.start();
					}

				}
			});
		}

		for (int i = 0;i <allButtons.length;i++) {
			System.out.println(allButtons[i]);
			viewObjects.add(allButtons[i]);

		}
	}
	private ButtonInterfaceAmanat getButton(int x, int y, int w, int h) {
		ButtonAmanat button = new ButtonAmanat(x,y,w,h,"",null);
		return button;
	}

}
