package de.hs_mannheim.se1.view;

import de.hs_mannheim.se1.model.Fakultaet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class BarChartView extends Observer {

    private final ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();

    public BarChartView(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        StackedBarChart<String, Number> barChart = new StackedBarChart<>(xAxis, yAxis);

        barChart.setTitle("Bewerber pro Studiengang");

        xAxis.setLabel("Studiengang");
        yAxis.setLabel("Anzahl Bewerber");

        data.add(new XYChart.Data<>("B. Sc. Informatik", 24));
        data.add(new XYChart.Data<>("B. Sc. Cyber Security", 14));
        data.add(new XYChart.Data<>("B. Sc. Medizininformatik", 15));
        data.add(new XYChart.Data<>("B. Sc. Unternehmens- und Wirtschaftsinformatik", 30));
        data.add(new XYChart.Data<>("B. Sc. Medical Data Science", 2));

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setData(data);
        barChart.getData().add(series);

        barChart.setMinWidth(1200);
        barChart.setMinHeight(700);

        barChart.setAnimated(true);

        Stage newStage = new Stage();
        newStage.setScene(new Scene(barChart));
        newStage.show();
    }

    @Override
    public void update(int index, String studiengang, int bewerber) {
        if (index < data.size() && index >= 0) {
            var value = data.get(index);
            value.setXValue(studiengang);
            value.setYValue(bewerber);
        }
    }
}
