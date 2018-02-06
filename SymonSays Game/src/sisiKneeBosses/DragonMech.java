package sisiKneeBosses;

import java.util.ArrayList;

import sisiKneeBattle.Attack;

public class DragonMech extends Boss {
	
	private static final int STARTING_HP = 600;
	
	public DragonMech() {
		
		super(null, 0, 0, 0, 0, 0, 0);
		
	}

	public void initializeAttacks() {

		attacks = new ArrayList<Attack>();
		attacks.add(new Attack("Missile Launch", 20, SPECIAL, PLAIN));
		attacks.add(new Attack("Laser Beam", 40, SPECIAL, PLAIN));
		attacks.add(new Attack("Charge Tackle", 30, SLASH, PLAIN));
		attacks.add(new Attack("Drill Peck", 30, PIERCE, PLAIN));
		attacks.add(new Attack("Rocket Slam", 35, BLUNT, PLAIN));
		attacks.add(new Attack("Jet Swoop", 35, BLUNT, PLAIN));

	}

}
