package shopmenu;

import guiTeacher.GUIApplication;
import inv.Inventory;

public class ShopMain extends GUIApplication {
	
	private static final long serialVersionUID = -2687172633720501579L;
	public static ShopMain s1;
	public static ShopScreen s2;
	static RickyBuy s3;
	static DavidSell s4;
	static GarrettUpgradeScreen s5;
	static GarrettUpgradeScreen2 s6;
    public static Inventory inventory;	

	public ShopMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		inventory = new Inventory();
		inventory.setCurrency(1000);
		s1 = new ShopMain(1400, 780);
		Thread runner = new Thread(s1);
		runner.start();
	}

	@Override
	public void initScreen() {
		s2 = new ShopScreen(getWidth(), getHeight());
		setScreen(s2);
		s3 = new RickyBuy(getWidth(),getHeight());
		s4 = new DavidSell(getWidth(),getHeight());
		s5 = new GarrettUpgradeScreen(getWidth(),getHeight());
		s6 = new GarrettUpgradeScreen2(getWidth(),getHeight());
	}
}
