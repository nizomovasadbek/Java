/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kichikdasturcha;

import com.jfoenix.controls.JFXRippler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane basic;
    
    @FXML
    private Pane myPanel;
    
    @FXML
    private Label myLabel;
    
    @FXML
    private void kirish(ActionEvent e){
        System.out.println("Bu metod");
    }
    
    @FXML
    private void handleButtonAction1(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Salomlar");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXRippler rippler = new JFXRippler(myPanel);
        JFXRippler rippler2 = new JFXRippler(myLabel);
        rippler.setRipplerFill(Paint.valueOf("#ff0000"));
        rippler.setRipplerRadius(60);
        rippler.setMaskType(JFXRippler.RipplerMask.CIRCLE);
        basic.getChildren().add(rippler);
        basic.getChildren().add(rippler2);
    }    
    
}
