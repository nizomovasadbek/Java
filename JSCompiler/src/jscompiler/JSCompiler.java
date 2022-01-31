package jscompiler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.script.*;

/**
 * WRITE ONCE RUN ANYWHERE
 *
 * @author User
 */
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class JSCompiler extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        JFXButton run = new JFXButton();
        run.setButtonType(JFXButton.ButtonType.RAISED);
        run.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("playbutton.png"))));
        JFXTextArea ta = new JFXTextArea();
        TextArea log = new TextArea();
        log.setEditable(false);
        ta.setDisableAnimation(Boolean.FALSE);
        VBox vb = new VBox(10, run, ta, log);
        
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        
        run.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    log.setText(engine.eval(ta.getText()).toString());
                } catch (ScriptException ex) {
                    Logger.getLogger(JSCompiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        ImageView iv = new ImageView("https://upload.wikimedia.org/"
//                + "wikipedia/commons/f/f9/Phoenicopterus_ruber_in_S%C3%A3o_Paulo_Zoo.jpg");
//        ScrollPane sp = new ScrollPane(iv);
//        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        run.setPrefSize(40, 40);
        run.setStyle("-fx-background-color: lightblue");
        run.setRipplerFill(Color.RED);

        Pane p = new Pane(vb);
        p.setPadding(new Insets(10));
        Scene scene = new Scene(p, 400, 400);
        primaryStage.setTitle("JS Kompliyator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
