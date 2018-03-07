package resultScreen;

import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class slotMachine extends AnimatedComponent {
	public Thread animation;
	public slotMachine(int x, int y, int w, int h) {
		super(x, y, w, h);
		addSequence("resources/Slots.png", 450,79, 81, 280, 212, 3);
		animation = new Thread(this);
		animation.start();
		update();
	}
	public void update(Graphics2D g) {
		super.update(g);
	}
	public void setAni() {
		animation.interrupt();
	}
}
