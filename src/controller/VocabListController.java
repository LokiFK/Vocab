package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

    public void loadVoc() {
        System.out.println(Main.getVocabBox().toString() + 1);
        listVocabs.setContent(new Label(Main.getVocabBox().toString()));
    }
}
