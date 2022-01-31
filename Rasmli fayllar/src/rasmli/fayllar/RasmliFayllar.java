package rasmli.fayllar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class RasmliFayllar {
    public static void main(String[] args) {
        try{
            BufferedImage originalImage = ImageIO.read(new File("D:\\15.png"));
            BufferedImage subImage = originalImage.getSubimage(0, 0, 45, 45);
            File outPutFile = new File("D:\\rasmcha.jpg");
            ImageIO.write(subImage, "jpg", outPutFile);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Hatolik sodir bo'ldi.");
        }
    }   
}