package ikki.sonning.yig.indisi;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class asosiyOyna extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.BLUE);
        g.fillRect(25, 25, 100, 30);
        
        g.setColor(new Color(30, 30, 40));
        g.fillRect(25, 65, 100, 30);
        
        g.setColor(Color.RED);
        g.drawString("Java", 25, 110);
    }
}