package htmlmatneditorbrauzerdanyuklash;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HtmlmatneditorBrauzerdanYuklash extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Brauzerdan yuklash");
        
        final HTMLEditor muharrir = new HTMLEditor();
        muharrir.setPrefSize(580, 350);
        
        WebView brauzer = new WebView();
        brauzer.setPrefSize(580, 400);
        
        final WebEngine webEngine = brauzer.getEngine();
        Button tugma = new Button("Brauzer ga yuklash");
        tugma.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.loadContent(muharrir.getHtmlText());
            }
        });
        VBox vb= new VBox(muharrir, tugma, brauzer);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10));
        vb.setSpacing(10);
        
        primaryStage.setScene(new Scene(vb, 600, 550));
        primaryStage.show();
    }
}