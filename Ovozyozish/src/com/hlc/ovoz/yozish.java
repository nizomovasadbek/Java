package com.hlc.ovoz;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
public class yozish {
    public static void main(String[] args) throws LineUnavailableException, 
            InterruptedException {
        AudioFormat format = new AudioFormat(16000, 8, 2, true, true);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        if(!AudioSystem.isLineSupported(info)){
            System.out.println("Ovoz chastotasi qo\'llab quvvatlamaydi.");
        }
        TargetDataLine target = (TargetDataLine) AudioSystem.getLine(info);
        target.open();
        System.out.println("Ovoz yozish boshlandi.");
        target.start();
        
        Thread stopper = new Thread(new Runnable() {
            @Override
            public void run() {
                AudioInputStream audio_stream = new AudioInputStream(target);
                File wavFile = new File("D:\\recordaudio.wav");
                System.out.println("Yozildi");
                try {
                    AudioSystem.write(audio_stream, AudioFileFormat.Type.WAVE, wavFile);
                } catch (IOException ex) {
                    Logger.getLogger(yozish.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        stopper.start();
        Thread.sleep(5200);
        target.stop();
        target.close();
        System.out.println("Ovoz yozish tugadi");
    }
}