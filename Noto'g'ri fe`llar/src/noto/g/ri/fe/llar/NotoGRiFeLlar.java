package noto.g.ri.fe.llar;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.scene.layout.Background;
import javafx.scene.input.KeyEvent;

import javax.swing.JOptionPane;

import java.util.Random;

public class NotoGRiFeLlar extends Application {
    TextField input1Past = new TextField();
    TextField input2Past = new TextField();
    TextField input3Past = new TextField();
    private Random rdm = new Random();
    private int son = 0, randomNumber = 0;
    private Label outPutInformations = new Label();
    private String[] birinchiZamon = {
        "awake", "be", "bear", "beat", "become", "begin", "bend", "bind", 
        "bite", "bleed", "blow", "break", "bring", "build", "burn", "burst", 
        "buy", "catch", "choose", "come"
    };
    private String[] ikkinchiZamon = {
        "awoke", "was", "bore", "beat", "became", "began", "bent", "bound", 
        "bit", "bled", "blew", "broke", "brought", "built", "burnt", "burst", 
        "bought", "caught", "chose", "came"
    };
    private String[] uchinchiZamon = 
    {
        "awaked", "been", "borne", "beaten", "become", "begun", "bent", "bound", 
        "bitten", "bled", "blown", "broken", "brought", "built", "burnt", "burst", 
        "bought", "caught", "chosen", "come"
    };
    private String[] tarjimasi = 
    {
        "Uyg'onmoq", "Bo'lmoq, bajarmoq", "Tug'ilmoq", "Urmoq", "Bo'lmoq, Biror narsa bo'lmoq",
        "Boshlamoq", "Qayirmoq", "O'ramoq",
        "Tishlamoq", "Qon oqmoq", "Uflamoq", "Sindirmoq", "Olib kelmoq", "Qurmoq", "Yonmoq", "Yorilib ketmoq",
        "Sotib olmoq", "Tutmoq", "Tanlamoq", "Oldiga kelmoq, Kelmoq"
    };
    
    @Override
    public void start(Stage primaryStage){
        randomNumber = rdm.nextInt(tarjimasi.length);
        son = randomNumber;
        outPutInformations.setText(tarjimasi[son]);
        ImageView backgroundPicture = new ImageView(new Image(NotoGRiFeLlar.class.getResourceAsStream("detskiy.jpg")));
        Button okButton = new Button("OK");
        Font font = new Font("Consolas", 23);
        Label birinchiZamonda = new Label("Present simple:");
        Label ikkinchiZamonda = new Label("Past simple:");
        Label uchinchiZamonda = new Label("Past participle:");
        input1Past.setMaxSize(120, 25);
        input1Past.setTranslateY(-100);
        input2Past.setMaxSize(120, 25);
        input2Past.setTranslateY(-50);
        input3Past.setMaxSize(120, 25);
        outPutInformations.setTranslateY(-150);
        outPutInformations.setFont(font);
        birinchiZamonda.setTranslateY(-100);
        birinchiZamonda.setTranslateX(-130);
        ikkinchiZamonda.setTranslateY(-50);
        ikkinchiZamonda.setTranslateX(-130);
        uchinchiZamonda.setTranslateX(-130);
        okButton.setTranslateY(50);
        okButton.setMaxWidth(100);
        input1Past.setBackground(Background.EMPTY);
        input2Past.setBackground(Background.EMPTY);
        input3Past.setBackground(Background.EMPTY);
        
        okButton.setOnAction((ActionEvent e) -> {
           okButtonOnClick();
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(backgroundPicture);
        root.getChildren().add(input1Past);
        root.getChildren().add(input2Past);
        root.getChildren().add(input3Past);
        root.getChildren().add(outPutInformations);
        root.getChildren().add(birinchiZamonda);
        root.getChildren().add(ikkinchiZamonda);
        root.getChildren().add(uchinchiZamonda);
        root.getChildren().add(okButton);
        
        
        Scene scene = new Scene(root, 400, 400);
        
        scene.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode().equals(e.getCode().ENTER))
                okButtonOnClick();
        });
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("Irregular verbs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    public void okButtonOnClick(){
         if(input1Past.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter \"Present Simple\" values");
            if(input2Past.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter \"Past Simple\" values");
            if(input3Past.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter \"Past Participle\" values");
            String s1 = input1Past.getText().toLowerCase();
            String s2 = input2Past.getText().toLowerCase();
            String s3 = input3Past.getText().toLowerCase();
            if(s1.equals(birinchiZamon[son]) && s2.equals(ikkinchiZamon[son]) && s3.equals(uchinchiZamon[son]))
            {
                JOptionPane.showMessageDialog(null, "You found!");
                randomNumber = rdm.nextInt(birinchiZamon.length);
                son = randomNumber;
                outPutInformations.setText(tarjimasi[son]);
                input1Past.setText("");
                input2Past.setText("");
                input3Past.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You not found!\nPlease, try again!");
                input1Past.setText("");
                input2Past.setText("");
                input3Past.setText("");
            }
    }
}