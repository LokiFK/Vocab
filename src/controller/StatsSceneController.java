package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
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
        if (isEnoughDataAvailable()) {
            addWrongCorrectRatio(newSeries());
            addCorrectAnswers(newSeries());
            addWrongAnswers(newSeries());
            lineChart.setScaleX(1.0);
            loadStats.setDisable(true);
        } else {
            new Alert(Alert.AlertType.ERROR, "Bitte führe mehr als ein Mal den Vokabeltest durch.", ButtonType.CANCEL).show();
        }
    }

    private boolean isEnoughDataAvailable() {
        return Main.getDatasetCorrectWrongRatio().size() > 1;
    }

    private XYChart.Series<Integer, Integer> newSeries() {
        return new XYChart.Series<>();
    }

    private void addWrongCorrectRatio(XYChart.Series<Integer, Integer> series) {
        //        show the ratio between correct and wrong in the chart
        series.setName("Richtig/Falsch Verhältnis");
        for (int i = 0; i < Main.getDatasetCorrectWrongRatio().size(); i++) {
            series.getData().add(new XYChart.Data<>(i, Main.getDatasetCorrectWrongRatio().get(i)));
        }
        lineChart.getData().add(series);
    }

    private void addCorrectAnswers(XYChart.Series<Integer, Integer> series) {
        series.setName("Richtige Antworten");
        for (int i = 0; i < Main.getCorrectWords().size(); i++) {
            series.getData().add(new XYChart.Data<>(i, Main.getCorrectWords().get(i)));
        }
        lineChart.getData().add(series);
    }

    private void addWrongAnswers(XYChart.Series<Integer, Integer> series) {
//        show the amount of wrong answers in the chart
        series.setName("Falsche Antworten");
        for (int i = 0; i < Main.getWrongWords().size(); i++) {
            series.getData().add(new XYChart.Data<>(i, Main.getWrongWords().get(i)));
        }
        lineChart.getData().add(series);
    }

}
