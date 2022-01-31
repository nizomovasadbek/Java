package asocketclient;
import java.net.*;
import java.io.*;
public class ASocketclient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Salom");
        pr.println("Yaxshimisiz oka");
        pr.flush();
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        char[] cbuf = new char[100];
        isr.read(cbuf);
        System.out.println(new String(cbuf));
    }
}