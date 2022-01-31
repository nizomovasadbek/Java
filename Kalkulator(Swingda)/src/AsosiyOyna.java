import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AsosiyOyna extends JFrame {
    private JList chapRoyxat;
    private JList ongRoyxat;
    private JButton otkazish;
    private static String[] royxat = {"1-qism", "2-qism", "3-qism", "4-qism", "5-qism", "6-qism", "7-qism", "8-qism",
     "9-qism"};
    
    public AsosiyOyna(){
        super("'Jlist' bilan ishlash");
        setLayout(new FlowLayout());
        
        chapRoyxat = new JList(royxat);
        chapRoyxat.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        chapRoyxat.setVisibleRowCount(5);
        add(new JScrollPane(chapRoyxat));
        
        otkazish = new JButton("O'tkaz --->");
        otkazish.addActionListener((ActionEvent e) -> {
            ongRoyxat.setListData(chapRoyxat.getSelectedValues());
        });
    }
}