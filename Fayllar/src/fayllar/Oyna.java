package fayllar;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Oyna extends JFrame {
    private JList list;
    private File fayl;
    private String s = File.separator;
    private String path = "D:" + s;
    private int sanoq=0;
    private String yol = "";
    private JLabel rasm = new JLabel();
    
    public Oyna(){
        super("Fayllar");
        setLayout(new FlowLayout());
        fayl = new File(path);
        list = new JList(fayl.list());
        list.setVisibleRowCount(5);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                sanoq = list.getSelectedIndex();
        String royxat[] = new String[sanoq+1];
        royxat = fayl.list();
        path += royxat[sanoq];
                Pattern tartib = Pattern.compile("\\.jpg" + Pattern.UNICODE_CASE);
                Matcher mostlik = tartib.matcher(path);
                if(mostlik.find()){
                    Icon ikonka = new ImageIcon(path);
                    rasm.setIcon(ikonka);
                } else
                try{
        fayl = new File(path+s);
        list.setListData(royxat);
                }catch(Exception ef){
                    ef.printStackTrace();
                }
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(300, 200);
        setVisible(true);
    }
}