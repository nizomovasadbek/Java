package forma;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Forma extends JFrame{
    public static void main(String[] args) {
        JButton btn = new JButton("Salom Dunyo!");
        JFrame formaa = new JFrame("Sinov oynasi");
        formaa.setLayout(new FlowLayout());
        formaa.add(btn);
        formaa.setSize(500, 400);
        formaa.setLocation(300, 300);
        formaa.setVisible(true);
        formaa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}