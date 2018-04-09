package audioPlayer;

import java.io.*;
import javax.sound.sampled.*;
import javax.sound.sampled.Mixer.Info;

import settingsCarsonAmanat.SettingsScreen;
public class AudioTest {

	private static int songSize;
	public static Clip sound;
	public static double gain;
	public static void main(String[] args){
	}
	
	public static void playSound(String file) {
		try {
			
			   File song = new File(file);
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(song));
			   FloatControl gainControl = (FloatControl) clip
				        .getControl(FloatControl.Type.MASTER_GAIN);
				     gain = SettingsScreen.volume/100D; // number between 0 and 1 (loudest)
				    System.out.println(gain);
				    System.out.println(SettingsScreen.volume);

				    float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
				    gainControl.setValue(dB);
			   sound = clip;
			   
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
