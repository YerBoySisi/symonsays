package creditsCarsonAmanat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;

import guiTeacher.components.MovingComponent;

public class ScrollingText extends MovingComponent{

	private int spanHeight;
	public int x = 275;
	public ArrayList<String> list = new ArrayList<String>();
	String[] listArr = {"Fahadullah Asif -- Boss Select", "David Yashayev -- Startup Screen + Main Menu", "Sisiame B. Sakasamo -- Mechanics", "Siddeeq Rasheed -- HUD & Battle Screen Layout", "Nabeel Amin -- Results Screen", "Ricky Pong -- Buy Menu", "David Li -- Sell Menu", "Garrett Chen -- Upgrade Menu", "Amanat Hossain -- Settings", "Carson Custodio -- Credits"};

	public ScrollingText(int spanHeight) {
		super(0, spanHeight, 1400, 780);
		this.setSpanHeight(getHeight());
		setVy(2);
		Thread go = new Thread(this);
		go.start();
	}

	@Override
	public void drawImage(Graphics2D g) {
		g.setColor(Color.WHITE);
		try {
			File fontFile = new File("resources/BankGothic Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(32f);
			g.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setList();
		for(int i = 0; i < listArr.length; i++) {
			g.drawString(listArr[i], x, 700 - i * 50);
		}
		try {
			File fontFile = new File("resources/BankGothic Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(64f);
			g.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawString("Symon Says", x + 200, 50);
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
	
	public void setList() {
		for(int i = 0; i < list.size(); i++) {
			list.set(i , listArr[i].toString());
		}
	}
}
