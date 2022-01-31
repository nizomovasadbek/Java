package javadastur5;
import java.awt.*;
import javax.swing.JPanel;
public class Grafika extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        for(int i = 10; i <= 100; i += 10){
            g.drawLine(i, 10, i, 100);
            g.drawLine(10, i, 100, i);
        }
        g.setColor(Color.red);
        g.drawRect(10, 120, 100, 30);
        
        g.setColor(Color.BLUE);
        g.fillOval(120, 10, 100, 80);
        
        g.setColor(Color.GREEN);
        g.fill3DRect(130, 130, 100, 30, true);
    }
}