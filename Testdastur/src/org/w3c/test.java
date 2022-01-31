package org.w3c;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class test extends Application {

    private final String TOGRI_JAVOB = "To'g'ri javob";
    private final String NOTOGRI_JAVOB = "Noto'g'ri javob";

    private Label savol = new Label("");
    private int current_time = 0;
    private JFXRadioButton javob_1 = new JFXRadioButton();
    private JFXRadioButton javob_2 = new JFXRadioButton();
    private JFXRadioButton javob_3 = new JFXRadioButton();
    private JFXRadioButton javob_4 = new JFXRadioButton();
    private JFXButton accept = new JFXButton();
    private ToggleGroup tg = new ToggleGroup();

    public void keyingi_savolga_otish(String savol) throws IOException {
        current_time++;
        BufferedReader buffer = new BufferedReader(new StringReader(savol));
        String savol_str = buffer.readLine();
        this.savol.setText(savol_str);
        String arr_javoblar[] = {buffer.readLine(), buffer.readLine(), buffer.readLine(), buffer.readLine()};
        List<String> javoblar = Arrays.asList(arr_javoblar);
        Collections.shuffle(javoblar);
        accept.setText("Qa\'bul qilish");
        accept.setStyle("-fx-background-color: lightblue");
        accept.setRipplerFill(Color.RED);
        this.savol.setFont(Font.font("Consolas", FontWeight.BOLD, 18));
        javob_1.setText(javoblar.get(0));
        javob_2.setText(javoblar.get(1));
        javob_3.setText(javoblar.get(2));
        javob_4.setText(javoblar.get(3));
        javob_1.setUserData(javoblar.get(0));
        javob_2.setUserData(javoblar.get(1));
        javob_3.setUserData(javoblar.get(2));
        javob_4.setUserData(javoblar.get(3));
        tg.getToggles().addAll(javob_1, javob_2, javob_3, javob_4);

    }

    @Override
    public void start(Stage sahna) throws IOException {
//        sahna.initStyle(StageStyle.UNDECORATED);
        keyingi_savolga_otish("Javani kim tuzib chiqqan?\nByorn Straustrup\nDennis Retchi\nLarry Wall\nJames Gosling");
        sahna.setTitle("Test");
        accept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (current_time == 1) {
                    if (tg.getSelectedToggle().getUserData().equals("James Gosling")) {
                        JOptionPane.showMessageDialog(null, TOGRI_JAVOB);
                        try {
                            keyingi_savolga_otish("x32 nima degani?\n32-razyadli protsessor\n32-bitli protsessor\n64-bitlik protsessor\nTo'g'ri javob"
                                    + " yo'q");
                        } catch (IOException ex) {
                            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            JOptionPane.showMessageDialog(null, NOTOGRI_JAVOB);
                            keyingi_savolga_otish("x32 nima degani?\n32-razyadli protsessor\n32-bitli protsessor\n64-bitlik protsessor\nTo'g'ri javob"
                                    + " yo'q");
                        } catch (IOException ex) {
                            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (current_time == 2) {
                    if (tg.getSelectedToggle().getUserData().equals("32-bitli protsessor")) {
                        JOptionPane.showMessageDialog(null, TOGRI_JAVOB);
                    } else {
                        JOptionPane.showMessageDialog(null, NOTOGRI_JAVOB);
                    }
                    try {
                        keyingi_savolga_otish("Javada konstanta qilish uchun kalit so'z?\nconst\nfinal\nimport\nwhile");
                    } catch (IOException ex) {
                        Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (current_time == 3) {
                    if (tg.getSelectedToggle().getUserData().equals("final")) {
                        JOptionPane.showMessageDialog(null, TOGRI_JAVOB);
                    } else {
                        JOptionPane.showMessageDialog(null, NOTOGRI_JAVOB);
                    }
                    sahna.close();
                }
                tg.getSelectedToggle().setSelected(false);
            }
        });

        VBox vb = new VBox(25, savol, javob_1, javob_2, javob_3, javob_4, accept);
        vb.setPadding(new Insets(0, 0, 0, 10));
        vb.setAlignment(Pos.CENTER_LEFT);
        Scene scene = new Scene(vb, 300, 400);
        sahna.setScene(scene);
        sahna.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
