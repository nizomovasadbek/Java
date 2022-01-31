package pkg1media;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
public class Unit2Class extends Application {
    @Override
    public void start(Stage primaryStage){
        
        Group root = new Group();
        
        Scene scene = new Scene(root, 300, 400);
        
        primaryStage.setTitle("Ikkinchi oyna");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}