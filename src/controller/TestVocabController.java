package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
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
    public Button btnStart;
    public TextField tfAnswer;
    public Label lbAnswerCorrect;
    public GridPane gridMain;

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
                    startTest();
                } else {
                    lbAnswerCorrect.setText("Deine Antwort ist falsch. Versuchs nochmal.");
                    wrong++;
                    startTest();
                }
            } else {
                if (tfAnswer.getText().equals(Main.getVocabBox().getVocab(random).getDeutsch())) {
                    lbAnswerCorrect.setText("Deine Antwort ist richtig! Herrzlichen Glückwunsch.");
                    correct++;
                    startTest();
                } else {
                    lbAnswerCorrect.setText("Deine Antwort ist falsch. Versuchs nochmal.");
                    wrong++;
                    startTest();
                }
            }
        } else {
            new Alert(AlertType.ERROR, "Die Vokabelliste ist leer!\nGehe in das 'Vokabel hinzufügen'-Menü,\num Vokabeln hinzuzufügen.", ButtonType.CLOSE).show();
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
        random = (int) (Math.random()*Main.getVocabBox().size());
        if (chBGermanEnglish.isSelected()) {
            if (Main.getVocabBox() != null && Main.getVocabBox().size() > 0)
                lbVocab.setText(Main.getVocabBox().getVocab(random).getDeutsch());
            else
                new Alert(AlertType.ERROR, "Die Vokabelliste ist leer!\nGehe in das 'Vokabel hinzufügen'-Menü,\num Vokabeln hinzuzufügen.", ButtonType.CLOSE).show();
        } else if (chBEnglishGerman.isSelected()){
            if (Main.getVocabBox() != null && Main.getVocabBox().size() > 0)
                lbVocab.setText(Main.getVocabBox().getVocab(random).getEnglish());
            else
                new Alert(AlertType.ERROR, "Die Vokabelliste ist leer!\nGehe in das 'Vokabel hinzufügen'-Menü,\num Vokabeln hinzuzufügen.", ButtonType.CLOSE).show();
        } else
            new Alert(AlertType.ERROR, "Bitte eins der beiden Boxen auswählen", ButtonType.CLOSE).show();
    }

//    if enter pressed then check if vocab is correct
    @FXML
    public void checkIfEnterKeyTyped(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            System.out.println(1);
            verifyVocab();
        }
    }

}
