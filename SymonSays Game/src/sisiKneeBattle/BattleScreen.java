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
import inv.Inventory;
import inv.Items;
import startGame.GameStarter;
import resultScreen.ShareableInfoNabeel;
import shopmenu.DavidSell;
import sisiKneeBosses.Boss;
import sisiKneeBosses.DragonMech;
import sisiKneeBosses.GundamShark;
import sisiKneeBosses.ShmarseTortoise;
import sisiKneeBosses.SimonBelmont;
import sisiKneeBosses.SuperSoldier;
import sisiKneeBosses.Symon;
import startGame.GameStarter;

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
	
	private ButtonDavid cancelItem;
	
	private ButtonDavid itemHP;
	private ButtonDavid itemDodge;
	private ButtonDavid itemDef;
	private ButtonDavid itemAtk;
	
	private ButtonDavid cancelSpell;
	private ButtonDavid prevSpell;
	private ButtonDavid currentSpell;
	private ButtonDavid nextSpell;
	private ArrayList<Attack> spells;
	private int spellIndex;
	
	public BattleScreen(int width, int height) { 
		
		super(width, height);
		
	}
	
	/*public void switchMenu(int menu, List<Visible> viewObjects) {
		
		for(int i = 0; i < fleeMenu.length; i++) {
			fleeMenu[i].setVisible(true);
			viewObjects.add(fleeMenu[i]);
		}
		
	}
	*/
	
	
	public void showFlee(ButtonDavid attack, ButtonDavid spell, ButtonDavid item, ButtonDavid escape, ButtonDavid run, ButtonDavid stay) {

		remove(attack);
		remove(spell);
		remove(item);
		remove(escape);
		addObject(run);
		addObject(stay);
	
	}
	
	public void hideFlee(ButtonDavid attack, ButtonDavid spell, ButtonDavid item, ButtonDavid escape, ButtonDavid run, ButtonDavid stay) {
	    remove(run);
		remove(stay);
		addObject(attack);
		addObject(spell);
		addObject(item);
		addObject(escape);
	}
	
	public void showItem(ButtonDavid attack, ButtonDavid spell, ButtonDavid item, ButtonDavid escape, ButtonDavid run, ButtonDavid stay) {
		remove(attack);
		remove(spell);
		remove(item);
		remove(escape);
		addObject(cancelItem);
		/*
		itemMenu = new ArrayList<ButtonDavid>(GameStarter.inventory.itemlist.size());
		for (int i = 0; i < GameStarter.inventory.itemlist.size(); i++) {
			itemMenu.add(new ButtonDavid(GameStarter.inventory.itemlist.get(i).getItemN(), null, 800, 564+46*(i+1), 350, 45, null));
		}
		for (int i = 0; i < GameStarter.inventory.itemlist.size(); i++) {
			addObject(itemMenu.get(i));
		*/
		calcAmount();
		addObject(itemHP);
		addObject(itemDef);
		addObject(itemDodge);
		addObject(itemAtk);

	}
	
	public void calcAmount() {
		int HPcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("hp"));
		int Defcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("def"));
		int Dodgecount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("dodge"));
		int Attackcount = DavidSell.countOccurences(GameStarter.inventory.itemlist,new Items("atk"));
		itemHP.setText(itemHP.getText()+" x"+HPcount);
		itemDef.setText(itemDef.getText()+" x"+Defcount);
		itemDodge.setText(itemDodge.getText()+" x"+Dodgecount);
		itemAtk.setText(itemAtk.getText()+" x"+Attackcount);
	}
	
	public void showSpell() {
		remove(attack);
		remove(spell);
		remove(item);
		remove(escape);
		addObject(cancelSpell);
		addObject(prevSpell);
		addObject(nextSpell);
		addObject(currentSpell);
		fetchSpells();
		updateSpell();
	}
	
	public void fetchSpells() {
		spells = new ArrayList<Attack>();
		for (int i = 1; i < player.attacks.size(); i++) {
			spells.add(player.attacks.get(i));
		}
		spellIndex = 0;
	}
	
	public void scrollSpellList(int direction) {
		if (spellIndex + direction == -1 || spellIndex + direction == spells.size()) {
			return;
		}
		spellIndex = spellIndex + direction;
		updateSpell();
	}
	
	public void updateSpell() {
		currentSpell.setText(spells.get(spellIndex).getName() + " (MP"+spells.get(spellIndex).getCost()+")");
	}
	
	public void hideSpell() {
		addObject(attack);
		addObject(spell);
		addObject(item);
		addObject(escape);
		remove(cancelSpell);
		remove(prevSpell);
		remove(nextSpell);
		remove(currentSpell);
	}
	
	public void hideItem(ButtonDavid attack, ButtonDavid spell, ButtonDavid item, ButtonDavid escape, ButtonDavid run, ButtonDavid stay) {
		/*
		for (int i = 0; i < GameStarter.inventory.itemlist.size(); i++) {
			remove(itemMenu.get(i));
		*/
		remove(cancelItem);
		remove(itemHP);
		remove(itemDef);
		remove(itemDodge);
		remove(itemAtk);
		addObject(attack);
		addObject(spell);
		addObject(item);
		addObject(escape);
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
		
		int newWidth = (int)Math.round(((double)player.getHP() / (double)player.getMaxHP()) * PLAYER_BAR_WIDTH);
		playerHP = new TextArea(300,560,newWidth, 100, player.getHP()+ " / " + player.getMaxHP());
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
		sharkSprite.setVisible(true);
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
		 run = new ButtonDavid("Run Away", null, 800, 615, 350, 130, new Action() {

			@Override
			public void act() {
				hideFlee(attack,spell,item,escape,run,stay);				
				GameStarter.start.setScreen(GameStarter.resultScreen);
			}
		}); 
		 stay = new ButtonDavid("Stay and Fight", null, 300, 615, 350, 130,new Action() {

				@Override
				public void act() {
					hideFlee(attack,spell,item,escape,run,stay);
					
				}
			}); 
		 cancelSpell = new ButtonDavid("Cancel", null, 300, 615, 300, 130,new Action() {

				@Override
				public void act() {
					hideSpell();
					
				}
			});
		 prevSpell = new ButtonDavid("prev", null, 610, 655, 100, 50, new Action() {
			
			@Override
			public void act() {
				scrollSpellList(-1);
				
			}
		});
		 nextSpell = new ButtonDavid("next", null, 1210, 655, 100, 50, new Action() {
				
				@Override
				public void act() {
					scrollSpellList(1);
					
				}
			});
		 currentSpell = new ButtonDavid(" ", null, 720, 615, 480, 130, new Action() {
			
			@Override
			public void act() {
				makeSelection(ATTACK, spells.get(spellIndex), viewObjects);
				
			}
		});
		 cancelItem = new ButtonDavid("Cancel", null, 300, 615, 300, 130,new Action() {

				@Override
				public void act() {
					hideItem(attack,spell,item,escape,run,stay);
					
				}
			}); 
		 itemHP = new ButtonDavid("HP", null, 610, 615, 130, 130,new Action() {

				@Override
				public void act() {
					
					
				}
			}); 
		 itemDef = new ButtonDavid("Def", null, 750, 615, 130, 130,new Action() {

				@Override
				public void act() {
					
					
				}
			}); 
		 itemAtk = new ButtonDavid("Atk", null, 890, 615, 130, 130,new Action() {

				@Override
				public void act() {
					
					
				}
			}); 
		 itemDodge = new ButtonDavid("Dg", null, 1030, 615, 130, 130,new Action() {

				@Override
				public void act() {
					
					
				}
			}); 
		 spell =  new ButtonDavid("Spell", null, 800, 610, 350, 45, new Action() {
			
			@Override
			public void act() {
				showSpell();
				
			}
		});
		 item =  new ButtonDavid("Item", null, 800, 661, 350, 45, new Action() {
			
			@Override
			public void act() {
				showItem(attack,spell,item,escape,run,stay);
			}
		});
		escape =  new ButtonDavid("Flee", null, 800, 709, 350, 45, new Action() {

				@Override
				public void act() {
					showFlee(attack,spell,item,escape,run,stay);
					
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
		//viewObjects.add(cheat);
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
	
	public void setHPWidth(int x, int y, int txtOffset, Bar bar, TextArea txt, Color clr, String text, int width, double currentHP, double maxHP, int maxBarWidth) {
		
		int newWidth = (int)Math.round(((double)currentHP / (double)maxHP) * maxBarWidth);
		if (newWidth<=0) {
			txt = new TextArea(x,y + txtOffset,width, 100, text);
			txt.setVisible(true);
			txt.setFont(font);
			addObject(txt);
		}
		else {
			bar = new Bar(x,y,newWidth,30, "", clr, clr);
			playerHPBar = bar;
			bar.setVisible(true);
			addObject(bar);
			
			txt = new TextArea(x,y + txtOffset,width, 100, text);
			txt.setVisible(true);
			txt.setFont(font);
			addObject(txt);
		}
		
	}
	
	public void setMPWidth(int x, int y, int txtOffset, Bar bar, TextArea txt, Color clr, String text, int width, double currentHP, double maxHP, int maxBarWidth) {
		
		int newWidth = (int)Math.round(((double)currentHP / (double)maxHP) * maxBarWidth);
		if (newWidth<=0) {
			txt = new TextArea(x,y + txtOffset,width, 100, text);
			txt.setVisible(true);
			txt.setFont(font);
			addObject(txt);
		}
		else {
			bar = new Bar(x,y,newWidth,30, "", clr, clr);
			mpBar = bar;
			bar.setVisible(true);
			addObject(bar);
			
			txt = new TextArea(x,y + txtOffset,width, 100, text);
			txt.setVisible(true);
			txt.setFont(font);
			addObject(txt);
		}
		
	}
	
	public void setBossWidth(int x, int y, int txtOffset, Bar bar, TextArea txt, Color clr, String text, int width, double currentHP, double maxHP, int maxBarWidth) {
	
		int newWidth = (int)Math.round(((double)currentHP / (double)maxHP) * maxBarWidth);
		if (newWidth<=0) {
			txt = new TextArea(x,y + txtOffset,width, 100, text);
			txt.setVisible(true);
			txt.setFont(font);
			addObject(txt);
		}
		else {
			bar = new Bar(x,y,newWidth,30, "", clr, clr);
			bossHP = bar;
			bar.setVisible(true);
			addObject(bar);
		
			txt = new TextArea(x,y + txtOffset,width, 100, text);
			txt.setVisible(true);
			txt.setFont(font);
			addObject(txt);
		}
	
	}

	public void updatePlayerHP() {
		
		remove(playerHPBar);
		remove(playerHP);
		setHPWidth(300, 560, 0, playerHPBar, playerHP, Color.green, player.getHP() + " / " + player.getMaxHP(), PLAYER_BAR_WIDTH, player.getHP(), player.getMaxHP(), PLAYER_BAR_WIDTH);
		
	}
	
	public void updatePlayerMP() {
		
		remove(mpBar);
		remove(mp);
		setMPWidth(800, 560, 0, mpBar, mp, Color.cyan, player.getMP() + " / " + player.getMaxMP(), PLAYER_BAR_WIDTH, player.getMP(), player.getMaxMP(), PLAYER_BAR_WIDTH);
	}
	
	public void updateBossHP() {
		
		remove(bossHP);
		remove(bossName);
		setBossWidth(200, 50, -18, bossHP, bossName, Color.red, boss.getName(), BOSS_BAR_WIDTH, boss.getHP(), boss.getMaxHP(), BOSS_BAR_WIDTH);
		
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
		
		BossSpriteArray[boss][0].setVisible(false);
		BossSpriteArray[boss][1].setVisible(false);
		BossSpriteArray[boss][2].setVisible(false);
		BossSpriteArray[boss][num].setVisible(true);

	}
	
	public void runBattleSequence(int selection, Attack a) {
		
		new Thread(() -> {
			
			playerTurn(selection, a);
			turnInfo.setText("Player turn, hp is "+player.hp);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setBossSprite(1,1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bossTurn();
			turnInfo.setText("Boss turn, hp is "+player.hp);
			setBossSprite(1,0);
				
		}).start();
		
		update();
		
	}
	
	public void playerTurn(int selection, Attack a) {
		
		switch(selection) {
		
		
		case ATTACK:
			if (a.equals(player.attacks.get(0)))
			setPlayerSprite(1);
			else {
			setPlayerSprite(2);	
			}
			player.attack(boss, a);
			if (!a.equals(player.attacks.get(0))) {
				//player.attacks.remove(a);
				fetchSpells();
				updateSpell();
			}
			player.changeMP(-a.getCost());
			break;
		case ITEM:
			if(player.getHP() < player.getMaxHP()) {
				player.changeHP(10);
			}
			break;
		case RUN:
			player.changeHP(-player.getHP());
			break;
		}
		
	}
	
	public void makeSelection(int selection, Attack a, List<Visible> vo) {
		runBattleSequence(selection, a);
		updatePlayerHP();
		updateBossHP();
		updatePlayerMP();
		
		if (player.hp<=0) {
			turnInfo.setText("You died!!");
			//GameStarter.start.setScreen(GameStarter.resultScreen);
		}
		if (boss.hp<=0) {
			turnInfo.setText("You won!!");
			//GameStarter.start.setScreen(GameStarter.resultScreen);
		}
		
	}
	
	public void bossTurn() {
		setPlayerSprite(0);
		int totalDmgBoss = 0;
		double[] bossAttackChances;
		
		for(int i = 0; i < boss.attacks.size(); i++) {
			totalDmgBoss += boss.attacks.get(i).getDamage();
		}
		
		double n = 0;
		
//		bossAttackChances = new double[boss.attacks.size()];
		
//		for(int i = boss.attacks.size() - 1; i >= 0; i--) {
//			n += (boss.attacks.get(i).getDamage() / totalDmgBoss);
//			bossAttackChances[i] = n;
//		}
//		
//		double rand = Math.random();
//		
//		for(int i = 0; i < bossAttackChances.length; i++) {
//			
//			if(rand <= bossAttackChances[i]) {
//				boss.attack(player, boss.getAttack(i));
//				break;
//			}
//			
//		}

		boss.attack(player, boss.attacks.get((int) (boss.attacks.size()*Math.random())));
		
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
}
