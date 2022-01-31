package pkg1javafx_kontrollari;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;
import javax.imageio.ImageIO;
public class Main extends Application {
    
    @Override
    public void start(Stage asosiySahna) throws IOException {
        
        asosiySahna.setTitle("'Button' klasi");
        
        Button tugma = new Button();
        tugma.setText("Bizning tugma");
        tugma.setFont(new Font("Consolas", 20));
        tugma.setEffect(new Reflection());
        tugma.setStyle("-fx-base: #ef28d4; -fx-background-radius: 50");
        
        final Timeline davrOqi = new Timeline();
        davrOqi.setCycleCount(Timeline.INDEFINITE);
        davrOqi.setAutoReverse(true);
        final KeyValue kalitQiymat = new KeyValue(tugma.opacityProperty(), 0);
        final KeyFrame kalitRamka = new KeyFrame(Duration.millis(3000), kalitQiymat);
        davrOqi.getKeyFrames().add(kalitRamka);
        davrOqi.play();
        
        StackPane root = new StackPane();
        root.getChildren().add(tugma);
        
        Scene sin = new Scene(root, 270, 150);
        
        asosiySahna.setScene(sin);
        asosiySahna.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
