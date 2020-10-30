package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public abstract class Controller {

//    Save the dimensions
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    protected double width = dimension.getWidth()/4;
    protected double height = dimension.getHeight()/4;

    //    Standard method to return to main screen
    protected void returnToMainScene(Stage stage) throws IOException {
        switchScene(stage, "main_scene.fxml", "Main Window");
    }

    //    Standard method to switch scene
    protected void switchScene(Stage stage, String scene, String title) throws IOException {
//        All scenes are supposed to have the same size
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
//        Loads parent
        Parent root = FXMLLoader.load(getClass().getResource("drawable/" + scene));
//        Sets scene
        stage.setScene(new Scene(root, width, height));
        stage.setTitle(title);
//        Makes stage visible
        stage.show();
    }

}
