package Worttrainer;

import java.io.*;

/**
 * Wörter mit URL werden gespeichert und auf Gültigkeit geprüft
 * @author Nathaniel Ribinin
 * @version 17-11-2022
 * */

public class WortTrainerSpeichern {
    private WortTrainer wtrainer;

    public WortTrainerSpeichern(WortTrainer wtrainer) {
        this.wtrainer = wtrainer;
    }

    /**
     * Die gespeicherten Daten, werden an einer txt Datei
     * "weitergeleitet" und dort gespeichert
     * @param path Pfad wird übergeben um einen festen "Speicher"
     * Stand zu haben
     */
    public void speichern(String path) throws IOException {
        String total = path;
        try (PrintWriter outputStream = new PrintWriter(total)) {
            outputStream.println(this.wtrainer.getEintrag());
            outputStream.println(this.wtrainer.getZaehlen());
            outputStream.println(this.wtrainer.getRichtig());
            for (int i = 0; i < wtrainer.getList().getEintrag().length; ++i) {
                if (this.wtrainer.getList().getEintrag(i) != null) {
                    outputStream.println(wtrainer.getList().getEintrag()[i].getWort());
                    outputStream.println(wtrainer.getList().getEintrag()[i].getUrl());
                }
            }
        }
    }

    /**
     * Es wird der Pfad und der Name für die
     * vorherige speichern Methode gesettet
     */
    public void speichern() throws IOException {
        this.speichern("./WortTrainer.txt");
    }

    /**
     * Nach dem die Daten in das txt File weiter geleitet wurde,
     * werden alle Objekte gelöscht. Mit dieser Methode wird
     * dies aber wiederhergestellt
     * @param file Pfad, Name und Textart wird übergeben
     * @return worttrainer, alles was gelöscht wurde
     */
    public WortTrainer laden(String file) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String text;
            WortEintrag ausgewaehlt;
            WortListe wliste = new WortListe();

            String ausgewaehltname = inputStream.readLine();
            if(!ausgewaehltname.equals("null")) {
                ausgewaehlt = new WortEintrag(ausgewaehltname, inputStream.readLine());
            } else {
                ausgewaehlt = null;
            }
            int abgefragt = Integer.parseInt(inputStream.readLine());
            int richtig = Integer.parseInt(inputStream.readLine());
            while((text = inputStream.readLine()) != null) {
                wliste.addWort(new WortEintrag(text, inputStream.readLine()));
            }


            WortTrainer wtrainer = new WortTrainer(wliste);
            wtrainer.setZaehlen(abgefragt);
            wtrainer.setIstRichtig(richtig);
            if(ausgewaehlt != null) {
                wtrainer.setEintrag(ausgewaehlt);
            }
            return wtrainer;
        }
    }

    /**
     * Da wird der Pfad, Name und Dateiart für die
     * obere Methode definiert
     * @return Pfad, Name und Dateiart
     */
    public WortTrainer laden() throws IOException{
        WortTrainer wtrainer = this.laden("./Worttrainer.txt");
        return wtrainer;
    }
}