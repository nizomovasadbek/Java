package htmlmatneditoryasash;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HtmlmatnEditoryasash extends Application {

    @Override
    public void start(Stage primaryStage) {
        final HTMLEditor muharrir = new HTMLEditor();
        muharrir.setPrefSize(580, 350);
        
        final TextArea html_kod = new TextArea();
        html_kod.setPromptText("Bu yerda html kod bo'lishi kerak");
        html_kod.setWrapText(true);
        html_kod.setEditable(false);
        
        Button tugma = new Button("HTML kodni olish");
        tugma.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                html_kod.setText(muharrir.getHtmlText());
            }
        });
        VBox vb = new VBox(muharrir, tugma, html_kod);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10));
        vb.setAlignment(Pos.CENTER);
        
        primaryStage.setTitle("HTML kod olish dasturi");
        primaryStage.setScene(new Scene(vb));
        primaryStage.show();
    }
}