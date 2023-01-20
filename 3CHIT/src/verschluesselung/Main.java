package verschluesselung;

public class Main {
    public static void main(String[] args) {
        String text = "HALlÖle?";
        MonoAlphabeticCypher m = new MonoAlphabeticCypher();
        System.out.println(m.encrypt(text));

    }

}
