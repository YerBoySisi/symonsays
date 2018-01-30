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
		TextArea desc1 = new TextArea(350,100,300,100,"USED TO INCREASE DEFENSE");
		TextArea quant1 = new TextArea(270,125,300,100,"x10");
		TextArea desc2 = new TextArea(350,200,300,100,"HEALS PLAYER FOR 100HP");
		TextArea quant2 = new TextArea(270,225,300,100,"x10");
		TextArea desc3 = new TextArea(350,300,300,100,"INCREASES DODGE RATE FOR 3 TURNS");
		TextArea quant3 = new TextArea(270,325,300,100,"x10");
		TextArea desc4 = new TextArea(350,400,300,100,"INCREASES ATK BY 50Pts");
		TextArea quant4 = new TextArea(270,425,300,100,"x10");
		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		viewObjects.add(new Graphic(200, 100, 75,75,"shopUpgradeResources/test.png"));
		viewObjects.add(new Graphic(200, 200, 75,75,"shopUpgradeResources/health.png"));
		viewObjects.add(new Graphic(200, 300, 75,75,"shopUpgradeResources/speed.png"));
		viewObjects.add(new Graphic(200, 400, 75,75,"shopUpgradeResources/strength.png"));
		viewObjects.add(title);
		viewObjects.add(desc1);
		viewObjects.add(quant1);
		viewObjects.add(desc2);
		viewObjects.add(quant2);
		viewObjects.add(desc3);
		viewObjects.add(quant3);
		viewObjects.add(desc4);
		viewObjects.add(quant4);
		
		
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
		Button buyS = new Button(500, 220, 50, 50, "Sell", new Action() {
			public void act() {
				
			}
		});
		viewObjects.add(buyS);
		Button buyR = new Button(500, 320, 50, 50, "Sell", new Action() {
			public void act() {
			
			}
		});
		viewObjects.add(buyR);
		Button buyHM = new Button(500, 420, 50, 50, "Sell", new Action() {
			public void act() {
				
			}
		});
		viewObjects.add(buyHM);
		
        
		
		
		
		
		
	}


}
