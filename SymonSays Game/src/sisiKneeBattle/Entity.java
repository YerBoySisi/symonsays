package sisiKneeBattle;

import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.TextArea;

public abstract class Entity {
	
	//sprite constants
	public static final int IDLE_SPRITE = 0; public static final int ATTACK_SPRITE = 1; 
	public static final int SPELL_SPRITE = 2; public static final int DAMAGE_SPRITE = 3;
	
	//attack type constants
	public static final int BLUNT = 0; public static final int SLASH = 1; public static final int PIERCE = 2;
	public static final int SPECIAL = 3;
			
	//element constants
	public static final int PLAIN = 0;
	public static final int BLAZE = 1; public static final int AQUA = 2; 
	public static final int TERRA = 3; public static final int GUST = 4;
	public static final int HOLY = 5; public static final int UNHOLY = 6;
	public static final int SYMON = 777;
	
	public static final double WEAKNESS_MULTIPLIER = 2;
	public static ArrayList<Double> dmgMultipliers;
	
	protected String name;
	protected int hp;
	protected int maxHP;
	protected int power;
	protected int defense;
	protected int weakness;
	protected int level;
	protected int xp;
	protected TextArea dmgIndicator;
	
	protected AnimatedComponent[] sprite;
	
	protected ArrayList<Attack> attacks;
	
	public Entity(String nam, int hp, int pow, int def, int weak, int lvl, int xp) {
		
		name = nam;
		this.hp = hp;
		this.maxHP = hp;
		maxHP = hp;
		power = pow;
		defense = def;
		weakness = weak;
		level = lvl;
		this.xp = xp;
		
	}
	
	public void attack(Entity e, Attack a) {
		
		e.changeHP(-calculateDamage(this, a, e));
		
	}
	
	public void changeHP(int x) {
		
		hp += x;
		
	}
	
	public int calculateDamage(Entity atkr, Attack a, Entity e) {
		
		int dmg = 0;
		double mult = dmgMultipliers.get((int)(Math.random() * dmgMultipliers.size()));
		
		dmg = (int)(a.damage * ((double)atkr.power / ((double)e.defense + 7)));
		
		if(a.getType() == e.weakness) {
			return (int)(Math.round(dmg * mult) * WEAKNESS_MULTIPLIER);
		} else {
			return (int)Math.round(dmg * mult);
		}
		
	}
	
	public void setMultipliers(Entity e, Attack a) {
		
		dmgMultipliers = new ArrayList<Double>();
		
		int levelDiff = e.level - this.level;
		
		if(a.type == SLASH) {
			dmgMultipliers.add(1.1);
			dmgMultipliers.add(1.1);
			dmgMultipliers.add(1.1);
		} else if(a.type == PIERCE) {
			dmgMultipliers.add(1.3);
			dmgMultipliers.add(1.3);
			dmgMultipliers.add(1.3);
		}
		
		if(levelDiff > 0) {
			
			if(levelDiff * 2 <= this.level) {
				
				for(int i = 0; i < levelDiff * 3; i++) {
					dmgMultipliers.add(0.0);
				}
				
				dmgMultipliers.add(1.0);
				dmgMultipliers.add(1.0);
				
				return;
			
			} else if(levelDiff * 3 <= this.level) {
				
				for(int i = 0; i < levelDiff * 2; i++) {
					dmgMultipliers.add(0.0);
				}
				
				dmgMultipliers.add(1.0);
				dmgMultipliers.add(1.0);
				dmgMultipliers.add(1.0);
				dmgMultipliers.add(1.1);
				
				return;
				
			} else {
				
				for(int i = 0; i < levelDiff; i++) {
					dmgMultipliers.add(0.0);
				}
				
			}
		
		}
		
		for(int i = 0; i < 8; i++) {
			dmgMultipliers.add(1.0);
		}
		
		dmgMultipliers.add(1.1);
		dmgMultipliers.add(1.1);
		dmgMultipliers.add(1.3);
		
	}
	
	public int getHP() {
		
		return hp;
		
	}
	
	public int getMaxHP() {
		
		return maxHP;
		
	}
	
	public int getXP() {
		
		return xp;
		
	}
	
	public int getLevel() {
		
		return level;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	 
	public AnimatedComponent getIdleSprite() {
		
		return sprite[IDLE_SPRITE];
		
	}
	
	public AnimatedComponent getAttackSprite() {
		
		return sprite[ATTACK_SPRITE];
		
	}
	
	public AnimatedComponent getSpellprite() {
		
		return sprite[SPELL_SPRITE];
		
	}
	
	public AnimatedComponent getDamageSprite() {
		
		return sprite[DAMAGE_SPRITE];
		
	}

}
