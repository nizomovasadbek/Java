package ikki.sonning.yig.indisi;
import javax.swing.JFrame;
public class IkkiSonningYigIndisi {
    public static void main(String[] args) {
       JFrame oyna = new JFrame("Javada grafika");
       oyna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       asosiyOyna grafika = new asosiyOyna();
       oyna.add(grafika);
       oyna.setSize(400, 300);
       oyna.setLocation(150, 150);
       oyna.setVisible(true);
    }
}