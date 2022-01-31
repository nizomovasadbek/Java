package jlisttester;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
public class AsosiyOyna extends JFrame{
    private JList royxat;
    
    private static String[] rangNomlari = {"Qora", "Ko'k", "Qizil", "Oq", "Yashil", "Pushti", "Sariq"};
    private static Color ranglar[] = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE, Color.GREEN, Color.PINK, Color.YELLOW};
    
    public AsosiyOyna(){
        super("'JList'");
        setLayout(new FlowLayout());
        
        royxat = new JList(rangNomlari);
        royxat.setVisibleRowCount(5);
        royxat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(royxat));
        royxat.addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(ranglar[royxat.getSelectedIndex()]);
            }
        }
);
    }
}