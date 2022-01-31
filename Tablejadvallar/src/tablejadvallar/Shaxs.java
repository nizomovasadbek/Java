package tablejadvallar;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Shaxs {
    SimpleStringProperty ismi;
    SimpleStringProperty sharifi;
    SimpleStringProperty ePochtasi;
    SimpleIntegerProperty id;
    SimpleStringProperty jinsi;
    static Integer idaddr = 1;
    
    public Shaxs(String ism, String sharif, String ePochta)
    {
        id = new SimpleIntegerProperty(idaddr);
        ismi = new SimpleStringProperty(ism);
        sharifi = new SimpleStringProperty(sharif);
        ePochtasi = new SimpleStringProperty(ePochta);
        if(sharif.endsWith("a")) jinsi = new SimpleStringProperty("ayol"); 
        else jinsi = new SimpleStringProperty("erkak");
        idaddr++;
    }
    
    public String getJinsi(){
        return jinsi.get();
    }
    
    public void setJinsi(String jins){
        jinsi.set(jins);
    }
    
    public Integer getId(){
        return id.get();
    }
    
    public void setId(Integer idaddr){
        id.set(idaddr);
    }
    
    public String getIsmi(){
        return ismi.get();
    }
    public void setIsmi(String ism){
        ismi.set(ism);
    }
    public String getSharifi(){
        return sharifi.get();
    }
    public void setSharifi(String sharif){
        sharifi.set(sharif);
    }
    public String getEPochtasi(){
        return ePochtasi.get();
    }
    public void setEPochtasi(String ePochta){
        ePochtasi.set(ePochta);
    }
}