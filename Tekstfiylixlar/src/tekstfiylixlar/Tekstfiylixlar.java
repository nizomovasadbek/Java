package tekstfiylixlar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tekstfiylixlar extends Application {
    
    @Override
    public void start(Stage sahna){
        sahna.setTitle("TextField");
        sahna.setResizable(false);
        
        GridPane setka = new GridPane();
        setka.setPadding(new Insets(10, 10, 10, 10));
        setka.setHgap(10);
        setka.setVgap(10);
        
        final TextField ismi = new TextField();
        ismi.setPromptText("Ismingizni kiriting");
        setka.add(ismi, 0, 0);
        
        final TextField sharif = new TextField();
        sharif.setPromptText("Sharifingizni kiriting");
        setka.add(sharif, 0, 1);
        
        final TextField izoh = new TextField();
        izoh.setPromptText("Izoh");
        setka.add(izoh, 0, 2);
        
        Button tasdiqlash = new Button("Tasdiqlash");
        setka.add(tasdiqlash, 1, 0);
        
        Button tozalash = new Button("Tozalash");
        setka.add(tozalash, 1, 1);
        
        Label msg = new Label();
        setka.add(msg, 0, 3, 2, 1);
        
        tasdiqlash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ismi.getText().equals("")){
                    msg.setText("Ismingiz kiritilmagan");
                    return;
                }
                if(sharif.getText().equals("")){
                    msg.setText("Sharifingiz kiritilmagan");
                    return;
                }
                if(izoh.getText().equals("")){
                    msg.setText("Izoh kiritilmagan");
                    return;
                }
                msg.setText(ismi.getText() + " "+ sharif.getText() +" izoh uchun raxmat!");
            }
        });
        
        tozalash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ismi.clear();
                sharif.clear();
                izoh.clear();
                msg.setText(null);
            }
        });
        
        Scene epizod = new Scene(setka, 280, 120);
        
        sahna.setScene(epizod);
        sahna.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}