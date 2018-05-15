package settingsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import inv.Inventory;
import inv.Items;
import mainMenuAndStartScreen.ButtonDavid;
import shopmenu.DavidSell;
import startGame.GameStarter;

public class SettingsScreen extends FullFunctionScreen{
	public Button volumeSlider;
	public static int volume = 100;
	public String[] images;

	public String[] names;
	private ButtonDavid[] buttons;
	private TextArea[] nums;
	private boolean[] ons;
	private int HPcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"));
	private int Defcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"));
	private int Dodgecount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"));
	private int Attackcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"));
	private int Revivecount = DavidSell.countOccurences(GameStarter.inventory.itemlist, new Items("revive"));
	private int[] counts = {HPcount, Revivecount, Defcount, Dodgecount, Attackcount};


	public SettingsScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		
		String[] images = {"shopUpgradeResources/health.png","shopUpgradeResources/revive.png","shopUpgradeResources/test.png","shopUpgradeResources/speed.png","shopUpgradeResources/strength.png"};
		String[] names = {"Heal","Revive","Defense","Dodge","Attack"};
		ons = new boolean[5];
		counts = new int[5];
		
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/earth.jpg"));
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {

			e.printStackTrace();
		}
		buttons = new ButtonDavid[5];

		nums= new TextArea[5];
		for(int i=0;i<5;i++) {
		     Integer innerMi = new Integer(i);

			System.out.println(images[i]);
			viewObjects.add(new Graphic((i*250)+50, 400, 200,200,images[i]));
			buttons[i] = new ButtonDavid((i*250)+50, 400, 250, Color.cyan, names[i], new Action() {

				@Override
				public void act() {
					if(ons[innerMi] == true) {
						ons[innerMi]=false;
						buttons[innerMi].setColor(Color.cyan);

					}
					else if(ons[innerMi]==false) {
						ons[innerMi]=true;
						buttons[innerMi].setColor(Color.lightGray);

						counts[innerMi]=2;
						HPcount = 2;
						System.out.println(counts[innerMi]);
						System.out.println(HPcount);
						System.out.println(Attackcount);

					}
					AudioTest.playSound("resources/ButtonSound.wav");

				}
			});
			viewObjects.add(buttons[i]);
			nums[i] = new TextArea((i*250)+50,300, 150,200,"x " +counts[i]);
			System.out.println(nums[i]);
			viewObjects.add(nums[i]);
		}

		TextArea title = new TextArea(getWidth()/2-100,getHeight()-750,300,200,"Settings");
		ButtonDavid creditt = new ButtonDavid(800,600,250, Color.lightGray, "Credits",new Action() {

			public void act() {
				GameStarter.start.setScreen(GameStarter.creditsScreen);
				AudioTest.playSound("resources/ButtonSound.wav");

			}
		});

		ButtonDavid update = new ButtonDavid(800,200,250, Color.lightGray, "Update",new Action() {

			public void act() {
				 HPcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"));
				 Defcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"));
				 Dodgecount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"));
				 Attackcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"));
				 Revivecount = DavidSell.countOccurences(GameStarter.inventory.itemlist, new Items("revive"));
				 counts[0]=HPcount;
				 counts[2]=Defcount;
				 counts[3]=Dodgecount;
				 counts[4]=Attackcount;
				 counts[1]=Revivecount;
 

				for(int i=0;i<5;i++) {
					System.out.println(nums[i]);
					System.out.println(nums[i]);

					
					nums[i].setText(counts[i]+"");
//					nums[i] = new TextArea((i*250)+50,300, 150,200,"x " +counts[i]);

					System.out.println(counts[i]);
					System.out.println(nums[i]);

					viewObjects.add(nums[i]);
				}

				AudioTest.playSound("resources/ButtonSound.wav");

			}
		});

		ButtonDavid exit = new ButtonDavid(400,600,250,Color.lightGray,"Exit",new Action() {

			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.startScreen);
				AudioTest.playSound("resources/ButtonSound.wav");

			}
		});
		TextLabel volumeTitle = new TextLabel(250,250,200,100,"Volume");
		title.setCustomTextColor(Color.lightGray);
		volumeTitle.setCustomTextColor(Color.lightGray);


		volumeSlider = new Button(1100, 275, 15, 15, "",Color.WHITE, null);
		viewObjects.add(title);
		viewObjects.add(creditt);
		viewObjects.add(exit);
		viewObjects.add(volumeSlider);
		viewObjects.add(volumeTitle);
		viewObjects.add(update);
	}

	public void mouseDragged(MouseEvent m) {
		super.mouseDragged(m);
		if(m.getY() >270 && m.getY()<325) {
			if(volumeSlider.getX()>449) 
				volumeSlider.setX(m.getX());
			if(volumeSlider.getX()<450)
				volumeSlider.setX(450);
			if(volumeSlider.getX()>1100)
				volumeSlider.setX(1100);
			volume = (int) ((volumeSlider.getX()-450)/6.5);
			AudioTest.changeVolume(volume/100D);
			if(getY()==275) 
				volumeSlider.setY(m.getY());
		}
	}

}
