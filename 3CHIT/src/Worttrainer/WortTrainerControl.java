package Worttrainer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * Steuert die Applikation und stellt eine Verbindung zwischen View und Model her
 * @author Nathaniel Ribinin
 * @version 17-11-2022
 * */
public class WortTrainerControl implements ActionListener {
    private WortTrainerFrame frame;
    private WortTrainerLayout layout;
    private WortTrainer trainer;

    /**
     * Initialisiert die View- und Model-Klassen
     * @param wortTrainer Worttrainer Model für die Applikation
     */
    public WortTrainerControl(WortTrainer wortTrainer) {
        if(wortTrainer == null)
            throw new IllegalArgumentException("Für wortTrainer muss ein Wert angegeben werden!");
        this.layout = new WortTrainerLayout(this);
        this.frame = new WortTrainerFrame(this.layout, this);
        this.trainer = wortTrainer;

        selectNewEintrag();
    }

    /**
     * Initialisiert die View- und Model-Klassen
     */
    public WortTrainerControl() {
        this(new WortTrainer(new WortListe()));
    }

    /**
     * Wählt einen neuen Eintrag im Model aus und aktualisiert das Bild und die Zahlen in der View
     */
    private void selectNewEintrag() {
        WortEintrag eintrag = this.trainer.randomGenerator();
        this.layout.setImage(eintrag.getUrl());
        this.layout.setAnzahl(this.trainer.getRichtig(), this.trainer.getZaehlen());
    }

    /**
     * Die Steuerungsmethode, die bei Button-Klick oder Eingabe ausgelöst wird.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        if(ac.equals("Zurücksetzen")) {
            this.trainer = new WortTrainer(this.trainer.getList());
            selectNewEintrag();
        } else if(ac.equals("Wort hinzufügen")) {
            boolean stop = false;
            do {
                try {
                    String wort = JOptionPane.showInputDialog(null, "Geben Sie das Wort ein:");
                    String pfad = JOptionPane.showInputDialog(null, "Geben Sie die URL zum Bild ein:");
                    this.trainer.getList().addWort(new WortEintrag(wort, pfad));
                    stop = true;
                } catch (IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
                }
            } while (!stop);
        } else if(ac.equals("close")) {
            int speichern = JOptionPane.showConfirmDialog(null, "Möchten Sie diesen Worttrainer speichern?", "Worttrainer speichern", JOptionPane.YES_NO_OPTION);
            if(speichern == JOptionPane.YES_OPTION) {
                JFileChooser fc = new JFileChooser();
                if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String pfad = fc.getSelectedFile().getAbsolutePath();
                    try {
                        new WortTrainerSpeichern(this.trainer).speichern(pfad);
                    } catch (IOException exc) {
                        JOptionPane.showMessageDialog(null, exc.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
                    }
                    System.exit(0);
                }
            }
        } else {
            if(this.trainer.check(ac))
                selectNewEintrag();
            else
                this.layout.setAnzahl(this.trainer.getRichtig(), this.trainer.getZaehlen());
        }
    }

    /**
     * Main-Methode
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        int vorhanden = JOptionPane.showConfirmDialog(null, "Möchten Sie einen gespeicherten Worttrainer laden?", "Worttrainer laden", JOptionPane.YES_NO_OPTION);
        if(vorhanden == JOptionPane.YES_OPTION) {
            try {
                JFileChooser fc = new JFileChooser();
                if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String pfad = fc.getSelectedFile().getAbsolutePath();
                    WortTrainer load = new WortTrainerSpeichern(new WortTrainer(new WortListe())).laden(pfad);
                    if(load != null)
                        new WortTrainerControl(load);
                    else
                        JOptionPane.showMessageDialog(null, "Das ist kein gültiger Worttrainer!", "Fehler", JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, exc.getMessage(), "Fehler", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            new WortTrainerControl();
        }
    }
}
