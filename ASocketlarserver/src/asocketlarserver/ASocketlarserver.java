package asocketlarserver;
import java.io.BufferedReader;
import java.net.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class ASocketlarserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();
        System.out.println("Klent bilan aloqa ulandi");
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        
        String str = bf.readLine();
        String str1 = bf.readLine();
        System.out.println("Klent dan kelgan xabar:\n" + str + "\n" + str1);
        
        PrintWriter pw = new PrintWriter(s.getOutputStream());
        pw.println("Salom bu serverdan kelgan xabar");
        pw.close();
    }
}