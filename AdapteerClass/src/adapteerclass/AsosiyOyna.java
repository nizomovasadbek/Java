package adapteerclass;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AsosiyOyna extends JFrame{ 
    private String hisobot;
    private JLabel holat;
    
    public AsosiyOyna(){
        super("Adapter Class bilan ishlash");
        
        holat = new JLabel("O'zgarmagan");
        add(holat, BorderLayout.SOUTH);
        addMouseListener(new tutuvchiClass());
    }
    private class tutuvchiClass extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e){
            hisobot = String.format("Sichqoncha %d marta chertildi", e.getClickCount());
            if(e.isMetaDown())
                hisobot += "(o'ng tugmasi)";
            else if(e.isAltDown())
                hisobot += "(o'rta tugmasi)";
            else
                hisobot += "(chap tugmasi)";
            holat.setText(hisobot);
        }
    }
}