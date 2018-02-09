package sisiKneeBattle;

import sisiKneeBosses.Boss;

public class BattleSequence {
	
	public static final int ATTACK = 0; public static final int ITEM = 1; public static final int RUN = 2;
	
	private Boss boss;
	private Player player;
	private int totalDmgBoss;
	private double[] bossAttackChances;
	
	private boolean selectionMade = false;
	private int selection;
	
	public BattleSequence(Player p, Boss b) {
		
		player = p;
		boss = b;
		
		totalDmgBoss = 0;
		
		for(int i = 0; i < boss.getAttacks().size(); i++) {
			totalDmgBoss += boss.getAttacks().get(i).getDamage();
		}
		
		double n = 0;
		bossAttackChances = new double[boss.getAttacks().size()];
		
		for(int i = boss.getAttacks().size() - 1; i >= 0; i--) {
			n += (boss.getAttacks().get(i).getDamage() / totalDmgBoss);
			bossAttackChances[i] = n;
		}
		
	}
	
	public void playerTurn(int action) {
		
		while(!selectionMade) {};
		
		
		
	}
	
	public void makeSelection(int action) {
		
		selectionMade = true;
		selection = action;
		
	}
	
	public void bossTurn() {
		
		double rand = Math.random();
		
		for(int i = 0; i < bossAttackChances.length; i++) {
			
			if(rand <= bossAttackChances[i]) {
				boss.attack(player, boss.getAttacks().get(i));
				break;
			}
			
		}
		
	}
	
	public void runBattleSequence(int action) {
		
		new Thread(() -> {
			playerTurn(action);
		}).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			bossTurn();
		}).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
