package shopmenu;

import java.awt.Color;
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
import mainMenuAndStartScreen.ButtonDavid;

public class ShopScreen extends FullFunctionScreen {
	
	private TextArea title;

	public ShopScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		setCustomFont();
		title.setTextColor(Color.WHITE);
		viewObjects.add(new Graphic(0, 0, getWidth()*2,getHeight()*2,"shopUpgradeResources/bgrnd.jpg"));
		TextArea title = new TextArea(600,50,300,50,"MERCHANT");
		viewObjects.add(title);
		ButtonDavid buy = new ButtonDavid(50,650,100,Color.LIGHT_GRAY,"Buy",new Action() {
			
			@Override
			public void act() {
			 ShopMain.s1.setScreen(ShopMain.s3);
			}
		});
		buy.setForeground(Color.white);		viewObjects.add(buy);
		
		ButtonDavid sell = new ButtonDavid(250,650,100,Color.LIGHT_GRAY,"Sell",new Action() {
			
			@Override
			public void act() {
				 ShopMain.s1.setScreen(ShopMain.s4);
			}
		});
		sell.setForeground(Color.white);
		viewObjects.add(sell);
		ButtonDavid upgrade = new ButtonDavid(450,650,200,Color.LIGHT_GRAY,"Upgrade",new Action() {
			
			@Override
			public void act() {
				 ShopMain.s1.setScreen(ShopMain.s5);
				
			}
		});
			
		upgrade.setForeground(Color.white);
		viewObjects.add(upgrade);
		ButtonDavid back = new ButtonDavid(750,650,200,Color.LIGHT_GRAY,"Back",new Action() {

			
			@Override
			public void act() {
				 ShopMain.s1.setScreen(ShopMain.s2);
			}
		});

		back.setForeground(Color.white);
		viewObjects.add(back);

		
		}
	private void setCustomFont(){
		
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f);
			StyledComponent.setBaseFont(font);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
	
	

		


