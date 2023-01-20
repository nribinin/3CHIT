package Template;

public class Produkt {
    private long produktID;
    private String bezeichnung;
    private String beschreibung;
    private double preis;

    Produkt(long produktID, String bezeichnung, String beschreibung, double preis){
        this.produktID = produktID;
        this.bezeichnung = bezeichnung;
        this.beschreibung = beschreibung;
        this.preis = preis;
    }

    public void setProduktID(long produktID){
        this.produktID = produktID;
    }

    public long getProduktID(){
        return this.produktID;
    }

    public void setBezeichnung(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung(){
        return this.bezeichnung;
    }

    public void setBeschreibung(String beschreibung){
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung(){
        return this.beschreibung;
    }

    public void setPreis(double preis){
        this.preis = preis;
    }

    public double getPreis(){
        return this.preis;
    }

    public double gesamtPreis(int stueckZahl){
       return stueckZahl * getPreis();
    }

    public String produktDaten(){
        return this.produktID + " - " + this.bezeichnung + ": " + this.beschreibung + " - " + this.preis + " Euro";
    }
}
