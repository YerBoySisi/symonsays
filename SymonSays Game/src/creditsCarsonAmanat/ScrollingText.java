package creditsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;

import guiTeacher.components.MovingComponent;

public class ScrollingText extends MovingComponent{

	private int spanHeight;

	public ScrollingText(int spanHeight) {
		super(0, spanHeight, 1600, 780);
		this.spanHeight = spanHeight;
		setVy(1);
		Thread go = new Thread(this);
		go.start();
	}

	@Override
	public void drawImage(Graphics2D g) {
		g.setColor(Color.white);
		try {
			File fontFile = new File("resources/BankGothic Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(48f);
			g.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawString("Person 1 -- did this", 400, 200);
		g.drawString("Person 2 -- did this", 400, 160);
		g.drawString("Person 3 -- did this", 400, 120);
		g.drawString("Person 4 -- did this", 400, 80);
		try {
			File fontFile = new File("resources/BankGothic Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(48f);
			g.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawString("cool.jpg", 400, 20);
	}

	@Override
	public void checkBehaviors() {
		
	}
}

