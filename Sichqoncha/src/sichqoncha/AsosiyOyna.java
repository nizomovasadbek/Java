package sichqoncha;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AsosiyOyna extends JFrame {
    private JPanel panel;
    private JLabel holat;
    
    public AsosiyOyna(){
        super("Sichqoncha bilan ishlash");
        
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        add(panel, BorderLayout.CENTER);
        
        holat = new JLabel("O'zgarmagan");
        add(holat, BorderLayout.SOUTH);
        
        tutuvchiClass tutuvchi = new tutuvchiClass();
        panel.addMouseListener(tutuvchi);
        panel.addMouseMotionListener(tutuvchi);
        
    }
    private class tutuvchiClass implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            holat.setText("Sichqoncha chertildi.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            holat.setText("Sichqoncha tugmasi bosildi.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            holat.setText("Sichqoncha tugmasi qo'yib yuborildi.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            holat.setText("Sichqoncha panel yuzasiga keldi.");
            panel.setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            holat.setText("Sichqoncha panel yuzasidan chiqib ketdi.");
            panel.setBackground(Color.GRAY);
        }  

        @Override
        public void mouseDragged(MouseEvent e) {
            holat.setText(String.format("Sichqoncha (%d,%d) koordinatada turibdi(Sudralayabdi)", e.getX(), e.getY()));
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            holat.setText(String.format("Sichqoncha (%d,%d) koordinatada turibdi(surilayabdi)", e.getX(), e.getY()));
        }
    }
}