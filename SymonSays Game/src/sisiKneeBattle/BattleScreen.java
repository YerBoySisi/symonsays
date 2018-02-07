package sisiKneeBattle;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextColoredLabel;
import guiTeacher.components.ButtonDavid;
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
	
	
	//HUD
	private TextColoredLabel playerHP;
	private TextColoredLabel mp;
	private TextColoredLabel xp;
	private TextColoredLabel bossHP;
	private TextColoredLabel playerDisplay;
	private TextColoredLabel bossDisplay;
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
		
		try {
			File fontFile = new File("resources/orbitron-medium.otf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(32f);
			TextColoredLabel.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		playerHP = new TextColoredLabel(300,560,350,30, "HP", Color.green, Color.green);
		playerHP.setVisible(true);
		viewObjects.add(playerHP);
		
		mp = new TextColoredLabel(800,560,350,30, "MP", Color.cyan, Color.cyan);
		mp.setVisible(true);
		viewObjects.add(mp);
		
		xp = new TextColoredLabel(20,600,5,150, "XP", Color.yellow, Color.yellow);
		xp.setVisible(true);
		viewObjects.add(xp);
		
		bossHP = new TextColoredLabel(200,50,1000,30, "BOSS HP", Color.red, Color.red);
		bossHP.setVisible(true);
		viewObjects.add(bossHP);
		
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

}
