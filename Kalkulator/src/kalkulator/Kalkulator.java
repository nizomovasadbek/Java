package kalkulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.control.Tooltip;

import javax.swing.JOptionPane;

public class Kalkulator extends Application {

    private Tooltip matn = new Tooltip("Tozalash");
    private Font shrift = new Font("Serif", 14);
    private final double OLCHAM = 40;
    private int operator = 0;
    private int value1 = 0, value2 = 0;
    private TextField output = new TextField("0");
    private final String SONTANISH = "([+|-]?(\\d+(\\.\\d*)?))|([+|-]?(\\.\\d+))";

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button qoshish = new Button("+");
        Button ayirish = new Button("-");
        Button kopaytirish = new Button("*");
        Button bolish = new Button("/");
        Button plusminus = new Button("=");
        Button tozalash = new Button("C");
        CheckBox qalin = new CheckBox("Qalin");

        tozalash.setTooltip(matn);
        tozalash.setFont(shrift);

        output.setEditable(false);
        output.setMaxSize(250, 30);
        output.setMinSize(250, 30);
        output.setTranslateX(-10);
        output.setTranslateY(-100);
        btn1.setMaxSize(OLCHAM, OLCHAM);
        btn1.setMinSize(OLCHAM, OLCHAM);
        btn1.setTranslateX(-100);
        btn1.setTranslateY(-60);
        btn2.setMaxSize(OLCHAM, OLCHAM);
        btn2.setMinSize(OLCHAM, OLCHAM);
        btn2.setTranslateX(-50);
        btn2.setTranslateY(-60);
        btn3.setMaxSize(OLCHAM, OLCHAM);
        btn3.setMinSize(OLCHAM, OLCHAM);
        btn3.setTranslateX(0);
        btn3.setTranslateY(-60);
        btn4.setMaxSize(OLCHAM, OLCHAM);
        btn4.setMinSize(OLCHAM, OLCHAM);
        btn4.setTranslateX(-100);
        btn4.setTranslateY(-10);
        btn5.setMaxSize(OLCHAM, OLCHAM);
        btn5.setMinSize(OLCHAM, OLCHAM);
        btn5.setTranslateX(-50);
        btn5.setTranslateY(-10);
        btn6.setMaxSize(OLCHAM, OLCHAM);
        btn6.setMinSize(OLCHAM, OLCHAM);
        btn6.setTranslateX(0);
        btn6.setTranslateY(-10);
        btn7.setMaxSize(OLCHAM, OLCHAM);
        btn7.setMinSize(OLCHAM, OLCHAM);
        btn7.setTranslateX(-100);
        btn7.setTranslateY(40);
        btn8.setMaxSize(OLCHAM, OLCHAM);
        btn8.setMinSize(OLCHAM, OLCHAM);
        btn8.setTranslateX(-50);
        btn8.setTranslateY(40);
        btn9.setMaxSize(OLCHAM, OLCHAM);
        btn9.setMinSize(OLCHAM, OLCHAM);
        btn9.setTranslateX(0);
        btn9.setTranslateY(40);
        btn0.setMaxSize(OLCHAM, OLCHAM);
        btn0.setMinSize(OLCHAM, OLCHAM);
        btn0.setTranslateX(-100);
        btn0.setTranslateY(90);
        qoshish.setMaxSize(OLCHAM, OLCHAM);
        qoshish.setMinSize(OLCHAM, OLCHAM);
        qoshish.setTranslateX(-50);
        qoshish.setTranslateY(90);
        ayirish.setMaxSize(OLCHAM, OLCHAM);
        ayirish.setMinSize(OLCHAM, OLCHAM);
        ayirish.setTranslateX(0);
        ayirish.setTranslateY(90);
        kopaytirish.setMaxSize(OLCHAM, OLCHAM);
        kopaytirish.setMinSize(OLCHAM, OLCHAM);
        kopaytirish.setTranslateX(50);
        kopaytirish.setTranslateY(90);
        bolish.setMaxSize(OLCHAM, OLCHAM);
        bolish.setMinSize(OLCHAM, OLCHAM);
        bolish.setTranslateX(50);
        bolish.setTranslateY(40);
        plusminus.setMaxSize(OLCHAM, OLCHAM);
        plusminus.setMinSize(OLCHAM, OLCHAM);
        plusminus.setTranslateX(50);
        plusminus.setTranslateY(-10);
        tozalash.setMaxSize(OLCHAM, OLCHAM);
        tozalash.setMinSize(OLCHAM, OLCHAM);
        tozalash.setTranslateX(50);
        tozalash.setTranslateY(-60);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayNumber(1);
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayNumber(2);
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayNumber(3);
            }
        });
        btn4.setOnAction((ActionEvent e) -> {
            displayNumber(4);
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayNumber(5);
            }
        });

        btn6.setOnAction((ActionEvent e) -> {
            displayNumber(6);
        });

        btn7.setOnAction((ActionEvent e) -> {
            displayNumber(7);
        });

        btn8.setOnAction((ActionEvent e) -> {
            displayNumber(8);
        });

        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayNumber(9);
            }
        });

        btn0.setOnAction((ActionEvent e) -> {
            displayNumber(0);
        });

        qoshish.setOnAction((ActionEvent e) -> {
            if (operator > 0) {
                hisoblash();
            }
            operator = 1;
        });

        ayirish.setOnAction((ActionEvent e) -> {
            if (operator > 0) {
                hisoblash();
            }
            operator = 2;
        });

        kopaytirish.setOnAction((ActionEvent e) -> {
            if (operator > 0) {
                hisoblash();
            }
            operator = 3;
        });

        bolish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (operator > 0) {
                    hisoblash();
                }
                operator = 4;
            }
        });

        plusminus.setOnAction((ActionEvent e) -> {
            hisoblash();
        });

        tozalash.setOnAction((ActionEvent e) -> {
            OynaniTozalash();
        });

        qalin.setOnAction((ActionEvent e) -> {
            if (qalin.isSelected()) {
                output.setOnMousePressed((MouseEvent event) -> {
                    JOptionPane.showMessageDialog(null, "Nimalar qilyabsan");
                });
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(output);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        root.getChildren().add(btn7);
        root.getChildren().add(btn8);
        root.getChildren().add(btn9);
        root.getChildren().add(btn0);
        root.getChildren().add(qoshish);
        root.getChildren().add(ayirish);
        root.getChildren().add(kopaytirish);
        root.getChildren().add(bolish);
        root.getChildren().add(plusminus);
        root.getChildren().add(tozalash);
        //root.getChildren().add(qalin);

        Scene sklet = new Scene(root, 300, 250);

        sklet.getStylesheets().add("kalkulator/Stil.css");
        primaryStage.setTitle("Kalkulator");
        primaryStage.setScene(sklet);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void OynaniTozalash() {
        operator = 0;
        value1 = value2 = 0;
        output.setText("0");
    }

    public void displayNumber(int n) {
        if (operator == 0) {
            value1 = (value1 * 10) + n;
            output.setText(String.format("%d", value1));
        } else {
            value2 = (value2 * 10) + n;
            output.setText(String.format("%d", value2));
        }
    }

    public void hisoblash() {
        double a;
        if (operator == 1) {
            value1 += value2;
            output.setText(String.format("%d", value1));
        }
        if (operator == 2) {
            value1 -= value2;
            output.setText(String.format("%d", value1));
        }
        if (operator == 3) {
            value1 *= value2;
            output.setText(String.format("%d", value1));
        }
        if (operator == 4) {
            a = (double) value1 / (double) value2;
            output.setText(String.format("%f", a));
        }
        if (operator > 0) {
            value2 = 0;
            operator = 0;
        }
    }
}