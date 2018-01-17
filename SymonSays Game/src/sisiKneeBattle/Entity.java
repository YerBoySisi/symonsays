package sisiKneeBattle;

import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.TextArea;

public abstract class Entity extends AnimatedComponent {
	
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

}
