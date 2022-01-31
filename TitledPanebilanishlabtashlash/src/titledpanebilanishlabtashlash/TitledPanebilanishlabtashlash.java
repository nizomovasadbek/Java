package titledpanebilanishlabtashlash;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TitledPanebilanishlabtashlash extends Application {
    
    @Override
    public void start(Stage primaryStage){
        GridPane setka = new GridPane();
        setka.setVgap(4);
        setka.setHgap(4);
        setka.setAlignment(Pos.CENTER);
        setka.setPadding(new Insets(5));
        setka.add(new Label("Ismi: "), 0, 0);
        setka.add(new TextField(), 1, 0);
        setka.add(new Label("Sharifi: "), 0, 1);
        setka.add(new TextField(), 1, 1);
        setka.add(new Label("E-Pochtasi: "), 0, 2);
        setka.add(new TextField(), 1, 2);
        
        TitledPane tp = new TitledPane("Bizning TitledPane", setka);
        tp.setExpanded(false);
        
        primaryStage.setScene(new Scene(tp));
        primaryStage.setTitle("TitledPane ga na\'muna");
        primaryStage.show();
    }
}