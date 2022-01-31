package skrolbar.yasash;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SkrolbarYasash extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ScrollBar");
        
        ScrollBar sb = new ScrollBar();
        sb.setMin(0);
        sb.setMax(100);
        sb.setValue(50);
        sb.setUnitIncrement(25);
        sb.setBlockIncrement(33);
        sb.setOrientation(Orientation.VERTICAL);
        
        StackPane ildiz = new StackPane(sb);
        ildiz.setPadding(new Insets(10, 10, 10, 10));
        
        Scene epizod = new Scene(ildiz, 250, 80);
        
        primaryStage.setResizable(false);
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
}
