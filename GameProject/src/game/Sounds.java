package game;

import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The Sounds class is used to initialise sound files used in other classes
 * through getters
 * @author M0MAC
 */

public class Sounds {
    private final SoundClip doorSound;
    private final SoundClip backgroundSound;
    private final SoundClip collectSound;
    private final SoundClip completeSound;
    
    //constructor used to initialise sounds and throw exceptions
    public Sounds() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        doorSound = new SoundClip("data/sounds/doorOpen.wav");
        backgroundSound = new SoundClip("data/sounds/backgroundSound.wav");
        collectSound = new SoundClip("data/sounds/collect.wav");
        completeSound = new SoundClip("data/sounds/complete.wav");
    }
    
    //getters used to retrieve above sounds from other classes
    public SoundClip getDoorSound(){
        return doorSound;
    }
    public SoundClip getBackgroundSound(){
        return backgroundSound;
    }
     public SoundClip getCollectSound(){
        return collectSound;
    }
     public SoundClip getCompleteSound(){
        return completeSound;
    }

}
