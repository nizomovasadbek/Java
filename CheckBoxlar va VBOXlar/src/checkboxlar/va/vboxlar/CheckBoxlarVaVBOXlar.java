package checkboxlar.va.vboxlar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxlarVaVBOXlar extends Application {
    
    private String[] nomlar = {"Xavfsizlik", "Loyiha", "Grafik"};
    private Image[] rasmlar = new Image[nomlar.length];
    private ImageView[] ikonlar = new ImageView[nomlar.length];
    private CheckBox[] cblar = new CheckBox[nomlar.length];
    
    private VBox vb = new VBox();
    private HBox hb = new HBox();
    
    @Override
    public void start(Stage primaryStage) {
        for(int i = 0; i < nomlar.length; i++){
            final Image image = rasmlar[i] = new Image(getClass().getResourceAsStream(nomlar[i]+".png"));
            final ImageView ikon = ikonlar[i] = new ImageView(image);
            hb.getChildren().add(ikon);
            
            CheckBox cb = cblar[i] = new CheckBox(nomlar[i]);
            cb.setSelected(true);
            vb.getChildren().add(cb);
            
            cb.selectedProperty().addListener(new ChangeListener<Object>() {
                @Override
                public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                    ikon.setImage((boolean)newValue?image:null);
                }
            });
        }
        vb.setAlignment(Pos.CENTER_LEFT);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 50, 10, 10));
        
        hb.setAlignment(Pos.CENTER_LEFT);
        hb.getChildren().add(0, vb);
        
        Scene epizod = new Scene(hb, 250, 80);
        
        primaryStage.setTitle("'CheckBox'lar va layout lar");
//        primaryStage.setResizable(false);
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
}
