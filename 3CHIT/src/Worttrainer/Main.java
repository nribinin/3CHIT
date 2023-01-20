package Worttrainer;

import java.io.*;
/**
 * Alle Methoden der anderen 3 Klassen werden getestet
 * @author Nathaniel Ribinin
 * @version 19-09-2022
 */
public class Main {
    public static void main(String[] args) {
        WortEintrag w1 = new WortEintrag("Esel", "https://www.planet-wissen.de/natur/haustiere/esel/afrikanischer-esel-100~_v-HintergrundL.jpg");
        if (WortEintrag.checkUrl("https://www.planet-wissen.de/natur/haustiere/esel/afrikanischer-esel-100~_v-HintergrundL.jpg") == true) {
            System.out.println("Diese URL ist gültig!");
        } else {
            System.out.println("Diese URL ist nicht gültig!");
        }
        System.out.println(w1.toString());
        WortEintrag w2 = new WortEintrag("Hund", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Harzer_Fuchs_H%C3%BCndin_2.jpg/640px-Harzer_Fuchs_H%C3%BCndin_2.jpg");
        if (WortEintrag.checkUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Harzer_Fuchs_H%C3%BCndin_2.jpg/640px-Harzer_Fuchs_H%C3%BCndin_2.jpg") == true) {
            System.out.println("Diese URL ist gültig!");
        } else {
            System.out.println("Diese URL ist nicht gültig!");
        }
        System.out.println(w1.toString());
        WortEintrag w3 = new WortEintrag("Hase", "https://image.geo.de/30042268/t/6Z/v3/w1440/r0/-/feldhase-gross-jpg--17168-.jpg");
        if (WortEintrag.checkUrl("https://image.geo.de/30042268/t/6Z/v3/w1440/r0/-/feldhase-gross-jpg--17168-.jpg") == true) {
            System.out.println("Diese URL ist gültig!");
        } else {
            System.out.println("Diese URL ist nicht gültig!");
        }
        //----
        System.out.println();
        System.out.println(w1.toString());
        System.out.println();
        WortListe woerter = new WortListe();
        woerter.addWort(new WortEintrag("Stier", "https://www.sutaj.com"));
        woerter.addWort(w1);
        woerter.addWort(w2);
        woerter.addWort(w3);
        System.out.println(woerter.toString());
        System.out.println();
        System.out.println(woerter.indexEingabe(0).toString());
        System.out.println();
        woerter.deleteWort("Hund");
        System.out.println(woerter.indexEingabe(0).toString());
        System.out.println();
        System.out.println(woerter.toString());
        WortTrainer n1 = new WortTrainer(woerter);
        System.out.println(n1.randomGenerator().toString());
        System.out.println();
        System.out.println(n1.check("Hund"));
        System.out.println(n1.checkIgnore("hUND"));

        WortTrainer wortT = new WortTrainer(woerter);
        wortT.randomGenerator();
        WortTrainerSpeichern s = new WortTrainerSpeichern(wortT);
        try {
            s.speichern();
        } catch(IOException e) {
            System.out.println("Das funktioniert nicht!");
        }

        try {
            WortTrainer laden = s.laden("Worttrainer.txt");
            System.out.println(laden.toString());
        } catch(java.io.IOException e) {
            System.out.println("Das funktioniert nicht");
        }
    }
}
