package test_verbesserung;

import java.time.LocalDate;

public class Konto {
    private int kontonr;
    private double kontostand;
    private Buchung[] buchungen;

    public Konto(int kontonr){
        this.kontonr = kontonr;
    }

    public void einzahlen(LocalDate datum, String text, double betrag){

    }
}
