package de.hs_mannheim.se1.controller;

import de.hs_mannheim.se1.view.Observer;

public abstract class Subject {

    public abstract void attach(Observer observer);

    public abstract void detach(Observer observer);

    public abstract void notifyAllObservers(int index, String studiengang, int bewerber);

}
