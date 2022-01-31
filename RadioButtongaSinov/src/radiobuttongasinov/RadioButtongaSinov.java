package radiobuttongasinov;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RadioButtongaSinov extends Application {
    
    @Override
    public void start(Stage asosiySahna) {
        asosiySahna.setTitle("'RadioButton'ga na'muna");
        asosiySahna.setResizable(false);
        
        GridPane setka = new GridPane();
        setka.setHgap(50);
        setka.setVgap(10);
        setka.setPadding(new Insets(15, 15, 15, 15));
        setka.setAlignment(Pos.CENTER_LEFT);
        
        final ToggleGroup guruh = new ToggleGroup();
        RadioButton rb1 = new RadioButton("UY");
        rb1.setToggleGroup(guruh);
        RadioButton rb2 = new RadioButton("Kalendar");
        rb2.setToggleGroup(guruh);
        RadioButton rb3 = new RadioButton("Kontaktlar");
        rb3.setToggleGroup(guruh);
        setka.add(rb1, 0, 0);
        setka.add(rb2, 0, 1);
        setka.add(rb3, 0, 2);
        
        ImageView ikon = new ImageView();
        setka.add(ikon, 1, 0, 1, 3);
        
        rb1.setUserData("uy");
        rb2.setUserData("kalendar");
        rb3.setUserData("kontakt");
        
        guruh.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(guruh.getSelectedToggle() != null){
                    final Image rasm = new Image(getClass().getResourceAsStream(
                            guruh.getSelectedToggle().getUserData().toString()+".bmp"));
                ikon.setImage(rasm);
                }
            }
        });
        
        Scene epizod = new Scene(setka, 260, 100);
        
        asosiySahna.setScene(epizod);
        asosiySahna.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}