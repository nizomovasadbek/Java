package mediaplayer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MediaPlayer extends Application {
    
    @Override
    public void start(Stage sahna){
        Label label = new Label("Parol: ");
        final Label habar = new Label();
        final PasswordField parol = new PasswordField();
        parol.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.equals("parol")){
                    habar.setText("Kiritilgan parol tasdiqlandi.");
                    habar.setTextFill(Color.GREEN);
                } else {
                    habar.setText("Parol noto'g'ri kiritilgan");
                    habar.setTextFill(Color.RED);
                }
            }
        });
        
        HBox hb = new HBox(10, label, parol);
        hb.setAlignment(Pos.CENTER_LEFT);
        VBox vb = new VBox(5*2, hb, habar);
        vb.setPadding(new Insets(10, 10, 10, 10));
        
        sahna.setScene(new Scene(vb));
        sahna.setTitle("Parol");
        sahna.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}