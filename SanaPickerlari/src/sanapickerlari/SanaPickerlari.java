package sanapickerlari;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.HijrahChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;
import com.sun.javafx.PlatformUtil;

public class SanaPickerlari extends Application {
    @Override
    public void start(Stage primaryStage){
        String format = "yyyy-MM-dd";
        
        StringConverter konvert = new StringConverter<LocalDate>() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            
            @Override
            public String toString(LocalDate sana) {
                if(sana != null){
                    return formatter.format(sana);
                } else { return ""; }
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && string.isEmpty()){
                    return LocalDate.parse(string, formatter);
                } else return null;
            }
        };
        
        primaryStage = new Stage(StageStyle.DECORATED);
        DatePicker dp = new DatePicker();
//        dp.setConverter(konvert);
        dp.setChronology(HijrahChronology.INSTANCE);
        dp.setValue(LocalDate.of(2003, Month.AUGUST, 2));
        primaryStage.setScene(new Scene(dp));
        primaryStage
                .show(); }
    
    /*@Override
    public void start(Stage primaryStage){
        System.out.println(PlatformUtil.isWindows());
        final DatePicker dp1  = new DatePicker(LocalDate.now());
        final DatePicker dp2  = new DatePicker();
        
        final Callback<DatePicker, DateCell> kun = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                return new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty){
                        super.updateItem(item, empty);
                        if(item.isBefore(dp1.getValue().plusDays(1))){
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb");
                        }
                    }
                };
            }
        };
        dp2.setDayCellFactory(kun);
        
        VBox vb = new VBox(5, new Label("Kelish sanasi"), dp1, new Label("Ketish sanasi"), dp2);
        vb.setPadding(new Insets(10));
        
        primaryStage.setTitle("Muzlatish");
        primaryStage.setScene(new Scene(vb));
        primaryStage.show();
    }*/
}