package javafxdastur;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import javax.xml.bind.JAXBContext;
//916 / 982
public class JavaFXDastur extends Application {
//    JavaFX da FGI yasash 007
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("'Label' ga misol"); //Oynaning sarlavhasi
        
        GridPane setka = new GridPane(); // layout o'rnatish
        setka.setHgap(10); // Grid pane orasidagi masofa
        setka.setAlignment(Pos.CENTER);
        
        Image rasm = new Image(getClass().getResourceAsStream("help.bmp"));
        Label label1 = new Label("Qidirish");
        label1.setGraphic(new ImageView(rasm));
        
        //Shrfitlar: Kristen ITC
//        Viner Hand ITC, Script MT, QuartetBold
        label1.setFont(new Font("Kristen ITC", 30));
        label1.setTextFill(Color.web("#0076a3"));
        setka.add(label1, 0, 0);
        
        Label label2  = new Label("Qiymatlar");
        label2.setFont(Font.font("Consolas", 32));
        label2.setRotate(270);
        setka.add(label2, 1, 0);
        
        Label label3 = new Label("Bu 'Label' dagi so'zlarni satrga ko'chiramiz");
        label3.setPrefWidth(80);
        label3.setWrapText(true);
        setka.add(label3, 2, 0);
        
        label3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label3.setScaleX(1.5);
                label3.setScaleY(1.5);
            }
        });
        label3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label3.setScaleX(1);
                label3.setScaleY(1);
            }
        });
        
        Scene scene = new Scene(setka, 500, 170);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }   
}