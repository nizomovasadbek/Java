package muntazam.ifodalari;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import javax.swing.JOptionPane;
public class MuntazamIfodalari extends Application {
    
    private String muntazamIfodalar = "";
    private String matn = "";
    String c = "";
    
    @Override
    public void start(Stage primaryStage){
        Label malumotlarniEkrangaChiqaruvchi = new Label();
        Label nishon = new Label("Matnni kiriting");
        Button tekshiruvniBoshlash = new Button("Tekshiruvni boshlash");
        TextField kiritish = new TextField();
        tekshiruvniBoshlash.setTranslateX(100);
        tekshiruvniBoshlash.setTranslateY(100);
        kiritish.setTranslateY(30);
        kiritish.setMaxWidth(300);
        kiritish.setMinWidth(300);
        nishon.setTranslateX(70);
        
        tekshiruvniBoshlash.setOnAction((ActionEvent e) -> {
            matn = kiritish.getText();
            muntazamIfodalar = JOptionPane.showInputDialog(null, "Matn ichidan qidiriluvchi so'zni kiriting");
            Pattern tartib = Pattern.compile(muntazamIfodalar);
            Matcher moslik = tartib.matcher(matn);
            int sanoq=0;
            while(moslik.find()){
                sanoq++;
                c += sanoq + ") " + moslik.start() + "~" + moslik.end() + " oraliqda moslik topildi.\n";
            }
            JOptionPane.showMessageDialog(null, c, "Muntazam Ifodalar", 2);
            JOptionPane.showMessageDialog(null, "Ja'mi " + sanoq + " ta moslik topildi.");
            kiritish.setText("");
        });
        
        Group root = new Group(tekshiruvniBoshlash, kiritish, nishon);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Muntazam ifodalar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}