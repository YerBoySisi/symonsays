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
	
	private boolean running = false;
	
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
		
		running = true;
		
	}
	
	public void playerTurn(int action, Attack a) {
		
		while(!selectionMade) {};
		
		switch(selection) {
		case ATTACK:
			player.attack(boss, a);
			player.changeMP(a.getCost());
		case ITEM:
			if(player.getHP() < player.getMaxHP()) {
				player.changeHP(10);
			}
		case RUN:
			running = false;
		}
		
		selectionMade = false;
		
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
	
	public void runBattleSequence(int action, Attack a) {
		
		while(running) {
			
			new Thread(() -> {
				playerTurn(action, a);
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
	
}
