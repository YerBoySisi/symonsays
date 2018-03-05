package audioPlayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.CompoundControl;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;
import javax.sound.sampled.UnsupportedAudioFileException;

import startGame.GameStarter;

public class AudioPlayer {

	private static int value;
	private boolean pause;
	private boolean cancel;

	public AudioPlayer() {
		pause = false;
		cancel = false;
	}

	Long audioPosition;
	private Clip audioLine;

	public void play(String audioFilePath) {
		File audioFile = new File(audioFilePath);
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

			audioLine = AudioSystem.getClip();
			audioLine.open(audioStream);

			audioLine.start();

			while(!cancel) {
				sleep(0);
				if(pause) {
					long clipTime = audioLine.getMicrosecondPosition();
					audioLine.stop();
					while(pause) {
						sleep(0);
					}
					audioLine.setMicrosecondPosition(clipTime);
					if(!cancel) {
						audioLine.start();
					}
				}
			}

			audioLine.flush();
			audioLine.close();
			audioStream.close();

		} catch (UnsupportedAudioFileException ex) {
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		}      
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String audioFilePath = "resources/MainMenuMusic.wav";
		AudioPlayer player = new AudioPlayer();
		player.play(audioFilePath);
	}

	public static void setMasterOutputVolume(float f) {
		if (value < 0 || value > 1)
			throw new IllegalArgumentException(
					"Volume can only be set to a value from 0 to 1. Given value is illegal: " + value);
		Line line = getMasterOutputLine();
		if (line == null) throw new RuntimeException("Master output port not found");
		boolean opened = open(line);
		try {
			FloatControl control = getVolumeControl(line);
			if (control == null)
				throw new RuntimeException("Volume control not found in master port: " + toString(line));
			control.setValue(value);
		} finally {
			if (opened) line.close();
		}		
	}

	public static String toString(Line line) {
		if (line == null) return null;
		Line.Info info = line.getLineInfo();
		return info.toString();// + " (" + line.getClass().getSimpleName() + ")";
	}

	private static Line getMasterOutputLine() {
		for (Mixer mixer : getMixers()) {
			for (Line line : getAvailableOutputLines(mixer)) {
				if (line.getLineInfo().toString().contains("Master")) return line;
			}
		}
		return null;
	}

	public static List<Line> getAvailableOutputLines(Mixer mixer) {
		return getAvailableLines(mixer, mixer.getTargetLineInfo());
	}


	private static List<Line> getAvailableLines(Mixer mixer, Line.Info[] lineInfos) {
		List<Line> lines = new ArrayList<Line>(lineInfos.length);
		for (Line.Info lineInfo : lineInfos) {
			Line line;
			line = getLineIfAvailable(mixer, lineInfo);
			if (line != null) lines.add(line);
		}
		return lines;
	}

	public static Line getLineIfAvailable(Mixer mixer, Line.Info lineInfo) {
		try {
			return mixer.getLine(lineInfo);
		} catch (LineUnavailableException ex) {
			return null;
		}
	}

	public static List<Mixer> getMixers() {
		Info[] infos = AudioSystem.getMixerInfo();
		List<Mixer> mixers = new ArrayList<Mixer>(infos.length);
		for (Info info : infos) {
			Mixer mixer = AudioSystem.getMixer(info);
			mixers.add(mixer);
		}
		return mixers;
	}


	public static FloatControl getVolumeControl(Line line) {
		if (!line.isOpen()) throw new RuntimeException("Line is closed: " + toString(line));
		return (FloatControl) findControl(FloatControl.Type.VOLUME, line.getControls());
	}
	
	private static Control findControl(Type type, Control... controls) {
		if (controls == null || controls.length == 0) return null;
		for (Control control : controls) {
			if (control.getType().equals(type)) return control;
			if (control instanceof CompoundControl) {
				CompoundControl compoundControl = (CompoundControl) control;
				Control member = findControl(type, compoundControl.getMemberControls());
				if (member != null) return member;
			}
		}
		return null;
	}
	
	public static boolean open(Line line) {
		if (line.isOpen()) return false;
		try {
			line.open();
		} catch (LineUnavailableException ex) {
			return false;
		}
		return true;
	}
}
