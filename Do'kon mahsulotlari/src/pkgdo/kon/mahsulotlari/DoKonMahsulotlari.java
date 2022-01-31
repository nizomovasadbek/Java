package pkgdo.kon.mahsulotlari;
import java.util.*;
public class DoKonMahsulotlari {
    public static void main(String[] args) {
        Scanner kiritilgan = new Scanner(System.in);
        List<Mahsulotlar> toplam = new ArrayList<>();
        boolean bormi; // agar keyingisi kelsa true aks holda false qiymat qaytaradi.
        double mahsulotNarxi = .0;
        double summa = 0;
        double mahsulotogiligi_kgda = 0;//kg
        double b;
        bormi = true;
        while(bormi){
            Mahsulotlar mahsulot = new Mahsulotlar(mahsulotNarxi, mahsulotogiligi_kgda);
            System.out.println("Keyingisi bormi:"); // ekranga chiqaramiz lekin aslida ekranga emas lazerga tayanadi.
            b = kiritilgan.nextShort();
            if(b == 0){ // 1 qiymat kiritilsa davom etadi 0 qiymatda tsikldan chiqadi.
                bormi = false;
                break;
            }
            System.out.println("Keyingisi qo'shilsin kilogrami\nMasalan 18.5 o'n sakkiz yarim kilo ko'rinishida");
            mahsulot.ogirligi = kiritilgan.nextDouble();
            System.out.println("So'mmasi qo'shilsin\nMasalan 5000 besh ming so'm ko'rinishida");
            mahsulot.sommasi = kiritilgan.nextDouble();
            toplam.add(mahsulot);
        }
        
        for(int i = 0; i < toplam.size(); i++){
          b = (toplam.get(i).sommasi * toplam.get(i).ogirligi);
          summa += b;
        }
        System.out.println("Mahsulotlarning umumiy summasi " + summa);
    }
}