package yangigibrittil;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class YangiGibritTil extends Application {

    private FileChooser choose = null;
    private FileChooser.ExtensionFilter filter = null;
    private File fayl = null;
    private String filePath = "D:\\";
    private List<String> qatorlar = new ArrayList<>();
    public String buyruqlar = null;
    public TextArea kodQism = new TextArea();
    private RUNKnopkasi rk = new RUNKnopkasi();
    private int sarlavhaNavbati = 1;
    private String encoding = "windows-1251";
    private byte[] bayt = null;

    public String getHTMLkod() {
        return kodQism.getText();
    }

    public void refresh() {
        buyruqlar = kodQism.getText();
        RUNKnopkasi.RUN(buyruqlar);
    }
    
    public void refreshPRO(TextArea ta) {
        buyruqlar = ta.getText();
        RUNKnopkasi.RUN(buyruqlar);
    }
    
    public void Sozlamalar() {
        RadioButton utf8 = new RadioButton("UTF-8");
        RadioButton utf16 = new RadioButton("UTF-16");
        RadioButton unicode = new RadioButton("UNICODE");
        RadioButton windows1251 = new RadioButton("windows-1251");
        utf8.setUserData(utf8.getText());
        utf16.setUserData(utf16.getText());
        unicode.setUserData(unicode.getText());
        windows1251.setUserData(windows1251.getText());

        ToggleGroup tg = new ToggleGroup();
        tg.getToggles().addAll(utf8, utf16, unicode, windows1251);

        TitledPane tp = new TitledPane();
        tp.setExpanded(false);
        GridPane tp_setka = new GridPane();
        tp_setka.setPadding(new Insets(5, 10, 5, 10));
        tp_setka.setVgap(10);
        tp_setka.add(utf8, 0, 0);
        tp_setka.add(utf16, 0, 1);
        tp_setka.add(unicode, 0, 2);
        tp_setka.add(windows1251, 0, 3);

        tp.setContent(tp_setka);
        tp.setText("Tanlanganlar");

        Stage encodingSahnasi = new Stage();
        encodingSahnasi.setTitle("Encoding");
        TextField encodingniKiritish = new TextField();
        encodingniKiritish.setPromptText("Encodingni kiriting");
        encodingniKiritish.setTooltip(new Tooltip("Faqat aniq qilib kiriting\nAks "
                + "holda dasturdagi yozuvlar ko'rinmasligi mumkin."));
        Button OK = new Button("OK");
        OK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    encoding = encodingniKiritish.getText();
                    kodQism.setText(new String(bayt, encoding));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }
        });

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                try {
                    encoding = newValue.getUserData().toString();
                    kodQism.setText(new String(bayt, encoding));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }
        });

        Button help = new Button("Yordam");
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Agar tushunmayotgan bo'lsagiz quyidagini qo'shtirnoqsiz"
                        + " yozing\n\"UTF-8\" Agar shunda ham ishlamasa \"UTF-16\" deb yozing\n"
                        + "\"windows-1251\"\n\"UNICODE\"\n"
                        + "Shularni ishlatib ko'rib HTML hujjatga qarang.");
            }
        });
        Button chiqish = new Button("Chiqish");
        chiqish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                encodingSahnasi.close();
            }
        });

        Separator s = new Separator(Orientation.VERTICAL);
        s.setMaxHeight(120);

        GridPane setka = new GridPane();
        setka.setPadding(new Insets(1));
        setka.setVgap(10);
        setka.setHgap(10);
        setka.add(encodingniKiritish, 0, 0);
        setka.add(OK, 0, 1);
        setka.add(s, 1, 0, 1, 2);
        setka.add(help, 2, 0);
        setka.add(chiqish, 2, 1);

        tp.setPrefHeight(120);
        VBox vb = new VBox(20, tp, setka);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vb, 600, 500);

        encodingSahnasi.setScene(scene);
        encodingSahnasi.show();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kod");
        primaryStage.setResizable(false);
        kodQism.setWrapText(true);
        RUNKnopkasi kn = new RUNKnopkasi();
        kodQism.setPrefSize(600, 500);
        kodQism.setPromptText("HTML kodini yozing");
        Button tozalash = new Button("Tozalash");

        Button ochish = new Button("", new ImageView(new Image(getClass().getResourceAsStream("open.png"))));
        ochish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                choose = new FileChooser();
                choose.setTitle("             HTML Storm");
                choose.setInitialDirectory(new File(filePath));
                filter = new FileChooser.ExtensionFilter("html hujjat", "*.html", "*.htm");
                choose.getExtensionFilters().add(filter);
                fayl = choose.showOpenDialog(null);
                filePath = fayl.toURI().toString();
                filePath = fayl.getParent();
                try {
                    FileInputStream fis = new FileInputStream(fayl);
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    bayt = new byte[bis.available()];
                    for (int i = 0; bis.available() != 0; i++) {
                        bayt[i] = (byte) bis.read();
                    }
                    Pattern tartib = Pattern.compile("charset=(\\w)?([A-Za-z]+\\-\\d+)(\\w)?");
                    Matcher mostlik = tartib.matcher(kodQism.getText());

                    kodQism.setText(new String(bayt, encoding));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Button run = new Button();
        run.setGraphic(new ImageView(new Image(YangiGibritTil.class.getResourceAsStream("playbutton.png"))));
        run.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refresh();
            }
        });
        run.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                run.setScaleX(1.2);
                run.setScaleY(1.2);
            }
        });

        run.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                run.setScaleX(1);
                run.setScaleY(1);
            }
        });

        ochish.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ochish.setScaleX(1.2);
                ochish.setScaleY(1.2);
            }
        });

        ochish.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ochish.setScaleX(1);
                ochish.setScaleY(1);
            }
        });
        ochish.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ochish.setScaleX(1.125);
                ochish.setScaleY(1.125);
            }
        });

//                buyruqlar = kodQism.getText();
//                RUNKnopkasi.RUN(buyruqlar);
        Timeline tl = new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sarlavhaNavbati == 1) {
                    primaryStage.setTitle("< < < HTML Storm > > >");
                    sarlavhaNavbati = 2;
                } else if (sarlavhaNavbati == 2) {
                    primaryStage.setTitle("  < < HTML Storm > >");
                    sarlavhaNavbati = 3;
                } else if (sarlavhaNavbati == 3) {
                    primaryStage.setTitle("    < HTML Storm >");
                    sarlavhaNavbati = 4;
                } else if (sarlavhaNavbati == 4) {
                    primaryStage.setTitle("      HTML Storm");
                    sarlavhaNavbati = 1;
                }
            }
        });
        tl.getKeyFrames().add(kf);

        Button yordam = new Button("Encoding");
        yordam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Sozlamalar();
                refresh();
            }
        });

        GridPane setka = new GridPane();
        setka.setHgap(10);
        setka.setVgap(10);
        setka.setPadding(new Insets(5));
        setka.setAlignment(Pos.CENTER);
        setka.add(run, 0, 0, 5, 1);
        setka.add(ochish, 6, 0);
        setka.add(kodQism, 1, 1, 8, 3);
        setka.add(yordam, 7, 0);

        primaryStage.setX(25);
        primaryStage.setY(50);
        primaryStage.setTitle("HTML storm");

        PasswordField parol = new PasswordField();
        parol.setPromptText("Parol ni kiriting");
        Button tekshir = new Button("OK");
        tekshir.setFont(new Font("Verdana", 17));

        VBox vb = new VBox(15, parol, tekshir);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10));

        Scene scene = new Scene(setka);
        Scene parolscene = new Scene(vb, 200, 100);
        final int X_SCREEN = (int) primaryStage.getX();
        final int Y_SCREEN = (int) primaryStage.getY();
        primaryStage.setX(500);
        primaryStage.setY(240);
        tekshir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(parol.getText().equalsIgnoreCase("P@r0lpro")){
                    proVersion(primaryStage);
                } else
                if (parol.getText().equals("P@r0l")) {
                    primaryStage.setScene(scene);
                    tl.play();
                    primaryStage.setX(X_SCREEN);
                    primaryStage.setY(Y_SCREEN);
                } else {
                    JOptionPane.showMessageDialog(null, "Parol noto'g'ri terilgan");
                    parol.clear();
                }
            }
        });
        primaryStage.setScene(parolscene);
        primaryStage.show();
    }

    private String encodingPRO = "windows-1251";
    private String path = "D:\\";
    private String kod = "";
    
    public void proVersion(Stage primaryStage) {
        
        Button OKPRO = new Button("OK");
        TextField inputEncodingPRO = new TextField();
        Button yordamPRO = new Button("Yordam");
        Button chiqishPRO = new Button("Chiqish");
        Separator sepa = new Separator(Orientation.VERTICAL);
        sepa.setMaxHeight(65);
        sepa.setMinHeight(55);
        
        Stage encodingStage = new Stage();
        TitledPane tanlash = new TitledPane();
        tanlash.setText("Standart");
        GridPane yozishSetka = new GridPane();
        yozishSetka.setHgap(10);
        yozishSetka.setVgap(5);
        yozishSetka.setPadding(new Insets(5));
        yozishSetka.setAlignment(Pos.CENTER);
        yozishSetka.add(inputEncodingPRO, 0, 0);
        yozishSetka.add(OKPRO, 0, 1);
        yozishSetka.add(yordamPRO, 2, 0);
        yozishSetka.add(sepa, 1, 0, 1, 2);
        yozishSetka.add(chiqishPRO, 2, 1);
        
        TitledPane yozish = new TitledPane();
        yozish.setText("Custom");
        yozish.setContent(yozishSetka);
        Accordion pane = new Accordion(tanlash, yozish);
        pane.setPrefSize(270, 120);
        encodingStage.setTitle("Encoding");
        ComboBox cb = new ComboBox(FXCollections.observableArrayList("windows-1251"
        , "UTF-8", "UTF-16", "UTF-16LE", "UNICODE"));
        cb.setVisibleRowCount(3);
        cb.setValue("Standart encoding");
        tanlash.setContent(cb);
        Scene sceneEncoding = new Scene(pane);
        encodingStage.setScene(sceneEncoding);
        
        
        //P@r0lpro
        Separator sep = new Separator();
        sep.setMaxWidth(470);
        TextArea kodQismPRO = new TextArea();
        kodQismPRO.setStyle("-fx-background-color: #e79423");
        
        OKPRO.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                encodingPRO = inputEncodingPRO.getText();
                bayt = kodQismPRO.getText().getBytes();
                try {
                    kodQismPRO.setText(new String(bayt, encoding));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                }
                refreshPRO(kodQismPRO);
            }
        });
        
        yordamPRO.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Standart bo'limida siz standart encodinglarni topasiz.\n"
                        + "Agar u yerda siz xohlagan encoding bo'lmasa Custom bo'limiga\nencoding ni yozaverasiz"
                        + "Va nihoyat OK tugmasini bosasiz va fayldan siz xohlagan encoding bilan o'qib olinadi.");
            }
        });
        
        chiqishPRO
                .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                encodingStage.close();
            }
        });
        
        primaryStage.setTitle("HTML Storm pro");
        String kompliyator = "JavaScript";
        Button encodingButtonPRO = new Button("Encoding");
        Button runPRO = new Button();
        Button openPRO = new Button();
        runPRO.setSnapToPixel(true);
        openPRO.setSnapToPixel(true);
        Image playButton = new Image(getClass().getResourceAsStream("playbutton.png"));
        Image open = new Image(YangiGibritTil.class.getResourceAsStream("open.png"));
        runPRO.setGraphic(new ImageView(playButton));
        openPRO.setGraphic(new ImageView(open));
        
        encodingButtonPRO.setOnAction((ActionEvent e) -> {
            encodingStage.show();
        });
        
        openPRO.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser openDialog = new FileChooser();
                openDialog.setTitle("HTML Storm PRO version");
                FileChooser.ExtensionFilter filter1 = new FileChooser.ExtensionFilter("HTML hujjat va Script lar",
                        "*.html", "*.htm", "*.js");
                FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("Istalgan fayl", "*.*");
                openDialog.getExtensionFilters().addAll(filter1, filter2);
                File f = openDialog.showOpenDialog(null);
                path = f.toURI().toString();
                try {
                    FileInputStream fis = new FileInputStream(f);
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    bayt = new byte[bis.available()];
                    for (int i = 0; bis.available() != 0; i++) {
                        bayt[i] = (byte) bis.read();
                    }
                    Pattern tartib = Pattern.compile("charset=(\\w)?([A-Za-z]+\\-\\d+)(\\w)?");
                    Matcher mostlik = tartib.matcher(kodQism.getText());

                    kodQismPRO.setText(new String(bayt, encoding));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        runPRO.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buyruqlar = kodQismPRO.getText();
                refreshPRO(kodQismPRO);
            }
        });
        runPRO.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                runPRO.setScaleX(1.2);
                runPRO.setScaleY(1.2);
            }
        });

        runPRO.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                runPRO.setScaleX(1);
                runPRO.setScaleY(1);
            }
        });

        openPRO.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                openPRO.setScaleX(1.2);
                openPRO.setScaleY(1.2);
            }
        });

        openPRO.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                openPRO.setScaleX(1);
                openPRO.setScaleY(1);
            }
        });
        openPRO.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                openPRO.setScaleX(1.125);
                openPRO.setScaleY(1.125);
            }
        });
        encodingButtonPRO.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                encodingButtonPRO.setScaleX(1.2);
                encodingButtonPRO.setScaleY(1.2);
            }
        });

        encodingButtonPRO.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                encodingButtonPRO.setScaleX(1);
                encodingButtonPRO.setScaleY(1);
            }
        });
        encodingButtonPRO.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                encodingButtonPRO.setScaleX(1.125);
                encodingButtonPRO.setScaleY(1.125);
            }
        });
        runPRO.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                runPRO.setScaleX(1.125);
                runPRO.setScaleY(1.125);
            }
        });
        
        
        GridPane setkaPRO = new GridPane();
        setkaPRO.setPadding(new Insets(10));
        setkaPRO.setHgap(15);
        setkaPRO.setVgap(10);
        kodQismPRO.setPrefSize(490, 380);
        kodQismPRO.setWrapText(true);
        kodQismPRO.setPromptText("HTML kod yoki "+ kompliyator);
        
        setkaPRO.add(encodingButtonPRO, 2, 1);
        setkaPRO.add(runPRO, 0, 1);
        setkaPRO.add(openPRO, 1, 1);
        setkaPRO.add(sep, 0, 2, 6, 1);
        setkaPRO.add(kodQismPRO, 0, 3, 5, 5);
        
        Scene epizod = new Scene(setkaPRO, 500, 400);
        epizod.getStylesheets().add("yangigibrittil/Stil.css");
        
        primaryStage.setScene(epizod);
        primaryStage.setResizable(true);
        primaryStage.setX(40);
        primaryStage.setY(50);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void fayldanMalumotOqimoq(TextArea ta){
        try {
            FileReader fr = new FileReader(path);
            BufferedReader buffer = new BufferedReader(fr);
            String line = "";
            while((line = buffer.readLine()) != null){
                kod += line;
            }
            ta.setText(new String(kod.getBytes(), ta.getText()));
            buffer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(YangiGibritTil.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshPRO(ta);
    }
}