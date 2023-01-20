package Testen;



public class Main {
    public static void main(String[] args) {
        String url1 = "https://www.ribinin.de";
        if (Methoden.isValid(url1)) {
            System.out.println("valid");
        }
        else{
            System.out.println("invalid");
        }
    }
}
