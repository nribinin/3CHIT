package Worttrainer;

import java.util.Arrays;

/**
 * Da mehrere Wörter gespeichert werden braucht man ein Array und diese Klasse
 * bearbeitet die Wörter eben in einem Array
 * @author Nathaniel Ribinin
 * @version 19-09-2022
 */
public class WortListe {
    private WortEintrag[] worteintraege;

    public WortListe(){
        this.worteintraege = new WortEintrag[0];
    }


    /**
     * Array wird vergrößert wenn ein Neues Wort hinzugefügt wird
     * @param worteintrag
     */
    public void addWort(WortEintrag worteintrag){
            this.worteintraege = Arrays.copyOf(this.worteintraege, this.worteintraege.length + 1);
            this.worteintraege[this.worteintraege.length -1] = worteintrag;
    }

    /**
     * Mithilfe des eingegebenen Index wird das Wort im Array ausgegeben
     * @param index wird als Paramerer übernommen
     * @return das Wort wo der Index ist, wird ausgegeben
     */
    public WortEintrag indexEingabe(int index) {
        if (index >= 0 && index < this.worteintraege.length ){
            return worteintraege[index];
            }
        else{
            throw new IllegalArgumentException("Index ist ungültig!");
        }
    }

    public WortEintrag[] getWorteintraege() {
        return worteintraege;
    }

    /**
     * Wenn ein Wort gelöscht wird, dann wird ein neues Array erstellt wo alle Wörter
     * bis auf das gelöschte hinzugefügt, da man ein Wort in Java nicht löschen kann
     * @param wort
     * @return ob es funktioniert hat oder nicht
     */
    public boolean deleteWort(String wort){
        if(wort == null){
            throw new IllegalArgumentException("Wort darf nicht leer sein!");
        }
        WortEintrag[] speichern = new WortEintrag[this.worteintraege.length -1];
        boolean geschafft = false;
        for(int i = 0, j = 0; i < this.worteintraege.length; i++){
            if(this.worteintraege[i]== null){
                continue;
            }
            if(this.worteintraege[i].getWort().equals(wort)){
                geschafft = true;
            }
            else{
                speichern[j] = this.worteintraege[i];
                j++;
            }
        }
        this.worteintraege = speichern;
        return geschafft;
    }

    /**
     * Länge des Arrays wird zurückgegeben
     * @return die Länge
     */
    public int getLaenge(){
        return this.worteintraege.length;
    }
    public WortEintrag[] getEintrag(){
        return this.worteintraege;
    }

    public WortEintrag getEintrag(int zurueckgegeben){
        if(zurueckgegeben < 0 || zurueckgegeben >this.worteintraege.length){
            throw new IllegalArgumentException("Index ungültig!");
        }
        return this.worteintraege[zurueckgegeben];
    }
    /**
     * Nach jedem Wort soll in die nächste Zeile gegangen werden
     * @return die neue Ausgabe
     */
    @Override
    public String toString() {
        String ausgabe = "";
        for(int i=0; i<this.worteintraege.length; i++) {
            if (this.worteintraege[i] != null) {
                ausgabe += this.worteintraege[i].toString() + "\n";
            }
        }
        return ausgabe;
    }
}
