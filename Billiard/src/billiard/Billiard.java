package billiard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Base64;
import java.util.Scanner;

public class Billiard {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("So'zni kiriting: ");
            String soz = scan.next();
            String url_str = "https://api.funtranslations.com/translate/morse/audio?text="+soz+
                    "&speed=20&tone=1000";
            URL url = new URL(url_str);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String json = "";
            String line = "";
            while((line = buffer.readLine())!=null){
                json += line;
            }
            
            con.disconnect();
            buffer.close();
            
            JSONObject json_object = new JSONObject(json);
            String contents = json_object.get("contents").toString();
            JSONObject obj1 = new JSONObject(contents);
            String translated = obj1.get("translated").toString();
            JSONObject obj2 = new JSONObject(translated);
            String audio = obj2.get("audio").toString();
            
            String base64_need_encode = audio.substring(23);
            File f = new File("D:\\morse.wav");
            if(!f.exists()) f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(Base64.getDecoder().decode(base64_need_encode.getBytes()));
            fos.close();
            
            String null_str = null;
            null_str.equals(null);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}