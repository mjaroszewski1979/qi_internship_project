package helpers;

import java.util.Random;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Utils {

    /**
     * Generuje losową liczbę całkowitą z zakresu od 1 do 100 (włącznie)
     * i zwraca ją jako ciąg znaków.
     *
     * @return String reprezentujący liczbę z zakresu 1–100
     */
    public static String generujLiczbeOd1Do100JakoString() {
        Random random = new Random();
        int liczba = random.nextInt(100) + 1;
        return String.valueOf(liczba);
    }

    /**
     * Generuje losową liczbę całkowitą z zakresu od 1 do 100000 (włącznie)
     * i zwraca ją jako ciąg znaków.
     *
     * @return String reprezentujący liczbę z zakresu 1–100000
     */
    public static String generujLiczbeOd1Do100000JakoString() {
        Random random = new Random();
        int liczba = random.nextInt(100000) + 1;
        return String.valueOf(liczba);
    }

    /**
     * Generuje bezpieczne, losowe hasło o długości 16 znaków.
     *
     * Hasło zawiera co najmniej jeden znak z każdej z następujących kategorii:
     * - wielkie litery (A–Z),
     * - małe litery (a–z),
     * - cyfry (0–9),
     * - znaki specjalne (!@#$%^&*()-_=+[]{}|;:,.<>?/`~).
     *
     * Pozostałe znaki są dobierane losowo z pełnej puli wszystkich dostępnych znaków.
     * Po zbudowaniu hasła znaki są tasowane, aby uniemożliwić przewidzenie ich kolejności.
     *
     * Metoda używa klasy SecureRandom dla zapewnienia większego bezpieczeństwa
     * niż standardowa klasa Random.
     *
     * @return String reprezentujący silne, 16-znakowe, losowe hasło
     */
    public static String generatePassword() {

        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String DIGITS = "0123456789";
        String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?/`~";
        int PASSWORD_LENGTH = 16;

        SecureRandom random = new SecureRandom();
        List<Character> passwordChars = new ArrayList<>();

        // Gwarantujemy, że każda kategoria znaków jest reprezentowana
        passwordChars.add(UPPER.charAt(random.nextInt(UPPER.length())));
        passwordChars.add(LOWER.charAt(random.nextInt(LOWER.length())));
        passwordChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        passwordChars.add(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        String allChars = UPPER + LOWER + DIGITS + SPECIAL;

        // Uzupełniamy resztę hasła losowymi znakami
        while (passwordChars.size() < PASSWORD_LENGTH) {
            passwordChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Tasujemy znaki, aby nie było przewidywalnego wzorca
        Collections.shuffle(passwordChars, random);

        // Tworzymy string z listy znaków
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }

}
