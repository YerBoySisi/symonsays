package sisiKneeBattle;

import guiTeacher.components.AnimatedComponent;

public abstract class Attack extends AnimatedComponent {
	
	protected int damage;
	protected int castTime;
	protected int type;
	protected int element;
	
	public Attack(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		
	}
	
}
