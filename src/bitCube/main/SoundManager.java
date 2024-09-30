package bitCube.main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;

public class SoundManager {
	
	Clip clip;
	
	private URL killSoundURL;
	
	public SoundManager() {
		killSoundURL = getClass().getResource("res/sounds/sound1.wav");
		
	}
	
	public void playKillSound() {
		playSound(killSoundURL);
	}
	
    public void playSound(URL soundFilePath) {
        new Thread(() -> {
                try {
                	
                	if (soundFilePath==null) {
						System.out.println("it's null");
						return;
					}

                	AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFilePath);
                	Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                    clip.addLineListener((e) -> {
                        if (e.getType() == LineEvent.Type.STOP) {
                            clip.close();
                        }
                    });
                	
                } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();  // Start the sound playing in a new thread
    }


}
