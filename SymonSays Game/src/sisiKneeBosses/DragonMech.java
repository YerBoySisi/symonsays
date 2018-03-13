package sisiKneeBosses;

import java.util.ArrayList;

import sisiKneeBattle.Attack;

public class DragonMech extends Boss {
	
	private static final int STARTING_HP = 600;
	
	public DragonMech() {
		
		super("Dragon Mech", STARTING_HP, 40, 40, HOLY, 5, 1200);
		initializeAttacks();
		
	}

	public void initializeAttacks() {

		attacks = new ArrayList<Attack>();
		attacks.add(new Attack("Jet Swoop", 1, BLUNT, PLAIN));
		attacks.add(new Attack("Drill Peck", 1, PIERCE, PLAIN));
		attacks.add(new Attack("Charge Tackle", 2, SLASH, PLAIN));
		attacks.add(new Attack("Missile Launch", 2, SPECIAL, PLAIN));
		attacks.add(new Attack("Rocket Slam", 2, BLUNT, PLAIN));
		attacks.add(new Attack("Laser Beam", 4, SPECIAL, PLAIN));

	}

}
