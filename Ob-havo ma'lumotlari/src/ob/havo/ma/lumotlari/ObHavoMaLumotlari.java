package ob.havo.ma.lumotlari;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ObHavoMaLumotlari extends Application {
    
    Label sarlavha = new Label("Ob-havo ma'lumoti");
    Label payshanba = new Label("Payshanba");
    Label juma = new Label("Juma");
    Label shanba = new Label("Shanba");
    Image bulutRasmi = new Image(getClass().getResourceAsStream("bulut.png"));
    Image quyoshRasmi = new Image(getClass().getResourceAsStream("sun.png"));
    
    @Override
    public void start(Stage primaryStage) {
        GridPane setka = new GridPane();
        setka.setPadding(new Insets(10, 10, 10, 10));
        setka.setHgap(10);
        setka.setVgap(10);
        
        sarlavha.setFont(Font.font("Verdana", 20));
        setka.add(sarlavha, 0, 0, 8, 1);
        
        Separator ajrGor = new Separator();
        setka.add(ajrGor, 0, 1, 7, 1);
        
        payshanba.setFont(new Font("Verdana", 18));
        setka.add(payshanba, 0, 2, 2, 1);
        
        Separator ajrVer1 = new Separator(Orientation.VERTICAL);
        setka.add(ajrVer1, 2, 2, 1, 2);
        
        juma.setFont(new Font("Verdana", 18));
        setka.add(juma, 3, 2, 2, 1);
        
        shanba.setFont(new Font("Verdana", 18));
        setka.add(shanba, 6, 2, 2, 1);
        
        Separator ajrVer2 = new Separator(Orientation.VERTICAL);
        ajrVer2.setMinHeight(120);
        setka.add(ajrVer2, 5, 2, 2, 1);
        
        ImageView bulut = new ImageView(bulutRasmi);
        setka.add(bulut, 0, 3);
        
        Label harorat1 = new Label("16\u00B0C");
        harorat1.setFont(new Font("Verdana", 18));
        setka.add(harorat1, 1, 3);
        
        ImageView quyosh1 = new ImageView(quyoshRasmi);
        setka.add(quyosh1, 3, 3);
        
        Label harorat2 = new Label("18\u00B0C");
        harorat2.setFont(new Font("Verdana", 18));
        setka.add(harorat2, 4, 3);
        
        ImageView quyosh2 = new ImageView(quyoshRasmi);
        setka.add(quyosh2, 6, 3);
        
        Label harorat3 = new Label("20\u00B0C");
        harorat3.setFont(new Font("Verdana", 18));
        setka.add(harorat3, 7, 3);
        
        primaryStage.setTitle("Ob-havo ma'lumoti");
        Scene epizod = new Scene(setka, 360, 150);
        epizod.getStylesheets().add("ob/havo/ma/lumotlari/Stil.css");
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}