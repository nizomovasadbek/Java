package generic.metod;
public class GenericMetod {
    public static void main(String[] args) {
        Integer[] intMassiv = {1, 2, 3, 4};
        Character[] charMassiv = {'J', 'a', 'v', 'a'};
        massivniKorsat(intMassiv);
        massivniKorsat(charMassiv);
    }
    private static <T> void massivniKorsat(T[] massiv){
        for(T x:massiv)
            System.out.printf("%s ", x);
        System.out.println("\b");
    }
}