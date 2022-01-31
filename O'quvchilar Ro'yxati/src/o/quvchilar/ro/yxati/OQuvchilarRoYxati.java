package o.quvchilar.ro.yxati;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXButton;

public class OQuvchilarRoYxati extends Application {

    private boolean isShowing = false;
    public TableView jadval = new TableView();
    private ObservableList<Uquvchi> malumotlar = FXCollections.observableArrayList();
    public Connection conn;
    private String path = "malumotlarbazasi.accdb";
    private String url = "jdbc:ucanaccess://" + path;
    private Statement stmt;
    private ResultSet rs;
    private Scene baseScene;

    private JFXButton[] menular = {
        new JFXButton(),
        new JFXButton(),
        new JFXButton(),
        new JFXButton(),
        new JFXButton("X")
    };

    public final int SIZE = 60;
    private final int INTERVAL = 20;

    private int sanoq = 0;
    private int xkord = 1;
    private int sanoq1 = 0;
    private int xkord1 = 1;

    public void _init() {
        menular[3].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("chiqish.png"))));
        menular[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        int i = 0;
        for (JFXButton x : menular) {
            x.setStyle("-fx-background-color: orange");
            x.setPrefSize(SIZE, SIZE);
            x.setTranslateX(-SIZE);
            x.setTranslateY((SIZE + 5) * i);
            x.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    x.setStyle("-fx-background-color: aqua;");
                }
            });
            x.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    x.setStyle("-fx-background-color: orange;");
                }
            });
            i++;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Asosiy bo'lim");
        primaryStage.setResizable(false);
        _init();
        Timeline tl = new Timeline();

        tl.setCycleCount(menular.length * SIZE);

        KeyFrame kf1 = new KeyFrame(Duration.millis(INTERVAL), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sanoq1 == 0) {
                    menular[sanoq1].setTranslateX(menular[sanoq1].getTranslateX() - xkord1);
                    if (menular[sanoq1].getTranslateX() <= -SIZE + 1) {
                        sanoq1 = 1;
                        xkord1 = 0;
                    }
                }
                if (sanoq1 == 1) {
                    menular[sanoq1].setTranslateX(menular[sanoq1].getTranslateX() - xkord1);
                    if (menular[sanoq1].getTranslateX() <= -SIZE + 1) {
                        sanoq1 = 2;
                        xkord1 = 0;
                    }
                }
                if (sanoq1 == 2) {
                    menular[sanoq1].setTranslateX(menular[sanoq1].getTranslateX() - xkord1);
                    if (menular[sanoq1].getTranslateX() <= -SIZE + 1) {
                        sanoq1 = 3;
                        xkord1 = 0;
                    }
                }
                if (sanoq1 == 3) {
                    menular[sanoq1].setTranslateX(menular[sanoq1].getTranslateX() - xkord1);
                    if (menular[sanoq1].getTranslateX() <= -SIZE + 1) {
                        sanoq1 = 4;
                        xkord1 = 0;
                    }
                }
                if (sanoq1 == 4) {
                    menular[sanoq1].setTranslateX(menular[sanoq1].getTranslateX() - xkord1);
                    if (menular[sanoq1].getTranslateX() <= -SIZE + 1) {
                        sanoq1 = 0;
                        xkord1 = 0;
                        tl.stop();
                    }
                }
                xkord1++;
            }
        });

        KeyFrame kf = new KeyFrame(Duration.millis(INTERVAL), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sanoq == 0) {
                    menular[sanoq].setTranslateX(menular[sanoq].getTranslateX() + xkord);
                    if (menular[sanoq].getTranslateX() >= 0) {
                        sanoq = 1;
                        xkord = 0;
                    }
                }
                if (sanoq == 1) {
                    menular[1].setTranslateX(menular[sanoq].getTranslateX() + xkord);
                    if (menular[sanoq].getTranslateX() >= 0) {
                        sanoq = 2;
                        xkord = 0;
                    }
                }
                if (sanoq == 2) {
                    menular[2].setTranslateX(menular[sanoq].getTranslateX() + xkord);
                    if (menular[sanoq].getTranslateX() >= 0) {
                        sanoq = 3;
                        xkord = 0;
                    }
                }
                if (sanoq == 3) {
                    menular[3].setTranslateX(menular[sanoq].getTranslateX() + xkord);
                    if (menular[sanoq].getTranslateX() >= 0) {
                        sanoq = 4;
                        xkord = 0;
                    }
                }
                if (sanoq == 4) {
                    menular[4].setTranslateX(menular[sanoq].getTranslateX() + xkord);
                    if (menular[sanoq].getTranslateX() >= 0) {
                        sanoq = 0;
                        xkord = 0;
                        tl.stop();
                    }
                }
                xkord++;
            }
        });
        tl.getKeyFrames().add(kf);

        Pane p1 = new Pane(menular);

        menular[4].setFont(new Font("Arial", 16));
        JFXButton btn = new JFXButton("Start");
        btn.setStyle("-fx-background-color: orange");
        btn.setUserData(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tl.getStatus().equals(tl.getStatus().RUNNING)) {
                    return;
                }
                tl.getKeyFrames().clear();
                tl.getKeyFrames().add(kf);
                tl.play();
                isShowing = true;
                btn.setDisable(isShowing);
            }
        });
        menular[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tl.setCycleCount(menular.length * SIZE);
                tl.getKeyFrames().clear();
                tl.getKeyFrames().add(kf1);
                tl.play();
                isShowing = false;
                btn.setDisable(isShowing);
            }
        });
        btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle("-fx-background-radius: 0;");
                btn.setStyle("-fx-background-color: aqua;");
            }
        });
        btn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.setStyle("-fx-background-radius: 0;");
                btn.setStyle("-fx-background-color: orange;");
            }
        });

        menular[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oquvchi(primaryStage);
            }
        });

        Pane p = new Pane(p1, btn);
        btn.setTranslateX(175);
        btn.setTranslateY(225);

        baseScene = new Scene(p, 349, 450);

        primaryStage.setScene(baseScene);
        primaryStage.show();
    }

    public void oquvchi(Stage primaryStage) {

        Button btn = ButtonBuilder.create().text("ORQAGA <--").style("-fx-base: lightblue")
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(baseScene);
                        primaryStage.setTitle("Asosiy bo'lim");
                        refresh();
                    }
                }).build();

        TextField ism = new TextField();
        ism.setPromptText("Ism kiriting");

        TextField fam = TextFieldBuilder.create().promptText("Familiya").build();
        TextField otaIsm = TextFieldBuilder.create().promptText("Otasining ismi").build();
        TextField manzil = TextFieldBuilder.create().promptText("Manzil").build();
        DatePicker sana = new DatePicker(LocalDate.of(2003, Month.JANUARY, 1));
        TextField nomer = TextFieldBuilder.create().promptText("Tel. nomeri").build();

        HBox kirituvchilar = new HBox(10, ism, fam, otaIsm, manzil, sana, nomer);

        Button delete = ButtonBuilder.create().text("O'chirish").build();
        Button update = ButtonBuilder.create().text("O'zgartirish").build();
        Button insert = ButtonBuilder.create().text("O'rnatish").build();

        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateData();
            }
        });

        insert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String chis = sana.getValue().getYear() + "-" + sana.getValue().getMonthValue() + "-"
                        + sana.getValue().getDayOfMonth();
                try {
                    stmt.executeUpdate(String.format("INSERT INTO base(Ismi, Familiyasi, OtasiIsmi, Manzil, tugkun, tel)"
                            + " VALUES('%s', '%s', '%s', '%s', DATE '%s', '%s');",
                            ism.getText(), fam.getText(), otaIsm.getText(), manzil.getText(), chis, nomer.getText()));
                    refresh();
                    ism.clear();
                    fam.clear();
                    otaIsm.clear();
                    manzil.clear();
                    nomer.clear();
                    ornat();
                } catch (SQLException ex) {
                    Logger.getLogger(OQuvchilarRoYxati.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int adID = Integer.parseInt(JOptionPane.showInputDialog(null, "O'chirish uchun id adresni kiriting"));
                    stmt.executeUpdate("DELETE FROM base WHERE id=" + adID);
                    ornat();
                    malumotlar.clear();
                    refresh();
                    ornat();
                } catch (HeadlessException | NumberFormatException e) {
                    System.out.println("Faqat son kiriting");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        HBox controls = new HBox(15, delete, update, insert);

        ornat();

        VBox vb = new VBox(10, btn, new Label("O'quvchilar ro'yxati"), jadval, kirituvchilar, controls);

        Scene scene = new Scene(vb, 818, 500);
        vb.setPadding(new Insets(10));

        primaryStage.setTitle("O'quvchilar ma'lumotlar bazasi");
        primaryStage.setScene(scene);
    }

    public void ornat() {
        malumotlar.clear();
        jadval.getColumns().clear();
        connect();

        TableColumn idUst = new TableColumn("O'quvchi ID");
        idUst.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn ismUst = new TableColumn("Ismi");
        ismUst.setCellValueFactory(new PropertyValueFactory("ismi"));

        TableColumn famUst = new TableColumn("Familiyasi");
        famUst.setCellValueFactory(new PropertyValueFactory("fam"));

        TableColumn sharifUst = new TableColumn("Otasining ismi");
        sharifUst.setCellValueFactory(new PropertyValueFactory("sharifi"));

        TableColumn manzilUst = new TableColumn("Manzili");
        manzilUst.setPrefWidth(240);
        manzilUst.setCellValueFactory(new PropertyValueFactory("manzil"));

        TableColumn tugkunUst = new TableColumn("Tug'ilgan kuni");
        tugkunUst.setCellValueFactory(new PropertyValueFactory("tugkun"));

        TableColumn telUst = new TableColumn("Nomeri");
        telUst.setCellValueFactory(new PropertyValueFactory("tel"));

        TableColumn jinsi = new TableColumn("Jinsi");
        jinsi.setCellValueFactory(new PropertyValueFactory("jinsi"));

        jadval.getColumns().addAll(idUst, ismUst, famUst, sharifUst, manzilUst, tugkunUst, telUst, jinsi);
        jadval.setItems(malumotlar);
    }

    public void refresh() {
        malumotlar.clear();
        jadval.getColumns().clear();
        jadval.setItems(null);
        connect();
        jadval.setItems(malumotlar);
    }

    public void connect() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM base ORDER BY Familiyasi");
            while (rs.next()) {
                Date d = rs.getDate("tugkun");
                malumotlar.add(new Uquvchi(rs.getInt("ID"), rs.getString("Ismi"), rs.getString("Familiyasi"),
                        rs.getString("OtasiIsmi"), rs.getString("Manzil"), d.toString(), rs.getString("tel")));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Klas topilmadi.");
        } catch (SQLException ex) {
            System.err.println("Ma'lumotlar omborida xatolik");
        }
    }

    public void updateData() {
        Stage sahna = new Stage();
        sahna.setTitle("O'zgartirishlar bo'limi");
        Button ok = ButtonBuilder.create().text("OK").style("-fx-base: green").build();

        ComboBox cb = new ComboBox(FXCollections.observableArrayList(
                "Ismi", "Familiyasi", "OtasiIsmi", "Manzil", "Tug'ilgan kuni", "tel"
        ));
        cb.setValue("Ustunni nomini tanglang");
        TextField tf = new TextField();
        DatePicker dp = new DatePicker(LocalDate.of(2003, Month.MARCH, 15));
        HBox hb = new HBox(10, cb, tf);
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((int) cb.getUserData() == 2) {
                    try {
                        int idaddre = Integer.parseInt(JOptionPane.showInputDialog(
                                null, "O'zgartirilishi kerak bo'lgan ID sonini kiriting"));
                        stmt.executeUpdate("UPDATE base SET " + cb.getValue().toString()
                                + "=\'" + tf.getText() + "\' WHERE ID=" + idaddre);
                        refresh();
                    } catch (SQLException e) {
                        System.out.println("O'zgartirishda xatolik");
                    }
                } else if ((int) cb.getUserData() == 1) {
                    try {
                        String chislo = dp.getValue().getYear() + "-" + dp.getValue().getMonthValue()
                                + "-" + dp.getValue().getDayOfMonth();
                        int idaddre = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "O'zgartirilishi kerak bo'lgan ID sonini kiriting"));
                        stmt.executeUpdate("UPDATE base SET tugkun = DATE \'" + chislo + "\' WHERE ID=" + idaddre);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (cb != null && tf != null) {
                    JOptionPane.showMessageDialog(null, "O'zgartirishlar kiritildi");
                }
                ornat();
                sahna.close();
            }
        });
        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (cb.getValue().toString().equals("Tug'ilgan kuni")) {
                    dp.setValue(LocalDate.of(2003, Month.MARCH, 15));
                    hb.getChildren().clear();
                    hb.getChildren().addAll(cb, dp);
                    cb.setUserData(1);
                } else {
                    hb.getChildren().clear();
                    hb.getChildren().addAll(cb, tf);
                    cb.setUserData(2);
                }
            }
        });
        VBox vb = new VBox(10, hb, ok);
        vb.setPadding(new Insets(10));
        Scene updateScene = new Scene(vb);
        sahna.setScene(updateScene);
        sahna.show();
    }
}
