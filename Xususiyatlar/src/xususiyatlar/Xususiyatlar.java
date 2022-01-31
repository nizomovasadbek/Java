package xususiyatlar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.transform.Rotate;

public class Xususiyatlar extends Application {
    
    @Override
    public synchronized void start(Stage primaryStage) {
        MenuItem mi = new MenuItem("Chiqish");
        Menu m = new Menu("File");
        m.getItems().add(mi);
        MenuBar mb = new MenuBar(m);
        mb.setTranslateY(-115);
        
        mi.setMnemonicParsing(true);
        
        
        final ScrollBar forRotate = new ScrollBar();
        forRotate.setBlockIncrement(1);
        forRotate.setUnitIncrement(1);
        forRotate.setTooltip(new Tooltip("Aylantirish"));
        forRotate.setMin(0);
        forRotate.setMax(10)
                ;
        forRotate.setValue(10);
        forRotate.setTranslateY(50);

        final Button btn = new Button();
        btn.setTranslateY(-50);
        btn.setText("Say 'Hello World'");
        btn.setSnapToPixel(true);
        btn.setBorder(Border.EMPTY);
        btn.setStyle("-fx-background-color: #A8e345;"
                + "-fx-background-radius: 50;");
        
        StackPane root = new StackPane(forRotate);
        root.getChildren().addAll(btn, mb);
        
        Scene scene = new Scene(root, 300, 250, Color.BLACK);
        mi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        forRotate.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                btn.setOpacity(newValue.doubleValue() / 10);
            }
        });
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
