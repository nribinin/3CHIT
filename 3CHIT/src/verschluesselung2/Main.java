// coding=utf-8
package verschluesselung2;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        try {
            SubstitutionCipher c = new SubstitutionCipher("abcdefghnjklmiopqrstuvwxyzäöüß");
            String verschluesseln = c.encrypt("Nig?ger");
            String entschluesseln = c.decrypt(verschluesseln);
            JOptionPane.showMessageDialog(null, verschluesseln);
            JOptionPane.showMessageDialog(null, entschluesseln);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "LEO IST EIN NIGGER!", "Nathan Nigger", JOptionPane.WARNING_MESSAGE);
    }
}
