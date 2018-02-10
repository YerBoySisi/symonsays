package resultScreen;

import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class MainCharacterAnimated extends AnimatedComponent {

	public MainCharacterAnimated(int x, int y, int w, int h) {
		super(x, y, w, h);
		addSequence("resources/Ness.png", 450,0, 0, 47, 60, 8);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}
	public void update(Graphics2D g) {
		super.update(g);
	}
}
