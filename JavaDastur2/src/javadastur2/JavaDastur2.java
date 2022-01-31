package javadastur2;

import java.util.PriorityQueue;

public class JavaDastur2 {
    public static void main(String[] args) {
       Bemor bemor1 = new Bemor("Lutfiddin", "Kamqonlik", 2);
       Bemor bemor2 = new Bemor("Shermuhammad", "Gripp", 3);
       Bemor bemor3 = new Bemor("Muhhammadziyo", "Travma", 1);
       Bemor bemor4 = new Bemor("Farhod", "Ko'rik", 4);
       
        PriorityQueue<Bemor> pp = new PriorityQueue<>();
        pp.offer(bemor1);
        pp.offer(bemor2);
        pp.offer(bemor3);
        pp.offer(bemor4);
        
        System.out.println(pp.poll());
        System.out.println(pp.poll());
        System.out.println(pp.poll());
        System.out.println(pp.poll());
 }
}