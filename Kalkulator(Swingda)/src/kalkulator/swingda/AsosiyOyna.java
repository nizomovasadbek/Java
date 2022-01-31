package kalkulator.swingda;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextField;
public class AsosiyOyna extends JFrame{
    
    private JButton num1 = new JButton("1");
    private JTextField ekran = new JTextField("0", 25);
    
    public AsosiyOyna(){
        super("Kalkulator'swing'da");
        setLayout(new FlowLayout());
        add(ekran);
        add(num1);
    }
}