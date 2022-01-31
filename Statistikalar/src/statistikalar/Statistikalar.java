package statistikalar;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Statistikalar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        x.setAnimated(true);
        x.setLabel("Sarmoya");
        y.setAnimated(true);
        y.setLabel("Vaqt");
        y.setSide(Side.TOP);
        
        
        BubbleChart bc = new BubbleChart(x, y);
        
        bc.getData().add(new XYChart.Data<Number, Number>(5,15));
        Group gr = new Group(bc);
        Scene sc = new Scene(gr);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}