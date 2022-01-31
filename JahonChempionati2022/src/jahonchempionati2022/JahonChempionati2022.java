package jahonchempionati2022;

import javafx.application.Application;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

public class JahonChempionati2022 extends Application {
    
    private IndicateMessage showmsg = new IndicateMessage();
    //Taarjima qismi
    private String nimalarniOzgartirasiz = "Nimalarni o'zgartirasiz";
    private String orqaga = "<- Orqaga";
    private String adminBolimigaOtish = "Admin bo'limiga o'tish";
    private String malumotlarniKiritish = "Ma'lumotlarni kiritish";
    private String durang = "Durang";
    private String kodniKiriting = "Kodni kiriting";
    private String kodTogriAdminPaneligaKirishingizMumkin = "Kod to'g'ri admin panelga kirishingiz mumkin";
    private String adminSahifasigaKirishUchunTerilganKodNotogri = "Admin sahifasiga kirish uchun terilgan"
            + " kod noto'g'ri";
    
    @Override
    public void start(Stage asosiySahna){
        ScrollPane layout = new ScrollPane();
        Scene epizod = new Scene(layout, 530, 450, Color.BLACK);
        ///Admin bo'limi
        Label laldjekcnjkj = new Label(nimalarniOzgartirasiz);
        VBox vb = new VBox();
        vb.setSpacing(5);
        vb.setPadding(new Insets(5, 5, 5, 5));
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().add(laldjekcnjkj);
        
        Button oddiyBolimgaQaytish = new Button(orqaga);
        vb.getChildren().add(oddiyBolimgaQaytish);
        oddiyBolimgaQaytish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                asosiySahna.setScene(epizod);
                
            }
        });
        
        Scene adminScene = new Scene(vb, 530, 450);
        adminScene.getStylesheets().add("jahonchempionati2022/Stil.css");
        
        
        
        
        
        
        //Oddiy bo'lim
        Button adminScenegaOtish = new Button(adminBolimigaOtish);
        adminScenegaOtish.setTranslateY(200);
        Separator separator = new Separator(Orientation.HORIZONTAL);
        separator.setTranslateY(57);
        Kommanda ispaniya = new Kommanda("Ispaniya");
        Kommanda italiya = new Kommanda("Italiya");
        Kommanda germaniya = new Kommanda("Germaniya");
        Kommanda xorvatiya = new Kommanda("Xorvatiya");
        Kommanda slovakiya = new Kommanda("Slovakiya");
        Guruh guruh = new Guruh(ispaniya, italiya);
        Button yangilash = new Button(malumotlarniKiritish);
        yangilash.setTranslateX(400);
        yangilash.setTranslateY(400);
        ispaniya.joylashuv(10, 0);
        italiya.joylashuv(10, 30);
        germaniya.joylashuv(10, 80);
        xorvatiya.joylashuv(10, 110);
        layout.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        layout.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        layout.setPannable(true);
        asosiySahna.setTitle("Jahon chempionati jadvali 2022 Qatar");
        LocalDateTime asosiyVaqt = LocalDateTime.now();
        layout.setStyle("-fx-base-color:#000000");
        
        if(asosiyVaqt.getYear() < 2012){
            IndicateMessage.Message("Hali Jahon chempionati bo'lmagan");
            return;
        }
        separator.setMinWidth(150);
        yangilash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Kommanda k = guruh.YutganKommandaniAniqlash();
                if(k == null){
                    IndicateMessage.Message("Faqat sonlarni kiritish kerak");
                } else {
                    if(guruh.Kommanda1().getUserData().equals(durang)){ guruh.setUserData(durang);
                    IndicateMessage.Message(durang);
                    }
                    else IndicateMessage.Message(k.toString());
                }
            }
        });
        
        adminScenegaOtish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String kod = JOptionPane.showInputDialog(null, kodniKiriting);
                if(kod.toLowerCase().equals("3143fiksik")){
                JOptionPane.showMessageDialog(null, kodTogriAdminPaneligaKirishingizMumkin, "Admin panel", 
                        JOptionPane.INFORMATION_MESSAGE);
                asosiySahna.setScene(adminScene);
                }
                else{ JOptionPane.showMessageDialog(null, adminSahifasigaKirishUchunTerilganKodNotogri);
                        
                }
            }
        });
        
        Group gru = new Group(ispaniya.getLabel(),ispaniya.getTextField(),italiya.getLabel(), italiya.getTextField(),
                separator
        ,germaniya.getLabel(), germaniya.getTextField(), yangilash, xorvatiya.getLabel(), xorvatiya.getTextField(),
        adminScenegaOtish);
        layout.setContent(gru);
        
        epizod.getStylesheets().add("jahonchempionati2022/Stil.css");
        epizod.setFill(Color.web("#000000"));
        asosiySahna.setScene(epizod);
        asosiySahna.setResizable(false);
        asosiySahna.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}