package noto.g.ri.fe.llar;
import javafx.scene.control.TextField;
public class Fel {
    private String birinchiZamon;
    private String ikkinchiZamon;
    private String uchinchiZamon;
    private String tarjimasi;
    
    public void sozlarniOrnat(String tarjimasi ,String birinchiZamon, String ikkinchiZamon, String uchinchiZamon){
        this.birinchiZamon = birinchiZamon;
        this.ikkinchiZamon = ikkinchiZamon;
        this.uchinchiZamon = uchinchiZamon;
        this.tarjimasi = tarjimasi;
    }
    
    public boolean check(TextField t1, TextField t2, TextField t3){
        if(birinchiZamon.equals(t1.getText().toLowerCase()) && ikkinchiZamon.equals(t2.getText().toLowerCase()) && uchinchiZamon.equals(t3.getText().toLowerCase()))
            return true;
        else
            return false;
    }
    
    public String getTarjimasi(){
        return tarjimasi;
    }
    
    public String getBirinchiZamon(){
        return birinchiZamon;
    }
    public String getIkkinchiZamon(){
        return ikkinchiZamon;
    }
    public String getUchinchiZamon(){
        return uchinchiZamon;
    }
}