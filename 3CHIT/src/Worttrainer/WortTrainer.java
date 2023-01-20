package Worttrainer;

import java.util.Random;

/**
 * Es wird aus dem Array eine Zahl gezogen und gleicht Wörter mit anderen
 * @author Nathaniel Ribinin
 * @version 19-09-2022
 */
public class WortTrainer {
    private WortListe list;
    private WortEintrag eintrag;

    private int zaehlen = 0;

    private int istRichtig = 0;

    public WortTrainer(WortListe list){
        this.list = list;
    }

    /**
     * Es soll von den Index eine zufällige Zahl rausgesucht werden und
     * das Wort des Indexes zurückgegeben
     * @return das Wort des Indexes
     */
    public WortEintrag randomGenerator(){
        int generator = (int)(Math.random() * list.getLaenge());
        this.eintrag = list.indexEingabe(generator);
        return list.indexEingabe(generator);
    }

    /**
     * Es wird überprüft dass das Attrib
     * @param zaehlen
     */
    public void setZaehlen(int zaehlen) {
        if(this.zaehlen < 0){
            throw new IllegalArgumentException("Wert darf nicht unter 0 sein!");
        }
        this.zaehlen = zaehlen;
    }

    public void setIstRichtig(int istRichtig) {
        if(this.istRichtig < 0){
            throw new IllegalArgumentException("Wert darf nicht unter 0 sein!");
        }
        this.istRichtig = istRichtig;
    }
    public int getRichtig() {
        return this.istRichtig;
    }
    public int getZaehlen(){
        return this.zaehlen;
    }

    public WortListe getList(){
        return this.list;
    }
    /**
     * Das Wort von Randomgenerator soll mit einem ausgewählten Wort geprüft werden und gibt
     * true bei Erfolg und false bei keinem Erfolg zurück
     * @param wort wird als Parameter übernommen
     * @return ob die Prüfung ein Erfolg war oder nicht
     */
    public boolean check(String wort){
        this.zaehlen += 1;
        if(this.eintrag.getWort().equals(wort)){
            this.istRichtig += 1;
            return true;
        }
        return false;
    }

    /**
     * Funktioniert gleich wie die Methode check, nur dass auf Groß- und
     * Kleinschreibung nicht geachtet wird
     * @param wort wird als Parameter übernommen
     * @return ob die Prüfung ein Erfolg war oder nicht
     */
    public boolean checkIgnore(String wort){
        this.zaehlen += 1;
        if(this.eintrag.getWort().equalsIgnoreCase(wort)){
            this.istRichtig += 1;
            return true;
        }
        return false;
    }

    /**
     * Derzeitiger Eintrag wird zurückgegeben
     * @return der eintrag
     */
    public WortEintrag getEintrag() {
        return eintrag;
    }

    /**
     * Eintrag wird übergeben und Konstruktor
     * wird zum übergebenem Parameter
     * @param eintrag eintrag wird übergeben
     */
    public void setEintrag(WortEintrag eintrag) {
        this.eintrag = eintrag;
    }

    /**
     * Der toString wird umgeschrieben
     * @return das "Design" des Textes
     */
    @Override
    public String toString(){
        String output = this.getEintrag() + "\n" + +this.getZaehlen() + "\n" + this.getRichtig() + "\n" + this.getList();
        return output;
    }
}
