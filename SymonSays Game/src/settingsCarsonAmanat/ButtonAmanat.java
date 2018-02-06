package settingsCarsonAmanat;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonAmanat extends Button implements ButtonInterfaceAmanat{
	private Action action;
	private Color color;
	public ButtonAmanat(int x, int y, int w, int h, String text, Object object) {

		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color c) {
		color = c;
		this.setBackground(c);
		update();
	} 

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	public void dim() {
		this.setBackground(this.color);
		update();
	}
	public void highlight() {
		this.setBackground(Color.WHITE);
		update();
	}
	public void act() {
		this.action.act();

	}
}
