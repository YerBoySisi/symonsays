package sisiKneeBattle;

import guiTeacher.components.AnimatedComponent;

public abstract class Attack extends AnimatedComponent {
	
	protected String name;
	protected int damage;
	protected int type;
	protected int element;
	protected int castTime;

	public Attack(String nam, int x, int y, int w, int h, int dmg, int typ, int ele, int ct) {
		
		super(x, y, w, h);
		name = nam;
		damage = dmg;
		type = typ;
		element = ele;
		castTime = ct;
		
	}
	
	public String getName() {
		
		return name;
		
	}

	public int getDamage() {
		
		return damage;
		
	}

	public int getType() {
		
		return type;
		
	}

	public int getElement() {
		
		return element;
		
	}

	public int getCastTime() {
		
		return castTime;
		
	}
	
}
