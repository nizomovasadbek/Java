package musiqaplayer;

import sun.audio.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MusiqaPlayer {
    public static transient int salom = 7;
    public static void main(String[] args) {
        AsosiyOyna ao = new AsosiyOyna();
        ao.setTitle("Musiqa");
        ao.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ao.setVisible(true);
        salom = 10;
    }
    
    public static void music(){
        AudioPlayer MGB;
        AudioStream BGM;
        AudioData MD;
        
    }
    
}