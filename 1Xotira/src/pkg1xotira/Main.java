package pkg1xotira;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Callback;
import java.time.chrono.HijrahDate;

public class Main extends Application{
    
    private HijrahDate hijriy = HijrahDate.now();
    private ObservableList malumotlar = FXCollections.observableArrayList(
      "black", "blue", "red", "wheat", "white", "chocolate", "yellow", "pink"
     ,"grey", "brown", "orange", "purple"
    );
    
    protected final Label label = new Label();
    
    private ListView<String> royxat = new ListView<String>(malumotlar);
    protected VBox box = new VBox(royxat, label);
    
    class RangliTortburchak extends ListCell<String>{
        @Override
        public void updateItem(String item, boolean empty){
            super.updateItem(item, empty);
            Rectangle tortburchak = new Rectangle(200, 20);
            if(item!=null){
                tortburchak
                        .setFill(Color.web(item));
                setGraphic(tortburchak);
            }
        }
    }
    
    @Override
    public void start(Stage sahna){
        label.setFont(new Font("Arial", 18));
        royxat.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new RangliTortburchak();
            }
        });
        
        royxat.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                label.setText(newValue);
                label.setTextFill(Color.web(newValue));
            }
        });
        
        sahna.setScene(new Scene(box));
        sahna.setTitle("Ranglar bilan ishlash");
        sahna.show();
    }
    
    public static void main(String[] args) {
        launch(args);
}
}