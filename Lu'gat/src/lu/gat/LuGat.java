package lu.gat;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LuGat extends Application {
    
    
    public static void enTouz(Stage primaryStage){
        Scene sc = primaryStage.getScene();
        EnglishToUzbek English_To_Uzbek = new EnglishToUzbek();
        HashMap<String, String> dic = English_To_Uzbek.lugat;
        
        Image rasm = new Image(LuGat.class.getResourceAsStream("yordam.bmp"));
        
        Button yordam = new Button();
        yordam.setGraphic(new ImageView(rasm));
        Kochish(yordam, 236, 294);
        
        Button orqaga = new Button("Orqaga");
        Kochish(orqaga, 240, 35);
        Button qidirish = new Button("Qidirish");
        Kochish(qidirish, 240, 0);
        
        TextField inputedText = new TextField();
        inputedText.setFont(new Font("Consolas", 14));
        inputedText.setPrefSize(210, 25);
        
        Group root = new Group(inputedText, qidirish, orqaga, yordam);
        
        Scene epizod = new Scene(root, 300, 350);
        
        primaryStage.setTitle("Lug'at English-Uzbek");
        primaryStage.setScene(epizod);
        primaryStage.show();
        
        
        orqaga.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(sc);
                primaryStage.setTitle("Lug'at dasturi");
            }
        });
        
//        int i=0;
        //Hodisalar
        qidirish.setOnAction((ActionEvent event) -> {
            String muntazamIfoda = inputedText.getText().toLowerCase();
            muntazamIfoda = muntazamIfoda.trim();
            muntazamIfoda = muntazamIfoda.replaceAll("\\s+", "");
            String matn = dic.get(muntazamIfoda);
            if(matn == null){ JOptionPane.showMessageDialog(null, "Hech narsa topilmadi");
            return;
            }
            IndicateMessage.Message(matn);
        });
        
        epizod.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode().equals(e.getCode().ENTER)){
                    String muntazamIfoda = inputedText.getText().toLowerCase();
                    muntazamIfoda = muntazamIfoda.trim();
                    muntazamIfoda = muntazamIfoda.replaceAll("\\s+", "");
                    String matn = dic.get(muntazamIfoda);
                    if(matn == null){ JOptionPane.showMessageDialog(null, "Hech narsa topilmadi");
            return;
            }
                    IndicateMessage.Message(matn);
                }
            }
        });
        yordam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                haqida(primaryStage);
            }
        });
    }
    
    public static void uzToen(Stage primaryStage){
        Scene sc = primaryStage.getScene();
        UzbekToEnglish English_To_Uzbek = new UzbekToEnglish();
        HashMap<String, String> dic = English_To_Uzbek.lugat;
        
        Image rasm = new Image(LuGat.class.getResourceAsStream("yordam.bmp"));
        
        Button yordam = new Button();
        yordam.setGraphic(new ImageView(rasm));
        Kochish(yordam, 236, 294);
        
        Button orqaga = new Button("Orqaga");
        Button qidirish = new Button("Qidirish");
        Kochish(qidirish, 240, 0);
        Kochish(orqaga, 240, 35);
        
        TextField inputedText = new TextField();
        inputedText.setPrefSize(210, 25);
        inputedText.setFont(new Font("Consolas", 14));
        
        Group root = new Group(inputedText, qidirish, orqaga, yordam);
        
        Scene epizod = new Scene(root, 300, 350);
        
        primaryStage.setTitle("Lug'at Uzbek-English");
        primaryStage.setScene(epizod);
        primaryStage.show();
        
        orqaga.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(sc);
                primaryStage.setTitle("Lug'at dasturi");
            }
        });
//        int i=0;
        //Hodisalar
        qidirish.setOnAction((ActionEvent event) -> {
            String muntazamIfoda = inputedText.getText().toLowerCase();
            muntazamIfoda = muntazamIfoda.trim();
            muntazamIfoda = muntazamIfoda.replaceAll("\\s+", "");
            String matn = dic.get(muntazamIfoda);
            IndicateMessage.Message(matn);
            if(matn == null){ JOptionPane.showMessageDialog(null, "Hech narsa topilmadi");
            return;
            }
        });
        
        
        epizod.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode().equals(e.getCode().ENTER)){
                    String muntazamIfoda = inputedText.getText().toLowerCase();
                    muntazamIfoda = muntazamIfoda.trim();
                    muntazamIfoda = muntazamIfoda.replaceAll("\\s+", "");
                    String matn = dic.get(muntazamIfoda);
                    IndicateMessage.Message(matn);
                    if(matn == null){ JOptionPane.showMessageDialog(null, "Hech narsa topilmadi");
            return;
            }
                }
            }
        });
        yordam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                haqida(primaryStage);
            }
        });
    }
    
    @Override
    public void start(Stage engAsosiySahna) {
        
//        JOptionPane.showMessageDialog(null, "Fe'llarning ohiriga \"moq\" qo'shib yozing.\nMasalan, suzmoq");
        
        Button rb1 = new Button("from English to Uzbek");
        Button rb2 = new Button("O'zbekchadan Ingilizchaga");
        
        Kochish(rb1, 0, 0);
        Kochish(rb2, 0, 40);
        
        rb1.setFont(new Font("Consolas", 15));
        rb2.setFont(new Font("Consolas", 15));
        
        Group root = new Group(rb1, rb2);
        
        rb1.setOnAction((ActionEvent e) -> {
            enTouz(engAsosiySahna);
        });
        
        rb2.setOnAction((ActionEvent e) -> {
            uzToen(engAsosiySahna);
        });
        
        Scene epizod = new Scene(root, 300, 350);
        
        engAsosiySahna.setResizable(true);
        engAsosiySahna.setTitle("Lug'at dasturi");
        engAsosiySahna.setScene(epizod);
        engAsosiySahna.show();
    }
    
    protected static void Kochish(Node obj, int x, int y){
        obj.setTranslateX(x);
        obj.setTranslateY(y);
    }
    public static void main(String[] args){
        launch(args);
    }
    public static void haqida(Stage primaryStage){
        Scene sc = primaryStage.getScene();
        String hq = primaryStage.getTitle();
        primaryStage.setTitle("Haqida");
        
        Button btn = new Button("Orqaga");
        btn.setTranslateX(180);
        btn.setTranslateY(150);
        btn.setFont(new Font("Consolas", 18));
                
        Label matn = new Label("Siz so'zni qidirmoqchi bo'lsangiz \nso'zning ohiriga \"moq\" ni qo'shib\n chiqishingiz"
                + " kerak bo'ladi.");
        matn.setFont(new Font("Consolas", 30));
        matn.setWrapText(true);
        Group root = new Group
           (matn, btn);
        
        Scene scene = new Scene(root, 550, 200);
        primaryStage.setScene(scene);
       
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage
                        .setTitle(hq);
                primaryStage.setScene(sc);
            }
        });
    }
}