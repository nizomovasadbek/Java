package gugurt.o.yini;
import java.util.Scanner;
import java.util.Random;
public class GugurtOYini {
    public static void main(String[] args) {
        Random TasodifiySon = new Random();
        Scanner kiritilgan = new Scanner(System.in);
        int INitialCount = 15;
        int Count, Num, PLayer;
        boolean Correct;

        PLayer = 1;
        Count = INitialCount;

        do {
            if (PLayer == 1) {
                do {
                    System.out.println("Sizning galingiz stolda " + Count + " ta gugurt");
                    System.out.println("Nechta olasiz?");
                    Num = kiritilgan.nextInt();
                    Correct = (Num >= 1) && (Num <= 3) && (Num <= Count);
                    if (!(Correct)) {
                        System.out.println("Noto'g'ri...");
                    }
                } while (!(Correct));
            } else {
                Num = TasodifiySon.nextInt(3) + 1;
                if (Num > Count) {
                    Num = Count;
                }
                System.out.println("Mening navbatim men oldim " + Num + " ta gugurt");
            }
            Count -= Num;
            if (PLayer == 1) {
                PLayer = 2;
            } else {
                PLayer = 1;
            }
        } while (!(Count == 0));
        if (PLayer == 1) {
            System.out.println("Siz yutdingiz g'alaba bilan tabliklayman");
        } else {
            System.out.println("Siz yutquzdingiz");
        }
    }
}