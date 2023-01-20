package Worttrainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Layout für die GUI des Worttrainers
 * @author Nathaniel Ribinin
 * @version 17-11-2022
 * */
public class WortTrainerLayout extends JPanel {
    private JTextField tfWort;
    private JLabel lImage, lAnzahlRichtigeWorte, lAnzahlWorte;
    private JButton bReset, bHinzufuegen;
    private ActionListener control;

    /**
     * Erstellt ein neues Layout für die GUI des Worttrainers
     * @param control Control-Klasse
     */
    public WortTrainerLayout(ActionListener control) {
        this.control = control;

        this.setLayout(new BorderLayout(20, 20));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel lAnweisung = new JLabel("Welches Wort wird unten dargestellt?", SwingConstants.CENTER);
        tfWort = new JTextField();
        tfWort.addActionListener(this.control);
        JPanel top = new JPanel(new BorderLayout(5, 5));
        top.add(lAnweisung, BorderLayout.PAGE_START);
        top.add(tfWort, BorderLayout.PAGE_END);
        this.add(top, BorderLayout.PAGE_START);

        lImage = new JLabel();
        lImage.setHorizontalAlignment(JLabel.CENTER);
        lImage.setVerticalAlignment(JLabel.CENTER);
        this.add(lImage, SwingConstants.CENTER);

        JLabel lRichtigeWorte = new JLabel("Richtige Wörter:", SwingConstants.RIGHT);
        JLabel lWorte = new JLabel("Anzahl Wörter:", SwingConstants.RIGHT);

        lAnzahlRichtigeWorte = new JLabel("0");
        lAnzahlWorte = new JLabel("0");

        bReset = new JButton("Zurücksetzen");
        bReset.addActionListener(this.control);
        bHinzufuegen = new JButton("Wort hinzufügen");
        bHinzufuegen.addActionListener(this.control);

        JPanel bottom = new JPanel(new GridLayout(2, 3, 5, 5));
        bottom.add(lRichtigeWorte);
        bottom.add(lAnzahlRichtigeWorte);
        bottom.add(bReset);
        bottom.add(lWorte);
        bottom.add(lAnzahlWorte);
        bottom.add(bHinzufuegen);

        this.add(bottom, BorderLayout.PAGE_END);
    }

    /**
     * Setzt die Anzahl der richtigen Wörter bzw. insgesamt abgefragten Wörter in der GUI
     * @param anzahlRichtigeWorte Anzahl richtige Wörter
     * @param anzahlWorte Anzahl Wörter insgesamt
     */
    public void setAnzahl(int anzahlRichtigeWorte, int anzahlWorte) {
        if(anzahlRichtigeWorte < 0 || anzahlWorte < 0)
            throw new IllegalArgumentException("Anzahl muss größer als 0 sein!");
        lAnzahlRichtigeWorte.setText(String.valueOf(anzahlRichtigeWorte));
        lAnzahlWorte.setText(String.valueOf(anzahlWorte));
    }

    /**
     * Aktualisiert das Bild, das im Layout angezeigt wird
     * @param url URL des neuen Bilds
     */
    public void setImage(String url) {
        try {
            Image img = new ImageIcon(new URL(url)).getImage();
            double ratio = 500.0 / img.getWidth(null);
            System.out.println(img.getWidth(null) + "," + img.getHeight(null) + "," + ratio);
            img = img.getScaledInstance((int)(img.getWidth(null) * ratio), (int)(img.getHeight(null) * ratio), Image.SCALE_SMOOTH);
            lImage.setIcon(new ImageIcon(img));
        } catch (MalformedURLException exc) {
            throw new IllegalArgumentException("Die URL muss in einem gültigen Format sein!");
        }
        tfWort.setText("");
    }
}
