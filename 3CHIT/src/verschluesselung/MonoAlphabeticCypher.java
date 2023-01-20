package verschluesselung;

public class MonoAlphabeticCypher implements Cipher {
    private String secretAlphabet;

    public MonoAlphabeticCypher(){

    }

    public String getSecretAlphabet() {
        return this.secretAlphabet;
    }

    protected void setSecretAlphabet(String secretAlphabet){

        this.secretAlphabet = secretAlphabet;
    }

    public String encrypt(String text){
        String speichern = "";
        for(int i = 0; i<text.length(); i++){
            if(text.substring(i, i + 1).charAt(0) >= 'A' && text.substring(i, i + 1).charAt(0) <= 'Z' ||
            text.substring(i,i+1) == "Ä" ||
            text.substring(i,i+1) == "Ö" ||
            text.substring(i, i+1) == "Ü"){
                speichern += text.substring(i, i+ 1).toLowerCase();
                //System.out.println("Durchgang: " + i + " " + speichern);
            }
            else{
                speichern += text.substring(i, i+1);
                //System.out.println("Durchgang: " + i + " " +speichern);
            }
        }
        return speichern;
    }

    public String decrypt(String text){

        return text;
    }
}
