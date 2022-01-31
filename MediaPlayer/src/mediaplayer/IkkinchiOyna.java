package mediaplayer;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class IkkinchiOyna extends JFrame {
    private JButton btn, btn1;
    public IkkinchiOyna(){
        super("2-oyna");
        setLayout(new FlowLayout());
        btn = new JButton("1-Oyna");
        btn1 = new JButton("Chiqish");
        add(btn);
        add(btn1);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BirinchiOyna oynacha = new BirinchiOyna();
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocation(300, 100);
        setVisible(true);
    }
}