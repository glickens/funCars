package FunCarSim;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

class CarDescription {
    String model;
    String make;
    String color;
    int doors;
    boolean isEmpty;
}

class CarActions {

    private Clip clip;

    public void carHorn() {
        stopSound();
        playSound("car_horn.wav");
    }

    public void pressGas() {
        stopSound();
        playSound("press_gas.wav");
    }

    public void pressBrakes() {
        stopSound();
        playSound("press_brakes.wav");
    }

    public void fillGas() {
        stopSound();
        playSound("gas_fill.wav");
    }

    public void crankUp() {
        stopSound();
        playSound("car_crank_up.wav");
    }

    public void playSound(String filename) {
        stopSound(); // Stop any ongoing sound
        try {
            File soundFile = new File(filename);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
