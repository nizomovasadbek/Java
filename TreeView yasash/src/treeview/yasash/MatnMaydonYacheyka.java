package treeview.yasash;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public class MatnMaydonYacheyka extends TreeCell<String>{
    private TextField matnMaydon;
    private String qatorniOlish(){
        return getItem() == null ? "" : getItem();
    }
    private void matnMaydonYasash(){
        matnMaydon = new TextField(qatorniOlish());
        matnMaydon.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER))
                    commitEdit(matnMaydon.getText());
                else if(event.getCode().equals(KeyCode.ESCAPE))
                    cancelEdit();
            }
        });
    }
    @Override
    public void startEdit(){
        super.startEdit();
        if(matnMaydon == null)
            matnMaydonYasash();
        setText(null);
        setGraphic(matnMaydon);
    }
    @Override
    public void cancelEdit(){
        super.cancelEdit();
        setText(getItem());
        setGraphic(getTreeItem().getGraphic());
    }
    @Override
    public void updateItem(String qism, boolean bosh){
        super.updateItem(qism, bosh);
        if(bosh){
            setText(null);
            setGraphic(null);
        } else {
            setText(qatorniOlish());
            setGraphic(getTreeItem().getGraphic());
        }
    }
}