package de.hs_mannheim.se1.view;

import de.hs_mannheim.se1.controller.Controller;
import de.hs_mannheim.se1.model.Fakultaet;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.util.converter.IntegerStringConverter;

public class TableViewView extends Observer {

    private final TableView<Fakultaet> table = new TableView<>();

    private final ObservableList<Fakultaet> data = FXCollections.observableArrayList();

    public TableViewView(Stage stage, Controller controller) {

        // Fixed size of 5 elements.
        for (int i = 0; i < 5; i++) {
            data.add(new Fakultaet());
        }

        table.setEditable(true);

        TableColumn<Fakultaet, String> studiengangColumn = new TableColumn<>("Studiengang");
        TableColumn<Fakultaet, Integer> bewerberColumn = new TableColumn<>("Bewerber");

        studiengangColumn.setMinWidth(200);
        bewerberColumn.setMinWidth(100);

        studiengangColumn.setCellValueFactory(new PropertyValueFactory<>("studiengang"));
        bewerberColumn.setCellValueFactory(new PropertyValueFactory<>("bewerber"));

        studiengangColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bewerberColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        // Setup callback to notify observers when table data has changed.
        studiengangColumn.setOnEditCommit(event -> controller.update(
                event.getTablePosition().getRow(),
                event.getNewValue(),
                event.getRowValue().getBewerber()));

        bewerberColumn.setOnEditCommit(event -> controller.update(
                event.getTablePosition().getRow(),
                event.getRowValue().getStudiengang(),
                event.getNewValue()));

        table.getColumns().add(studiengangColumn);
        table.getColumns().add(bewerberColumn);

        table.setItems(data);

        StackPane root  = new StackPane();
        root.getChildren().add(table);

        // Close application on table close.
        stage.setOnCloseRequest(windowEvent -> Platform.exit());

        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    @Override
    public void update(int index, String studiengang, int bewerber) {
        if (index < data.size() && index >= 0) {
            var fakultaet = data.get(index);
            fakultaet.setBewerber(bewerber);
            fakultaet.setStudiengang(studiengang);
            table.refresh();
        }
    }
}
