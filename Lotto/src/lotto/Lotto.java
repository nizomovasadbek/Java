package lotto;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import java.util.Random;
public class Lotto extends Application{
    
    private int jon = 5;
    private boolean imkoniyatiKettimi = false;

    @Override
    public void start(Stage primaryStage){
        Button btn = new Button("Lottoreyani ishga tushurish");
        TextArea kiritilishMaydoni = new TextArea();
        Label matn = new Label("Son kiriting");
        Label jonKorsatkichi = new Label(String.format("Imkoniyatingiz:\n%d", jon));
        Label aslist = new Label();
        kiritilishMaydoni.setTranslateX(0);
        kiritilishMaydoni.setTranslateY(0);
        kiritilishMaydoni.setMaxSize(60, 25);
        kiritilishMaydoni.setMinSize(60, 20);
        btn.setTranslateX(3);
        btn.setTranslateY(50);
        matn.setMaxSize(100, 30);
        matn.setMinSize(100, 10);
        matn.setTranslateX(23);
        matn.setTranslateY(-30);
        jonKorsatkichi.setTranslateX(-85);
        jonKorsatkichi.setTranslateY(-60);
        aslist.setTranslateY(-65);
        aslist.setTranslateX(-5);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int massiv[] = new int[5];
                int son;
                son = Integer.parseInt(kiritilishMaydoni.getText());
                Random tasodifiySon = new Random();
                for(int i = 0; i < massiv.length; i++)
                    massiv[i] = tasodifiySon.nextInt(100);
                
                for(int j = 0; j < massiv.length; j++)
                    if(massiv[j] == son){
                        JOptionPane.showMessageDialog(null, "Siz topdingiz sonlarning " + (j + 1) + "-elementi"
                                + "\nsiz kiritgan songa teng", "Lotoreya", JOptionPane.INFORMATION_MESSAGE);
                        imkoniyatiKettimi = true;
                        break;
            }
                if(!(imkoniyatiKettimi))
                 JOptionPane.showMessageDialog(null, "Afsuski javob noto'g'ri");
                
                JOptionPane.showMessageDialog(null, Arrays.toString(massiv) + " sonlari edi.", "Lotoreya", JOptionPane.INFORMATION_MESSAGE);
            if(imkoniyatiKettimi){
                jon++;
                jonKorsatkichi.setText(String.format("Imkoniyatingiz:\n%d", jon));
            }
            else{
                jon--;
                jonKorsatkichi.setText(String.format("Imkoniyatingiz:\n%d", jon));
            }
            if(jon == 0){
                    JOptionPane.showMessageDialog(null, "Siz yutquzdingiz sizning joningiz tugadi.", "Lottoreya", JOptionPane.INFORMATION_MESSAGE);
                    primaryStage.close();
                    return;
                }
            imkoniyatiKettimi = false;
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(kiritilishMaydoni);
        root.getChildren().add(matn);
        root.getChildren().add(jonKorsatkichi);
        root.getChildren().add(aslist);
        
        Scene sklet = new Scene(root, 250, 160);
        
        primaryStage.setTitle("Lottoreya");
        primaryStage.setScene(sklet);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}