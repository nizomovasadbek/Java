package sachat;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.Scanner;
public class Sachat implements Runnable {
    
    String link;
    File out;
    
    public Sachat(String link, File out){
        this.link = link;
        this.out = out;
    }
    
    @Override
    public void run(){
        try{
            URL url = new URL(link);
            URLConnection http = url.openConnection();
            http.connect();
            double fileSize = (double) http.getContentLengthLong();
            BufferedInputStream bis = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double persent = 0.00;
            while((read = bis.read(buffer, 0, 1024)) >= 0){
                bos.write(buffer, 0, read);
                downloaded += read;
                persent = (downloaded*100)/fileSize;
                String persent_str = String.format("%.4f", persent);
                System.out.println("Skachat qilindi\t" + persent_str + "%");
            }
            bos.close();
            bis.close();
            System.out.println("Skachat qilish tugatildi");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        /*String other_link = "http://iiti.ac.in/people/~tanimad/JavaTheCompleteReference.pdf";
        String  link = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        File chiqish = new File("D:\\demoVideo.pdf");
        new Thread(new Sachat(other_link, chiqish)).start();*/
        InputStream fileIn;
        FileOutputStream fileOut;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter URL: ");
        String urlStr = s.nextLine();

        if(!urlStr.startsWith("http([s])?://")) urlStr = "http://" + urlStr;
        
        URL url = new URL(urlStr);
        URLConnection urlConnect = url.openConnection();
        fileIn = urlConnect.getInputStream();

        System.out.println("Enter file name: ");
        String fileStr = s.nextLine();
        fileOut = new FileOutputStream(fileStr);

        int a = 0;
        while ((a = fileIn.read()) != -1) {   
            fileOut.write(a);
        }
        System.out.println("File is downloaded");

    }
}