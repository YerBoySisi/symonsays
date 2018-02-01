package bossSelect;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class BossButton extends Button {

	public BossButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}

	public BossButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}

	public static void main(String[] args) {

	}

}
