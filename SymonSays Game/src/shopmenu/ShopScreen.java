package shopmenu;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class ShopScreen extends ClickableScreen {

	public ShopScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		TextArea x = new TextArea(150,100,getWidth()/2,getHeight()/2,"MERCHANT");
		Button buy = new Button(100,100,0,0,"Buy",new Action() {
			
			@Override
			public void act() {
			
			}
		});
		viewObjects.add(buy);
		
		Button sell = new Button(100,100,0,0,"Sell",new Action() {
			
			@Override
			public void act() {
			
			}
		});
	
		viewObjects.add(sell);
		
		Button upgrade = new Button(100,100,0,0,"Upgrade",new Action() {
			
			@Override
			public void act() {
			
			}
		});
		
		viewObjects.add(upgrade);
		Button back = new Button(100,100,0,0,"Back",new Action() {
			
			@Override
			public void act() {
			
			}
		});
		
		viewObjects.add(back);
		
		}
		
}
	
	

		


