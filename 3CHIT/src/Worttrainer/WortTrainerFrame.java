package Worttrainer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Das Frame wird hier erstellt
 * @author Nathaniel Ribinin
 * @version 17-11-2022
 * */

public class WortTrainerFrame extends JFrame {
    ActionListener control;

    /**
     * Erstellt ein neues Fenster
     * @param layout Layout für das Fenster
     * @param control Control-Klasse
     */
    public WortTrainerFrame(WortTrainerLayout layout, ActionListener control) {
        super("Worttrainer");
        this.control = control;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(layout, BorderLayout.CENTER);

        this.pack();
        this.setBounds(300, 100, 1000, 600);
        this.setVisible(true);
    }

    /**
     * Wird beim Schließen des Fensters aufgerufen und sorgt dafür, dass der ActionListener etwas davon mitbekommt
     */
    @Override
    public void dispose() {
        this.control.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "close"));
        super.dispose();
    }
}
