package sisiKneeBosses;

import java.util.ArrayList;

import sisiKneeBattle.Attack;
import sisiKneeBattle.Entity;

public abstract class Boss extends Entity {
	
	//attack type constants
	public static final int BLUNT = 0; public static final int SLASH = 1; public static final int PIERCE = 2;
	public static final int SPECIAL = 3;
	
	//element constants
	public static final int PLAIN = 0;
	public static final int BLAZE = 1; public static final int AQUA = 2; 
	public static final int TERRA = 3; public static final int GUST = 4;
	public static final int HOLY = 5; public static final int UNHOLY = 6;
	public static final int SYMON = 777;
	
	public ArrayList<Attack> attacks;
	
	public Boss(String nam, int hp, int pow, int def, int weak, int lvl, int xp) {
		
		super(nam, hp, pow, def, weak, lvl, xp);
		
	}

	public void addAttack(Attack a) {
		
		attacks.add(a);
		
	}
	
	public abstract void initializeAttacks();

}
