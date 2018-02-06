package sisiKneeBattle;

public class Player extends Entity {
	
	private int mp;
	private int xp;
	
	public Player() {
		
		super(null, 0, 0, 0, 0, 0, 0);
		
	}
	
	public void setStats(int hp, int mp, int pow, int def, int weak) {
		
		this.hp = hp;
		this.mp = mp;
		power = pow;
		defense = def;
		weakness = weak;
		
	}
	
	public void useItem(Object i) {
		
		
		
	}

}
