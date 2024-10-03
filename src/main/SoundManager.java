package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

public class SoundManager {

    float musicVolume = 0.025f; 
    float soundVolume = 0.5f; 
    Clip sound;
    Clip music;
    
    FloatControl soundVolumeControl;
    FloatControl musicVolumeControl;
    SettingPanel st;

    private URL killSoundURL;
    private URL BGmusicURL;

    public SoundManager(SettingPanel settings) {
        st = settings;
        killSoundURL = getClass().getResource("res/sounds/sound1.wav");
        BGmusicURL = getClass().getResource("res/sounds/BGMusic.wav");
    }

    public void playKillSound() {
        playSound(killSoundURL);
    }

    public void playBGMusic() {
        playMusic(BGmusicURL);
    }

    public void playSound(URL soundFilePath) {
        new Thread(() -> {
            try {
                if (soundFilePath == null) {
                    System.out.println("Sound file path is null.");
                    return;
                }
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFilePath);
                sound = AudioSystem.getClip();
                sound.open(audioIn);

                soundVolumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
                setSoundVolume(st.soundSlider.getValue()); 

                sound.start();
                sound.addLineListener(e -> {
                    if (e.getType() == LineEvent.Type.STOP) {
                        sound.close();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void setSoundVolume(float value) {
    
        float dbVolume = (float) (20 * Math.log10(value/100));
        if (soundVolumeControl != null) {
            soundVolumeControl.setValue(dbVolume);
        }
    }

    public void playMusic(URL musicFilePath) {
        new Thread(() -> {
            try {
                if (musicFilePath == null) {
                    System.out.println("Music file path is null.");
                    return;
                }
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFilePath);
                music = AudioSystem.getClip();
                music.open(audioIn);

                // Set volume for the background music
                musicVolumeControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
                System.out.println(st.musicSlider.getValue());
                setMusicVolume(st.musicSlider.getValue());

                music.loop(Clip.LOOP_CONTINUOUSLY);
                music.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void setMusicVolume(float value) {
        float dbVolume = (float) (20 * Math.log10(value/100)); 
		if (musicVolumeControl != null) {
            musicVolumeControl.setValue(dbVolume);
        }
    }
}

