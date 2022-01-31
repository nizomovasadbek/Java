package togglebuttonlarvastackpane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class ToggleButtonlarVaStackPane extends Application {
    
    @Override
    public void start(Stage asosiySahna) {
        asosiySahna.setTitle("'ToggleButton'ga na'muna");
        
        final ToggleGroup guruh = new ToggleGroup();
        
        ToggleButton tb1 = new ToggleButton("Muhim emas");
        tb1.setToggleGroup(guruh);
        
        ToggleButton tb2 = new ToggleButton("O'rtacha");
        tb2.setToggleGroup(guruh);
        tb2.setTranslateX(95);
        
        ToggleButton tb3 = new ToggleButton("O'ta muhim");
        tb3.setToggleGroup(guruh);
        tb3.setTranslateX(170);
        
        tb1.setUserData(Color.LIGHTGREEN);
        tb2.setUserData(Color.YELLOW);
        tb3.setUserData(Color.SALMON);
        
        tb1.setStyle("-fx-base: lightgreen");
        tb2.setStyle("-fx-base: yellow");
        tb3.setStyle("-fx-base: salmon");
        
        final Rectangle tortburchak = new Rectangle(250, 50, Color.WHITE);
        tortburchak.setStroke(Color.web("#a9a9a9"));
        tortburchak.setStrokeWidth(2);
        tortburchak.setArcHeight(10);
        tortburchak.setArcWidth(10);
        tortburchak.setTranslateY(30);
        
        guruh.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue == null)
                    tortburchak.setFill(Color.WHITE);
                else
                    tortburchak.setFill(
                     (Color) guruh.getSelectedToggle().getUserData()
                    );
            }
        });
        
        StackPane root = new StackPane(tb1, tb2, tb3, tortburchak);
        root.setAlignment(Pos.TOP_LEFT);
        root.setPadding(new Insets(10, 10, 10, 10));
        
        Scene epizod = new Scene(root, 270, 100);
        
        asosiySahna.setScene(epizod);
        asosiySahna.show();
    }
}