package chartlar;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class Chartlar extends Application {

    @Override
    public void start(Stage primaryStage) {
        NumberAxis xOqi = new NumberAxis();
        xOqi.setLabel("Oylar");
        NumberAxis yOqi = new NumberAxis();
        yOqi.setLabel("Harorat");
        
//        BubbleChart bizningDiagramma = new BubbleChart(xOqi, yOqi);
        AreaChart bizningDiagramma = new AreaChart(xOqi, yOqi);
//        ScatterChart bizningDiagramma = new ScatterChart(xOqi, yOqi);
        
        ObservableList<XYChart.Data> malumotlarA = FXCollections.observableArrayList(
            new XYChart.Data(5, 12),
            new XYChart.Data(10, 15),
            new XYChart.Data(15, 20),
            new XYChart.Data(20, 15),
            new XYChart.Data(25, 25),
            new XYChart.Data(30, 10)
        );
        
        XYChart.Series qatorA = new XYChart.Series("A", malumotlarA);
        bizningDiagramma.getData().addAll(qatorA);
        primaryStage.setTitle("Diagramma");
        primaryStage.setScene(new Scene(bizningDiagramma));
        primaryStage.show();
    }
}
