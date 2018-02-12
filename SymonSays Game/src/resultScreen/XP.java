package resultScreen;

public class XP {
	private static int health = ResultGui.battleScreen.totalHealth();
	private static int playerRem = ResultGui.battleScreen.remainingHealth();
	private static int playerLvl = ResultGui.battleScreen.playerLevel();
	private static int xp;
	private static int monsterLVL = ResultGui.battleScreen.bossLevel();
	private static int playerXP =  ResultGui.battleScreen.playerXp();
	
	public static int determineXP() {
		
		if(playerRem>health/2 && monsterLVL*5 > 2*playerLvl) {
			int lvlUp= (playerLvl+1)*(playerLvl)*500;
			xp = lvlUp - playerXP +100; 
		}
		else {
			if(playerRem<health/2 && monsterLVL*5 > 2*playerLvl ) {
				int lvlUp= (playerLvl+1)*(playerLvl)*500;
				if(lvlUp - playerXP > 1000) {
					xp = lvlUp - playerXP - 300; 
				
				}
				else {
					xp = (int)((lvlUp-playerXP)/1.5);
				}
			
			}
			else {
				if(monsterLVL*5 > 2*playerLvl) {
					int lvlUp= (playerLvl+)*(playerLvl)*500;
					if(lvlUp - playerXP > 1000) {
						xp = lvlUp - playerXP - 500; 
					}
					else{
						xp = (int)((lvlUp-playerXP)/1.9);
					
					}
				}
				else {
					xp = 100;
				}
				
			}
		}
		return xp;
		
	}

}

