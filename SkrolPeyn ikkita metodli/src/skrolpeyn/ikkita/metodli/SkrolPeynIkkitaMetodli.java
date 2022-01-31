package skrolpeyn.ikkita.metodli;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SkrolPeynIkkitaMetodli extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane setka = new GridPane();
        setka.setPadding(new Insets(10, 10, 10, 10));
        setka.setAlignment(Pos.CENTER);
        setka.setHgap(10);
        setka.setVgap(10);
        
        ToggleGroup guruh = new ToggleGroup();
        
        RadioButton rb1 = new RadioButton("Yuqori");
        rb1.setToggleGroup(guruh);
        setka.add(rb1, 0, 0);
        RadioButton rb2 = new RadioButton("O'rtacha");
        rb2.setToggleGroup(guruh);
        setka.add(rb2, 0, 1);
        RadioButton rb3 = new RadioButton("Past");
        rb3.setToggleGroup(guruh);
        setka.add(rb3, 0, 2);
        
        TextField ism = new TextField();
        ism.setPromptText("Ism kiriting.");
        setka.add(ism, 1, 0);
        
        PasswordField parol = new PasswordField();
        parol.setPromptText("Parol kiriting");
        setka.add(parol, 1, 1);
        
        ScrollPane sp = new ScrollPane(setka);
        
        
        Scene epizod = new Scene(sp, 260, 130);
        primaryStage.setTitle("setFitWidth va setFitHeight metodlari");
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
}