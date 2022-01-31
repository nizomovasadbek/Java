package javadastur2;
public class Bemor implements Comparable<Bemor>{
   private String ismi;
   private String sabab;
   private int ahamiyati;
   
   public Bemor(String ismi, String sabab, int ahamiyati){
       this.ahamiyati = ahamiyati;
       this.ismi = ismi;
       this.sabab = sabab;
   }
   public String getIsmi(){
       return ismi;
   }
   
   public int getAhamiyati(){
       return ahamiyati;
   }

   public int compareTo(Bemor bemor) {
        if(this.getAhamiyati() == bemor.getAhamiyati())
            return 0;
        else
            if(this.getAhamiyati() > bemor.getAhamiyati()) return 1;
            else return -1;
    }
   @Override
   public String toString(){
       return ismi;
   }
}
