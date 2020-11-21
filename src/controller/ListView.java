package controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ListView extends Controller {

    /*
    * Diese Klasse habe ich nur erstellt,
    * um sie beim Einkaufslistenprogramm wiederverwenden zu können.
    * */

    @FXML
    public Button btnBack;
    public ScrollPane scrollPane = new ScrollPane();
    public Button loadContent;

    protected Pane createLineToScrollPane(Label label, Button... buttons) {
       Pane content;
       BorderPane borderPane = new BorderPane();
       GridPane gridPane = new GridPane();
       borderPane.setPrefWidth(scrollPane.getWidth()-20);
       borderPane.setLeft(label);
       for (int i = 0; i < buttons.length; i++) {
           gridPane.add(buttons[i], i, 0);
       }
       borderPane.setRight(gridPane);
       borderPane.getStyleClass().add("borderLayout");
       if (scrollPane.getContent() == null)
           content = new Pane(borderPane);
       else
           content = new Pane(new VBox(scrollPane.getContent(), borderPane));
       borderPane.setPadding(new Insets(10));
       return content;
    }

    protected void addLineToScrollPane(Label label, Button ...buttons) {
        scrollPane.setContent(createLineToScrollPane(label, buttons));
    }
}
