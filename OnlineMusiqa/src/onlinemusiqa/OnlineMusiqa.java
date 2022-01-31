package onlinemusiqa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
public class OnlineMusiqa extends Application {
    
    private Label foiz_label = new Label();
    private JFXButton download_button = new JFXButton("Yuklash");
    private JFXProgressBar indicator = new JFXProgressBar(0);
    private File out;
    private String url;
    public final int BIT = 1024;
    
    @Override
    public void start(Stage sahna){
        sahna.setTitle("Online musiqa");
        TextField input_url = new TextField();
        FileChooser choose = new FileChooser();
        download_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                choose.setTitle("Faylni saqlash");
                out = choose.showSaveDialog(null);
                url = input_url.getText();
                (new Thread(new Runnable(){
                   @Override
                   public void run(){
                       try{
                        URL manzil = new URL(url);
                        HttpURLConnection http = (HttpURLConnection) manzil.openConnection();
                        double fileSize = (double) http.getContentLengthLong();
                        BufferedInputStream bis = new BufferedInputStream(http.getInputStream());
                        FileOutputStream fos = new FileOutputStream(out);
                        BufferedOutputStream bos = new BufferedOutputStream(fos, BIT);
                        byte buffer[] = new byte[BIT];
                        double downloaded = 0.0;
                        int read = 0;
                        double foiz = 0.0;
                        while((read = bis.read(buffer, 0, BIT)) >= 0){
                            bos.write(buffer, 0, read);
                            downloaded += read;
                            foiz = (downloaded*100)/fileSize;
                            //foiz_label.setText(foiz + "%");
                            indicator.setProgress(foiz/100);
                            System.out.println(foiz + "%");
                        }
                        bos.close();
                        bis.close();
                    } catch (MalformedURLException ex) {
                        JOptionPane.showMessageDialog(null, "URL mavjud emas");
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Faylda xatolik");
                        ex.printStackTrace();
                    }
                   }
                })).start();
            }
        });
        HBox hb = new HBox(15, indicator, download_button);
        VBox root = new VBox(10, input_url, hb, foiz_label);
        Scene scene = new Scene(root);
        sahna.setScene(scene);
        sahna.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}