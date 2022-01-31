package faylclass;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FaylClass {
    private Scanner fayl;
    public static void main(String[] args) {
        FaylClass obekt = new FaylClass();
        obekt.faylniOchish();
        obekt.fayldanOqish();
        obekt.faylniYopish();
        
    }
    public void faylniOchish(){
        try{
            fayl = new Scanner(new File("D:\\fayl.txt"));
        } catch(FileNotFoundException e){
            System.out.println("Hatolik Sodir bo'ldi");
        }
    }
    
    public void fayldanOqish(){
        int cCycleCount = 0;
        while(fayl.hasNext()){
            cCycleCount++;
            String qator = fayl.nextLine();
            System.out.println(cCycleCount + "." + qator);
        }
    }
    public void faylniYopish(){
        fayl.close();
    }
}