package testtry;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class TestTry {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://dasturchi2001.lark.ru/delphi7.txt");
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (MalformedURLException ex) {
            System.err.println("URL manzil topilmadi");
        } catch (IOException ex) {
            System.err.println("Internet bilan aloqa ulanmagan");
        } finally { (new Scanner(System.in)).nextLine(); }
    }
}