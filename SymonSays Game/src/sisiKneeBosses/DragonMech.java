package sisiKneeBosses;

import java.util.ArrayList;

import sisiKneeBattle.Attack;

public class DragonMech extends Boss {
	
	private static final int STARTING_HP = 600;
	
	public DragonMech(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		hp = STARTING_HP;
		
	}

	public void initializeAttacks() {

		attacks = new ArrayList<Attack>();
		attacks.add(new Attack("Missile Launch", 0, 0, 0, 0, 20, SPECIAL, PLAIN));
		attacks.add(new Attack("Laser Beam", 0, 0, 0, 0, 40, SPECIAL, PLAIN));
		attacks.add(new Attack("Charge Tackle", 0, 0, 0, 0, 30, SLASH, PLAIN));
		attacks.add(new Attack("Drill Peck", 0, 0, 0, 0, 30, PIERCE, PLAIN));
		attacks.add(new Attack("Rocket Slam", 0, 0, 0, 0, 35, BLUNT, PLAIN));
		attacks.add(new Attack("Jet Swoop", 0, 0, 0, 0, 35, BLUNT, PLAIN));

	}

}
