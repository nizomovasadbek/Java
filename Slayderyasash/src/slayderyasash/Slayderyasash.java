package slayderyasash;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Slayderyasash extends Application {

    Image rasm = new Image(getClass().getResourceAsStream("cappucino3.png"));
    final ImageView kappukino = new ImageView(rasm);

    Label shaffoflikSarlavha = new Label("Shaffoflik");
    Slider shaffoflik = new Slider(0, 1, 1);
    final Label shaffoflikQiymat = new Label(String.valueOf(shaffoflik.getValue()) + "0");

    Label sepiaSarlavha = new Label("Sepia ton");
    Slider sepiaTon = new Slider(0, 1, 1);
    final Label sepiaQiymat = new Label(String.valueOf(sepiaTon.getValue()) + "0");

    Label masshtabSarlavha = new Label("Masshtab");
    Slider masshtab = new Slider(0.3, 1, 1);
    final Label masshtabQiymat = new Label(String.valueOf(masshtab.getValue()) + "0");
    double i = 0.001;
    
    @Override
    public void start(Stage sahna) {
        Timeline davrOqi = new Timeline();
        davrOqi.setCycleCount(42*10);
        davrOqi.setAutoReverse(true);
        KeyFrame kalitRamka = new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                kappukino.setScaleX(i);
                kappukino.setScaleY(i);
                i += 0.005;
                masshtab.setDisable(true);
            }
        });
        davrOqi.getKeyFrames().add(kalitRamka);
        davrOqi.play();
        davrOqi.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                masshtab.setDisable(false);
            }
        });
        masshtab.setDisable(!true);
        sahna.setTitle("Rasm grafikasi");
        GridPane setka = new GridPane();
        setka.setPadding(new Insets(10, 10, 10, 10));
        setka.setHgap(70);
        setka.setVgap(10);

        setka.add(kappukino, 0, 0, 3, 1);

        setka.add(shaffoflikSarlavha, 0, 1);
        shaffoflik.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                kappukino.setOpacity(newValue.doubleValue());
                shaffoflikQiymat.setText(String.format("%.2f", newValue));
            }
        });
        setka.add(shaffoflik, 1, 1);
        setka.add(shaffoflikQiymat, 2, 1);

        final SepiaTone sepiaEffect = new SepiaTone();
        kappukino.setEffect(sepiaEffect);

        setka.add(sepiaSarlavha, 0, 2);
        sepiaTon.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sepiaEffect.setLevel(newValue.doubleValue());
                sepiaQiymat.setText(String.format("%.2f", newValue));
            }
        });
        setka.add(sepiaTon, 1, 2);
        setka.add(sepiaQiymat, 2, 2);

        setka.add(masshtabSarlavha, 0, 3);
        masshtab.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                kappukino.setScaleX(newValue.doubleValue());
                kappukino.setScaleY(newValue.doubleValue());
                masshtabQiymat.setText(String.format("%.1f", newValue));
            }
        });
        setka.add(masshtab, 1, 3);
        setka.add(masshtabQiymat, 2, 3);

        Group ildiz = new Group(setka);
        Scene epizod = new Scene(ildiz, Color.BLACK);
        epizod.getStylesheets().add("slayderyasash/Stil.css");
        sahna.setScene(epizod);
        sahna.show();
    }
}
