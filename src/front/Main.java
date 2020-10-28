package front;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vocabs.Vokabel;
import vocabs.Vokabelkasten;

import java.awt.*;

public class Main extends Application {

    private final Vokabelkasten vocBox = new Vokabelkasten(200);;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        primaryStage.setTitle("Vocabulary Tester");
        primaryStage.setScene(new Scene(root, screenSize.getWidth()/4, screenSize.getHeight()/4));
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.show();
    }

    protected void addVoc(String german, String english) {
        vocBox.addVokabel(new Vokabel(german, english));
    }

    public Vokabelkasten getVocBox() {
        System.out.println(vocBox.toString());
        return vocBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
