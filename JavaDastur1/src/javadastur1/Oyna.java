/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadastur1;

/**
 *
 * @author User
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class Oyna extends JFrame{
    private JSlider slayder;
    private DoiraChizish panel;
    
    public Oyna(){
        super.setTitle("Doira chizish");
        
        panel = new DoiraChizish();
        panel.setBackground(Color.BLUE);
        
        slayder = new JSlider(SwingConstants.HORIZONTAL, 10, 200, 10);
        slayder.setMajorTickSpacing(10);
        slayder.setPaintTicks(true);
        slayder.addChangeListener(
          new ChangeListener() {
              @Override
            public void stateChanged(ChangeEvent e) {
                panel.radiusOrnatish(slayder.getValue());
            }
        }
        );
        add(slayder, BorderLayout.CENTER);
        add(slayder, BorderLayout.SOUTH);
    }
}
