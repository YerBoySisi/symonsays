package creditsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;

import guiTeacher.components.MovingComponent;

public class ScrollingText extends MovingComponent{

	private int spanHeight;

	public ScrollingText(int spanHeight) {
		super(0, spanHeight, 1400, 780);
		this.setSpanHeight(spanHeight);
		setVy(2);
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
		g.drawString("Person 0 -- did this", 400, 550);
		g.drawString("Person 1 -- did this", 400, 500);
		g.drawString("Person 2 -- did this", 400, 450);
		g.drawString("Person 3 -- did this", 400, 400);
		g.drawString("Person 4 -- did this", 400, 350);
		g.drawString("Person 5 -- did this", 400, 300);
		g.drawString("Person 6 -- did this", 400, 250);
		g.drawString("Person 7 -- did this", 400, 200);
		g.drawString("Person 8 -- did this", 400, 150);
		g.drawString("Person 9 -- did this", 400, 100);
		try {
			File fontFile = new File("resources/BankGothic Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(64f);
			g.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawString("cool.jpg", 400, 50);
	}

	@Override
	public void checkBehaviors() {
		
	}

	public int getSpanHeight() {
		return spanHeight;
	}

	public void setSpanHeight(int spanHeight) {
		this.spanHeight = spanHeight;
	}
}

