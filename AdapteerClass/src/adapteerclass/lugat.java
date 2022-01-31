package adapteerclass;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class lugat {
    private static int idad = 1;
    private SimpleIntegerProperty id;
    private SimpleStringProperty nomi;
    private SimpleStringProperty eng;
    private SimpleStringProperty rus;
    private SimpleStringProperty izoh;
    public lugat(String nomi, String eng, String rus, String izoh){
        id = new SimpleIntegerProperty(idad);
        idad++;
        this.nomi = new SimpleStringProperty(nomi);
        this.eng = new SimpleStringProperty(eng);
        this.rus = new SimpleStringProperty(rus);
        this.izoh = new SimpleStringProperty(izoh);
    }
    
    public String getIzoh(){
        return izoh.get();
    }
    
    public void setIzoh(String izohi){
        izoh.set(izohi);
    }
    
    public String getRus(){
        return rus.get();
    }
    
    public void setRus(String newValue){
        rus.set(newValue);
    }
    
    public String getEng(){
        return eng.get();
    }
    
    public void setEng(String s){
        eng.set(s);
    }
    
    public String getNomi(){
        return nomi.get();
    }
    
    public void setNomi(String nom){
        nomi.set(nom);
    }
    
    public int getId(){
        return id.get();
    }
    public void setId(int idadr){
        id.set(idadr);
    }
}