package akalendarlar.formati;
import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;
public class AKalendarlarFormati {
    public static void main(String[] args){
        GregorianCalendar kalendar = new GregorianCalendar();
        String tartiblashQatori = "";
        tartiblashQatori = String.format("Soat (00--23) %tH", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Soat (00--12) %tI", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Soat (0--23) %tk", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Soat (1--12) %tl", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Daqiqa (00--59) %tM", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Soniya (00--59) %tS", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Millesekund (000--999) %tL", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Nanosekond (00000000--99999999999) %tN", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Hududiy vaqt %tz", kalendar);
        System.out.println(tartiblashQatori);
        tartiblashQatori = String.format("Hududiy vaqt %tZ", kalendar);
        System.out.println(tartiblashQatori);
    }
}