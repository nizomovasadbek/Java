package javadastur1;
import java.awt.*;
import javax.swing.*;
public class JavaDastur1 {
    public static void main(String[] args) {
        Oyna oynamiz = new Oyna();
        oynamiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oynamiz.setSize(250,300);
        oynamiz.setLocation(150, 150);
        oynamiz.setResizable(false);
        oynamiz.setVisible(true);
    }
    
}
