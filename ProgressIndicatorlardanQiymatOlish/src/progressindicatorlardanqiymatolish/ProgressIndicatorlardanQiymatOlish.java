package progressindicatorlardanqiymatolish;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProgressIndicatorlardanQiymatOlish extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CheckBox cb = new CheckBox("Aniqlanmagan");
        cb.setSelected(false);
        
        Slider slider = new Slider(0, 1, .2);
        slider.setBlockIncrement(0.05);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.5);
        slider.setMinorTickCount(4);
        
        ProgressBar pb = new ProgressBar(slider.getValue());
        
        ProgressIndicator pi = new ProgressIndicator(slider.getValue());
        
        cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    slider.setDisable(true);
                    pb.setProgress(-1);
                    pi.setProgress(-1);
                } else {
                    slider.setDisable(false);
                    pb.setProgress(slider.getValue());
                    pi.setProgress(slider.getValue());
                }
            }
        });
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pb.setProgress(slider.getValue());
                pi.setProgress(slider.getValue());
            }
        });
        
        GridPane setka = new GridPane();
        setka.setHgap(20);
        setka.setVgap(20);
        setka.setPadding(new Insets(10, 10, 10, 10));
        setka.setAlignment(Pos.CENTER);
        setka.add(cb, 4, 0);
        setka.add(slider, 0, 0, 3, 1);
        setka.add(pb, 0, 1, 3, 1);
        setka.add(pi, 1, 2);
        
        Scene epziod = new Scene(setka);
        
        primaryStage.setTitle("Dastur");
        primaryStage.setScene(epziod);
        primaryStage.show();
    }
}
