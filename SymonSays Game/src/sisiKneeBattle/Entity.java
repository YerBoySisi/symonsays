package sisiKneeBattle;

import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.TextArea;

public abstract class Entity extends AnimatedComponent {
	
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
	
	protected int hp;
	protected int power;
	protected int defense;
	protected int weakness;
	protected int level;
	protected TextArea dmgIndicator;
	
	protected ArrayList<Attack> attacks;
	
	public Entity(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		
	}
	
	public void setStats(int hp, int pow, int def, int weak) {
		
		this.hp = hp;
		power = pow;
		defense = def;
		weakness = weak;
		
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
		
		dmg = a.damage - (int)Math.round(e.defense-1 / atkr.power);
		
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

}
