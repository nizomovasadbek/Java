package delphi.loyiha;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXListCell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;

/**
 * WRITE ONCE RUN ANYWHERE
 * @author Asadbek
 */
public class DelphiLoyiha extends Application {
    
    protected final int ENI = 400;
    protected final int BOYI = 400;
    
    protected void btnInit(JFXButton btn){
        btn.setFont(Font.font("Comic Sans MS", 18));
        btn.setRipplerFill(Color.RED);
        btn.setStyle("-fx-background-color: lightblue; -fx-background-radius: 25;");
        btn.setMinWidth(110);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primary_stage) {
        ImageView fon = new ImageView(new Image(getClass().getResourceAsStream("fon.jpg")));
        fon.setFitWidth(ENI);
        fon.setFitHeight(BOYI);
        
        JFXButton kirish = new JFXButton("Delphi");
        kirish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                apply_scene(primary_stage);
            }
        });
        
        JFXButton haqida = new JFXButton("Dasturchi");
        JFXButton chiqish = new JFXButton("Chiqish");
        btnInit(kirish);
        btnInit(haqida);
        btnInit(chiqish);
        
        chiqish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primary_stage.close();
            }
        });
        
        VBox hb =  new VBox(15, kirish, haqida, chiqish);
        
        Group root = new Group(fon, hb);
        hb.setPadding(new Insets(10));
        hb.setTranslateX((ENI/2)-60);
        hb.setTranslateY((BOYI/2)-90);
        hb.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, ENI, BOYI);
        
        primary_stage.setWidth(ENI);
        primary_stage.setHeight(BOYI);
        primary_stage.setResizable(false);
        primary_stage.setScene(scene);
        primary_stage.setTitle("Delphi");
        primary_stage.getIcons().clear();
        primary_stage.getIcons().add(new Image(getClass().getResourceAsStream("Grafik.png")));
        primary_stage.show();
    }
    
    protected void apply_scene(Stage primary_stage){
       VBox vb = new VBox(10);
       Scene scene = new Scene(vb, ENI, BOYI);
       primary_stage.setTitle("Delphi darslari");
       
       JFXButton soat = new JFXButton("SOAT");
        btnInit(soat);
       soat.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
                get_engine_from_html("soat", primary_stage);
           }
       });
       vb.getChildren().add(soat);
       primary_stage.setScene(scene);
    }
    protected void get_engine_from_html(String path, Stage primary_stage){
        WebView view  = new WebView();
        view.applyCss();
        WebEngine engine = view.getEngine();
        String line = "";
        String s = "";
        
        try{
        File f = new File("src\\delphi\\loyiha\\" + path + ".html");
        FileReader fr = new FileReader(f);
        BufferedReader buffer = new BufferedReader(fr);
        while((line=buffer.readLine()) != null){
            s += line;
        }
        } catch(FileNotFoundException e){
            System.err.println("Fayl topilmadi.");
        } catch(IOException e){
            System.err.println("Xatolik");
        }
        engine.loadContent(s);
        
        primary_stage.setScene(new Scene(view, ENI, BOYI));
    }
}