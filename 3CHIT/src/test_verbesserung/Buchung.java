package test_verbesserung;
import java.time.LocalDate;

public class Buchung {
    private LocalDate datum;
    private String text;
    private double betrag;
    private int kontonr;

    Buchung(LocalDate datum, String text, double betrag){
        this.datum = datum;
        this.text = text;
        this.betrag = betrag;
        this.kontonr = kontonr;
    }

    public String toString(){
        return getDatum() + getText() + getBetrag() + getKontonr();
    }

    public LocalDate getDatum(){
        return this.datum;
    }
    public String getText(){
        return this.text;
    }
    public double getBetrag(){
        return this.betrag;
    }
    public int getKontonr(){
        return this.kontonr;
    }
}
