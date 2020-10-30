package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Controller {

    @FXML
    public Button btnVocList;
    public Button btnAddVoc;
    public Button btnTestVoc;
    public Button btnStats;

    @FXML
    public void launchVocList() throws IOException {
        switchScene((Stage) btnVocList.getScene().getWindow(), "vocab_list_scene.fxml", "Vocabulary");
    }

    @FXML
    public void launchAddVoc() throws IOException {
        switchScene((Stage) btnAddVoc.getScene().getWindow(), "add_vocab_scene.fxml", "Add vocabulary");
    }

    @FXML
    public void launchTestVoc() throws IOException {
        switchScene((Stage) btnTestVoc.getScene().getWindow(), "test_vocab_scene.fxml", "Test Vocabulary");
    }

    @FXML
    public void launchStats() throws IOException {
        switchScene((Stage) btnStats.getScene().getWindow(), "stats_scene.fxml", "Statistics");
    }
}
