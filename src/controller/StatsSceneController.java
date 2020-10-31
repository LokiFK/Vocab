package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class StatsSceneController extends Controller {

    @FXML
    public Button btnBack;
    public LineChart lineChart;
    public Button loadStats;

    @FXML
    public void launchMainScene() throws IOException {
        returnToMainScene((Stage) btnBack.getScene().getWindow());
    }

    @FXML
    public void loadData() {
        /*for (int i = 0; i < 20; i++) {
            Main.addDatasetCorrectWrongRatio((int)(Math.random()*20),(int)(Math.random()*20));
        }*/
//        check if enough data is available to create a statistic
        if (Main.getDatasetCorrectWrongRatio().size() > 1) {
            //        show the ratio between correct and wrong in the chart
            XYChart.Series<Integer, Integer> series = new XYChart.Series<>();
            series.setName("Richtig/Falsch Verhältnis");
            for (int i = 0; i < Main.getDatasetCorrectWrongRatio().size(); i++) {
                series.getData().add(new XYChart.Data<>(i, Main.getDatasetCorrectWrongRatio().get(i)));
            }
            lineChart.getData().add(series);
//        show the amount of correct answers in the chart
            series = new XYChart.Series<>();
            series.setName("Richtige Antworten");
            for (int i = 0; i < Main.getCorrectWords().size(); i++) {
                series.getData().add(new XYChart.Data<>(i, Main.getCorrectWords().get(i)));
            }
            lineChart.getData().add(series);
//        show the amount of wrong answers in the chart
            series = new XYChart.Series<>();
            series.setName("Falsche Antworten");
            for (int i = 0; i < Main.getWrongWords().size(); i++) {
                System.out.println(Main.getWrongWords().size() + " " + Main.getDatasetCorrectWrongRatio().size());
                series.getData().add(new XYChart.Data<>(i, Main.getWrongWords().get(i)));
            }
            lineChart.getData().add(series);
            lineChart.setScaleX(1.0);
            loadStats.setDisable(true);
        } else {
            new Alert(Alert.AlertType.ERROR, "Bitte führe mehr als ein Mal den Vokabeltest durch.", ButtonType.CANCEL).show();
        }
    }
}
