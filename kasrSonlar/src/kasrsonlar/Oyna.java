package kasrsonlar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Oyna extends JFrame {

    private JComboBox comboBox;
    private JLabel rasm;
    private static String faylNomi[] = {"true.png", "help.png"};
    private Icon ikonka[] = {new ImageIcon(getClass().getResource(faylNomi[0])), new ImageIcon(getClass().getResource(faylNomi[1]))};

  
    public Oyna() {
        super("'JComboBox'");
        setLayout(new FlowLayout());

        comboBox = new JComboBox(faylNomi);
        comboBox.addItemListener(
                new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    rasm.setVisible(true);
                    rasm.setIcon(ikonka[comboBox.getSelectedIndex()]);
                }
            }
        }
        );
        add(comboBox);
        rasm = new JLabel();
        rasm.setVisible(false);
        add(rasm);
    }
}