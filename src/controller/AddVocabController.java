package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.KeyAdapter;
import java.io.IOException;

public class AddVocabController extends Controller {


    @FXML
    public Button btnBack;
    public Button btnSave;
    public TextField lbGerman;
    public TextField lbEnglish;
    public GridPane mainGrid;

    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

    @FXML
    public void saveVocab() {
//        add vocabulary to vocabBox
        if (!(lbGerman.getText().equals("") && lbEnglish.getText().equals(""))) {
            Main.addVocab(lbGerman.getText(), lbEnglish.getText());
            lbGerman.setText("");
            lbEnglish.setText("");
        } else {
            lbEnglish.setPromptText("Please enter a word...");
            lbGerman.setPromptText("Please enter a word...");
        }
    }

    @FXML
    public void checkIfEnterKeyTyped(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER)
            saveVocab();
    }
}
