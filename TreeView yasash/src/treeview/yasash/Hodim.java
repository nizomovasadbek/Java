package treeview.yasash;

import javafx.beans.property.SimpleStringProperty;

public class Hodim {
    private SimpleStringProperty ismi;
    private SimpleStringProperty bolimi;

    Hodim(String ism, String bolim) {
        ismi = new SimpleStringProperty(ism);
        bolimi = new SimpleStringProperty(bolim);
        
    }
    
    public String getIsmi(){
        return ismi.get();
    }
    
    public void setIsmi(String ism){
        ismi.set(ism);
    }
    
    public String getBolimi(){
        return bolimi.get();
    }
    
    public void setBolimi(String bolim){
        bolimi.set(bolim);
    }
    
}