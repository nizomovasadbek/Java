package gipermasofadagitarkibgaaloqa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GiperMasofadagitarkibgaAloqa extends Application {
    
    private String[] sarlavhalar = {
        "Mahsulot",
        "Ta'lim",
        "Hamkorlar",
        "Yordam"
    };
    
    private String[] fayllarNomi = {
        "mahsulot.png",
        "ta'lim.png",
        "hamkorlar.png",
        "yordam.png"
    };
    private String[] webManzillar = {
        "http://oracle.com/us/products/index.html",
        "http://education.oracle.com/",
        "http://oracle.com/partners/index.html",
        "http://oracle.com/us/support/index.html"
    };
    
    private Image[] rasmlar = new Image[sarlavhalar.length];
    private Hyperlink[] havolalar = new Hyperlink[sarlavhalar.length];
    
    @Override
    public void start(Stage primaryStage) {
        WebView brauzer = new WebView();
        final WebEngine webEngine = brauzer.getEngine();
        
        for(int i = 0; i < sarlavhalar.length; i++){
            final String webManzil = webManzillar[i];
            
            rasmlar[i] = new Image(getClass().getResourceAsStream(fayllarNomi[i]));
            
            havolalar[i] = new Hyperlink(sarlavhalar[i]);
            havolalar[i].setFont(new Font("Arial", 14));
            havolalar[i].setGraphic(new ImageView(rasmlar[i]));
            havolalar[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    webEngine.load(webManzil);
                }
            });
            
        }
        
        HBox hb = new HBox(havolalar);
        VBox vb = new VBox(hb, brauzer);
        
        primaryStage.setTitle("Oracle.com ning mahsus sahifalari");
        primaryStage.setScene(new Scene(vb, 600, 550));
        primaryStage.show();
    }
}
