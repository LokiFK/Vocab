package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vocabulary.Vocab;
import vocabulary.VocabBox;

import java.awt.*;

public class Main extends Application {

    private static VocabBox vocabBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Initialise variables
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        vocabBox = new VocabBox();

//        Do not change this code
        Parent root = FXMLLoader.load(getClass().getResource("drawable/main_scene.fxml"));
        primaryStage.setTitle("Vocabulary Tester");
        primaryStage.setScene(new Scene(root, screenSize.getWidth()/4, screenSize.getHeight()/4));
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
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

}
