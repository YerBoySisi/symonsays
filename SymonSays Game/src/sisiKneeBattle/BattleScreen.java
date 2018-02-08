package sisiKneeBattle;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Bar;
import guiTeacher.components.ButtonDavid;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import sisiKneeBosses.Boss;
import sisiKneeBosses.DragonMech;
import sisiKneeBosses.GundamShark;
import sisiKneeBosses.ShmarseTortoise;
import sisiKneeBosses.SimonBelmont;
import sisiKneeBosses.SuperSoldier;
import sisiKneeBosses.Symon;

public class BattleScreen extends FullFunctionScreen {
	
	private static final long serialVersionUID = 9151939983030157712L;
	
	//menu constants
	private static final int BATTLE_MENU = 0;
	private static final int ATTACK_MENU = 1;
	private static final int ITEM_MENU = 2;
	private static final int FLEE_MENU = 3;
	
	
	//menu buttons
	private static final ButtonDavid[] battleMenu = 
		{new ButtonDavid("Attack", null, 300, 615, 350, 130, null),
		 new ButtonDavid("Spell", null, 800, 610, 350, 45, null),
		 new ButtonDavid("Item", null, 800, 661, 350, 45, null),
		 new ButtonDavid("Flee", null, 800, 709, 350, 45, null)};
	
	private ArrayList<ButtonDavid> spellMenu;
	
	private ArrayList<ButtonDavid> itemMenu;
	
	private static final ButtonDavid[] fleeMenu =
		{new ButtonDavid("Run Away", null, 300, 615, 350, 130, null), 
		 new ButtonDavid("Stay and Fight", null, 800, 615, 350, 130, null)};
	
	//Background
	private Graphic bg;
	
	//HUD CONSTANTS
	private static final int PLAYER_BAR_WIDTH = 350;
	private static final int BOSS_BAR_WIDTH = 1000;
	
	//HUD
	private Bar playerHPBar;
	private TextArea playerHP;
	private Bar mpBar;
	private TextArea mp;
	private Bar xp;
	private Bar bossHP;
	private TextArea bossName;
	private Bar blackBarHP;
	private Bar blackBarMP;
	private Bar blackBarBoss;
	private Bar playerDisplay;
	private Bar bossDisplay;
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

		TextArea.setTextColor(Color.white);
		
		try {
			File fontFile = new File("resources/orbitron-medium.otf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(32f);
			Bar.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
////////////////////////////////////////////////////////////////////////////////////
		
		bg = new Graphic(0, 0, 1400, 780, "resources/bg.png");
		viewObjects.add(0, bg);
		
////////////////////////////////////////////////////////////////////////////////////
		
		player = new Player();
		
////////////////////////////////////////////////////////////////////////////////////
		
		blackBarHP = new Bar(300,560,PLAYER_BAR_WIDTH,30, "HP", Color.black, Color.black);
		blackBarHP.setVisible(true);
		viewObjects.add(blackBarHP);
		
		playerHPBar = new Bar(300,560,PLAYER_BAR_WIDTH,30, "HP", Color.green, Color.green);
		playerHPBar.setVisible(true);
		viewObjects.add(playerHPBar);
		
		playerHP = new TextArea(425,553,PLAYER_BAR_WIDTH, 100, player.getHP()+ " / " + player.getMaxHP());
		playerHP.setVisible(true);
		viewObjects.add(playerHP);
		
////////////////////////////////////////////////////////////////////////////////////
		
		blackBarMP = new Bar(800,560,PLAYER_BAR_WIDTH,30, "HP", Color.black, Color.black);
		blackBarMP.setVisible(true);
		viewObjects.add(blackBarMP);
		
		mpBar = new Bar(800,560,PLAYER_BAR_WIDTH,30, "MP", Color.cyan, Color.cyan);
		mpBar.setVisible(true);
		viewObjects.add(mpBar);
		
		mp = new TextArea(925,553,PLAYER_BAR_WIDTH, 100, player.getMP()+ " / " + player.getMaxMP());
		mp.setVisible(true);
		viewObjects.add(mp);
		
////////////////////////////////////////////////////////////////////////////////////
		
		xp = new Bar(20,600,5,150, "XP", Color.yellow, Color.yellow);
		xp.setVisible(true);
		viewObjects.add(xp);
		
////////////////////////////////////////////////////////////////////////////////////
		
		blackBarBoss = new Bar(200,50,BOSS_BAR_WIDTH,30, "HP", Color.black, Color.black);
		blackBarBoss.setVisible(true);
		viewObjects.add(blackBarBoss);
		
		bossHP = new Bar(200,50,BOSS_BAR_WIDTH,30, "BOSS HP", Color.red, Color.red);
		bossHP.setVisible(true);
		viewObjects.add(bossHP);
		
		bossName = new TextArea(200,32,BOSS_BAR_WIDTH, 100, "Dragon Mech");
		bossName.setVisible(true);
		viewObjects.add(bossName);
		
////////////////////////////////////////////////////////////////////////////////////
		
		turnInfo = new TextArea(200,100,1200,60,"Dymon just used a piercing slash! It's a critical hit!");
		turnInfo.setVisible(true);
		viewObjects.add(turnInfo);
		
		for(int i = 0; i < battleMenu.length; i++) {
			battleMenu[i].setVisible(true);
			viewObjects.add(battleMenu[i]);
		}
		
		for(int i = 0; i < fleeMenu.length; i++) {
			fleeMenu[i].setVisible(false);
			viewObjects.add(fleeMenu[i]);
		}
		
		/*for(int i = 0; i < spellMenu.size(); i++) {
			itemMenu.get(i).setVisible(false);
			viewObjects.add(itemMenu.get(i));
		}
		
		for(int i = 0; i < itemMenu.size(); i++) {
			itemMenu.get(i).setVisible(false);
			viewObjects.add(itemMenu.get(i));
		}
		
		playerDisplay = player.getIdleSprite();
		playerDisplay.setVisible(true);
		viewObjects.add(playerDisplay);
		
		setBoss(0);
		bossDisplay = boss.getIdleSprite();
		bossDisplay.setVisible(true);
		viewObjects.add(bossDisplay);*/
		
	}
	
	public void setBoss(int stage) {
		
		boss = bossList[stage];
		
	}
	
	public void setBarWidth(Bar bar, TextArea txt, double currentHP, double maxHP, int maxBarWidth, List<Visible> viewObjects) {
		
		viewObjects.remove(bar);
		viewObjects.remove(txt);
		
		int newWidth = (int)Math.round((currentHP / maxHP) * maxBarWidth);
		playerHPBar = new Bar(300,560,newWidth,30, "HP", Color.green, Color.green);
		playerHPBar.setVisible(true);
		viewObjects.add(playerHPBar);
		
		playerHP = new TextArea(425,553,PLAYER_BAR_WIDTH, 100, player.getHP()+ " / " + player.getMaxHP());
		playerHP.setVisible(true);
		viewObjects.add(playerHP);
		
	}
	
}
