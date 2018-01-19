package mainMenuAndStartScreen;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDavid extends Button implements ButtonInterfaceDavid{

	private Color color;
	private Action action;
	
	public ButtonDavid(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}

	@Override
	public void dim() {
		this.setBackground(this.color);
		update();
	}

	@Override
	public void highlight() {
		this.setBackground(Color.WHITE);
		update();
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void setColor(Color c) {
		color = c;
		this.setBackground(c);
		update();
	}

}
