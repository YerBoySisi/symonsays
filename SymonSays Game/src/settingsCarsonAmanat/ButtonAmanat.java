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
	private Graphics2D g;
	public static Image Gear;
    Graphics2D g2 = (Graphics2D) g;

	public ButtonAmanat(int x, int y, int w, int h, Image image, Action action) {

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
		Settings.symon.setScreen(Settings.screen);
		

	}
	public void drawImage(Graphics2D g) {
		Gear = Toolkit.getDefaultToolkit().getImage("resources/gear.png"); 
		g2.drawImage(Gear, 10, 10, null );

	}
}
