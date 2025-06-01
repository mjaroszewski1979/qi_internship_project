package pages.sprzedaz;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KlienciPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public KlienciPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    //************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Klienci"
    String poprawnyTytulStronyKlienci = "Klienci ‹ Platforma kursów online — WordPress";
    // URL strony "Klienci"
    String poprawnyURLStronyKlienci = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-customers";


    // ELEMENTY NA STRONIE:





    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Klienci" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyKlienci(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Klienci" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyKlienci(){
        System.out.println("Poprawny tytuł strony KLIENCI: " + poprawnyTytulStronyKlienci);
        return poprawnyTytulStronyKlienci;
    }

    // Zwraca aktualny adres URL strony "Klienci" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyKlienci(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Klienci" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyKlienci() {
        System.out.println("Poprawny URL strony KLIENCI: " + poprawnyURLStronyKlienci);
        return poprawnyURLStronyKlienci;
    }







    //**********************************Operacje na webelementach KONIEC ******************************************/

}
