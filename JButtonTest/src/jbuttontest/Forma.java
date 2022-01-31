package jbuttontest;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Forma extends JFrame{
    private JButton btn = new JButton("Chiqarish");
    
    public Forma(){
        super("'JButton'");
        setLayout(new FlowLayout());
        
        add(btn);
        
        btn.addActionListener((ActionEvent e) -> {
            System.out.println("Knopka bosildi.");
        });
    }
}