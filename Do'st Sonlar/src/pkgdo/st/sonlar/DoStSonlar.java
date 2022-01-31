package pkgdo.st.sonlar;
import java.util.Scanner;
public class DoStSonlar {
    public static void main(String[] args) {
        Scanner kiritilgan = new Scanner(System.in);
        System.out.println("Ikki sonni kiriting");
        int son1 = kiritilgan.nextInt();
        int son1yigindi = 0;
        int son2 = kiritilgan.nextInt();
        int son2yigindi = 0;
        for(int i = 1; i < son1; i++)
            if(son1 % i == 0){
                son1yigindi += i;
            }
        for(int i = 1; i < son2; i++)
            if(son2 % i == 0)
                son2yigindi += i;
        if(son2yigindi == son1 && son1yigindi == son2)
            System.out.println("Kiritilgan sonlar do'st sonlar");
        else
            System.out.println("Kiritilgan sonlar do'st sonlar emas");
    } 
}