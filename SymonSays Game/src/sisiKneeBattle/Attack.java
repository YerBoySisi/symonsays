package sisiKneeBattle;

import guiTeacher.components.AnimatedComponent;

public abstract class Attack extends AnimatedComponent {
	
	protected int damage;
	protected int type;
	protected int element;
	protected int castTime;
	
	public Attack(int x, int y, int w, int h, int dmg, int typ, int ele, int ct) {
		
		super(x, y, w, h);
		damage = dmg;
		type = typ;
		element = ele;
		castTime = ct;
		
	}
	
}
