package Template;

public class Bewertung {
    private double bewertung;
    private String anmerkung;

    Bewertung(double bewertung, String anmerkung){
        this.bewertung = bewertung;
        this.anmerkung = anmerkung;
    }
    public void setBewertung(double bewertung){
        this.bewertung = bewertung;
    }

    public double getBewertung(){
        return this.bewertung;
    }

    public void setAnmerkung(String anmerkung){
        this.anmerkung = anmerkung;
    }

    public String getAnmerkung(){
        return this.anmerkung;
    }

    public String bewertungDaten(){
        return "Bewertung: " + this.bewertung + "\nAnmerkung: " + this.anmerkung;
    }
}
