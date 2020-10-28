package front;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vocabs.Vokabelkasten;

import java.io.IOException;

public class MainController extends Controller {

    private Vokabelkasten vocBox = new Vokabelkasten(200);

    @FXML
    public Button btnVocList;
    public Button btnAddVoc;
    public Button btnTestVoc;
    public Button btnStats;

    @FXML
    public void launchVocList() throws IOException {
        switchScene((Stage) btnVocList.getScene().getWindow(), "vocabList.fxml", "Vocabulary");
    }

    @FXML
    public void launchAddVoc() throws IOException {
        switchScene((Stage) btnAddVoc.getScene().getWindow(), "addVoc.fxml", "Add vocabulary");
    }

    @FXML
    public void launchTestVoc() throws IOException {
        switchScene((Stage) btnTestVoc.getScene().getWindow(), "testVoc.fxml", "Test Vocabulary");
    }

    @FXML
    public void launchStats() throws IOException {
        switchScene((Stage) btnStats.getScene().getWindow(), "statsScene.fxml", "Statistics");
    }
}
