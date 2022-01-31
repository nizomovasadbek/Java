package titledpane.accordionga.qo.yish;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TitledPaneAccordiongaQoYish extends Application {
    
    private String[] faylNomlari = {
       "apple.png",
        "flower.png",
        "leaf.png"
    };
    
    private String[] nomlar = { "Olma", "Gul", "Barg" };
    private Image[] rasmlar = new Image[faylNomlari.length];
    private TitledPane[] tplar = new TitledPane[faylNomlari.length];
    private Label label = new Label("Aniqlanmagan");
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rasmlar");
        GridPane setka = new GridPane();
        setka.setVgap(4);
        setka.setPadding(new Insets(5));
        setka.add(new Label("Kimga:"), 0, 0);
        setka.add(new TextField(), 1, 0);
        setka.add(new Label("Nusxasi:"), 0, 1);
        setka.add(new TextField(), 1, 1);
        setka.add(new Label("Mavzu:"), 0, 2);
        setka.add(new TextField(), 1, 2);
        setka.add(new Label("Biriktirilgan fayl:"), 0, 3);
        setka.add(label, 1, 3);
        
        TitledPane tp_setka = new TitledPane("Xabar", setka);
        tp_setka.setExpanded(false);
        
        final Accordion acc = new Accordion();
        
        for(int i = 0; i < faylNomlari.length; i++){
            rasmlar[i] = new Image(getClass().getResourceAsStream(faylNomlari[i]));
            ImageView rasm = new ImageView(rasmlar[i]);
            tplar[i] = new TitledPane(nomlar[i], rasm);
            
            acc.getPanes().add(tplar[i]);
        }
        
        acc.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                if(newValue != null){
                    label.setText(acc.getExpandedPane().getText()+".jpg");
                } else {
                    label.setText("Aniqlanmagan");
                }
            }
        });
        
        HBox hb = new HBox(10);
        hb.setPadding(new Insets(20));
        hb.getChildren().addAll(tp_setka, acc);
        
        Scene scene = new Scene(hb);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}