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

//    launch various scenes
    @FXML
    public void launchVocList() throws IOException {
        switchScene((Stage) btnVocList.getScene().getWindow(), "vocab_list_scene.fxml", "Vokabelliste");
    }

    @FXML
    public void launchAddVoc() throws IOException {
        switchScene((Stage) btnAddVoc.getScene().getWindow(), "add_vocab_scene.fxml", "Vokabel hinzufügen");
    }

    @FXML
    public void launchTestVoc() throws IOException {
        switchScene((Stage) btnTestVoc.getScene().getWindow(), "test_vocab_scene.fxml", "Vokabeltest");
    }

    @FXML
    public void launchStats() throws IOException {
        switchScene((Stage) btnStats.getScene().getWindow(), "stats_scene.fxml", "Statistiken");
    }
}
