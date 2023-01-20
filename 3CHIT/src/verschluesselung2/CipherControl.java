package verschluesselung2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Steuert die Applikation und stellt eine Verbindung zwischen View und Model her
 */

public class CipherControl implements ActionListener {
    private CipherFrame frame;
    private CipherLayout layout;
    private Cipher chiper;

    /**
     * Initialisiert die View- und Model-Klassen
     */
    public CipherControl() {
        this.layout = new CipherLayout(this);
        this.frame = new CipherFrame(this.layout, this);

        String[] options = {"Substitution Cipher", "Shift Cipher"};
        String input = (String) JOptionPane.showInputDialog(null, "Wählen Sie die Art der Verschlüsselung",
                "Verschlüsselungsart wählen", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        boolean stop = false;
        if(input.equals(options[0])) {
            do {
                String secretAlphabetInput = JOptionPane.showInputDialog(null, "Geben Sie das Geheimalphabet ein");
                if(secretAlphabetInput == null)
                    stop = true;
                else {
                    try {
                        this.chiper = new SubstitutionCipher(secretAlphabetInput);
                        stop = true;
                    } catch (IllegalArgumentException exc) {
                        JOptionPane.showMessageDialog(null, "Das Geheimalphabet ist ungültig!", "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } while(!stop);
        } else if(input.equals(options[1])) {
            do {
                String shiftStr = JOptionPane.showInputDialog(null, "Geben Sie den Verschiebewert ein");
                if(shiftStr == null)
                    stop = true;
                else {
                    try {
                        this.chiper = new ShiftCipher(Integer.parseInt(shiftStr));
                        stop = true;
                    } catch (IllegalArgumentException exc) {
                        JOptionPane.showMessageDialog(null, "Der Verschiebewert ist ungültig!", "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } while(!stop);
        }
    }

    /**
     * Die Steuerungsmethode, die bei Button-Klick oder Eingabe ausgelöst wird.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        String text = ((JTextField)e.getSource()).getText();
        if(ac.equals("decrypted")) {
            layout.setTextEncrypted(chiper.encrypt(text));
        } else {
            layout.setTextDecrypted(chiper.decrypt(text));
        }
    }

    /**
     * Main-Methode
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        new CipherControl();
    }
}
