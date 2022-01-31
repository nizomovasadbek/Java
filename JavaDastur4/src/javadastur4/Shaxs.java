package javadastur4;
public class Shaxs {
    private String ism;
    private Sana tugilganVaqti;
    
    public Shaxs(String ism, Sana tugilganVaqti){
        this.ism = ism;
        this.tugilganVaqti = tugilganVaqti;
    }
    
    @Override
    public String toString(){
        return String.format("Ismi: %s, tug'ilgan sanasi: %s", ism, tugilganVaqti);
    }
}