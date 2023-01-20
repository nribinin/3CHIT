package Testen;

import java.net.URL;

public class Methoden {
    public static boolean isValid(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }

        catch (Exception e) {
            return false;
        }
    }
}
