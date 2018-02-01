package sisiKneeBosses;

import java.util.ArrayList;

import sisiKneeBattle.Attack;
import sisiKneeBattle.Entity;

public abstract class Boss extends Entity {
	
	protected ArrayList<Attack> attacks;
	
	public Boss(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		
	}
	
	public void addAttack(Attack a) {
		
		attacks.add(a);
		
	}
	
	public abstract void initializeAttacks();

}
