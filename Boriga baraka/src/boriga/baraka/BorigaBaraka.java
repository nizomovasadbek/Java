package boriga.baraka;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BorigaBaraka extends Application {

    private String[] nomlar = {
        "GUGURT",
        "SALFETKA",
        "LAMPOCHKA",
        "MIKSER",
        "OLIVIA TO'PLAMI",
        "TELEFON",
        "KONDITSIONER",
        "KOMPYUTER",
        "CHANGYUTGICH",
        "TELEVIZOR",
        "MUZLATGICH",
        "YUMSHOQ MEBELLAR TO'PLAMI", "VAUCHER (ECOBOZOR)", "VAUCHER (KUPON)",
        "AKFAMEDLINEGA VAUCHER", "SAMSUNG", "SENOR va SENORITA", "2 XONALI UY",
        "AVTOMOBIL", "FITNES SOAT", "MINIPECH", "KIR YUVISH MASHINASI",
        "GAZ PLITASI", "HAVO NAMLANTIRGICH"
    };

    private String[] tablo = nomlar;
    public Image r;

    private final String NOMLAR_OVOZLI = ".mp3";
    private final String NOMLAR_RASMLI = ".jpg";
    private final int SOVGALAR_SONI = nomlar.length + 1;

    private final Image[] rasmlar = new Image[nomlar.length];
    private final AudioClip[] qoshiqlar = new AudioClip[nomlar.length];
    private final ImageView[] tugma = new ImageView[nomlar.length];

    private AudioClip kirishQoshigi = new AudioClip(getClass().getResource("Intro.wav").toString());
    private final AudioClip bosish = new AudioClip(getClass().getResource("Click.wav").toString());
    private Image yopiq = new Image(getClass().getResourceAsStream("Yopiq.jpg"));
    private Image gif = new Image(getClass().getResourceAsStream("Intro.gif"));
    private int si = 0;
    private Scene scene;

    private int x = 0;
    private int y = 0;
    private int n = 0;
    
    private Random rand = new Random();

    private void boshlangich_sozlamanlar(){
        int i = 0;
        for(String x:nomlar){
            tablo[i++] = x.toLowerCase();
        }
    }
    
    private void kuyla(AudioClip ac){
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                ac.play();
            }
        });
        th.start();
    }
    
    @Override
    public void start(Stage primaryStage) {
        boshlangich_sozlamanlar();
        Button btn = ButtonBuilder.create()
                .text("Hello")
                .focusTraversable(true)
                .font(Font.font("Arial", FontWeight.THIN, FontPosture.REGULAR, 18))
                .pickOnBounds(true)
                .build();
        primaryStage.setScene(new Scene(new StackPane(btn)));
        primaryStage.show();
    }
}