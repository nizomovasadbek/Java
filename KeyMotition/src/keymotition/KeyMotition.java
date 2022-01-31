package keymotition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyEvent;

import javax.swing.JOptionPane;

public class KeyMotition extends Application {
    
    @Override
    public void start(Stage primaryStage){
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 500, 450);
        
        scene.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode().equals(e.getCode().ESCAPE))
                primaryStage.close();
            //if(e.getCode().equals(e.getCode().ENTER))
                JOptionPane.showMessageDialog(null, "Nima gaplar");
        });
        
        primaryStage.setTitle("Klaviatura bilan ishlash");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}