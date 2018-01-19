package shopmenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class DavidSell extends FullFunctionScreen {
	
	private TextArea title;

	public DavidSell(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title.setTextColor(Color.WHITE);
		title = new TextArea(300,50,300,50,"MERCHANT");
		TextArea desc = new TextArea(350,100,300,100,"USED TO INCREASE DEFENSE");
		TextArea quant = new TextArea(270,125,300,100,"x10");
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(200, 100, 75,75,"shopUpgradeResources/test.png"));
		viewObjects.add(title);
		viewObjects.add(desc);
		viewObjects.add(quant);
		
		
		Button back = new Button(0,10,100,50,"Back",new Action() {

			
			@Override
			public void act() {
				 ShopMain.s1.setScreen(ShopMain.s2);
			}
		});
		

		viewObjects.add(back);
		
		Button buyH = new Button(500, 120, 50, 50, "Sell", new Action() {
			public void act() {
				
			}
		});
		viewObjects.add(buyH);
		Button buyS = new Button(20, 20, 100, 100, "Sell", new Action() {
			public void act() {
				
			}
		});
		Button buyR = new Button(20, 20, 100, 100, "Sell", new Action() {
			public void act() {
			
			}
		});
		Button buyHM = new Button(20, 20, 100, 100, "Sell", new Action() {
			public void act() {
				
			}
		});
		
        
		
		
		
		
		
	}


}
