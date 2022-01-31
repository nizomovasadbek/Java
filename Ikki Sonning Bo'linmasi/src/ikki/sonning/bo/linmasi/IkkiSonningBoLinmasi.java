package ikki.sonning.bo.linmasi;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
public class IkkiSonningBoLinmasi extends Application {
    
    @Override
    public void start(Stage primaryStage){
       Button btn = new Button("Listening");
       btn.setLayoutX(50);
       final AudioClip qoshiq = new AudioClip(IkkiSonningBoLinmasi.class.getResource("kuku.wav").toString());
       
       btn.setOnAction((ActionEvent e) -> {
           qoshiq.play();
       });
       
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("Rasmcha");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
         launch(args);
    }   
}