package pages.narzedzia;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PrzekierowaniaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public PrzekierowaniaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Przekierowania"
    String poprawnyTytulStronyPrzekierowania = "Przekierowania po zakupie ‹ Platforma kursów online — WordPress";
    // URL strony "Przekierowania"
    String poprawnyURLStronyPrzekierowania = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-purchase-redirections";


    // ELEMENTY NA STRONIE:




    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Przekierowania" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyPrzekierowania() {
        System.out.println("Aktualny tytuł strony PRZEKIEROWANIA: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Przekierowania" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyPrzekierowania() {
        System.out.println("Poprawny tytuł strony PRZEKIEROWANIA: " + poprawnyTytulStronyPrzekierowania);
        return poprawnyTytulStronyPrzekierowania;
    }

    // Zwraca aktualny adres URL strony "Przekierowania" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyPrzekierowania() {
        System.out.println("Aktualny URL strony PRZEKIEROWANIA: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Przekierowania" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyPrzekierowania() {
        System.out.println("Poprawny URL strony PRZEKIEROWANIA: " + poprawnyURLStronyPrzekierowania);
        return poprawnyURLStronyPrzekierowania;
    }





    /**********************************Operacje na webelementach KONIEC ******************************************/
}
