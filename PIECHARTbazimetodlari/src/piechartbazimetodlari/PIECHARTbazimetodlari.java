package piechartbazimetodlari;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class PIECHARTbazimetodlari extends Application {
    
/*    @Override
    public void start(Stage primaryStage) {
        ObservableList<PieChart.Data> pirogmalumotlari = FXCollections.observableArrayList(
            new PieChart.Data("Uzum", 13),
            new PieChart.Data("Apelsin", 25),
            new PieChart.Data("Olxo'ri", 10),
            new PieChart.Data("Shaftoli", 22),
            new PieChart.Data("Olma", 30)
        );
        PieChart pirog = new PieChart(pirogmalumotlari);
        
        for(final PieChart.Data bolak:pirogmalumotlari){
            bolak.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    InnerShadow soya = new InnerShadow();
                    bolak.getNode().setEffect(soya);
                }
            });
            bolak.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    bolak.getNode().setEffect(null);
                }
            });
        }
        
        pirog.setTitle("Harid qilingan mevalar");
        primaryStage.setTitle("PieChart");
        primaryStage.show();
        primaryStage.setScene(new Scene(pirog));
    }*/
    
    @Override
    public void start(Stage sahna){
        ObservableList<PieChart.Data> malumotlar = FXCollections.observableArrayList(
                new PieChart.Data("A", 40),
                new PieChart.Data("B", 22),
                new PieChart.Data("C", 15),
                new PieChart.Data("D", 30)
        );
        PieChart pc = new PieChart(malumotlar);
        pc.setTitle("Bizning diagramma");
        final Label izoh = new Label();
        izoh.setTextFill(Color.WHITE);
        izoh.setFont(Font.font("Arial",FontWeight.BOLD, 20));
        
        for(final PieChart.Data bolak:malumotlar){
            bolak.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    String qiymat = bolak.getPieValue() + "%";
                    izoh.setText(qiymat);
                    izoh.setTranslateX(event.getX());
                    izoh.setTranslateY(event.getY());
                    
                }
            });
        }
        StackPane ildiz = new StackPane(pc, izoh);
        sahna.setScene(new Scene(ildiz));
        sahna.setTitle("Piechart");
        sahna.show();
    };
}