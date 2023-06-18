package de.hs_mannheim.se1;

import de.hs_mannheim.se1.controller.Controller;
import de.hs_mannheim.se1.model.FakultaetContainer;
import de.hs_mannheim.se1.view.PieChartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}