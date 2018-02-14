package sisiKneeBattle;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Bar;
import guiTeacher.components.ButtonDavid;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAndStartScreen.GameStarter;
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
	
	//Battle constants
	public static final int ATTACK = 0; public static final int ITEM = 1; public static final int RUN = 2;
	
	
	//menu buttons
	
	private ButtonDavid[] battleMenu;
	
	private ButtonDavid[] fleeMenu;
	
	private ArrayList<ButtonDavid> spellMenu;
	
	private ArrayList<ButtonDavid> itemMenu;
	
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
	
	private boolean flee2;
	
	private ButtonDavid cheat;
	
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
	
	private AnimatedComponent sharkSprite;
	private AnimatedComponent sharkAttack;
	private AnimatedComponent sharkDamage;
	private AnimatedComponent[] sharkArray = {sharkSprite, sharkAttack, sharkDamage};
	
	private AnimatedComponent turtleSprite;
	private AnimatedComponent turtleAttack;
	private AnimatedComponent turtleDamage;
	private AnimatedComponent[] turtleArray = {turtleSprite, turtleAttack, turtleDamage};
	
	private AnimatedComponent belmontSprite;
	private AnimatedComponent belmontAttack;
	private AnimatedComponent belmontDamage;
	private AnimatedComponent[] belmontArray = {belmontSprite, belmontAttack, belmontDamage};
	
	private AnimatedComponent soldierSprite;
	private AnimatedComponent soldierAttack;
	private AnimatedComponent soldierDamage;
	private AnimatedComponent[] soldierArray = {soldierSprite, soldierAttack, soldierDamage};
	
	private AnimatedComponent symonSprite;
	private AnimatedComponent symonAttack;
	private AnimatedComponent symonDamage;
	private AnimatedComponent[] symonArray = {symonSprite, symonAttack, symonDamage};
	
	private AnimatedComponent[][] BossSpriteArray = {dragonMechArray, sharkArray, turtleArray, belmontArray, soldierArray, symonArray};
	
	File fontFile;
	Font font;
	Font baseFont;

	private ButtonDavid escape;

	private ButtonDavid spell;

	private ButtonDavid item;

	private ButtonDavid run;

	private ButtonDavid attack;

	private ButtonDavid stay;

	public BattleScreen(int width, int height) { 
		
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		try {
			fontFile = new File("resources/orbitron-medium.otf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			baseFont = font.deriveFont(32f);
			TextArea.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TextArea.setTextColor(Color.white);
		
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
		
////////////////////////////////////////////////////////////////////////////////////
		
		soraSprite = new AnimatedComponent(300,300,200,200);
		soraSprite.addSequence("resources/soraflipped.png", 150, 396, 201, 49, 41, 4);
		Thread soraIdle = new Thread(soraSprite);
		soraIdle.start();
		soraSprite.setVisible(true);
		viewObjects.add(soraSprite);
		
		soraAttack = new AnimatedComponent(330,250,275,275);
		soraAttack.addSequence("resources/soraattack.png", 150, 0, 0, 75, 50, 8);
		Thread soraAtk = new Thread(soraAttack);
		soraAtk.start();
		soraAttack.setVisible(false);
		viewObjects.add(soraAttack);
			
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
		dragonMechSprite.addSequence("resources/dragonmechattack.png", 850, 0, 0, 150, 105, 2);
		Thread dragonmechIdle = new Thread(dragonMechSprite);
		dragonmechIdle.start();
		dragonMechSprite.setVisible(false);
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
		
		
		
		belmontSprite = new AnimatedComponent(950, 275, 100, 200);
		belmontSprite.addSequence("resources/belmont.png", 1000, 574, 0, 25, 50, 1);
		Thread belmontIdle = new Thread(belmontSprite);
		belmontIdle.start();
		belmontSprite.setVisible(false);
		viewObjects.add(belmontSprite);
		
		belmontAttack = new AnimatedComponent(900, 200, 300, 300);
		belmontAttack.addSequence("resources/belmontAttack.png", 150, 0, 0, 85, 70, 3);
		Thread belmontAtk = new Thread(belmontAttack);
		belmontAtk.start();
		belmontAttack.setVisible(false);
		viewObjects.add(belmontAttack);
		
		belmontDamage = new AnimatedComponent(950, 275, 100, 200);
		belmontDamage.addSequence("resources/belmont.png", 1000, 285, 0, 25, 50, 1);
		Thread belmontDmg = new Thread(belmontDamage);
		belmontDmg.start();
		belmontDamage.setVisible(false);
		viewObjects.add(belmontDamage);
		

		
		sharkSprite = new AnimatedComponent(950, 275, 200, 200);
		sharkSprite.addSequence("resources/sharkBoss.png", 1000, 510, 10, 55, 55, 1);
		Thread sharkIdle = new Thread(sharkSprite);
		sharkIdle.start();
		sharkSprite.setVisible(false);
		viewObjects.add(sharkSprite);
		
		sharkAttack = new AnimatedComponent(950, 275, 200, 200);
		sharkAttack.addSequence("resources/sharkBoss.png", 1000, 763, 9, 55, 55, 1);
		Thread sharkAtk = new Thread(sharkAttack);
		sharkAtk.start();
		sharkAttack.setVisible(false);
		viewObjects.add(sharkAttack);
		
		sharkDamage = new AnimatedComponent(950, 275, 200, 200);
		sharkDamage.addSequence("resources/sharkBoss.png", 1000, 634, 9, 57, 55, 1);
		Thread sharkDmg = new Thread(sharkDamage);
		sharkDmg.start();
		sharkDamage.setVisible(false);
		viewObjects.add(sharkDamage);
		
		
		
		turtleSprite = new AnimatedComponent(750, 200, 500, 320);
		turtleSprite.addSequence("resources/turtle1.png", 1000, 50, 75, 300, 200, 1);
		Thread turtleIdle = new Thread(turtleSprite);
		turtleIdle.start();
		turtleSprite.setVisible(false);
		viewObjects.add(turtleSprite);
		
		turtleAttack = new AnimatedComponent(750, 200, 500, 320);
		turtleAttack.addSequence("resources/turtle2.png", 1000, 50, 75, 300, 200, 1);
		Thread turtleAtk = new Thread(turtleAttack);
		turtleAtk.start();
		turtleAttack.setVisible(false);
		viewObjects.add(turtleAttack);
		
		turtleDamage = new AnimatedComponent(750, 200, 500, 320);
		turtleDamage.addSequence("resources/turtle3.png", 1000, 50, 75, 300, 200, 1);
		Thread turtleDmg = new Thread(turtleDamage);
		turtleDmg.start();
		turtleDamage.setVisible(false);
		viewObjects.add(turtleDamage);
		
		
		
		soldierSprite = new AnimatedComponent(875, 250, 150, 300);
		soldierSprite.addSequence("resources/supersoldier.png", 150, 385, 15, 40, 50, 5);
		Thread soldierIdle = new Thread(soldierSprite);
		soldierIdle.start();
		soldierSprite.setVisible(false);
		viewObjects.add(soldierSprite);
		
		soldierAttack = new AnimatedComponent(800, 300, 350, 170);
		soldierAttack.addSequence("resources/soldierAttack.png", 100, 0, 0, 80, 50, 5);
		Thread soldierAtk = new Thread(soldierAttack);
		soldierAtk.start();
		soldierAttack.setVisible(false);
		viewObjects.add(soldierAttack);
		
		soldierDamage = new AnimatedComponent(875, 250, 150, 300);
		soldierDamage.addSequence("resources/supersoldier.png", 1000, 549, 211, 35, 47, 1);
		Thread soldierDmg = new Thread(soldierDamage);
		soldierDmg.start();
		soldierDamage.setVisible(false);
		viewObjects.add(soldierDamage);
		
////////////////////////////////////////////////////////////////////////////////////
		 attack = new ButtonDavid("Attack", null, 300, 615, 350, 130, new Action() {
				
				@Override
				public void act() {
					makeSelection(ATTACK, player.getAttack(0), viewObjects);
				}
			});
		 run = new ButtonDavid("Run Away", null, 300, 615, 350, 130, new Action() {

			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.resultScreen);
			}
		}); 
		 stay = new ButtonDavid("Stay and Fight", null, 800, 615, 350, 130,new Action() {

				@Override
				public void act() {
					changeButtons2(viewObjects,attack,spell,item,escape,run,stay);
					
				}
			}); 
		 spell =  new ButtonDavid("Spell", null, 800, 610, 350, 45, null);
		 item =  new ButtonDavid("Item", null, 800, 661, 350, 45, null);
		escape =  new ButtonDavid("Flee", null, 800, 709, 350, 45, new Action() {

				@Override
				public void act() {
					changeButtons(viewObjects,attack,spell,item,escape,run,stay);
					
				}
			});
		viewObjects.add(attack);
		viewObjects.add(spell);
		viewObjects.add(item);
		viewObjects.add(escape);
//		''
		
//		for(int i = 0; i < fleeMenu.length; i++) {
//			fleeMenu[i].setVisible(false);
//			
//		}
		
////////////////////////////////////////////////////////////////////////////////////

		cheat = new ButtonDavid("Cheat", null, 50, 50, 50, 50, new Action() {
			
			@Override
			public void act() {
				GameStarter.start.setScreen(GameStarter.resultScreen);
				
			}
		});
		cheat.setCustomTextColor(Color.WHITE);
		cheat.setVisible(true);
		viewObjects.add(cheat);
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
		
		int newWidth = (int)Math.round(((double)currentHP / (double)maxHP) * maxBarWidth);
		bar = new Bar(x,y,newWidth,30, "", clr, clr);
		bar.setVisible(true);
		viewObjects.add(bar);
		
		txt = new TextArea(x,y + txtOffset,width, 100, text);
		txt.setVisible(true);
		txt.setFont(font);
		viewObjects.add(txt);
		
	}
	
	public void updatePlayerHP(List<Visible> viewObjects) {
		
		viewObjects.remove(playerHPBar);
		viewObjects.remove(playerHP);
		setBarWidth(300, 560, 0, playerHPBar, playerHP, Color.green, player.getHP() + " / " + player.getMaxHP(), PLAYER_BAR_WIDTH, player.getHP(), player.getMaxHP(), PLAYER_BAR_WIDTH, viewObjects);
		
	}
	
	public void updatePlayerMP(List<Visible> viewObjects) {
		
		viewObjects.remove(mpBar);
		viewObjects.remove(mp);
		setBarWidth(800, 560, 0, mpBar, mp, Color.cyan, player.getMP() + " / " + player.getMaxMP(), PLAYER_BAR_WIDTH, player.getMP(), player.getMaxMP(), PLAYER_BAR_WIDTH, viewObjects);
		
	}
	
	public void updateBossHP(List<Visible> viewObjects) {
		
		viewObjects.remove(bossHP);
		viewObjects.remove(bossName);
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
	
	public void setBossSprite(int boss, int num) {
		/*
		 * FIRST INT (selects which boss to display)
		 * 0 - dragon mech
		 * 1 - gundam shark
		 * 2 - sharse tortoise
		 * 3 - simon belmont
		 * 4 - super soldier
		 * 5 - symon
		 * 
		 * SECOND INT (selects which animation to play)
		 * 0 - idle
		 * 1 - attack
		 * 2 - damage
		 */
		
		for (int i = 0; i < BossSpriteArray.length; i++) {
			for (int e = 0; e < BossSpriteArray[i].length; i++) {
				BossSpriteArray[i][e].setVisible(false);
			}
		}
		
		BossSpriteArray[boss][num].setVisible(true);

	}
	
	public void runBattleSequence(int selection, Attack a) {
		
		new Thread(() -> {
			
			playerTurn(selection, a);
				
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			bossTurn();
				
		}).start();
		
		//updatePlayerHP(viewObjects);
		//updateBossHP(viewObjects);
		update();
		
	}
	
	public void playerTurn(int selection, Attack a) {
		
		switch(selection) {
		case ATTACK:
			player.attack(boss, a);
			player.changeMP(a.getCost());
		case ITEM:
			if(player.getHP() < player.getMaxHP()) {
				player.changeHP(10);
			}
		case RUN:
			player.changeHP(-player.getHP());
		}
		
	}
	
	public void makeSelection(int selection, Attack a, List<Visible> vo) {
		
		runBattleSequence(selection, a);
		updatePlayerHP(vo);
		
	}
	
	public void bossTurn() {
		
		int totalDmgBoss = 0;
		double[] bossAttackChances;
		
		for(int i = 0; i < boss.attacks.size(); i++) {
			totalDmgBoss += boss.attacks.get(i).getDamage();
		}
		
		double n = 0;
		
		bossAttackChances = new double[boss.attacks.size()];
		
		for(int i = boss.attacks.size() - 1; i >= 0; i--) {
			n += (boss.attacks.get(i).getDamage() / totalDmgBoss);
			bossAttackChances[i] = n;
		}
		
		double rand = Math.random();
		
		for(int i = 0; i < bossAttackChances.length; i++) {
			
			if(rand <= bossAttackChances[i]) {
				boss.attack(player, boss.getAttack(i));
				break;
			}
			
		}
		
	}
	
	@Override
	public int bossLevel() {
		
		return bossList[0].getLevel();
		
	}

	@Override
	public boolean determineWinner() {
		
		return false;
		
	}

	@Override
	public int remainingHealth() {
		
		return 0;
		
	}

	@Override
	public int totalHealth() {
		
		return 0;
		
	}

	@Override
	public int playerLevel() {
		
		return player.getHP();
	}

	@Override
	public int playerXp() {
		
		return 0;
		
	}
	
	public void switchMenu(int menu, List<Visible> viewObjects) {
			
		for(int i = 0; i < fleeMenu.length; i++) {
			fleeMenu[i].setVisible(true);
			viewObjects.add(fleeMenu[i]);
		}
		
	}
	
	public void changeButtons(List<Visible> viewObjects, ButtonDavid attack, ButtonDavid spell, ButtonDavid item, ButtonDavid escape, ButtonDavid run, ButtonDavid stay) {

			viewObjects.remove(attack);
			viewObjects.remove(spell);
			viewObjects.remove(item);
			viewObjects.remove(escape);
			viewObjects.add(run);
			viewObjects.add(stay);
	
	}
	
	public void changeButtons2(List<Visible> viewObjects, ButtonDavid attack, ButtonDavid spell, ButtonDavid item, ButtonDavid escape, ButtonDavid run, ButtonDavid stay) {
			viewObjects.remove(run);
			viewObjects.remove(stay);
			viewObjects.add(attack);
			viewObjects.add(spell);
			viewObjects.add(item);
			viewObjects.add(escape);
	}
}
	
