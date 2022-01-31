package javadastur5;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class Oyna extends JFrame {
    private JSlider slayder;
    private GrafikaDoiraChizish panel;
    
    public Oyna(){
        super("Doira chizish");
        
        panel = new GrafikaDoiraChizish();
        panel.setBackground(Color.BLUE);
        
        slayder = new JSlider(SwingConstants.HORIZONTAL, 20, 200, 20);
        slayder.setMajorTickSpacing(10);
        slayder.setPaintTicks(true);
        
        slayder.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                panel.radiusniOrnatish(slayder.getValue());
            }
        });
        add(panel, BorderLayout.CENTER);
        add(slayder, BorderLayout.SOUTH);
    }
}