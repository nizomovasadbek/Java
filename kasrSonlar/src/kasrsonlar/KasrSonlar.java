package kasrsonlar;
import javax.swing.JFrame;
public class KasrSonlar {
    public static void main(String[] args) {
        Oyna oyna = new Oyna();
        oyna.setSize(250, 320);
        oyna.setLocation(250, 250);
        oyna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyna.setVisible(true);
    }
}