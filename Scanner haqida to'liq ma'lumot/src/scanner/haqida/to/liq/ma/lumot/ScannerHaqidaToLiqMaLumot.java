package scanner.haqida.to.liq.ma.lumot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerHaqidaToLiqMaLumot {
    public static void main(String[] args) {
        try {
            FileInputStream manba = new FileInputStream("D:\\hususiyatlar.ini");
            Properties congf = new Properties();
            congf.load(manba);
            System.out.println(congf.getProperty("Shrift o'lchami"));
            System.out.println(congf.getProperty("Fon Ranggi"));
        } catch (IOException ex) {
            Logger.getLogger(ScannerHaqidaToLiqMaLumot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}