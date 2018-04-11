package sisiKneeBosses;

import java.util.ArrayList;

import sisiKneeBattle.Attack;

public class DragonMech extends Boss {
	
	private static final int STARTING_HP = 100;
	
	public DragonMech() {
		
		super("Dragon Mech", STARTING_HP, 40, 40, HOLY, 5, 1200);
		initializeAttacks();
		
	}

	public void initializeAttacks() {

		attacks = new ArrayList<Attack>();
		attacks.add(new Attack("Jet Swoop", 8, BLUNT, PLAIN));
		attacks.add(new Attack("Drill Peck", 8, PIERCE, PLAIN));
		attacks.add(new Attack("Charge Tackle", 10, SLASH, PLAIN));
		attacks.add(new Attack("Missile Launch", 12, SPECIAL, PLAIN));
		attacks.add(new Attack("Rocket Slam", 16, BLUNT, PLAIN));
		attacks.add(new Attack("Laser Beam", 20, SPECIAL, PLAIN));

	}

}
