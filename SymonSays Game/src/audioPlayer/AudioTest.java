package audioPlayer;

import java.io.*;
import javax.sound.sampled.*;

//David Yashayev

import javax.sound.sampled.Mixer.Info;

import settingsCarsonAmanat.SettingsScreen;
public class AudioTest {

	//David Yashayev
	
	private static int songSize;
	public static Clip sound;
	public static double gain;
	public static FloatControl gainControl;
	public static Clip clip;
	public static File song;
	public static void main(String[] args){
	}

	public static void playSound(String file) {
		try {

			song = new File(file);
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(song));
			gainControl = (FloatControl) clip
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
	
	public static void changeVolume(double num) {
		FloatControl gainControl = (FloatControl) getClip().getControl(FloatControl.Type.MASTER_GAIN);
		 double gain = num; // number between 0 and 1 (loudest)
		    float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
		    gainControl.setValue(dB);
	}
	


	public static void stopSound(Clip clip) {
		clip.stop();
	}
}
