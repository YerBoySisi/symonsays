
package shopmenu;

import guiTeacher.GUIApplication;
import inv.Inventory;
import inv.Items;

public class ShopMain extends GUIApplication {
	
	 public static ShopMain s1;
	 public static ShopScreen s2;
	 static RickyBuy s3;
	 static DavidSell s4;
	 static UpgradeScreen s5;
	 public static Inventory inventory;
	

	public ShopMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	public static void main(String[] args) {
		s1 = new ShopMain(1400, 780);
		inventory = new Inventory();
		ShopMain.inventory.itemlist.add(new Items("Def"));
		Thread runner = new Thread(s1);
		runner.start();
	}

	@Override
	public void initScreen() {
		s2 = new ShopScreen(getWidth(), getHeight());
		setScreen(s2);
		s3 = new RickyBuy(getWidth(),getHeight());
		s4 = new DavidSell(getWidth(),getHeight());
		s5 = new UpgradeScreen(getWidth(),getHeight());
	}

}
