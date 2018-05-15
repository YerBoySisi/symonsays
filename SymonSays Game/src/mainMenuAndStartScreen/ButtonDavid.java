package mainMenuAndStartScreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;

//David Yashayev

public class ButtonDavid extends Button{

	public Color color;
	private Action action;
	private static final int _THICKNESS = 5;
	
	public ButtonDavid(int x, int y, int w,Color color,  String text, Action action) {
		super(x, y, w, 50, text, action);
		this.color = color;
		update();
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	public void setColor(Color c) {
		color = c;
		this.setBackground(c);
		update();
	} 
	
	public void drawButton(Graphics2D g, boolean hovered) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(color != null) {
		Color c = hovered? Utilities.lighten(color, .6f): color;
		g.setColor(c);
		g.setStroke(new BasicStroke(_THICKNESS));
		g.drawLine(0,_THICKNESS, getWidth(), _THICKNESS);
		}
		FontMetrics fm = g.getFontMetrics();
		int textWidth = fm.stringWidth(getText());
		g.drawString(getText(), (getWidth()-textWidth)/2, _THICKNESS+fm.getHeight());
	}
}