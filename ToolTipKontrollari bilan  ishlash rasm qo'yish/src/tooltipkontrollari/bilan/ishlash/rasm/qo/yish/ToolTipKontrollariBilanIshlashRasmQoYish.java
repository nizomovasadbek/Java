package tooltipkontrollari.bilan.ishlash.rasm.qo.yish;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ToolTipKontrollariBilanIshlashRasmQoYish extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Image rasm = new Image(ToolTipKontrollariBilanIshlashRasmQoYish.class.getResourceAsStream("error.png"));
        ImageView tooltiprasm = new ImageView(rasm);
        
        PasswordField parolMaydon = new PasswordField();
        parolMaydon.setPromptText("Kodni kiriting");
        
        Tooltip izoh = new Tooltip();
        izoh.setText("Parolingiz uzunligi kamida\n8ta belgi bo'lish kerak");
        izoh.setGraphic(tooltiprasm);
        
        parolMaydon.setTooltip(izoh);
        
        Button btn = new Button("Kiritish");
        btn.setTranslateY(30);
        
        StackPane ildiz = new StackPane(parolMaydon, btn);
        ildiz.setPadding(new Insets(10, 30, 10, 30));
        
        primaryStage.setTitle("'Tooltip\' klasiga na\'muna");
        primaryStage.setScene(new Scene(ildiz, 300, 100));
        primaryStage.show();
    }
}