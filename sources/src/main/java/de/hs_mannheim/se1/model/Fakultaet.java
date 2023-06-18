package de.hs_mannheim.se1.model;

/**
 * Fakultaet Klasse.
 */

public class Fakultaet {

    /**
     * Name des Studiengangs.
     */
    private String studiengang;

    /**
     * Anzahl der Bewerber.
     */
    private int bewerber;

    public Fakultaet() {}

    public Fakultaet(String studiengang, int bewerber) {
        this.studiengang = studiengang;
        this.bewerber = bewerber;
    }

    public String getStudiengang() {
        return  studiengang;
    }

    public int getBewerber() {
        return bewerber;
    }

    public void setBewerber(int bewerber) {
        this.bewerber = bewerber;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }
}
