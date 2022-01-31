package javadan.kuchaytirilgan.darslar.regex;
import java.util.*;
import java.util.regex.*;
public class JavadanKuchaytirilganDarslarRegex {
    public static void main(String[] args) {
        Scanner kiritilgan = new Scanner(System.in);
        while(true){
            System.out.println("Dasturni yakunlash uchun 'ch' ni kiriting");
            System.out.println("Tartibni kiriting:");
            String kiritilganTartib = kiritilgan.nextLine();
            
            if(kiritilganTartib.equals("ch")){
                System.out.println("Dastur yakunlandi.");
                break;
            }
            
            System.out.println("Matnni kiriting");
            String kiritilganMostlik = kiritilgan.nextLine();
            char[] belgilar = new char[kiritilganMostlik.length()];
            int sanoq=0;
            
            Pattern tartib = Pattern.compile(kiritilganTartib);
            Matcher mostlik = tartib.matcher(kiritilganMostlik);
            
            while(mostlik.find()){
                Arrays.fill(belgilar, mostlik.start(), mostlik.end(), '^');
                sanoq++;
            }
            if(sanoq>0){
                System.out.println(kiritilganMostlik);
                System.out.println(belgilar);
                System.out.println(sanoq + " ta moslik topildi.");
            } else 
                System.out.println("Mosliklar topilmadi!");
        }
    }
}