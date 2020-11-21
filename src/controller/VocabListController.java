package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class VocabListController extends ListView {

    private final Image deleteImg = new Image(getClass().getResourceAsStream("delete.png"));
    private final Image editImg = new Image(getClass().getResourceAsStream("edit.png"));

    @FXML
    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

//    load all vocabs into scroll pane
    public void loadVoc() {
        if (Main.getVocabBox().size() > 0) {
            for (int i = 0; i < Main.getVocabBox().size(); i++) {
                Button deleteBtn = getButton(deleteImg);
                Button editBtn = getButton(editImg);
                createEditOnClickListener(editBtn, i);
                createDeleteOnClickListener(deleteBtn, i);
                if (Main.getVocabBox().getVocab(i) != null)
                addLineToScrollPane(new Label(Main.getVocabBox().getVocab(i).toString()), deleteBtn, editBtn);
            }
            loadContent.setDisable(true);
        } else {
            newAlert("Die Vokabelliste ist leer.");
        }
    }

//    adds style, img to button
    private Button getButton(Image img) {
        Button btn = new Button();
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        btn.setGraphic(imageView);
        addStyleClassToButton(btn);
        btn.setAlignment(Pos.CENTER_RIGHT);
        return btn;
    }

//    open edit stage when clicked
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

//    delete element when clicked
    private void createDeleteOnClickListener(Button btn, int index) {
        btn.setOnAction(actionEvent -> {
            Main.getVocabBox().deleteVocab(index);
            scrollPane.setContent(null);
            loadVoc();
        });
    }
}
