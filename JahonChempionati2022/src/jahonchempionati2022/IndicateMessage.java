package jahonchempionati2022;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class IndicateMessage extends Application {

    private static String xabar = "";
    
    public static void Message(String text){
        xabar = text;
        Stage asosiySahna = new Stage();
        IndicateMessage im = new IndicateMessage();
        im.start(asosiySahna);
    }
    
    @Override
    public void start(Stage asosiySahna) {
        Button moreButton = new Button("Batafsil");
        moreButton.setEffect(new Reflection());
        moreButton.setVisible(false);
        moreButton.setStyle("-fx-background-radius: 50;"
                + "-fx-background-color: #0076a3");
        moreButton.setFont(new Font("Consolas", 14));
        Button OKButton = new Button("OK");
        OKButton.setFont(new Font("Consolas", 14));
        OKButton.setEffect(new InnerShadow());
        OKButton.setStyle("-fx-background-radius: 50");
//        if(xabar.length()>=10)
//            moreButton.setVisible(true);
//        else moreButton.setVisible(false);
        Label xabar1 = new Label(xabar);
//        xabar1.setPrefWidth(70);
        Kochish(moreButton, 120, 40);
//        xabar1.setWrapText(true);
        
        OKButton.setTranslateX(80);
        OKButton.setTranslateY((80/2));
        
//        xabar1.setTranslateX(60);
//        xabar1.setTranslateY(5);
        xabar1.setFont(new Font("Serif", 14));
        
        Group root = new Group(xabar1,OKButton,moreButton);
        
        Scene scene = new Scene(root, 250, 90);
        
        asosiySahna.setTitle("Xabar!!!");
        asosiySahna.setResizable(false);
        scene.getStylesheets().add("jahonchempionati2022/Stil.css");
        asosiySahna.setScene(scene);
        asosiySahna.show();
        
        scene.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode().equals(e.getCode().ENTER))
                asosiySahna.close();
        });
        
        OKButton.setOnAction((event) -> {
            asosiySahna.close();
        });
        moreButton.setOnAction((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, xabar, "Batafsil...", JOptionPane.INFORMATION_MESSAGE);
            asosiySahna.close();
        });
    }
    public static void Kochish(Node obj, int x, int y){
        obj.setTranslateX(x);
        obj.setTranslateY(y);
    }
}