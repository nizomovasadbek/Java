package yangigibrittil;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RUNKnopkasi extends Application {

    public static String command = null;
    private static int oynalarSoni = 0;
    public static Stage asosiySahna = new Stage();
    
    public static void RUN(String text) {
        oynalarSoni++;
        command = text;
        asosiySahna.setX(700);
        asosiySahna.setY(50);
        RUNKnopkasi runk = new RUNKnopkasi();
        runk.start(asosiySahna);
        
    }

    public WebView brauzer = new WebView();
    public WebEngine webEngine = brauzer.getEngine();
    
    @Override
    public void start(Stage primaryStage) {
        brauzer.applyCss();
        
        YangiGibritTil ygt = new YangiGibritTil();
        primaryStage.setTitle("Web dastur");
        Button yangilash = new Button("Tozalash");
        yangilash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ygt.refresh();
                webEngine.reload();
            }
        });
        
        brauzer.setPrefSize(600, 500);
        Button ok = new Button("OK");
        
        webEngine.loadContent(command);
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        HBox hb = new HBox(ok, yangilash);
        hb.setSpacing(10);
        hb.setPadding(new Insets(1, 1, 1, 5));
        VBox vb = new VBox(brauzer, hb);
        vb.setSpacing(10);
        primaryStage.setScene(new Scene(vb, 650, 550));
        primaryStage.show();
    }
}