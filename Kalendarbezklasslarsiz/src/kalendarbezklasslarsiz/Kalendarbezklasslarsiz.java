package kalendarbezklasslarsiz;
import java.util.Scanner;
import java.util.GregorianCalendar;
public class Kalendarbezklasslarsiz {
    public static void main(String[] args) {
        String[] oylar = {"YANVAR", "FEVRAL", "MART", "APREL", "MAY", "IYUN", "IYUL", "AVGUST", "SENTABR"
        , "OKTABR", "NOYABR", "DEKABR"};
        String[] kunlar = {"DUSHANBA", "SESHANBA", "CHORSHANBA", "PAYSHANBA", "JUMA", "SHANBA", "YAKSHANBA"};
        GregorianCalendar gc = new GregorianCalendar();
        int yil = gc.get(GregorianCalendar.YEAR);
        System.out.printf("Joriy yil:\t%d-yil\n",yil);
        int kabisa=28, b=0;
        if(yil%4==0) kabisa = 29; else kabisa=28; 
        int arr[] = {31,kabisa,31,30,31,30,31,31,30,31,30,31};
        Scanner kiritilgan = new Scanner(System.in);
        System.out.println("Kun sonini kiriting");
        int kunSoni = kiritilgan.nextInt();
        int kunSoniNusxa=0, haftaSoni=0;
        kunSoniNusxa = kunSoni;
        for(int i=0; i < arr.length; i++)
            if(kunSoniNusxa > arr[i]) kunSoniNusxa -= arr[i]; else  { b=i; break; }
        haftaSoni = kunSoniNusxa;
        while(haftaSoni > 7)
            haftaSoni -= 7;
        System.out.println("Kiritilgan kun "+oylar[b]+" oyining "+kunSoniNusxa+" kuniga to'g'ri keladi.");
        System.out.println("Haftaning kuni:\t"+kunlar[haftaSoni-1]);
    }
}