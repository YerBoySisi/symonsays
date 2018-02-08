package sisiKneeBattle;

public class Player extends Entity {
	
	private int mp;
	private int maxMP;
	private int xp;
	
	public Player() {
		
		super("Dymon", 5, 5, 5, 5, 5, 5);
		
	}
	
	public void setStats(int hp, int mp, int pow, int def, int weak) {
		
		this.hp = hp;
		this.mp = mp;
		this.maxMP = mp;
		power = pow;
		defense = def;
		weakness = weak;
		
	}
	
	public void useItem(Object i) {
		
		
		
	}

	public int getMP() {
		
		return mp;
		
	}

	public int getMaxMP() {
		
		return maxMP;
		
	}

}
