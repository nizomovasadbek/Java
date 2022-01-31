package asocketlar;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class ASocketlar extends Application{
    
    private Button btn;
    
    @Override
    public void start(Stage s){
        Timeline tl = new Timeline();
        TextField tf = TextFieldBuilder.create()
                .editable(false)
                .text("IP: Aniqlanmagan")
                .build();
        btn = ButtonBuilder.create()
                .text("IP adresni chiqar")
                .scaleX(1.7)
                .scaleY(1.5)
                .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tl.play();
                try{
                InetAddress ip = InetAddress.getLocalHost();
                tf.setText("IP: " + ip.getHostAddress());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "IP adres topishda xatolik");
                }
            }
        }).build();
        
        KeyFrame kf = new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handle_timer();
            }
        });
        
        tl.getKeyFrames().add(kf);
        tl.setCycleCount(335);
        
        VBox vb = new VBox(80, btn, tf);
        vb.setPadding(new Insets(10));
        vb.setAlignment(Pos.CENTER);
        s.setScene(new Scene(vb, 400, 400));
        s.show();
    }
    
    public double i = 0;
    public void handle_timer(){
        btn.setScaleX(Math.cos(Math.toRadians(i))+2);
        btn.setScaleY(Math.cos(Math.toRadians(i))+1.534);
        i += 1;
        if(i>=334) { btn.setScaleX(1.7); btn.setScaleY(1.5); i = 0; }
    }
    
    public static void main(String args[]){
        launch(args);
    }
}