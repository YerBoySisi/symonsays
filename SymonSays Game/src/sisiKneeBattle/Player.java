package sisiKneeBattle;

import java.util.ArrayList;

public class Player extends Entity {
	
	private int mp;
	private int maxMP;
	private int xp;
	
	public Player() {
		
		super("Dymon", 0, 0, 0, 0, 0, 0);
		setStats(100, 50, 20, 20, 777);
		initializeAttacks();
		
	}
	
	public void setStats(int hp, int mp, int pow, int def, int weak) {
		
		this.hp = hp;
		this.maxHP = hp;
		this.mp = mp;
		this.maxMP = mp;
		power = pow;
		defense = def;
		weakness = weak;
		
	}

	public void initializeAttacks() {

		attacks = new ArrayList<Attack>();
		attacks.add(new Attack("Strike", power, BLUNT, PLAIN));
		attacks.add(new Attack("Pierce Shot", power + 5, PIERCE, PLAIN, 2));
		attacks.add(new Attack("Dual Slash", power * 2, SLASH, PLAIN, 10));
		attacks.add(new Attack("Divine Intervention", 100, SPECIAL, HOLY, 30));

	}

	public void changeMP(int n) {
		
		mp += n;
		
	}

	public int getMP() {
		
		return mp;
		
	}

	public int getMaxMP() {
		
		return maxMP;
		
	}

}
