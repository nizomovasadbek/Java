package kolorpiker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KolorPiker extends Application {
    
    @Override
    public void start(Stage sahna) {
        final ColorPicker rangTanlagich = new ColorPicker(Color.GREEN);
        final Text matn = new Text("ColorPickerni o'rganamiz");
        matn.setFont(Font.font(20));
        matn.setFill(rangTanlagich.getValue());
        
        rangTanlagich.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matn.setFill(rangTanlagich.getValue());
            }
        });
        
        HBox hb = new HBox(10, rangTanlagich, matn);
        hb.setPadding(new Insets(10));
        
        Group gr = new Group(hb);
        
        sahna.setScene(new Scene(gr, 380, 40, Color.BLACK));
        sahna.setTitle("ColorPicker (rang tanlagich) ga na'muna");
        sahna.show();
    }
}