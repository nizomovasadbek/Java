package skrolpeyn.yasash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SkrolPeynYasash extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Image rasm = new Image(getClass().getResourceAsStream("atirgullar.jpg"));
        ImageView foto = new ImageView(rasm);
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(foto);
        sp.setPannable(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        Scene epizod = new Scene(sp, 150, 200);
        
        primaryStage.setTitle("ScrollPane");
        primaryStage.setScene(epizod);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
