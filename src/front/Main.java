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

    private static Vokabelkasten vokabelkasten;

    public Main() {
        System.out.println(123);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Initialise variables
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        vokabelkasten = new Vokabelkasten(200);
        System.out.println(vokabelkasten.getVokabelanzahl());

//        Do not change this code
        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
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

    //    Save the dimensions
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    protected double width = dimension.getWidth()/4;
    protected double height = dimension.getHeight()/4;

   /* public Controller(int length) {
        vokabelkasten = new Vokabelkasten(length);
        System.out.println(22);
    }*/

    public static Vokabelkasten getVokabelkasten() {
        System.out.println(vokabelkasten.toString());
        return vokabelkasten;
    }

    public static void addVoc(String german, String english) {
        System.out.println(english + german);
        vokabelkasten.addVokabel(new Vokabel(german, english));
        System.out.println(vokabelkasten.toString());
    }

}
