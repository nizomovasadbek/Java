package sichqoncha;
import javax.swing.JFrame;
public class Sichqoncha {
    public static void main(String[] args) {
        AsosiyOyna oyna = new AsosiyOyna();
        oyna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyna.setSize(400, 400);
        oyna.setLocation(250, 100);
        oyna.setVisible(true);
    }   
}