package ro.yxat;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
public class Rasmlar extends Application{
    
    @Override
    public void start(Stage pr){
        ImageView rasm = new ImageView(new Image(getClass().getResourceAsStream("package_games_board.png")));
        
        StackPane root = new StackPane();
        root.getChildren().add(rasm);
        
        Scene scene = new Scene(root, 400, 300);
        
        pr.setTitle("Rasmlar");
        pr.setScene(scene);
        pr.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}