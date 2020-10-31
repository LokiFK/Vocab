package controller;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VocabListController extends Controller {

    @FXML
    public Button btnBack = new Button();
    public GridPane grid = new GridPane();
    public ScrollPane listVocabs = new ScrollPane();
    public Button loadVoc;

    @FXML
    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

//    load all vocabs into scroll pane
    public void loadVoc() {
        if (Main.getVocabBox().size() > 0) {
            listVocabs.setContent(new Label(Main.getVocabBox().toString()));
        } else {
            new Alert(Alert.AlertType.ERROR, "Die Vokabelliste ist leer!\nGehe in das 'Vokabel hinzufügen'-Menü,\num Vokabeln hinzuzufügen.", ButtonType.CLOSE).show();
        }
    }
}
