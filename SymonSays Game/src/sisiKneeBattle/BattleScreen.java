package sisiKneeBattle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.ImageTextButton;
import guiTeacher.components.ProgressBar;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import sisiKneeBosses.Boss;
import sisiKneeBosses.DragonMech;
import sisiKneeBosses.GundamShark;
import sisiKneeBosses.ShmarseTortoise;
import sisiKneeBosses.SimonBelmont;
import sisiKneeBosses.SuperSoldier;
import sisiKneeBosses.Symon;

public class BattleScreen extends ClickableScreen {
	
	private static final long serialVersionUID = 9151939983030157712L;
	
	//menu constants
	private static final int BATTLE_MENU = 0;
	private static final int ATTACK_MENU = 1;
	private static final int ITEM_MENU = 2;
	private static final int FLEE_MENU = 3;
	
	
	//menu buttons
	private static final ImageTextButton[] battleMenu = 
		{new ImageTextButton("Attack", null, 0, 0, 0, 0, null), 
		 new ImageTextButton("Item", null, 0, 0, 0, 0, null),
		 new ImageTextButton("Flee", null, 0, 0, 0, 0, null)};
	
	private ArrayList<ImageTextButton> attackMenu;
	
	private ArrayList<ImageTextButton> itemMenu;
	
	private static final ImageTextButton[] fleeMenu =
		{new ImageTextButton("Run Away", null, 0, 0, 0, 0, null), 
		 new ImageTextButton("Stay and Fight", null, 0, 0, 0, 0, null)};
	
	
	//HUD
	private ProgressBar playerHP;
	private ProgressBar mp;
	private ProgressBar xp;
	private ProgressBar bossHP;
	private AnimatedComponent playerDisplay;
	private AnimatedComponent bossDisplay;
	private TextArea turnInfo;
	
	//Entities
	private Player player;
	
	private SuperSoldier ssold;
	private GundamShark gshark;
	private DragonMech dmech;
	private ShmarseTortoise stort;
	private SimonBelmont sbelm;
	private Symon symon;
	
	private final Boss[] bossList = {ssold, gshark, dmech, stort, sbelm, symon};
	private Boss boss;

	public BattleScreen(int width, int height) {
		
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		playerHP = new ProgressBar(10,100,200,50);
		playerHP.setBarColor(Color.GREEN);
		playerHP.setIncompleteColor(Color.BLACK);
		playerHP.setVisible(true);
		viewObjects.add(playerHP);
		
		mp = new ProgressBar(10,160,200,50);
		mp.setBarColor(Color.CYAN);
		mp.setIncompleteColor(Color.BLACK);
		mp.setVisible(true);
		viewObjects.add(mp);
		
		xp = new ProgressBar(10,220,10,100);
		xp.setBarColor(Color.GRAY);
		xp.setIncompleteColor(Color.BLACK);
		xp.setVisible(true);
		viewObjects.add(xp);
		
		bossHP = new ProgressBar(510,100,1000,50);
		bossHP.setBarColor(Color.RED);
		bossHP.setIncompleteColor(Color.BLACK);
		bossHP.setVisible(true);
		viewObjects.add(bossHP);
		
		turnInfo = new TextArea(400,100,400,60,"Test");
		turnInfo.setVisible(true);
		viewObjects.add(turnInfo);
		
		playerDisplay = player.getIdleSprite();
		playerDisplay.setVisible(true);
		viewObjects.add(playerDisplay);
		
		setBoss(0);
		bossDisplay = boss.getIdleSprite();
		bossDisplay.setVisible(true);
		viewObjects.add(bossDisplay);
		
	}
	
	public void setBoss(int stage) {
		
		boss = bossList[stage];
		
	}

}
