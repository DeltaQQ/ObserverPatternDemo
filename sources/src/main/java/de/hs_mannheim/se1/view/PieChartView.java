package de.hs_mannheim.se1.view;

import de.hs_mannheim.se1.model.Fakultaet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartView extends Observer {

    private final ObservableList<PieChart.Data> data =
            FXCollections.observableArrayList();

    public PieChartView(Stage stage) {

        // Fixed size of 5 elements.
        for (int i = 0; i < 5; i++) {
            data.add(new PieChart.Data("", 0));
        }

        PieChart pieChart = new PieChart();
        pieChart.setData(data);
        pieChart.setMinSize(800, 500);

        Stage newStage = new Stage();
        newStage.setScene(new Scene(pieChart));
        newStage.show();
    }

    @Override
    public void update(int index, String studiengang, int bewerber) {
        if (index < data.size() && index >= 0) {
            PieChart.Data value = data.get(index);
            value.setName(studiengang);
            value.setPieValue(bewerber);
        }
    }
}
