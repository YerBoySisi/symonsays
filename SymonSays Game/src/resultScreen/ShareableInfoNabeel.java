package resultScreen;

public interface ShareableInfoNabeel {
	int bossLevel();// returns bosses level
	boolean determineWinner();// true if player won and false if the cpu wins
	int remainingHealth();//gives the health of the player after victory
	int totalHealth();//players starting health
	int playerLevel();//the players xp level
	int playerXp(); //xp before the player reaches next level
	
	
	
	
}
