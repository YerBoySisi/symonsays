package sisiKneeBattle;

public class Player extends Entity {
	
	private int mp;
	private int xp;
	
	public Player(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		
	}
	
	public void setStats(int hp, int mp, int pow, int def, int weak) {
		
		this.hp = hp;
		this.mp = mp;
		power = pow;
		defense = def;
		weakness = weak;
		
	}

}
