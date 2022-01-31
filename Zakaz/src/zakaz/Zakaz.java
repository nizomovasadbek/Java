package zakaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Zakaz extends Application {

    private final int SHRIFT_OLCHAMI = 18;
    private File f = new File("src"+File.separator+"zakaz"+File.separator+"malumotlar.txt");
    private String strlogin = ""
    ;
    private String strparol = "";
    private String ismi = "";
    private String familiya = "";
    private String tugilganSana = "";
    private String pochta = "";
    private String jinsi = "";
    
    @Override
    public void start(Stage sahna) {
        //start reg
        Stage sreg = new Stage();
        
        TextField ismreg = new TextField();
        ismreg.setPromptText("Ismingizni kiriting");
        TextField familiyareg = new TextField();
        familiyareg.setPromptText("Familiyangizni kiriting");
        TextField tugilganreg = new TextField();
        tugilganreg.setPromptText("Tug'ilgan kuningizni kiriting");
        tugilganreg.setTooltip(new Tooltip("Sanani quyidagi formatda kiriting:\ndd-MM-yyyy"));
        TextField epochta = new TextField();
        epochta.setPromptText("Elektron pochta");
        epochta.setTooltip(new Tooltip("Elektron pochtani kiriting"));
        TextField jinsireg = new TextField();
        jinsireg.setPromptText("Jinsingizni kiriting e/a");
        TextField loginreg = TextFieldBuilder.create()
                .promptText("Loginni kiriting")
                .build();
        TextField pr = TextFieldBuilder.create()
                .promptText("Parolni kiriting...")
                .build();
        
        Button toreg = ButtonBuilder.create()
                .text("Registratsiya")
                .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ismreg.getText().equals("") || familiyareg.getText().equals("") ||
                        tugilganreg.getText().equals("")
                        || epochta.getText().equals("") || jinsireg.getText().equals("") ||
                        pr.getText().equals("") || loginreg.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Ma'lumotlar to'liq kiritilmagan");
                } else {
                    Pattern tartib = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
                    Matcher mostlik = tartib.matcher(tugilganreg.getText());
                    if(mostlik.find()){
                    String qator = familiyareg.getText() + " " + ismreg.getText() + " " + tugilganreg.getText()
                            + " " + epochta.getText() + " " + jinsireg.getText() + " " + loginreg.getText() + " "
                            + pr.getText();
                    File fayl = new File("src"+File.separator+"zakaz"+File.separator+"malumotlar.txt");
                    try {
                        FileWriter fw = new FileWriter(fayl, true);
                        BufferedWriter buffer = new BufferedWriter(fw);
                        buffer.newLine();
                        buffer.write(qator);
                        buffer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Zakaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Siz registratsiyadan o'tdingiz");
                    sreg.close();
                    } else {JOptionPane.showMessageDialog(null, "Sana noto'g'ri kiritilgan");}
                }
            }
        }).font(new Font("Verdana", SHRIFT_OLCHAMI))
                .build();
        
        GridPane setka = new GridPane();
        setka.setAlignment(Pos.TOP_CENTER);
        setka.setHgap(10);
        setka.setVgap(5);
        setka.add(loginreg, 1, 5, 2, 1);
        setka.add(ismreg, 1, 0, 2, 1);
        setka.add(familiyareg, 1, 1, 2, 1);
        setka.add(tugilganreg, 1, 2, 2, 1);
        setka.add(epochta, 1, 3, 2, 1);
        setka.add(jinsireg, 1, 4, 2, 1);
        setka.add(pr, 1, 6, 2, 1);
        setka.add(new Label("Ism:"), 0, 0);
        setka.add(new Label("Familiya:"), 0, 1);
        setka.add(new Label("Tug'ilgan sana:"), 0, 2);
        setka.add(new Label("E-pochta:"), 0, 3);
        setka.add(new Label("Jinsi"), 0, 4);
        setka.add(new Label("Login:"), 0, 5);
        setka.add(new Label("Parol:"), 0, 6);
        setka.add(toreg, 2, 7);
        
        Scene s = new Scene(setka);
        sreg.setTitle("Registratsiya");
        sreg.setScene(s);
        ///end reg
        sahna.setTitle("Dastur");
        Hyperlink reg = new Hyperlink("Registratsiya");
        kochish(reg, 150, 250);
        
        Button kirish = new Button("Kirish");
        kirish.setFont(new Font("Verdana", SHRIFT_OLCHAMI));
        kochish(kirish, 150, 200);
        kirish.setPrefSize(120, 20);
        
        Label text = new Label("Dasturga kirish");
        text.setFont(new Font("Verdana", 20));
        text.setTextFill(Color.VIOLET);
        kochish(text, 140, 10);
        
        Label axborot = new Label("");
        axborot.setFont(new Font("Verdana", 14));
        axborot.setTextFill(Color.VIOLET);
        kochish(axborot, 30, 45);
        
        TextField login = new TextField();
        kochish(login, 150, 90);
        
        PasswordField parol = new PasswordField();
        kochish(parol, 150, 150);
        
        Label parolLabel = new Label("Parol:");
        kochish(parolLabel, 30, 150);
        parolLabel.setFont(new Font("Verdana", SHRIFT_OLCHAMI));
        parolLabel.setTextFill(Color.DARKVIOLET);
        
        Label loginLabel = new Label("Login:");
        loginLabel.setFont(new Font("Verdana", SHRIFT_OLCHAMI));
        loginLabel.setTextFill(Color.DARKVIOLET);
        kochish(loginLabel, 30, 90);
        
        //Hodisalar:
        kirish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try{
                if(!f.exists()){
                    f.createNewFile();
                    JOptionPane.showMessageDialog(null, "Registratsiya qilinmagan!");
                } else {
                    FileReader fr = new FileReader(f);
                    BufferedReader buffer = new BufferedReader(fr);
                    String line = "";
                    
                    while((line=buffer.readLine())!=null){
                        String[] malumotlar = line.split("\\s");
                        strlogin = malumotlar[5];
                        strparol = malumotlar[6];
                        if(login.getText().equals(strlogin) && parol.getText().equals(strparol)){
                            login.clear();
                            parol.clear();
                            axborot.setText("Parol va login to'g'ri");
                            axborot.setTextFill(Color.BLUE);
                            familiya = malumotlar[0];
                            ismi = malumotlar[1];
                            tugilganSana = malumotlar[2];
                            pochta = malumotlar[3];
                            jinsi = malumotlar[4];
                            JOptionPane.showMessageDialog(null, String.format("Sizning"
                                    + " ismingiz: %s\nSizning familiyangiz: %s\n"
                                    + "Sizning tugilgan sanangiz: %s\nSizning elek"
                                    + "tron pochtangiz: %s\nSizning jinsingiz: %s\n", ismi, familiya
                             ,tugilganSana, pochta, jinsi));
                            break;
                        } else {
                            axborot.setText("Ma'lumotlar omborida bunday login va parol yo'q");
                            axborot.setTextFill(Color.RED);
                        }
                    }
                    buffer.close();
                }
                }catch(IOException e){
                    System.err.println("Xatolik sodir bo'ldi.");
                }
            }
        });
        
        reg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sreg.show();
            }
        });
        
        reg.setFont(new Font("Verdana", SHRIFT_OLCHAMI));
        
        Group gr = new Group(loginLabel, parolLabel, login, parol, axborot, text, kirish, reg);
        
        Scene scene = new Scene(gr, 400, 300);
        
        sahna.setScene(scene);
        sahna.show();
    }
    
    public void kochish(Node n, int x, int y){
        n.setTranslateX(x);
        n.setTranslateY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}