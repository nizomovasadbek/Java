package kalendarg;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class KalendarG extends Application {
    
    @Override
    public void start(Stage sahna){
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Kunlar");
        yAxis.setLabel("Ballar");
        
        AreaChart ac = new AreaChart(xAxis, yAxis);
        
        ObservableList<XYChart.Data> malumotlar = FXCollections.observableArrayList(
            new XYChart.Data(5, 14),
            new XYChart.Data(7, 15),
            new XYChart.Data(10, 11),
            new XYChart.Data(13, 3),
            new XYChart.Data(18, 34),
            new XYChart.Data(31, 31)
        );
        
        XYChart.Series ser = new XYChart.Series("Yugurish marafoni", malumotlar);
        xAxis.setAnimated(true);
        ac.getData().add(ser);
        
        sahna.setTitle("Yugurish marafoni");
        sahna.setScene(new Scene(ac));
        sahna.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}