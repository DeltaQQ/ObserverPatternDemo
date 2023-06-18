package de.hs_mannheim.se1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class FakultaetContainer implements Iterable<Fakultaet> {

    private final List<Fakultaet> fakultaetList = new ArrayList<>();

    public FakultaetContainer() {
        fakultaetList.add(new Fakultaet("B. Sc. Informatik", 24));
        fakultaetList.add(new Fakultaet("B. Sc. Cyber Security", 14));
        fakultaetList.add(new Fakultaet("B. Sc. Medizininformatik", 15));
        fakultaetList.add(new Fakultaet("B. Sc. Unternehmens- und Wirtschaftsinformatik", 30));
        fakultaetList.add(new Fakultaet("B. Sc. Medical Data Science", 2));
    }

    public void update(int index, String studiengang, int bewerber) {
        var fakultaet = fakultaetList.get(index);
        fakultaet.setBewerber(bewerber);
        fakultaet.setStudiengang(studiengang);
    }

    public void addFakultaet(Fakultaet fakultaet) {
        fakultaetList.add(fakultaet);
    }

    public void forEach(Consumer<? super Fakultaet> action) {
        fakultaetList.forEach(action);
    }

    @Override
    public Iterator<Fakultaet> iterator() {
        return fakultaetList.iterator();
    }
}
