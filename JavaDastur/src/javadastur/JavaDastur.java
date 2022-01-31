package javadastur;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JavaDastur {
    public static void main(String[] args) {
        Runtime.getRuntime().load("D:\\Database.exe");
        try{
            Runtime.getRuntime().exec("D:\\Database.exe");
        }catch(IOException ex){
            Logger.getLogger(JavaDastur.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}