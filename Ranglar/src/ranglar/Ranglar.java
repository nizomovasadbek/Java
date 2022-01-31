package ranglar;
import java.util.Scanner;
public class Ranglar {
    public static void main(String[] args) {
        int son1, son2, son3;
        Scanner kiritilgan = new Scanner(System.in);
        System.out.print("Qizil rangni kiriting: ");
        son1 = kiritilgan.nextInt();
        System.out.print("Yashil rangni sonnini kiriting: ");
        son2 = kiritilgan.nextInt();
        System.out.print("Ko'k rangni sonini kiriting: ");
        son3 = kiritilgan.nextInt();
        System.out.printf("#%x%x%x\n", son1, son2, son3);
    }   //Nizomov Asadbek 
} // 1-Masala