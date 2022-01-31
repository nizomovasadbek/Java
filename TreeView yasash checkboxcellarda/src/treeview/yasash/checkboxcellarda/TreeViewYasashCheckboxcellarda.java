package treeview.yasash.checkboxcellarda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.stage.Stage;

public class TreeViewYasashCheckboxcellarda extends Application {

    @Override
    public void start(Stage primaryStage) {
        CheckBoxTreeItem ildizQism = 
                new CheckBoxTreeItem("Source fayllarni ko'rish");
        ildizQism.setExpanded(true);
        TreeView daraht = new TreeView(ildizQism);
        daraht.setCellFactory(CheckBoxTreeCell.forTreeView());
        for(int i = 0; i < 8; i++){
            CheckBoxTreeItem checkboxtreeitem 
                    = new CheckBoxTreeItem("Na'muna " + (i+1));
            ildizQism.getChildren().add(checkboxtreeitem);
        }
        ildizQism.setIndependent(true);
        primaryStage.setTitle("TreeView ga na'muna");
        primaryStage.show();
        primaryStage.setScene(new Scene(daraht));
        
    }
}