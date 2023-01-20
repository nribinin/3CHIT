package Template;

public class Main {
    public static void main(String [] args){
        Produkt produkt1 = new Produkt(54789154l, "VW-Golf", "Erleben Sie jetzt das neue schwarze Auto von VW", 8499.99);
        System.out.println(produkt1.gesamtPreis(4));
        System.out.println(produkt1.produktDaten());
        Bewertung bewertung1 = new Bewertung(4.5, "Ein tolles Produkt");
        System.out.println(bewertung1.bewertungDaten());

    }
}
