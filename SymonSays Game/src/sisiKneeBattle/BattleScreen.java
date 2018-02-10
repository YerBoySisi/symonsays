package sisiKneeBattle;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Bar;
import guiTeacher.components.ButtonDavid;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import resultScreen.ShareableInfoNabeel;
import sisiKneeBosses.Boss;
import sisiKneeBosses.DragonMech;
import sisiKneeBosses.GundamShark;
import sisiKneeBosses.ShmarseTortoise;
import sisiKneeBosses.SimonBelmont;
import sisiKneeBosses.SuperSoldier;
import sisiKneeBosses.Symon;

public class BattleScreen extends FullFunctionScreen implements ShareableInfoNabeel {
	
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
	
	private final Boss[] bossList = {new SuperSoldier(), new GundamShark(), new DragonMech(),
			 						 new ShmarseTortoise(), new SimonBelmont(), new Symon()};

	private Boss boss;
	
	//Sprites
	private AnimatedComponent soraSprite;
	private AnimatedComponent soraAttack;
	private AnimatedComponent soraCast;
	private AnimatedComponent soraDamage;
	private AnimatedComponent[] soraArray = {soraSprite,soraAttack,soraCast,soraDamage};
	private AnimatedComponent dragonMechSprite;
	private AnimatedComponent dragonMechAttack;
	private AnimatedComponent dragonMechDamage;
	private AnimatedComponent[] dragonMechArray = {dragonMechSprite, dragonMechAttack, dragonMechDamage};

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
		boss = new DragonMech();
		
////////////////////////////////////////////////////////////////////////////////////
		
		blackBarHP = new Bar(300,560,PLAYER_BAR_WIDTH,30, "HP", Color.black, Color.black);
		blackBarHP.setVisible(true);
		viewObjects.add(blackBarHP);
		
		playerHPBar = new Bar(300,560,PLAYER_BAR_WIDTH,30, "HP", Color.green, Color.green);
		playerHPBar.setVisible(true);
		viewObjects.add(playerHPBar);
		
		playerHP = new TextArea(300,560,PLAYER_BAR_WIDTH, 100, player.getHP()+ " / " + player.getMaxHP());
		playerHP.setVisible(true);
		viewObjects.add(playerHP);
		
		updatePlayerHP(viewObjects);
		
////////////////////////////////////////////////////////////////////////////////////
		
		blackBarMP = new Bar(800,560,PLAYER_BAR_WIDTH,30, "HP", Color.black, Color.black);
		blackBarMP.setVisible(true);
		viewObjects.add(blackBarMP);
		
		mpBar = new Bar(800,560,PLAYER_BAR_WIDTH,30, "MP", Color.cyan, Color.cyan);
		mpBar.setVisible(true);
		viewObjects.add(mpBar);
		
		mp = new TextArea(800,560,PLAYER_BAR_WIDTH, 100, player.getMP()+ " / " + player.getMaxMP());
		mp.setVisible(true);
		viewObjects.add(mp);
		
		updatePlayerMP(viewObjects);
		
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
		
		updateBossHP(viewObjects);
		
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
		
////////////////////////////////////////////////////////////////////////////////////
		
		soraSprite = new AnimatedComponent(300,300,200,200);
		soraSprite.addSequence("resources/soraflipped.png", 150, 396, 201, 49, 41, 4);
		Thread soraIdle = new Thread(soraSprite);
		soraIdle.start();
		soraSprite.setVisible(true);
		viewObjects.add(soraSprite);
		
//		soraAttack = new AnimatedComponent(330,250,275,275);
//		soraAttack.addSequence("resources/soraattack.png", 150, 0, 0, 75, 50, 8);
//		Thread soraAtk = new Thread(soraAttack);
//		soraAtk.start();
//		soraAttack.setVisible(false);
//		viewObjects.add(soraAttack);
			
		soraCast = new AnimatedComponent(270,220,275,275);
		soraCast.addSequence("resources/soramagic.png", 150, 0, 0, 50, 82, 7);
		Thread soraCst = new Thread(soraCast);
		soraCst.start();
		soraCast.setVisible(false);
		viewObjects.add(soraCast);
		
		soraDamage = new AnimatedComponent(300,300,200,200);
		soraDamage.addSequence("resources/soraflipped.png", 1000, 548, 411, 45, 45, 1);
		Thread soraDmg = new Thread(soraDamage);
		soraDmg.start();
		soraDamage.setVisible(false);
		viewObjects.add(soraDamage);
		
////////////////////////////////////////////////////////////////////////////////////

		dragonMechSprite = new AnimatedComponent(900,150,400,400);
		dragonMechSprite.addSequence("resources/dragonmechattack.png", 150, 0, 0, 150, 105, 2);
		Thread dragonmechIdle = new Thread(dragonMechSprite);
		dragonmechIdle.start();
		dragonMechSprite.setVisible(true);
		viewObjects.add(dragonMechSprite);
		
		dragonMechAttack = new AnimatedComponent(900,150,400,400);
		dragonMechAttack.addSequence("resources/dragonmechattack.png", 150, 0, 0, 150, 105, 14);
		Thread dragonmechAtk = new Thread(dragonMechAttack);
		dragonmechAtk.start();
		dragonMechAttack.setVisible(false);
		viewObjects.add(dragonMechAttack);
		
		dragonMechDamage = new AnimatedComponent(900,150,400,400);
		dragonMechDamage.addSequence("resources/dragonmechdamage.png", 150, 36, 333, 135, 95, 3);
		Thread dragonmechDmg = new Thread(dragonMechDamage);
		dragonmechDmg.start();
		dragonMechDamage.setVisible(false);
		viewObjects.add(dragonMechDamage);
		
////////////////////////////////////////////////////////////////////////////////////

		
		
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
	
	public void setBarWidth(int x, int y, int txtOffset, Bar bar, TextArea txt, Color clr, String text, int width, double currentHP, double maxHP, int maxBarWidth, List<Visible> viewObjects) {
		
		viewObjects.remove(bar);
		viewObjects.remove(txt);
		
		int newWidth = (int)Math.round((currentHP / maxHP) * maxBarWidth);
		bar = new Bar(x,y,newWidth,30, "", clr, clr);
		bar.setVisible(true);
		viewObjects.add(bar);
		
		txt = new TextArea(x,y + txtOffset,width, 100, text);
		txt.setVisible(true);
		viewObjects.add(txt);
		
	}
	
	public void updatePlayerHP(List<Visible> viewObjects) {
		
		setBarWidth(300, 560, 0, playerHPBar, playerHP, Color.green, player.getHP() + " / " + player.getMaxHP(), PLAYER_BAR_WIDTH, player.getHP(), player.getMaxHP(), PLAYER_BAR_WIDTH, viewObjects);
		
	}
	
	public void updatePlayerMP(List<Visible> viewObjects) {
		
		setBarWidth(800, 560, 0, mpBar, mp, Color.cyan, player.getMP() + " / " + player.getMaxMP(), PLAYER_BAR_WIDTH, player.getMP(), player.getMaxMP(), PLAYER_BAR_WIDTH, viewObjects);
		
	}
	
	public void updateBossHP(List<Visible> viewObjects) {
		
		setBarWidth(200, 50, -18, bossHP, bossName, Color.red, boss.getName(), BOSS_BAR_WIDTH, boss.getHP(), boss.getMaxHP(), BOSS_BAR_WIDTH, viewObjects);
		
	}
	
	public void setPlayerSprite(int num) {
		/*
		 * 0 - idle
		 * 1 - attack
		 * 2 - magic
		 * 3 - damage
		 */
		soraSprite.setVisible(false);
		soraAttack.setVisible(false);
		soraCast.setVisible(false);
		soraDamage.setVisible(false);
		
		soraArray[num].setVisible(true);
	}
	
	public void setBossSprite(int num) {
		/*
		 * 0 - idle
		 * 1 - attack
		 * 2 - damage
		 */
		
		dragonMechSprite.setVisible(false);
		dragonMechAttack.setVisible(false);
		dragonMechDamage.setVisible(false);
		
		dragonMechArray[num].setVisible(true);

	}

	@Override
	public int bossLevel() {
		return 40;
	}

	@Override
	public boolean determineWinner() {
		//return true if player won, false is boss won
		return false;
	}

	
	/* TO DO SIDEEQ:
	 * Place character sprites on the stage
	 * Create functions for changing sprites
	 * E.G. a function that calls getAttackSprite() when a player attacks
	 * The above function can take the attack type (it's an integer, physical or special) or any other
	 * constants you make as an input.
	 * Create the game flow class (so like the turn by turn system, where the player can choose
	 * an attack and the boss uses his)
	 * Create the player spell list and item list (don't initialize it or put a placeholder item if
	 * it's empty)
	 * NOTE: I made updatePlayerHP, updatePlayeRMP, updateBossHP so it's a LOT simpler and easier 
	 * for you.
	 */
	
}
