package ro.yxat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Collections;
public class RoYxat extends Application{
    
    private List<String> toplam = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage){
        Button saqlash = new Button("Qo'shish");
        Button korish = new Button("Listni ko'rish");
        Button tozalash = new Button("Tozalash");
        TextField matn = new TextField();
        matn.setMaxSize(200, 30);
        matn.setMinSize(200, 30);
        matn.setTranslateX(0);
        matn.setTranslateY(-50);
        korish.setTranslateY(50);
        tozalash.setTranslateY(100);
        
        saqlash.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                toplam.add(matn.getText());
                matn.setText("");
            }
        });
        
        korish.setOnAction((ActionEvent e) -> {
            Collections.sort(toplam);
            JOptionPane.showMessageDialog(null, toplam);
        });

        tozalash.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            toplam.clear();
        }
    });
        
        StackPane root = new StackPane();
        root.getChildren().add(saqlash);
        root.getChildren().add(matn);
        root.getChildren().add(korish);
        root.getChildren().add(tozalash);
        
        Scene scene = new Scene(root, 350, 300);
        
        primaryStage.setTitle("Ro'yxat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}