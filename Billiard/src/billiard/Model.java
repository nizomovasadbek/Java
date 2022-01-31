package billiard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class Model {
    public static void main(String[] args) throws Exception {
        File f = new File("D:\\encode.txt");
        File f1 = new File("C:\\new_file.wav");
        if(!f1.exists()) f1.createNewFile();
        byte[] bayt = new byte[(int)f.length()];
        FileInputStream fis = new FileInputStream(f);
        fis.read(bayt);
        fis.close();
        FileOutputStream fos = new FileOutputStream(f1);
        fos.write(Base64.getDecoder().decode(bayt));
        fos.close();
    }
    
    public static void encoder_need() throws Exception {
        File f = new File("D:\\decode.txt");
        File f1 = new File("C:\\my_newFile.txt");
        FileInputStream fis = new FileInputStream(f);
        byte[] src = new byte[(int) f.length()];
        fis.read(src);
        fis.close();
        FileOutputStream fos = new FileOutputStream(f1);
        if(!f1.exists()) f1.createNewFile();
        fos.write(Base64.getEncoder().encode(src));
        fos.close();
    }
    
}