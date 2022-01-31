package faylchoser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FaylChoser extends Application {
/*    
    @Override
    public void start(Stage primaryStage) {
        
        Button ochish = new Button("Ochish");
        final FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("D:\\"));
        chooser.setTitle("Rasm tanlang");
        
        final ImageView imageView = new ImageView();
        imageView.setFitWidth(250);
        imageView.setFitHeight(250);
        imageView.setPreserveRatio(true);
        
        
        ochish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File f = chooser.showOpenDialog(null);
                if(f!=null){
                Image img = new Image("file:"+f);
                imageView.setImage(img);
                } else { 
                    return;
                }
                
            }
        });
        
        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPG fayllar", "*.jpg"),
            new FileChooser.ExtensionFilter("GIF fayllar", "*.gif"),
            new FileChooser.ExtensionFilter("BMP fayllar", "*.bmp"),
            new FileChooser.ExtensionFilter("PNG fayllar", "*.png"),
            new FileChooser.ExtensionFilter("Barcha fayllar", "*.*")
        );
        
        VBox vb = new VBox(10, ochish, imageView);
        vb.setPadding(new Insets(10));
        primaryStage.setTitle("Rasm ochish");
        primaryStage.setScene(new Scene(vb, 300, 300));
        primaryStage.show();
        
    }*/
    
    
    
    @Override
    public void start(Stage sahna){
        final TextArea matnOrni = new TextArea();
        Button faylSaqlash = new Button("Saqlash");
        
        final FileChooser fc = new FileChooser();
        fc.setTitle("Saqlang");
        faylSaqlash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File f = fc.showSaveDialog(null);
                if(f!=null){
                    try {
                        FileOutputStream saqlash = new FileOutputStream(f);
                        saqlash.write(matnOrni.getText().getBytes());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FaylChoser.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FaylChoser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {return;}
            }
        });
        VBox vb = new VBox(10, matnOrni, faylSaqlash);
        vb.setPadding(new Insets(10));
        sahna.setScene(new Scene(vb));
        sahna.show();
    }
}