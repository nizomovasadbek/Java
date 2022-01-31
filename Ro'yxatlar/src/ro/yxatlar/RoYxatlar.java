package ro.yxatlar;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Iter<T>{
    private T value;
    public void Ornat(T values){
        value = values;
    }
    public T Ol(){
        return value;
    }
}

public class RoYxatlar {
    public static void main(String[] args) {
        Iter<Character> salom = new Iter<>();
        salom.Ornat('A');
        
        int son, keyingisi;
        Scanner kiritilgan = new Scanner(System.in);
        List<Integer> toplam = new ArrayList<>();
        do{
            System.out.println("Sonni kiriting");
            son = kiritilgan.nextInt();
            toplam.add(son);
            
            System.out.println("Keyingisi bormi bor bo'lsa 1 ni aks holda 0 ni kiriting");
            keyingisi = kiritilgan.nextInt();
            
        }while(keyingisi != 0);
        System.out.println("Ro'yxatdagi sonlar:");
        System.out.println(toplam);
    }   
}