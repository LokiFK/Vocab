package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StatsSceneController extends Controller {

    @FXML
    public Button btnBack;

    @FXML
    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }
}
