package parol; // Programma parol
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
public class Parol extends Application{
    @Override
    public void start(Stage primaryStage){
        Label nishon = new Label("Parolni kiriting");
        Button btn = new Button("Kiritish");
        PasswordField kiritilishMaydoni = new PasswordField();
        nishon.setTranslateY(-100);
        btn.setTranslateY(-50);
        kiritilishMaydoni.setMaxSize(170, 25);
        kiritilishMaydoni.setMinSize(170, 25);
        
        btn.setOnAction((ActionEvent e) -> {
            if(kiritilishMaydoni.getText().equalsIgnoreCase("Java"))
                JOptionPane.showMessageDialog(null, "Javob to'g'ri");
            else
                JOptionPane.showMessageDialog(null, "Javob noto'g'ri");
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(nishon);
        root.getChildren().add(btn);
        root.getChildren().add(kiritilishMaydoni);
        
        Scene scene = new Scene(root, 500, 400);
        
        primaryStage.setTitle("Parol");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
