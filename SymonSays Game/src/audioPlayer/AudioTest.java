package audioPlayer;

import java.io.*;
import javax.sound.sampled.*;
public class AudioTest {

	private static int songSize;
	public static void main(String[] args) {
	}
	
	public static void playSound(String file) {
		try {
			   File song = new File(file);
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(song));
			   clip.start();
			  songSize = (int) (clip.getMicrosecondLength()/1000);
		  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
	}
	public static void stopSound() {
		try {
			Thread.sleep(songSize);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
