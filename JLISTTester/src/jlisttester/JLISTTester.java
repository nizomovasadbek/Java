package jlisttester;
import javax.swing.JFrame;
public class JLISTTester {
    public static void main(String[] args) {
        AsosiyOyna oyna = new AsosiyOyna();
        oyna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyna.setSize(220, 200);
        oyna.setLocation(300, 300);
        oyna.setVisible(true);
    }   
}