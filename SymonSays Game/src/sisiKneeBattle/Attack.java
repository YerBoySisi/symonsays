package sisiKneeBattle;

import guiTeacher.components.AnimatedComponent;

public class Attack {
	
	protected String name;
	protected int damage;
	protected int type;
	protected int element;
	
	protected AnimatedComponent[] sprite;

	public Attack(String nam, int dmg, int typ, int ele) {
		
		name = nam;
		damage = dmg;
		type = typ;
		element = ele;
		
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
	
}
