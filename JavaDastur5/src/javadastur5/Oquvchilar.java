package javadastur5;
public class Oquvchilar {
  private int yosh;
  private double ogirligi;
  private String ismi, familiyasi, sharifi;
  protected int oquvchilarSoni = 0;

    public Oquvchilar(int yosh, double ogirligi, String ismi, String familiyasi, String sharifi) {
        this.yosh = yosh;
        this.ogirligi = ogirligi;
        this.ismi = ismi;
        this.familiyasi = familiyasi;
        this.sharifi = sharifi;
    }
    
    public int getYosh(){
        return yosh;
    }  
    
    public double getOgirligi(){
        return ogirligi;
    }
    
    public String getIsmi(){
        return ismi;
    }
    
    public String getFamiliyasi(){
        return familiyasi;
    }
    
    public String getSharifi(){
        return sharifi;
    }
    
    public int getOquvchilarSoni(){
        return oquvchilarSoni;
    }
    
    @Override
    public String toString(){
        return String.format("Yoshi:%d\nOg'irligi:%f\nIsm va familiyasi: %s %s %s\n---------------------", yosh, ogirligi, ismi, familiyasi, sharifi);
    }
  
}