package audioPlayer;

import java.io.*;
import javax.sound.sampled.*;
public class AudioTest {

	public static void main(String[] args) {
		playSound();
	}
	
	public static void playSound() {
		try {
			   File song = new File("resources/MainMenuMusic.wav");
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(song));
			   clip.start();
			   Thread.sleep(clip.getMicrosecondLength());
		  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
	}
}
