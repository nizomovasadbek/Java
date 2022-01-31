package arxitektura.rasmlar.to.plami;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.PaginationBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ArxitekturaRasmlarToPlami extends Application {

    private Pagination pagination;
    private Image[] images = new Image[18];

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        VBox outerBox = new VBox();
        outerBox.setAlignment(Pos.CENTER);
        //Images for our pages
        for (int i = 0; i < 19; i++) {
            images[i] = new Image(ArxitekturaRasmlarToPlami.class.getResource("img" + (i + 1) + ".jpg").toExternalForm()
                    , false);
        }

        pagination = PaginationBuilder.create().pageCount(18).pageFactory(new Callback<Integer, Node>() {           
            @Override public Node call(Integer pageIndex) {
                return createAnimalPage(pageIndex);
            }
        }).build();
        //Style can be numeric page indicators or bullet indicators
        Button styleButton = ButtonBuilder.create().text("Almashtirish").onAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent me) {
                if (!pagination.getStyleClass().contains(Pagination.STYLE_CLASS_BULLET)) {
                    pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
                } else {
                    pagination.getStyleClass().remove(Pagination.STYLE_CLASS_BULLET);
                }
            }
        }).build();

        outerBox.getChildren().addAll(pagination, styleButton);
        root.getChildren().add(outerBox);
    }
    //Creates the page content
    private VBox createAnimalPage(int pageIndex) {
        VBox box = new VBox();
        ImageView iv = new ImageView(images[pageIndex]);
        box.setAlignment(Pos.CENTER);
        Label desc = new Label("PAGE " + (pageIndex + 1));
        box.getChildren().addAll(iv, desc);
        return box;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}