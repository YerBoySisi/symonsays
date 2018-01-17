package creditsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;

import guiTeacher.components.MovingComponent;

public class ScrollingText extends MovingComponent{

	private int spanHeight;

	public ScrollingText(int spanHeight) {
		super(0, spanHeight, 800, 800);
		this.spanHeight = spanHeight;
		setVy(1);
		Thread go = new Thread(this);
		go.start();
	}

	@Override
	public void drawImage(Graphics2D g) {
		g.setColor(Color.black);
		try {
			File fontFile = new File("resources/BankGothic Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(24f);
			g.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawString("Person 1 -- did this", 250, 140);
		g.drawString("Person 2 -- did this", 250, 100);
		g.drawString("Person 3 -- did this", 250, 60);
		g.drawString("Person 4 -- did this", 250, 20);
	}

	@Override
	public void checkBehaviors() {
		
	}
}

