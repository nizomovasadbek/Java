package treeview.yasash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.TreeCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class TreeViewYasash extends Application {
    
    ImageView ildizkorxona = new ImageView(new Image(TreeViewYasash.class.getResourceAsStream("ildiz.bmp")));
    
    ImageView ildizIkonkasi = new ImageView(new Image(getClass().getResourceAsStream("fayl.bmp")));
    
    List<Hodim> hodimlar = Arrays.asList(
     new Hodim("Abdulhakimov Isomiddin", "Harid qilish bo'limi"),
     new Hodim("Mamatkarimov Karimberdi", "Harid qilish bo'limi"),
     new Hodim("Tojiboyev Alisher", "Harid qilish bo'limi"),
     new Hodim("Jabborov Shuxrat", "Harid qilish bo'limi"),
     new Hodim("Sobirov Ilhom", "Harid qilish bo'limi"),
     new Hodim("Lutfidin Sobirov", "Axborot tizimlar"),
     new Hodim("Umidjon Holmirzayev", "Axborot tizimlar"),
     new Hodim("Rustambek G'anijonov", "Axborot tizimlar"),
     new Hodim("Hamidov Alisher", "Bug'alteriya bo'limi"),
     new Hodim("Ahmedov Ma'murjon", "Bug'alteriya bo'limi"),
     new Hodim("Umarov Anvarjon", "Bug'alteriya bo'limi")
    );
    
    TreeItem<String> ildiz = new TreeItem<>("Korxona hodimlari boshqaruvi", ildizkorxona);
    
    @Override
    public void start(Stage primaryStage) {
        ildiz.setExpanded(true);
        for(Hodim hodim:hodimlar){
            TreeItem<String> hodimBarg = new TreeItem<>(hodim.getIsmi());
            boolean topildi = false;
            for(TreeItem<String> bolimQism: ildiz.getChildren()){
                if(bolimQism.getValue().contentEquals(hodim.getBolimi())){
                    System.out.println(bolimQism.getValue());
                    bolimQism.getChildren().add(hodimBarg);
                    topildi = true;
                    break;
                }
            }
            if(!topildi){
                TreeItem<String> bolimQism = new TreeItem<>(hodim.getBolimi(), new ImageView(
                        new Image(getClass().getResourceAsStream("fayl.bmp"))));
            
            ildiz.getChildren().add(bolimQism);
            bolimQism.getChildren().add(hodimBarg);// .getChildren.add(hodimBarg);
        }
        
    }
        TreeView daraxt = new TreeView(ildiz);
        daraxt.setEditable(true);
        daraxt.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> param) {
                return new MatnMaydonYacheyka();
            }
            
        });
        
        VBox vb = new VBox(daraxt);
        Scene scene = new Scene(vb, 300, 400);
        
        primaryStage.setTitle("Korxona hodimlari");
        primaryStage.setScene(scene);
        primaryStage.show();
}
}