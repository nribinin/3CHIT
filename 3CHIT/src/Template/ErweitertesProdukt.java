package Template;

public class ErweitertesProdukt extends Produkt {

    private double rabatte;
    private Bewertung [] bewertungen;

    ErweitertesProdukt(long produktID, String bezeichnung, String beschreibung, double preis) {
        super(produktID, bezeichnung, beschreibung, preis);
    }

    public void setRabatte(double rabatte) {
        if (rabatte <= 100 && rabatte >= 0) {
            this.rabatte = rabatte;
        } else {
            System.out.println("Eingabe ungültig!");
        }
    }
    public double getRabatte() {
        return this.rabatte;
    }
    public double ermaessigterPreis(){
        return getPreis()*getRabatte();
    }

    @Override
    public double gesamtPreis(int stueckzahl){
        return gesamtPreis(stueckzahl) * getRabatte();
    }

    public void neueBewertung(Bewertung bewertungen){
        for(int i = 0; i < this.bewertungen.length; i++){
            if(this.bewertungen[i] == null){
                this.bewertungen[i] = bewertungen;
            }
        }
    }


}
