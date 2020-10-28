package front;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddVocController extends MainController {


    @FXML
    public Button btnBack;
    public Button btnSave;
    public TextField lbGerman;
    public TextField lbEnglish;

    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

    @FXML
    public void saveVocab() {
        addVoc(lbGerman.getText(), lbEnglish.getText());
        System.out.println(getVoc().toString());
        lbGerman.setText("");
        lbEnglish.setText("");
    }
}
