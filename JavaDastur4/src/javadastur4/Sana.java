package javadastur4;
public class Sana { 
    private int kun, oy, yil;
    
    public Sana(int kun, int oy, int yil){
        this.kun = kun;
        this.oy = oy;
        this.yil = yil;
    }
    
    @Override
    public String toString(){
        return String.format("%02d.%02d.%04d yil", kun, oy, yil);
    }
}