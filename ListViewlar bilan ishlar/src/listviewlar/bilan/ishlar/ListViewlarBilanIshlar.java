package listviewlar.bilan.ishlar;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListViewlarBilanIshlar extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage Sahna) {
        ListView<String> royxat = new ListView();
        ObservableList<String> qismlar = FXCollections.observableArrayList(
          "Bir kishilik", "Ikki kishilik", "Juftlik", "Oilaviy"
        );
        royxat.setItems(qismlar);
        royxat.setPrefSize(100, 70);
        royxat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        StackPane ildiz = new StackPane(royxat);
        
        Scene epizod = new Scene(ildiz);
        
        Sahna.setTitle("ListView");
        Sahna.setScene(epizod);
        Sahna.show();
    }
}