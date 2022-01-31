package javadastur5;
import java.awt.*;
import javax.swing.*;
public class GrafikaDoiraChizish extends JPanel {
    private int radius = 10;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, radius, radius);
    }
     
    public void radiusniOrnatish(int r){
        radius = r;
        repaint();
    }
}