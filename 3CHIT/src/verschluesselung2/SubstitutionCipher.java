package verschluesselung2;

/**
 * Diese Klasse dient dazu, ein Wort mit dem neuen Alphabet
 * zu verändern
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{
    public SubstitutionCipher(String secretAlphabet){
        setSecretAlphabet(secretAlphabet);
    }

    @Override
    /**
     * Ein Alphabet wird übergeben und überprüft.
     * Anschließend, wird das übergebene Wort mit dem neuen
     * Alphabet verändert
     * @param eingae Als Parameter wird das eingegebene Alphabet zurückgegeben
     */
    public void setSecretAlphabet(String eingabe){
        String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        if(eingabe.length() != 30){
            throw new IllegalArgumentException("Das Geheimalphabet muss genau 30 Buchstaben haben!");
        }
        for(int i=0; i<alphabet.length(); i++) {
            if (eingabe.indexOf(alphabet.charAt(i)) == -1) {
                throw new IllegalArgumentException("Das Geheimalphabet hat ungültige Werte, oder ein Buchstabe ist mehrfach eingegeben worden.");
            }
        }
        super.setSecretAlphabet(eingabe);
    }
}
