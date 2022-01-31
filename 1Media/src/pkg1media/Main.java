package pkg1media;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Main extends Application {
    
    private ObservableList ismlar = FXCollections.observableArrayList();
    private ObservableList malumotlar = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage){
        ismlar.addAll("Abdurahmon", "Abdullox", "Ali", "Davron", "Bahrom", "Abdurahmon", "Erkin", "Elyos"
        ,"Samandar", "Holid", "Asliddin", "Asilbek");
        for(int i =0 ; i < 18; i++)
            malumotlar.add("ismsiz");
        ListView list = new ListView(malumotlar);
        list.setEditable(true);
        list.setCellFactory(ComboBoxListCell.forListView(ismlar));
        
        StackPane ildiz = new StackPane(list);
        
        Scene scene = new Scene(ildiz);
        
        primaryStage.setTitle("'ListView'Cell factory bilan ishlash");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}