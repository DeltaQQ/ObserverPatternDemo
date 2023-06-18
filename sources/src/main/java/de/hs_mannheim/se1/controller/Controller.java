package de.hs_mannheim.se1.controller;

import de.hs_mannheim.se1.view.Observer;
import de.hs_mannheim.se1.model.FakultaetContainer;
import de.hs_mannheim.se1.view.BarChartView;
import de.hs_mannheim.se1.view.PieChartView;
import de.hs_mannheim.se1.view.TableViewView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller extends Subject {

    private final List<Observer> observerList;

    private final FakultaetContainer fakultaetContainer;

    public Controller(Stage stage) {
        observerList = new ArrayList<>();

        fakultaetContainer = new FakultaetContainer();

        observerList.add(new BarChartView(stage));
        observerList.add(new PieChartView(stage));
        observerList.add(new TableViewView(stage, this));

        int index = 0;
        for (var fakultaet : fakultaetContainer) {
            notifyAllObservers(
                    index++,
                    fakultaet.getStudiengang(),
                    fakultaet.getBewerber()
            );
        }
    }

    /**
     * Updates Model and View. This is called from TableViewView.
     */
    public void update(int index, String studiengang, int bewerber) {
        notifyAllObservers(index, studiengang, bewerber);
        fakultaetContainer.update(index, studiengang, bewerber);
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers(int index, String studiengang, int bewerber) {
        for (Observer observer : observerList) {
            observer.update(index, studiengang, bewerber);
        }
    }
}
