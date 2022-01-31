package tablejadvallar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Tablejadvallar extends Application {
    
    private ObservableList<Shaxs> malumotlar = FXCollections.observableArrayList(
            new Shaxs("Asadbek", "Nizomov", "nizomovasadbekjava@gmail.com"),
            new Shaxs("Shokir", "Ibrohimov", "ibrohimovshokir2002@gmail.com"),
            new Shaxs("Xurshid", "Sherqulov", "sherqulovxurshidbek1206@gmail.com"),
            new Shaxs("Samandar", "Po'latov", "samandarpolatov@email.com"),
            new Shaxs("Nodir", "Ergashev", "nodirbek2017@gmail.com"),
            new Shaxs("Madina", "Xatamova", "xatamovamadina@gmail.com"),
            new Shaxs("Yulduz", "Nizomova", "nizomovayulduz@gmail.com"),
            new Shaxs("Samandar", "Haydarov", "xaydarovsamanchik@gmail.com"),
            new Shaxs("Dilrabo", "Yusupova", "dilraboyusupova1223@gmail.com")
    );
    
    @Override
    public void start(Stage primaryStage) {
        Pattern tartib = Pattern.compile("[A-Za-z]{1,}(\\.)?[A-Za-z]{1,}@[A-Za-z]{1,10}\\.[A-Za-z]{1,5}",
                Pattern.UNICODE_CASE);
        
        Label label = new Label("Manzillar kitobi");
        label.setFont(new Font("Serif", 20));
        
        TableColumn idUstuni = new TableColumn("Shaxs ID");
        idUstuni.setCellValueFactory(new PropertyValueFactory("id"));
        
        TableColumn ismiUstuni = new TableColumn("Ismi");
        ismiUstuni.setCellValueFactory(new PropertyValueFactory("ismi"));
//        ismiUstuni.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Shaxs, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<Shaxs, String> event) {
//                ((Shaxs) event.getTableView().getItems()
//                        .get(event.getTablePosition().getRow()))
//                        .setIsmi(event.getNewValue());
//            }
//        });
        
        TableColumn sharifiUstuni = new TableColumn("Sharifi");
        sharifiUstuni.setPrefWidth(130);
        sharifiUstuni.setCellValueFactory(new PropertyValueFactory("sharifi"));
        
        TableColumn ePochtaUstuni = new TableColumn("E-Pochta");
        ePochtaUstuni.setCellValueFactory(new PropertyValueFactory("ePochtasi"));
        TableColumn jinsiUstuni = new TableColumn("Jinsi");
        jinsiUstuni.setCellValueFactory(new PropertyValueFactory("jinsi"));
        jinsiUstuni.setVisible(false);
        
        TableView jadval = new TableView();
        jadval.getColumns().addAll(idUstuni, ismiUstuni, sharifiUstuni, ePochtaUstuni, jinsiUstuni);
        jadval.setItems(malumotlar);
        
        final TextField ismQoshish = new TextField();
        ismQoshish.setPromptText("Ism kiriting");
        ismQoshish.setMaxWidth(90);
        
        final TextField sharifQoshish = new TextField();
        sharifQoshish.setPromptText("Sharif kiriting");
        sharifQoshish.setMaxWidth(90);
        
        final TextField ePochtaQoshish = new TextField();
        ePochtaQoshish.setPromptText("E-Pochta");
        ePochtaQoshish.setMaxWidth(90);
        
        Button qoshish = new Button("Qo'shish");
        qoshish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Matcher mostlik = tartib.matcher(ePochtaQoshish.getText());
                if(mostlik.find()){
                malumotlar.add(new Shaxs(ismQoshish.getText(), sharifQoshish.getText(), ePochtaQoshish.getText()));
                ismQoshish.clear();
                sharifQoshish.clear();
                ePochtaQoshish.clear();
                }
                else JOptionPane.showMessageDialog(null, "Elektron pochta xato kiritildi");
            }
        });
        
        HBox hb = new HBox(10, ismQoshish, sharifQoshish, ePochtaQoshish, qoshish);
        
        TextField filtermatn = new TextField();
        filtermatn.setPromptText("Filterlash");
        filtermatn.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(filtermatn.textProperty().get().isEmpty()){
                    jadval.setItems(malumotlar);
                    return;
                }
                ObservableList filter = FXCollections.observableArrayList();
                ObservableList<TableColumn> ustunlar = jadval.getColumns();
                for(int i = 0; i < malumotlar.size(); i++){
                    for(int j = 0; j < ustunlar.size(); j++){
                        TableColumn ustun = ustunlar.get(j);
                        String yacheyka = ustun.getCellData(malumotlar.get(i)).toString();
                        yacheyka = yacheyka.toLowerCase();
                        if(yacheyka.contains(filtermatn.textProperty().get().toLowerCase())){
                            filter.add(malumotlar.get(i));
                            break; 
                        }
                    }
                }
                jadval.setItems(filter);
            }
        });
        
        VBox vb = new VBox(5, label, jadval, filtermatn, hb);
        vb.setPadding(new Insets(10));
        
        Scene epizod = new Scene(vb, 550, 450);
        primaryStage.setTitle("Jadvallar bilan ishlash");
        primaryStage.setScene(epizod);
        primaryStage.show();
    }
}