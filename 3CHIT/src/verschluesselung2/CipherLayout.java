package verschluesselung2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CipherLayout extends JPanel {
    private ActionListener control;
    private JTextField tfDecrypted;
    private JTextField tfEncrypted;

    /**
     * Erstellt ein neues Layout für die GUI
     * @param control Control-Klasse
     */
    public CipherLayout(ActionListener control) {
        this.control = control;

        this.setLayout(new BorderLayout(20, 20));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.tfDecrypted = new JTextField("", 20);
        this.tfDecrypted.setActionCommand("decrypted");
        this.tfDecrypted.addActionListener(this.control);
        this.tfEncrypted = new JTextField("", 20);
        this.tfEncrypted.setActionCommand("encrypted");
        this.tfEncrypted.addActionListener(this.control);

        JPanel container1 = new JPanel();
        container1.add(new JLabel("Entschlüsselt:"));
        container1.add(this.tfDecrypted);
        JPanel container2 = new JPanel();
        container2.add(new JLabel("Verschlüsselt:"));
        container2.add(this.tfEncrypted);
        JPanel center = new JPanel();
        center.add(container1);
        center.add(container2);
        this.add(center, BorderLayout.CENTER);
    }

    /**
     * Setzt den Text für die verschlüsselte Textbox
     * @param text Text, der gesetzt wird
     */
    public void setTextEncrypted(String text) {
        tfEncrypted.setText(text);
    }

    /**
     * Setzt den Text für die entschlüsselte Textbox
     * @param text Text, der gesetzt wird
     */
    public void setTextDecrypted(String text) {
        tfDecrypted.setText(text);
    }
}
