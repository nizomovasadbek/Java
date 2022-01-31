package pkgdo.kon.mahsulotlari;
public class Mahsulotlar {

 public double ogirligi;
 public double sommasi;
 
 public Mahsulotlar(double o, double s){
     sommasi = s;
     ogirligi = o;
 }
 
 public double getsumma(){
   return sommasi;
 }
 public double getogirligi(){
     return ogirligi;
 }
}