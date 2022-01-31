package sanoqsistemalari;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
public class SanoqSistemalari extends Application {
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("'ChoiceBox' ga na'muna");
        primaryStage.setResizable(false);
        
        GridPane setka = new GridPane();
        setka.setPadding(new Insets(25, 10, 10, 10));
        setka.setAlignment(Pos.TOP_LEFT);
        setka.setHgap(25);
        
        final String[] salomlashish = {"Salom","Hello","Privet"};
        String[] tillar = {"O'zbek", "English", "Russia"};
        
        Label lbl = new Label(salomlashish[0]);
        lbl.setFont(new Font("Consolas", 18));
        setka.add(lbl, 1, 0);
        
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(tillar));
        cb.setValue(tillar[0]);
        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                lbl.setText(salomlashish[newValue.intValue()]);
            }
        });
        setka.add(cb, 0, 0);
        
        Scene epizod = new Scene(setka, 250, 100);
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}