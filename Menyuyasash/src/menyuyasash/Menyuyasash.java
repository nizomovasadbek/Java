package menyuyasash;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menyuyasash extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Text matn = new Text("Bizning matn.");
        matn.setFont(Font.font("Verdana", 32));
        matn.setFill(Color.GREEN);
        
        Image ochishRasm = new Image(getClass().getResourceAsStream("ochish.png"));
        Image nashrRasm= new Image(getClass().getResourceAsStream("nashr.png"));
        Image chiqishRasm = new Image(getClass().getResourceAsStream("chiqish.png"));
        
        MenuBar menuOrni = new MenuBar();
        Menu fayl = new Menu("_Fayl");
        
        MenuItem fayl_Ochish = new MenuItem("_Ochish");
        fayl_Ochish.setGraphic(new ImageView(ochishRasm));
        fayl_Ochish.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        fayl_Ochish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matn.setText("Fayl-Ochish\\tanlandi");
            }
        });
        MenuItem fayl_Nashr = new MenuItem("_Nashr qilish");
        fayl_Nashr.setGraphic(new ImageView(nashrRasm));
        fayl_Nashr.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        fayl_Nashr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matn.setText("Fayl-Nashr\\tanlandi.");
            }
        });
        MenuItem fayl_Chiqish = new MenuItem("_Chiqish");
        fayl_Chiqish.setGraphic(new ImageView(chiqishRasm));
        fayl_Chiqish.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN));
        fayl_Chiqish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        fayl.getItems().addAll(fayl_Ochish, fayl_Nashr, new SeparatorMenuItem(), fayl_Chiqish);
        menuOrni.getMenus().add(fayl);
        
        BorderPane ildiz = new BorderPane();
        ildiz.setTop(menuOrni);
        ildiz.setCenter(matn);
        
        primaryStage.setTitle("Menu ga na'muna");
        primaryStage.setScene(new Scene(ildiz, 350, 250));
        primaryStage.show();
    }
}