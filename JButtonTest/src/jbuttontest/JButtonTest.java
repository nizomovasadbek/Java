package jbuttontest;
import javax.swing.JFrame;
public class JButtonTest {
    public static void main(String[] args) {
        Forma oyna = new Forma();
        oyna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyna.setSize(400, 500);
        oyna.setLocation(500, 200);
        oyna.setVisible(true);
    }   
}