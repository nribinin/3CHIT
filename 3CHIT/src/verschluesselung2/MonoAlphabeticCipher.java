package verschluesselung2;

public class MonoAlphabeticCipher implements Cipher {

    private String secretAlphabet;

    public MonoAlphabeticCipher(){
    }

    public String getSecretAlphabet(){
        return this.secretAlphabet;
    }

    /**
     * Settet das Attribut mit dem übergebenen Parameter
     * @param secretAlphabet
     */
    protected void setSecretAlphabet(String secretAlphabet){
        this.secretAlphabet = secretAlphabet;
    }

    /**
     * Enhschlüsselt das eingegebene Wort
     * @param text nimmt das Wort als Parameter
     * @return das verschlüsselte Wort
     */
    public String encrypt(String text){
        text = text.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        String ausgabe = "";
        for(int i = 0; i<text.length(); i++){
            char zeichen = text.charAt(i);
            int index = alphabet.indexOf(zeichen);
            if(index == -1){
                ausgabe += zeichen;
                continue;
            }
            char secretZeichen = this.secretAlphabet.charAt(index);
            ausgabe += secretZeichen;
        }
        return ausgabe;
    }

    /**
     * Wie das verschlüsseln, wird das verschlüsselte Wort
     * wieder in das normale Wort umgewandelt
     * @param text
     * @return
     */
    public String decrypt(String text){
        text = text.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        String ausgabe = "";
        for(int i = 0; i<text.length(); i++){
            char secretZeichen = text.charAt(i);
            int index = this.secretAlphabet.indexOf(secretZeichen);
            if(index == -1){
                ausgabe += secretZeichen;
                continue;
            }
            char zeichen = alphabet.charAt(index);
            ausgabe += zeichen;
        }
        return ausgabe;
    }
}
