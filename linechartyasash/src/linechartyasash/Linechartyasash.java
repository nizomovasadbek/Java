package linechartyasash;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Linechartyasash extends Application {

    @Override
    public void start(Stage primaryStage) {
        CategoryAxis xOqi = new CategoryAxis();
        xOqi.setLabel("Oylar");
        NumberAxis yOqi = new NumberAxis();
        yOqi.setLabel("Ko'rilganlar soni");
        LineChart chiziqliDiagramma = new LineChart(xOqi, yOqi);
        chiziqliDiagramma.setTitle("Bizning chiziqli diagramma");

        ObservableList<XYChart.Data> malumotlar = FXCollections.observableArrayList(
                new XYChart.Data<>("Yanvar", 350),
                new XYChart.Data<>("Fevral", 500),
                new XYChart.Data<>("Mart", 200),
                new XYChart.Data<>("Aprel", 450),
                new XYChart.Data<>("May", 300),
                new XYChart.Data<>("Iyun", 250),
                new XYChart.Data<>("Iyul", 440),
                new XYChart.Data<>("Avgust", 150),
                new XYChart.Data<>("Sentyabr", 430),
                new XYChart.Data<>("Oktabr", 215),
                new XYChart.Data<>("Noyabr", 510),
                new XYChart.Data<>("Dekabr", 200)
        );

        XYChart.Series s = new XYChart.Series<>();
        s.getData().addAll(malumotlar);
        ObservableList<XYChart.Data> malumotlar1 = FXCollections.observableArrayList(
                new XYChart.Data<>("Yanvar", 300),
                new XYChart.Data<>("Fevral", 350),
                new XYChart.Data<>("Mart", 300),
                new XYChart.Data<>("Aprel", 450),
                new XYChart.Data<>("May", 300),
                new XYChart.Data<>("Iyun", 250),
                new XYChart.Data<>("Iyul", 400),
                new XYChart.Data<>("Avgust", 250),
                new XYChart.Data<>("Sentyabr", 430),
                new XYChart.Data<>("Oktabr", 210),
                new XYChart.Data<>("Noyabr", 110),
                new XYChart.Data<>("Dekabr", 500)
        );

        XYChart.Series s1 = new XYChart.Series<>();
        s1.getData().addAll(malumotlar1);
        ObservableList<XYChart.Data> malumotlar2 = FXCollections.observableArrayList(
                new XYChart.Data<>("Yanvar", 400),
                new XYChart.Data<>("Fevral", 450),
                new XYChart.Data<>("Mart", 400),
                new XYChart.Data<>("Aprel", 250),
                new XYChart.Data<>("May", 100),
                new XYChart.Data<>("Iyun", 350),
                new XYChart.Data<>("Iyul", 200),
                new XYChart.Data<>("Avgust", 550),
                new XYChart.Data<>("Sentyabr", 130),
                new XYChart.Data<>("Oktabr", 410),
                new XYChart.Data<>("Noyabr", 310),
                new XYChart.Data<>("Dekabr", 50)
        );

        XYChart.Series s2 = new XYChart.Series<>();
        s2.getData().addAll(malumotlar2);
        chiziqliDiagramma.getData().addAll(s, s1, s2);
        s.setName("Javadan boshlang'ich darslar");
        s1.setName("Javadan kuchaytirilgan darslar");
        s2.setName("JavaFX da FGI yasash");

        primaryStage.setScene(new Scene(chiziqliDiagramma));
        primaryStage.setTitle("Chiziqli diagrammaga na'muna");
        primaryStage.show();
    }
}
