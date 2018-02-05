package settingsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;

public class ButtonAmanat extends Button {
	private Action action;
	private Color color;
	public ButtonAmanat(int x, int y, int w, int h, String text, Action action) {

		super(x, y, w, h, "", null);
		update();
	}

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
		this.act();

	}
	public void drawImage(Graphics2D g) {
		Image Gear = Toolkit.getDefaultToolkit().getImage("resources/gear.png"); 
		
	}
}
