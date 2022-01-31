package giperlinkyasash;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GiperlinkYasash extends Application {
    
    private String[] sarlavhalar = {
        "Hamkorlar", "Mahsulot", "Ta'lim", "Yordam"
    };
    
    private Hyperlink[] havolalar = new Hyperlink[sarlavhalar.length];
    private Image[] rasmlar = new Image[sarlavhalar.length];
    private final ImageView tanlanganRasm = new ImageView();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Havola bilan ishlash");
        
        for(int i = 0; i < sarlavhalar.length; i++){
            final Image rasm = rasmlar[i] = new Image(getClass().getResourceAsStream(sarlavhalar[i].toLowerCase()
            +".png"));
            Hyperlink havola = havolalar[i] = 
                    new Hyperlink(sarlavhalar[i]);
            havola.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tanlanganRasm.setImage(rasm);
                }
            });
        }
        
        Button tugma = new Button("Yangilash");
        tugma.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i < sarlavhalar.length; i++){
                    havolalar[i].setVisited(false);
                }
                tanlanganRasm.setImage(null);
            }
        });
        
        VBox vb = new VBox(havolalar);
        vb.setSpacing(5);
        vb.getChildren().add(tugma);
        
        HBox hb = new HBox(vb, tanlanganRasm);
        hb.setSpacing(30);
        hb.setPadding(new Insets(10, 10, 10, 10));
        
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(hb, 200, 150));
        primaryStage.show();
    }
}