package webc.brauzerc;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
        
public class FaylniOqish extends JFrame {
    private JTextField manzil;
    private JEditorPane korsat;

    public FaylniOqish(){
        super("Bizning web brauzerchamiz.");
        
        manzil = new JTextField("Manzilni kiriting..");
        manzil.setForeground(Color.BLUE);
        manzil.setToolTipText("Web manzilni kiriting..");
        manzil.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    yuklash(e.getActionCommand());
            }
        });
        add(manzil, BorderLayout.NORTH);
        korsat = new JEditorPane();
        korsat.setEditable(false);
        korsat.addHyperlinkListener(
         new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                yuklash(e.getURL().toString());
            }
        }
        );
        add(new JScrollPane(korsat), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(30, 125);
        setSize(800, 450);
        setVisible(true);
    }
    private void yuklash(String malumot){
        try {
            korsat.setPage(malumot);
            manzil.setText(malumot);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}