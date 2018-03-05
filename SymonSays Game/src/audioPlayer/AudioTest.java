package audioPlayer;

import java.io.*;
import javax.sound.sampled.*;
public class AudioTest {

	private static int songSize;
	private static Clip sound;
	public static void main(String[] args) {
	}
	
	public static void playSound(String file) {
		try {
			   File song = new File(file);
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(song));
			   sound = clip;
			   AudioPlayer.setMasterOutputVolume(0.5f);

			   clip.start();
			  songSize = (int) (clip.getMicrosecondLength()/1000);
		  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
	}
	
	public static Clip getClip() {
		return sound;
	}
	
	
	public static void stopSound(Clip clip) {
		clip.stop();
	}
}
