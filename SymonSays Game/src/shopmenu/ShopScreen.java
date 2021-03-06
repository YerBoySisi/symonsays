package shopmenu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import inv.Items;
import mainMenuAndStartScreen.ButtonDavid;
import startGame.GameStarter;

public class ShopScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 4047527092551155043L;
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
			 GameStarter.start.setScreen(GameStarter.buyScreen);
			 updateQuant();
			}
		});
		buy.setForeground(Color.white);		viewObjects.add(buy);
		
		ButtonDavid sell = new ButtonDavid(250,650,100,Color.LIGHT_GRAY,"Sell",new Action() {
			
			@Override
			public void act() {
				 GameStarter.start.setScreen(GameStarter.sellScreen);
				 updateQuant();
			}
		});
		sell.setForeground(Color.white);
		viewObjects.add(sell);
			
		ButtonDavid back = new ButtonDavid(450,650,200,Color.LIGHT_GRAY,"Back",new Action() {

			
			@Override
			public void act() {
				 GameStarter.start.setScreen(GameStarter.mainMenuScreen);
			}
		});

		back.setForeground(Color.white);
		viewObjects.add(back);
		
		

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
	
	public void updateQuant() {
		DavidSell.quant1.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"))));
		DavidSell.quant2.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"))));
		DavidSell.quant3.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"))));
		DavidSell.quant4.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"))));
		DavidSell.quant5.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("revive"))));
		DavidSell.currency.setText(Integer.toString(GameStarter.inventory.getCurrency()));
		
		
		RickyBuy.multiplierDef.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"))));
		RickyBuy.multiplierHP.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"))));
		RickyBuy.multiplierDodge.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"))));
		RickyBuy.multiplierAtk.setText("x"+Integer.toString(DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"))));
		RickyBuy.numOfCoins.setText(Integer.toString(GameStarter.inventory.getCurrency()));		
	}	
}