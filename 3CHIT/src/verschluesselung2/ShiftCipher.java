package verschluesselung2;

/**
 * Diese Klasse dient dazu ein Wort, aus der MonoAlphabeticCipher
 * mittels übergebenen Zahl zu verschieben
 * @version 07-01-2023
 * @author Nathaniel Ribinin
 */
public class ShiftCipher extends MonoAlphabeticCipher{
    public ShiftCipher(int value){
        setShiftValue(value);
    }

    /**
     * Ein Wort wird um die Zahl, der im Parameter übergeben wird
     * verschoben
     * @param value Anzahl an zu verschiebenen Werten
     */
    public void setShiftValue(int value){
        String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        int laenge = alphabet.length();
        String shiftedAlphabet =  alphabet.substring(value, laenge) + alphabet.substring(0, value);
        super.setSecretAlphabet(shiftedAlphabet);
    }
}
