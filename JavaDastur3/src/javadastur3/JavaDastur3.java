package javadastur3;
public class JavaDastur3 {
public static void main(String[] args) {
    double son = urtacha(1,5,3,7,4,8,2);
    System.out.println("Sonlarning o'rtacha qiymati: " + son);
 }
  private static double urtacha(int ... qiymatlar){
      int yigindi = 0;
      double urtachaQiymat = 0;
      
      for(int i = 0; i < qiymatlar.length; i++)
          yigindi += qiymatlar[i];
      urtachaQiymat = (double) yigindi / (double) qiymatlar.length;
      
      return urtachaQiymat;
  }
}