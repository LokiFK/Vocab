package controller;

import javafx.event.ActionEvent;
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
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }


    @FXML
    public void verifyVocab() {
        if (chBGermanEnglish.isSelected()) {
            if (tfAnswer.getText().equals(Main.getVocabBox().getVocab(random).getEnglish())) {
                lbAnswerCorrect.setText("Deine Antwort ist richtig! Herrzlichen Glückwunsch.");
                startTest();
            } else {
                lbAnswerCorrect.setText("Deine Antwort ist falsch. Versuchs nochmal.");
                startTest();
            }
        } else {
            if (tfAnswer.getText().equals(Main.getVocabBox().getVocab(random).getDeutsch())) {
                lbAnswerCorrect.setText("Deine Antwort ist richtig! Herrzlichen Glückwunsch.");
                startTest();
            } else {
                lbAnswerCorrect.setText("Deine Antwort ist falsch. Versuchs nochmal.");
                startTest();
            }
        }
    }

    @FXML
    public void checkBoxEnglishChecked() {
        chBGermanEnglish.setSelected(!chBGermanEnglish.isSelected());
    }

    @FXML
    public void checkBoxGermanChecked() {
           chBEnglishGerman.setSelected(!chBEnglishGerman.isSelected());
    }

    @FXML
    public void startTest() {
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

    @FXML
    public void checkIfEnterKeyTyped(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER)
            System.out.println(1);
            verifyVocab();
    }

}
