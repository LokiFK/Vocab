package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TestVocabController extends Controller {

    private int random;
    private int wrong;
    private int correct;

    @FXML
    public Button btnBack;
    public Label lbVocab;
    public CheckBox chBEnglishGerman;
    public CheckBox chBGermanEnglish;
    public TextField tfAnswer;
    public Label lbAnswerCorrect;

    public void launchMainScene() throws IOException {
//        save the statistics
        Main.addDatasetCorrectWrongRatio(wrong, correct);
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

    @FXML
    public void verifyVocab() {
//        check whether vocabs are correct or not
        if (Main.getVocabBox().size() > 0) {
            if (chBGermanEnglish.isSelected()) {
                if (tfAnswer.getText().equals(Main.getVocabBox().getVocab(random).getEnglish())) {
                    lbAnswerCorrect.setText("Deine Antwort ist richtig! Herrzlichen Glückwunsch.");
                    correct++;
                } else {
                    lbAnswerCorrect.setText("Deine Antwort ist falsch. Versuchs nochmal.");
                    wrong++;
                }
            } else {
                if (tfAnswer.getText().equals(Main.getVocabBox().getVocab(random).getDeutsch())) {
                    lbAnswerCorrect.setText("Deine Antwort ist richtig! Herrzlichen Glückwunsch.");
                    correct++;
                } else {
                    lbAnswerCorrect.setText("Deine Antwort ist falsch. Versuchs nochmal.");
                    wrong++;
                }
            }
            startTest();
        } else {
            newAlert("Die Vokabelliste ist leer");
        }
    }

//    unchecks opposite checkbox
    @FXML
    public void checkBoxEnglishChecked() {
        chBGermanEnglish.setSelected(!chBGermanEnglish.isSelected());
    }

//    unchecks opposite checkbox
    @FXML
    public void checkBoxGermanChecked() {
           chBEnglishGerman.setSelected(!chBEnglishGerman.isSelected());
    }

    @FXML
    public void startTest() {
//        calls random vocab into the label
        random = (int) (Math.random()*Main.getVocabBox().size()-1);
        if (chBGermanEnglish.isSelected()) {
            if (Main.getVocabBox() != null && Main.getVocabBox().size() > 0)
                lbVocab.setText(Main.getVocabBox().getVocab(random).getDeutsch());
            else
                newAlert("Die Vokabelliste ist leer");
        } else if (chBEnglishGerman.isSelected()){
            if (Main.getVocabBox() != null && Main.getVocabBox().size() > 0)
                lbVocab.setText(Main.getVocabBox().getVocab(random).getEnglish());
            else
                newAlert("Die Vokabelliste ist leer");
        } else
            newAlert("Die Vokabelliste ist leer");
    }

//    if enter pressed then check if vocab is correct
    @FXML
    public void checkIfEnterKeyTyped(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            verifyVocab();
        }
    }

}
