package creditsCarsonAmanat;

import java.awt.Color;
import java.awt.Graphics2D;
import guiTeacher.components.MovingComponent;

public class ScrollingText extends MovingComponent{

	private int spanHeight;

	public ScrollingText(int spanHeight) {
		super(0, spanHeight, 260, 60);
		this.spanHeight = spanHeight;
		setVy(1);
		Thread go = new Thread(this);
		go.start();
	}

	@Override
	public void drawImage(Graphics2D g) {
		g.setColor(Color.black);
		g.drawString("Person 1", 200, 200);
		g.drawString("Person 2", getWidth()/2, 50);
		g.drawString("Person 3", getWidth()/2, 50);
		g.drawString("Person 4", getWidth()/2, 50);
	}

	@Override
	public void checkBehaviors() {
		
	}
}

