package mainMenuAndStartScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;

public class ButtonDavid extends Button implements ButtonInterfaceDavid{

	private Color color;
	private Action action;
	private int xCord;
	private int yCord;
	private int width;
	private int height;
	private String text;
	
	public ButtonDavid(int x, int y, int w, int h,  String text, Action action) {
		super(x, y, w, h, text, action);
		this.xCord = x;
		this.yCord = y;
		this.width = w;
		this.height = h;
		this.text = text;
	}

	@Override
	public void dim() {
		this.setBackground(Color.GRAY);
		update();
	}

	@Override
	public void highlight() {
		this.setBackground(color.GRAY);
		update();
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void setColor(Color c) {
		this.setBackground(c);
		update();
	}

	
	
	public void drawImage(Graphics2D g) {
		try {
			File fontFile = new File("resources/bankgothic_medium_bt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.setColor(color);
	//	g.drawLine(xCord, yCord+height, xCord, yCord+5);;
		g.drawString(text, xCord, yCord);;
	}
}
