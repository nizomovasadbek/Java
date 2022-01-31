package spearatoryasash;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SpearatorYasash extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("'Separator'lar");
        
        Label obhavo = new Label("Ob-have ma'lumotlari");
        Label payshanba = new Label("Payshanba");
        
        
        primaryStage.show();
    }
}
