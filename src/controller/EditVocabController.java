package controller;

import controller.VocabListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import vocabulary.Vocab;

import java.io.IOException;

public class EditVocabController extends VocabListController {

    @FXML
    public Button backBtn;
    public Button saveBtn;

    private int listItemCount = getListItem();

    public void goToParentScene() throws IOException {
        switchScene((Stage) backBtn.getScene().getWindow(), "vocab_list_scene.fxml", "Vocablist");
    }

    public void saveChanges() {
        Main.getVocabBox().updateVocab(new Vocab("hat", "geklappt"), listItemCount);
        Main.getVocabBox().sortVocabBox();
    }

}
