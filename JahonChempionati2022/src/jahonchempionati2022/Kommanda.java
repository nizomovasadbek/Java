package jahonchempionati2022;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Kommanda {
    private TextField tf = new TextField();
    private Label label = new Label();
    private Object malumotlar = "Ma'lumotlar mavjud emas";
    private int idAdres = 0;
    private int ochko = 0;
    public Kommanda(String kommandaNomi){
        label.setText(kommandaNomi);
        tf.setPrefSize(40, 10);
    }
    public void joylashuv(int x, int y){
        label.setTranslateX(x);
        label.setTranslateY(y);
        tf.setTranslateX(x+70);
        tf.setTranslateY(y);
    }
    public Label getLabel(){
        return label;
    }
    public TextField getTextField(){
        return tf;
    }
    public void setUserData(Object qiymat){
        malumotlar = qiymat;
    }
    public Object getUserData(){
        return malumotlar;
    }
    public void setId(int id){
        idAdres = id;
    }
    public int getId(){
        return idAdres;
    }
    @Override
    public String toString(){
        return label.getText();
    }
}
