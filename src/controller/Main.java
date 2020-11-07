package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vocabulary.Vocab;
import vocabulary.VocabBox;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main extends Application {

//    All vocabs are saved in here
    private static VocabBox vocabBox;

    private static int currentVocab;

//    necessary for statistics
    private static LinkedList<Integer> correctWrongRatio;
    private static LinkedList<Integer> correctWords;
    private static LinkedList<Integer> wrongWords;

    private final String[] test = {"Z", "Y", "A", "F", "B", "G", "A", "Z", "W", "U", "P"};

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Initialise variables
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        vocabBox = new VocabBox();
        correctWrongRatio = new LinkedList<>();
        correctWords = new LinkedList<>();
        wrongWords = new LinkedList<>();
        for (String s : test) {
            vocabBox.addVocab(new Vocab(s, s));
        }

//        Load the primary stage
        Parent root = FXMLLoader.load(getClass().getResource("drawable/main_scene.fxml"));
        primaryStage.setTitle("Hauptfenster");
        primaryStage.setScene(new Scene(root, screenSize.getWidth()/4, screenSize.getHeight()/4));
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

//    Used to get the vocabularyBox
    public static VocabBox getVocabBox() {
        return vocabBox;
    }

//    Add a vocabulary to vocabBox
    public static void addVocab(String german, String english) {
        vocabBox.addVocab(new Vocab(german, english));
    }

//    used to add new ratio
    public static void addDatasetCorrectWrongRatio(int wrong, int correct) {
        if (wrong > 0 && correct > 0) {
            correctWrongRatio.add(correct / wrong);
        } else {
            correctWrongRatio.add(1);
        }
        correctWords.add(correct);
        wrongWords.add(wrong);
    }

//    set the index of the current vocab
    public static void setCurrentVocab(int currentVocab) {
        Main.currentVocab = currentVocab;
    }

//    get the index of the current vocab
    public static int getCurrentVocab() {
        return currentVocab;
    }

    //    used to get the ratio of correct and wrong answers
    public static List<Integer> getDatasetCorrectWrongRatio() {
        return correctWrongRatio;
    }

//    returns a list of all wrong words
    public static LinkedList<Integer> getWrongWords() {
        return wrongWords;
    }

//    returns a list of all correct words
    public static LinkedList<Integer> getCorrectWords() {
        return correctWords;
    }
}
