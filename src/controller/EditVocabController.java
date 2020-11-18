package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vocabulary.Vocab;

import java.io.IOException;

public class EditVocabController extends Controller {

    @FXML
    public Button backBtn;
    public Button saveBtn;
    public TextField germanTxt;
    public TextField englishTxt;

//    go back to vocablist
    public void goToParentScene() throws IOException {
        switchScene((Stage) backBtn.getScene().getWindow(), "vocab_list_scene.fxml", "Vocablist");
    }

//    update the vacab
    public void saveChanges() {
        System.out.println(germanTxt.getText());
        if (!(germanTxt.getText().equals("") || englishTxt.getText().equals(""))) {
            Main.getVocabBox().updateVocab(new Vocab(germanTxt.getText(), englishTxt.getText()), Main.getCurrentVocab());
            germanTxt.setText("");
            englishTxt.setText("");
        } else {
            germanTxt.setPromptText("Bitte eine neue Vokabel eingeben...");
            englishTxt.setPromptText("Bitte eine neue Vokabel eingeben...");
        }
    }

    @FXML
    public void checkIfEnterKeyTyped(KeyEvent keyEvent) {
//        if enter then save the vocab
        if(keyEvent.getCode() == KeyCode.ENTER)
            saveChanges();
    }
}
