package videoplayer2.avlod;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class VideoPlayer2Avlod extends Application {

    private int sanoq = 1;

    @Override
    public void start(Stage primaryStage) {
        FileChooser connection = new FileChooser();
        connection.setInitialDirectory(new File("D:\\"));
        connection.setTitle("Ochish");

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Faqat *.txt", "*.txt");
        connection.getExtensionFilters().add(filter);

        List<String> yopishIshi = new ArrayList<>();
        MenuBar bar = new MenuBar();
        final TextArea matn = new TextArea();
        matn.setWrapText(true);
        List<Tab> tabs = new ArrayList<>();
        List<TextArea> tas = new ArrayList<>();
        tabs.add(new Tab(String.format("Matn%02d", sanoq)));
        tas.add(new TextArea());
        tabs.get(0).setContent(tas.get(0));
        
        TabPane tp = new TabPane(tabs.get(0));

        MenuItem fayl_ochish = new MenuItem("_Ochish");
        fayl_ochish.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN));
        fayl_ochish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File f = connection.showOpenDialog(null);
                String filePath = f.toURI().toString();

                try {
                    FileInputStream fr = new FileInputStream(f);
                    BufferedInputStream buffer = new BufferedInputStream(fr);
                    byte[] bayt = new byte[(int) buffer.available()];
                    for (int i = 0; i < bayt.length; i++) {
                        bayt[i] = (byte) buffer.read();
                    }
                for(int i = 0; i < tas.size(); i++){
                    if(tas.get(i).isFocused()){
                        tas.get(i).setText(new String(bayt));
                    } else if(tabs.get(i).isSelected()){
                        tas.get(i).setText(new String(bayt));
                    }
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connection.setInitialDirectory(f.getParentFile());
            }
        });
        
        MenuItem fayl_saqlash = new MenuItem("_Saqlash");
        fayl_saqlash.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        fayl_saqlash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i < tas.size(); i++){
                    if(tabs.get(i).isSelected()){
                        FileWriter fw = null;
                        try {
                            FileChooser saqlovchi = new FileChooser();
                            saqlovchi.setTitle("Saqlang");
                            saqlovchi.setInitialFileName(tabs.get(i).getText());
                            saqlovchi.setInitialDirectory(new File("D:\\"));
                            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Tekst fayl",
                                    "*.txt");
                            FileChooser.ExtensionFilter filterOther = new
                                    FileChooser.ExtensionFilter("Hamma fayllar", "*.*");
                            saqlovchi.getExtensionFilters().addAll(filter, filterOther);
                            File f = saqlovchi.showSaveDialog(null);
                            fw = new FileWriter(f);
                            BufferedWriter buffer = new BufferedWriter(fw);
                            buffer.write(tas.get(i).getText());
                            buffer.close();
                        } catch (IOException ex) {
                            Logger.getLogger(VideoPlayer2Avlod.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        
        MenuItem fayl_yangi = new MenuItem("_Yangi");
        fayl_yangi.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        fayl_yangi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(TextArea x:tas){
            x.setWrapText(true);
        }
                sanoq++;
                tabs.add(new Tab(String.format("Matn%02d", sanoq)));
                tp.getTabs().add(tabs.get(tabs.size() - 1));
                tas.add(new TextArea());
                tabs.get(tabs.size() - 1).setContent(tas.get(tas.size()-1));
                tabs.get(tabs.size() - 1).setUserData((tas.get(tas.size()-1)).getText());
            }
        });

        MenuItem fayl_chiqish = new MenuItem("_Chiqish");
        fayl_chiqish.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN));
        fayl_chiqish.setOnAction((ActionEvent e) -> {
            primaryStage.close();
        });

        Menu fayl = new Menu("_Fayl");
        fayl.getItems().addAll(fayl_ochish, fayl_saqlash, fayl_yangi, new SeparatorMenuItem(), fayl_chiqish);
        bar.getMenus().add(fayl);

        MenuItem yordam_dasturchiHaqida = new MenuItem("_Dasturchi haqida");
        yordam_dasturchiHaqida.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
        yordam_dasturchiHaqida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Dasturchi: Nizomov Asadbek\nCopyright \u00A9 2019");
            }
        });

        MenuItem yordam_dasturHaqida = new MenuItem("D_astur haqida");
        yordam_dasturHaqida.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
        yordam_dasturHaqida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Note dasturining 1.0.0 versiyasi siz uchun manzur\n"
                        + "@dastur_yaratish kanali uchun maxsus\n"
                        + "Biz bilan bo'ling");
            }
        });

        Menu yordam = new Menu("_Yordam");
        yordam.getItems().addAll(yordam_dasturchiHaqida, yordam_dasturHaqida);
        bar.getMenus().add(yordam);

        GridPane setka = new GridPane();
        setka.setAlignment(Pos.TOP_CENTER);
        setka.add(bar, 0, 0, 5, 1);
        setka.add(tp, 0, 1, 5, 3);

        Scene scene = new Scene(setka, 460, 250);

        primaryStage.setTitle("Bloknot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}