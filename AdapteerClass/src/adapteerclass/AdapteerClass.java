package adapteerclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AdapteerClass extends Application {
    
    public static ObservableList list = FXCollections.observableArrayList();
    public static ConnectionWithDB db = new ConnectionWithDB();
    private ObservableList malumotlar = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage){
        TextField filter = TextFieldBuilder.create()
                .promptText("Filter")
                .maxWidth(90)
                .build();
        
        
        for(int i = 0; i < db.list1.size(); i++){
            malumotlar.add(new lugat(db.list1.get(i), db.list2.get(i), db.list3.get(i), db.list4.get(i)));
        }
        TableColumn idUst = new TableColumn("AKT ID");
        idUst.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn nomiUst = new TableColumn("Nomi");
        nomiUst.setCellValueFactory(new PropertyValueFactory("nomi"));
        TableColumn engUst = new TableColumn("English");
        engUst.setCellValueFactory(new PropertyValueFactory("eng"));
        TableColumn rusUst = new TableColumn("Russia");
        rusUst.setCellValueFactory(new PropertyValueFactory("rus"));
        TableColumn izohUst = new TableColumn("Comment");
        izohUst.setCellValueFactory(new PropertyValueFactory("izoh"));
        
        TableView jadval = new TableView();
        jadval.getColumns().addAll(idUst, nomiUst, engUst, rusUst, izohUst);
        jadval.setItems(malumotlar);
        
        CheckBox cb = CheckBoxBuilder.create()
                .text("Jadval")
                .build();
        
        WebView nat =new WebView();
        nat.setDisable(true);
        WebEngine engine = nat.getEngine();
        
        ListView listView = new ListView(list);
        
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int i = newValue.intValue();
                String satr = "<html><body><font color=\"red\">"+db.list2.get(i) +"</font><br>"
                        + "<font color=\"blue\">"+ db.list3.get(i) + "</font><br><font color=\"green\">" 
                        + db.list4.get(i) + "</font></body></html>";
                engine.loadContent(satr);
            }
        });
        
        jadval.setPrefWidth(600);
        
        HBox hb = new HBox(20, listView, nat);
        VBox vb  = new VBox(20, hb, cb);
        vb.setPadding(new Insets(10));
        
        cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    hb.getChildren().clear();
                    hb.getChildren().addAll(jadval);
                } else {
                    hb.getChildren().clear();
                    hb.getChildren().addAll(listView, nat);
                }
            }
        });
        
        Scene scene = new Scene(vb);
        
        primaryStage.setTitle("AKT Izohli lug'at");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String args[]){
        for(String x:db.list1){
            list.add(x);
        }
        launch(args);
    }
}

class ConnectionWithDB{
    public Statement stmt;
    public List<String> list1 = new ArrayList<>();
    public List<String> list2 = new ArrayList<>();
    public List<String> list3 = new ArrayList<>();
    public List<String> list4 = new ArrayList<>();
    private Connection conn = null;
    public void connect(){
        String url = "jdbc:sqlite:D:\\conn.db";
        String sql = "SELECT * FROM base";
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Baza bilan aloqa ulandi.");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                
                list1.add(rs.getString("nomi"));
                list2.add(rs.getString("eng"));
                list3.add(rs.getString("rus"));
                list4.add(rs.getString("izoh"));
            }
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException e){
            System.out.println("Malumotlar omborida xatolik");
        }
    }
    public ConnectionWithDB(){
        connect();
    }
}