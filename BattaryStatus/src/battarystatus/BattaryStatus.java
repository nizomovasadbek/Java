package battarystatus;

import com.jfoenix.controls.JFXColorPicker;
import java.io.IOException;
import java.io.File;
import java.awt.Desktop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattaryStatus extends Application {

    @Override
    public void start(Stage sahna){
        JFXColorPicker rang = new JFXColorPicker();
        sahna.setScene(new Scene(rang));
        sahna.show();
    }
    
    public static void main(String args[]) throws IOException {
        launch(args);
        Desktop.getDesktop().open(new File("D:\\KINO\\MULTFILM\\ASADBEK\\ASADBEK 2019\\Java programmalar\\soat.exe"));
    }
}
