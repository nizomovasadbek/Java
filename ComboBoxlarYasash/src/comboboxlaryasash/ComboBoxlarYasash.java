package comboboxlaryasash;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComboBoxlarYasash extends Application {
    
    private final Button tugma = new Button("Jo'natish");
    private final Label bildirgich = new Label();
    private final TextField mavzu = new TextField();
    private final TextArea hat = new TextArea();
    private String manzil = "";
    
    
    @Override
    public void start(Stage primaryStage) {
        final ComboBox ePochtacombobox = new ComboBox();
        ePochtacombobox.getItems().addAll(
                "ihtiyor.kahandirov@misol.com",
                "tavakkal.dehqonov@misol.com",
                "murodjon.usmonov@misol.com",
                "javohir.azizov@misol.com",
                "qobiljon.yusupov@misol.com",
                "umidjon.xolmirzayev@misol.com",
                "lutfidin.sobirov@misol.com",
                "rustam.ganijonov@misol.com"
        );
        ePochtacombobox.setMaxWidth(400);
        ePochtacombobox.setVisibleRowCount(3);
        ePochtacombobox.setPromptText("Elektron pochta");
        
        GridPane setka = new GridPane();
        setka.setAlignment(Pos.CENTER);
        setka.setHgap(4);
        setka.setVgap(4);
        setka.setPadding(new Insets(5, 5, 5, 5));
        setka.add(new Label("Kimga: "), 0, 0);
        setka.add(ePochtacombobox, 1, 0);
        setka.add(new Label("Mavzu: "), 0, 1);
        setka.add(mavzu, 1, 1);
        setka.add(hat, 0, 2, 2, 1);
        setka.add(tugma, 0, 3);
        setka.add(bildirgich, 1, 3);
        
        ePochtacombobox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                manzil = newValue;
            }
        });
        
        tugma.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ePochtacombobox.getValue()!=null){
                    bildirgich.setText("Xabar \"" + manzil + "\" ga muvaffiqiyatli yuborildi.");
                    mavzu.clear();
                    hat.clear();
                } else {
                    bildirgich.setText("Elektron pochta manzili kiritilmagan");
                }
            }
        });
        
        hat.setPromptText("Hat matnini yozing");
        mavzu.setPromptText("Matnni mavzusini kiriting");
        
        primaryStage.setScene(new Scene(setka, 450, 250));
        primaryStage.setTitle("Xat jo'natish dasturi");
        primaryStage.show();
    }
}