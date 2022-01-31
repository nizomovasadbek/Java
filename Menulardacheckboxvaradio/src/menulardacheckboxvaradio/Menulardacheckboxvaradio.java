package menulardacheckboxvaradio;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
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

public class Menulardacheckboxvaradio extends Application {
    
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
        
        Menu korinish = new Menu("Ko'rinish");
        CheckMenuItem soyaliMatn = new CheckMenuItem("Soyali matn");
        soyaliMatn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(soyaliMatn.isSelected()){
                    DropShadow soya = new DropShadow();
                    matn.setEffect(soya);
                } else {
                    matn.setEffect(null);
                }
            }
        });
        
        Menu matnRangi = new Menu("Matn ranggi");
        ToggleGroup guruh = new ToggleGroup();
        
        RadioMenuItem yashil = new RadioMenuItem("Yashil");
        yashil.setUserData(Color.GREEN);
        yashil.setToggleGroup(guruh);
        yashil.setSelected(true);
        RadioMenuItem qizil = new RadioMenuItem("Qizil");
        qizil.setUserData(Color.RED);
        qizil.setToggleGroup(guruh);
        RadioMenuItem kok = new RadioMenuItem("Ko'k");
        kok.setUserData(Color.BLUE);
        kok.setToggleGroup(guruh);
        RadioMenuItem jigarrang = new RadioMenuItem("Jigarrang");
        jigarrang.setUserData(Color.BROWN);
        jigarrang.setToggleGroup(guruh);
        
        guruh.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue!=null)
                matn.setFill((Color)newValue.getUserData());
            }
        });
        
        matnRangi.getItems().addAll(yashil, qizil, kok, jigarrang);
        
        korinish.getItems().addAll(soyaliMatn, new SeparatorMenuItem(), matnRangi);
        menuOrni.getMenus().addAll(fayl, korinish);
        
        
        BorderPane ildiz = new BorderPane();
        ildiz.setTop(menuOrni);
        ildiz.setCenter(matn);
        
        primaryStage.setTitle("Menu ga na'muna");
        primaryStage.setScene(new Scene(ildiz, 350, 250));
        primaryStage.show();
    }
}