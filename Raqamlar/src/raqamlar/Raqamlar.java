package raqamlar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Raqamlar extends Application {
    
    private final int MASSIV_UZUNLIGI = 10;
    private ScrollBar sb = new ScrollBar();
    private Image[] tasvirlar = new Image[MASSIV_UZUNLIGI];
    private ImageView[] suratlar = new ImageView[MASSIV_UZUNLIGI];
    private VBox vb = new VBox();
    private DropShadow soya = new DropShadow();
    
    @Override
    public void start(Stage sahna) {
        Group ildiz = new Group();
        
        Scene epizod = new Scene(ildiz, 175, 132);
        
        sahna.setTitle("Raqamlar");
        sahna.setScene(epizod);
        
        ildiz.getChildren().addAll(vb, sb);
        
        soya.setColor(Color.GREY);
        soya.setOffsetX(12);
        soya.setOffsetY(12);
        
        vb.setLayoutX(20);
        vb.setSpacing(20);
        
        sb.setLayoutX(epizod.getWidth()-sb.getWidth());
        sb.setOrientation(Orientation.VERTICAL);
        sb.setPrefHeight(122);
        sb.setMax((MASSIV_UZUNLIGI-1)*(sb.getPrefHeight()+vb.getSpacing()));
        sb.setBlockIncrement(100);
        
        for(int i = 0; i < MASSIV_UZUNLIGI; i++){
            tasvirlar[i] = new Image(getClass().getResourceAsStream("number"+(i+1)+".png"));
            suratlar[i] = new ImageView(tasvirlar[i]);
            suratlar[i].setEffect(soya);
            vb.getChildren().add(suratlar[i]);
        }
        
        sb.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                vb.setLayoutY(-newValue.doubleValue());
            }
        });
        
        sahna.show();
    }
}
