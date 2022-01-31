package generic.metod.javob.qaytaruvchi;
import java.util.Arrays;
public class GenericMetodJavobQaytaruvchi {
    public static void main(String[] args) {
        System.out.println(maximum(1, 2, 4, 5, 9, 22, 100, -1, -3));
        System.out.println(maximum('x', 'e', 'r', 'o', 'z', 'a', 'w'));
        System.out.println(maximum("Anor", "Olma", "Pomidor", "Behi"));
    }
    private static <T extends Comparable<T>> T maximum(T ... qiymatlar){
        Arrays.sort(qiymatlar);
        return qiymatlar[qiymatlar.length - 1];
    }
}