package mediaplayer;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
public class BirinchiOyna extends JFrame {
    private JButton btn, btn1;
    private IkkinchiOyna oy;
    public BirinchiOyna(){
        super("1-oyna");
        setLayout(new FlowLayout());
        btn = new JButton("2-oyna");
        btn1 = new JButton("Chiqish");
        add(btn);
        add(btn1);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                IkkinchiOyna oynacha = new IkkinchiOyna();
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocation(300, 100);
        setVisible(true);
    }
}
