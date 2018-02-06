package settingsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;

public class ButtonAmanat extends Button {
	private Action action;
	private Color color;
	private Graphics2D g;
	public static Image Gear;
    Graphics2D g2 = (Graphics2D) g;

	public ButtonAmanat(int x, int y, int w, int h, ImageIcon gearIcon) {

		super(x, y, w, h, "", null);
		update();
	}
	public void drawButton(Graphics2D g, boolean hovered) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(color != null) {
		Color c = hovered? Utilities.lighten(color, .6f): color;
		g.setColor(c);
		}
	}
}