package jlisttester01mutipleselection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AsosiyOyna extends JFrame {
    private JList chapRoyxat;
    private JList ongRoyxat;
    private JButton otkazishTugmasi;
    private static String[] royxat = {"1-qism", "2-qism", "3-qism", "4-qism", "5-qism", "6-qism", "7-qism", "8-qism", "9-qism"};

    public AsosiyOyna(){
        super("JList bilan ishlash");
        setLayout(new FlowLayout());
        
        chapRoyxat = new JList(royxat);
        chapRoyxat.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        chapRoyxat.setVisibleRowCount(5);
        add(new JScrollPane(chapRoyxat));
        
        otkazishTugmasi = new JButton("O'tkaz -->");
        otkazishTugmasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ongRoyxat.setListData(chapRoyxat.getSelectedValues());
            }
        });
        add(otkazishTugmasi);
        ongRoyxat = new JList();
        ongRoyxat.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ongRoyxat.setVisibleRowCount(5);
        ongRoyxat.setFixedCellHeight(20);
        ongRoyxat.setFixedCellWidth(55);
        add(new JScrollPane(ongRoyxat));
        
    }    
}