package jahonchempionati2022;

import java.util.List;
import java.util.regex.*;

public class Guruh {
    private Kommanda birinchiKommanda;
    private Kommanda ikkinchiKommanda;
    private String malumotlar = "";
    public int hisobBirinchiKommanda = 0;
    public int hisobIkkinchiKommanda = 0;
    public Guruh(Kommanda birinchiKommanda, Kommanda ikkinchiKommanda){
        this.birinchiKommanda = birinchiKommanda;
        this.ikkinchiKommanda = ikkinchiKommanda;
    }
    private boolean tekshir(){
        Pattern tartib = Pattern.compile("\\D+", Pattern.UNICODE_CASE);
        Matcher mostlik1 = tartib.matcher(birinchiKommanda.getTextField().getText());
        Matcher mostlik2 = tartib.matcher(ikkinchiKommanda.getTextField().getText());
        if(mostlik1.find() || mostlik2.find()){
            return false;
        }
        else return true;
   }
    
    public Kommanda Kommanda1(){
        return birinchiKommanda;
    }
    public Kommanda Kommanda2(){
        return ikkinchiKommanda;
    }
    
    public Kommanda YutganKommandaniAniqlash(){
        if(tekshir()){
            hisobBirinchiKommanda = Integer.parseInt(birinchiKommanda.getTextField().getText());
            hisobIkkinchiKommanda = Integer.parseInt(ikkinchiKommanda.getTextField().getText());
            if(hisobBirinchiKommanda>hisobIkkinchiKommanda) return birinchiKommanda;
            else if(hisobBirinchiKommanda<hisobIkkinchiKommanda) return ikkinchiKommanda;
            else if(hisobBirinchiKommanda==hisobIkkinchiKommanda){  birinchiKommanda.setUserData("Durang");
            return birinchiKommanda;
            }
        }
        return null;
    }
    
    public Kommanda yutquzganKommandaniAniqlash(){
        Kommanda k = YutganKommandaniAniqlash();
        if(k.equals(birinchiKommanda)) return ikkinchiKommanda; else
        if(k.equals(ikkinchiKommanda)) return birinchiKommanda;
        else
            return null;
    }
    
    public String durang(){
        return "Durang";
    }
    public void setUserData(String text){
        malumotlar = text;
    }
    public String getUserData(){
        return malumotlar;
    }
}