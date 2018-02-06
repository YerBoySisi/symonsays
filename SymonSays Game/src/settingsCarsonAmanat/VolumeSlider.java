package settingsCarsonAmanat;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Dragable;

public class VolumeSlider extends Button{


	private ButtonAmanat button;

	public VolumeSlider(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public  BufferedImage getImage() {
		Image buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File("resources/gear.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		button = new ButtonAmanat(10,10 ,10 ,10 , buttonIcon);
		return null;
	}

	@Override
	public int getX() {
		
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		x = 700;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean b) {
		b =true;
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(float f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unhoverAction() {
		
		
	}

	@Override
	public void hoverAction() {
		// TODO Auto-generated method stub
		
	}

}
