package shopmenu;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ShopScreen extends FullFunctionScreen {

	public ShopScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		setCustomFont();
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"shopUpgradeResources/bgrnd.jpg"));
		TextArea title = new TextArea(300,50,300,50,"MERCHANT");
		viewObjects.add(title);
		Button buy = new Button(50,450,100,50,"Buy",new Action() {
			
			@Override
			public void act() {
			 System.out.println("Buy");
			}
		});
		viewObjects.add(buy);
		
		Button sell = new Button(150,450,100,50,"Sell",new Action() {
			
			@Override
			public void act() {
			
			}
		});
	
		viewObjects.add(sell);
		
		Button back = new Button(100,100,50,50,"Back",new Action() {
		Button upgrade = new Button(250,450,200,50,"Upgrade",new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		};
		viewObjects.add(upgrade);
		Button back = new Button(450,450,100,50,"Back",new Action() {

			
			@Override
			public void act() {
			
			}
		}


		@Override
		public void act() {
			// TODO Auto-generated method stub
			
		});
		
		viewObjects.add(back);

		
		}
	private void setCustomFont(){
		
		try {
			File fontFile = new File("shopUpgradeResources//Orbitron-Black.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(20f);
			StyledComponent.setBaseFont(font);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
	
	

		


