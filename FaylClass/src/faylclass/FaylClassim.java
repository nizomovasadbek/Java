package faylclass;
import java.util.Formatter;
public class FaylClassim {
    private Formatter fayl;
    
    public void faylOchish(){
        try{
            fayl = new Formatter("D:\\Faylimiz.txt");
            
        }catch(Exception e){
            System.out.println("Xatolik sodir bo'ldi!");
        }
    }
    public void faylgaYozish(){
        fayl.format("%s", "Biz yozgan matn");
    }
    public void yopish(){
        fayl.close();
    }
}