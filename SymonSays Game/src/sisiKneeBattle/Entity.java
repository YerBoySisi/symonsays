package sisiKneeBattle;

import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.TextArea;

public abstract class Entity extends AnimatedComponent {
	
	public static final double CRITICAL_MULTIPLIER = 1.3;
	
	protected int hp;
	protected int power;
	protected int defense;
	protected int weakness;
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
		
		int dmg = 0;
		
	}
	
	public void setHP(int x) {
		
		hp = x;
		
	}

}
