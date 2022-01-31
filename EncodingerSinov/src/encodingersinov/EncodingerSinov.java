package encodingersinov;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.Charset;

public class EncodingerSinov {
    public static void main(String[] args) {
        System.out.println("1-fayl.txt:");
	baytlarOqish("D:"+File.separator+"1-fayl.txt");
        belgilarniOqish("D:"+File.separator+"1-fayl.txt", Charset.forName("windows-1251"));
        
	System.out.println("\n2-fayl.txt:");
	baytlarOqish("D:"+File.separator+"2-fayl.txt");
        belgilarniOqish("D:"+File.separator+"2-fayl.txt", Charset.forName("UTF-8"));
        
	System.out.println("\n3-fayl.txt:");
	baytlarOqish("D:"+File.separator+"3-fayl.txt");
        belgilarniOqish("D:"+File.separator+"3-fayl.txt", Charset.forName("UTF-16"));
        
//	System.out.println("\n4-fayl.txt:");
//	baytlarOqish("D:"+File.separator+"4-fayl.txt");
//        belgilarniOqish("D:"+File.separator+"4-fayl.txt", Charset.forName("MAC"));
    }
    private static void baytlarOqish(String faylNomi){
		try {
			FileInputStream manba = new FileInputStream(faylNomi);
			int bayt;
			while((bayt=manba.read())!=-1){
				System.out.print(bayt+", ");
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("Fayl topilmadi.");
		} catch(IOException e){
			System.out.println("Fayllar bilan ishlashda xatolik vujudga keldi.");
		}
	}
    protected static void belgilarniOqish(String faylNomi, Charset charsetNomi){
        try {
            FileInputStream manba = new FileInputStream(faylNomi);
            byte[] bayt = new byte[manba.available()];
            manba.read(bayt);
            System.out.println(new String(bayt, charsetNomi));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EncodingerSinov.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException e){
            Logger.getLogger(EncodingerSinov.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}