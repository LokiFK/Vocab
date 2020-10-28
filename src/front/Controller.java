package front;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public abstract class Controller {

    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    protected double width = dimension.getWidth()/4;
    protected double height = dimension.getHeight()/4;

    protected void returnToMainScene(Stage stage) throws IOException {
        switchScene(stage, "mainScene.fxml", "Main Window");
    }

    protected void switchScene(Stage stage, String scene, String title) throws IOException {
        width = stage.getScene().getWidth();
        height = stage.getScene().getHeight();
        Parent root = FXMLLoader.load(getClass().getResource(scene));
        stage.setScene(new Scene(root, width, height));
        stage.setTitle(title);
        stage.show();
    }

}
