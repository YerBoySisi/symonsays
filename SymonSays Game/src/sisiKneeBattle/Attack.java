package sisiKneeBattle;

import guiTeacher.components.AnimatedComponent;

public class Attack {
	
	protected String name;
	protected int damage;
	protected int type;
	protected int element;
	protected int manaCost;
	
	protected AnimatedComponent[] sprite;

	public Attack(String nam, int dmg, int typ, int ele) {
		
		name = nam;
		damage = dmg;
		type = typ;
		element = ele;
		manaCost = 0;
		
	}	
	
	public Attack(String nam, int dmg, int typ, int ele, int mc) {
		
		name = nam;
		damage = dmg;
		type = typ;
		element = ele;
		manaCost = mc;
		
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
	
	public int getCost() {
		
		return manaCost;
		
	}
	
}
