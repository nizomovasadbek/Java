package javadastur5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class asosiyOyna extends JFrame {
    private JButton tanlash;
    private JPanel panel;
    private Color rang = Color.WHITE;
    
    public asosiyOyna(){
        super("Rang tanlash muloqot oynasi...");
        panel = new JPanel();
        panel.setBackground(rang);
        
        tanlash = new JButton("Fon rangini tanlash");
        tanlash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rang = JColorChooser.showDialog(null, "Rangni tanlang", rang);
                if(rang == null)
                    rang = Color.WHITE;
                panel.setBackground(rang);
            }
        });
        add(panel, BorderLayout.CENTER);
        add(tanlash, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(150, 150);
        setVisible(true);
    }
}