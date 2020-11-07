package controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class VocabListController extends Controller {

    @FXML
    public Button btnBack;
    public ScrollPane listVocabs = new ScrollPane();
    public Button loadVoc;

    private final Image deleteImg = new Image(getClass().getResourceAsStream("delete.png"));
    private final Image editImg = new Image(getClass().getResourceAsStream("edit.png"));

    private int listItem = Main.getCurrentVocab();

    @FXML
    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

//    load all vocabs into scroll pane
    public void loadVoc() {
        if (Main.getVocabBox().size() > 0) {
            for (int i = 0; i < Main.getVocabBox().size(); i++) {
                addNewVocabLine(i);
            }
            loadVoc.setDisable(true);
        } else {
            newAlert("Die Vokabelliste ist leer.");
        }
    }

    private Pane createNewVocabLine(Button deleteBtn, Button editBtn, int index) {
        Pane content;
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        borderPane.setPrefWidth(listVocabs.getWidth()-10);
        borderPane.setLeft(new Label(Main.getVocabBox().getVocab(index).toString()));
        gridPane.add(editBtn, 0, 0);
        gridPane.add(deleteBtn, 1, 0);
        borderPane.setRight(gridPane);
        borderPane.getStyleClass().add("borderLayout");
        if (listVocabs.getContent() == null)
            content = new Pane(borderPane);
        else
            content = new Pane(new VBox(listVocabs.getContent(), borderPane));
        borderPane.setPadding(new Insets(10));
        createDeleteOnClickListener(deleteBtn, index);
        createEditOnClickListener(editBtn, index);
        return content;
    }

    private void addNewVocabLine(int index) {
        listVocabs.setContent(createNewVocabLine(createDeleteBtn(), createEditBtn(), index));
    }

    private Button createDeleteBtn() {
        return getButton(deleteImg);
    }

    private Button createEditBtn() {
        return getButton(editImg);
    }

    private Button getButton(Image editImg) {
        Button btn = new Button();
        ImageView imageView = new ImageView(editImg);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        btn.setGraphic(imageView);
        addStyleClassToButton(btn);
        btn.setAlignment(Pos.CENTER_RIGHT);
        return btn;
    }

    private void createEditOnClickListener(Button btn, int index) {
        btn.setOnAction(actionEvent -> {
            try {
                Main.setCurrentVocab(index);
                switchScene((Stage) btn.getScene().getWindow(), "edit_vocab_scene.fxml", "Vokabeln ändern");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public int getListItem() {
        return listItem;
    }

    private void createDeleteOnClickListener(Button btn, int index) {
        btn.setOnAction(actionEvent -> {
            Main.getVocabBox().deleteVocab(index);
            listVocabs.setContent(null);
            loadVoc();
        });
    }
}
