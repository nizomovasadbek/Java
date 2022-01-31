package javadastur4;
public class JavaDastur4 {
    public static void main(String[] args) {
        Sana sana1 = new Sana(24, 11, 2015);
        Sana sana2 = new Sana(3, 8, 2004);
        
        Shaxs shaxs1 = new Shaxs("Xurshid", sana1);
        Shaxs shaxs2 = new Shaxs("Javohir", sana2);
        
        System.out.printf("%s\n%s\n", shaxs1, shaxs2);
    }   
}