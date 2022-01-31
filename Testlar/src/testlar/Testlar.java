package testlar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Testlar extends Application {
    
    private final int JAVOB_CHEGARASI = 4;
    private TextField[] javoblar = new TextField[4];
    private RadioButton[] togriJavob = new RadioButton[4];
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox vb = new VBox();
        vb.setSpacing(5);
        
        TextField savol = new TextField();
        savol.setPromptText("Savolingizni kiriting");
        
        vb.getChildren().add(savol);
        
        for(int i = 0; i < JAVOB_CHEGARASI; i++){
            vb.getChildren().add(togriJavob[i]);
            vb.getChildren().add(javoblar[i]);
        }
        Scene scene = new Scene(vb, 500, 500);
        
        primaryStage.setTitle("Testlar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
