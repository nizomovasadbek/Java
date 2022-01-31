package button.klasi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ButtonKlasi extends Application {
    
    @Override
    public void start(Stage asosiySahna) {
        
        asosiySahna.setTitle("'Button'ga na'muna");
        asosiySahna.setResizable(false);
        
        GridPane setka = new GridPane();
        setka.setVgap(10);
        setka.setHgap(10);
        setka.setPadding(new Insets(15, 15, 15, 15));
        setka.setAlignment(Pos.CENTER_LEFT);
        
        Image rasm1 = new Image(getClass().getResourceAsStream("tasdiq.bmp"));
        Button tugma1 = new Button("Tasdiq", new ImageView(rasm1));
        tugma1.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9");
        setka.add(tugma1, 0, 0, 2, 1);
        
        Button tugma2 = new Button("Tasdiq");
        setka.add(tugma2, 0, 1);
        Button tugma3 = new Button("Rad");
        setka.add(tugma3, 1, 1);
        
        Button tugma4 = new Button();
        tugma4.setGraphic(new ImageView(rasm1));
        setka.add(tugma4,0,2);
        Button tugma5 = new Button();
        tugma5.setGraphic(new ImageView(new Image(ButtonKlasi.class.getResourceAsStream("rad.bmp"))));
        setka.add(tugma5,1,2);
        
        Label label = new Label();
        setka.add(label, 2, 0, 1, 3);
        
        tugma2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("Tasdiqlandi.");
            }
        });
        
        tugma3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("Rad etildi.");
            }
        });
        
        DropShadow soya = new DropShadow();
        tugma3.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tugma3.setEffect(soya);
                
            }
        });
        tugma3.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tugma3.setEffect(null);
                
            }
        });
        
        Scene scene = new Scene(setka, 230, 150);
        asosiySahna.setScene(scene);
        asosiySahna.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}