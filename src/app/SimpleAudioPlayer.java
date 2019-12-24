package app;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {
	// to store current position
	Long currentFrame;
	Clip clip;

	// current status of clip

	AudioInputStream audioInputStream;

	// constructor to initialize streams and clip
	public SimpleAudioPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// create AudioInputStream object
		audioInputStream = AudioSystem.getAudioInputStream(new File("bell.WAV"));

		// create clip reference
		clip = AudioSystem.getClip();

		// open audioInputStream to the clip
		clip.open(audioInputStream);

	}

	public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		currentFrame = 0L;
		clip.stop();
		clip.close();
	}

	public void play() {
		// start the clip

		clip.start();

	}

	// Method to reset audio stream
	public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioInputStream = AudioSystem.getAudioInputStream(new File("bell.WAV"));
		
		

       
        clip.open(audioInputStream); 
        
		
		

	}

	public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		clip.stop();
		clip.close();
		resetAudioStream();
		currentFrame = 0L;
		clip.setMicrosecondPosition(0);
		this.play();
	}

}
