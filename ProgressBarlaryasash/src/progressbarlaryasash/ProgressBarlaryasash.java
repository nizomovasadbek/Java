package progressbarlaryasash;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProgressBarlaryasash extends Application {
    
    private float qiymatlar[] = { -1f, 0f, 0.7f, 1f };
    private Label labellar[] = new Label[qiymatlar.length];
    private ProgressBar[] pblar = new ProgressBar[qiymatlar.length];
    private ProgressIndicator[] pilar = new ProgressIndicator[qiymatlar.length];
    private GridPane setka = new GridPane();
    private Scene epizod = null;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("'ProgressBar\' jarayonlari...");
        
        //init
        setka.setPadding(new Insets(5, 5, 5, 5));
        setka.setAlignment(Pos.CENTER);
        setka.setHgap(10);
        setka.setVgap(5);
        //end init
        
        for(int i = 0; i < qiymatlar.length; i++){
            labellar[i] = new Label("Jarayonlar: " + qiymatlar[i]);
            pblar[i] = new ProgressBar(qiymatlar[i]);
            pilar[i] = new ProgressIndicator(qiymatlar[i]);
            if(i==0) pilar[i].setPrefSize(24, 24);
            setka.add(labellar[i], 0, i);
            setka.add(pblar[i], 1, i, 2, 1);
            setka.add(pilar[i], 3, i);
        }
        epizod = new Scene(setka);
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
}