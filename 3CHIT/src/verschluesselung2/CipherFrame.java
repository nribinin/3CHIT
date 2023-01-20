package verschluesselung2;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Das Fenster, in dem die Verschlüsselungsfunktionen dargestellt werden
 */
public class CipherFrame extends JFrame {
    ActionListener control;

    /**
     * Erstellt ein neues Fenster
     * @param layout  Layout für das Fenster
     * @param control Control-Klasse
     */
    public CipherFrame(CipherLayout layout, ActionListener control) {
        super("Verschlüsselung");
        this.control = control;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(layout, BorderLayout.CENTER);

        this.pack();
        this.setBounds(300, 100, 500, 200);
        this.setVisible(true);
    }
}