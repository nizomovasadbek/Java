/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadastur1;

/**
 *
 * @author User
 */
import java.awt.*;
import javax.swing.*;
public class DoiraChizish extends JPanel{
 private int radius = 10;
 @Override
 public void paint(Graphics g){
     super.paint(g);
     g.setColor(Color.YELLOW);
     g.fillOval(40, 40, radius, radius);
 }
 public void radiusOrnatish(int r){
     radius = r;
     repaint();
 }
}
