package pages.sprzedaz;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HistoriaCenPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public HistoriaCenPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    //************************ Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Historia cen"
    String poprawnyTytulStronyHistoriaCen = "Historia cen ‹ Platforma kursów online — WordPress";
    // URL strony "Historia cen"
    String poprawnyURLStronyHistoriaCen = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-price-history";


    // ELEMENTY NA STRONIE:





    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Historia cen" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyHistoriaCen(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Historia cen" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyHistoriaCen(){
        System.out.println("Poprawny tytuł strony HISTORIA CEN: " + poprawnyTytulStronyHistoriaCen);
        return poprawnyTytulStronyHistoriaCen;
    }

    // Zwraca aktualny adres URL strony "Historia cen" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyHistoriaCen(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Historia cen" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyHistoriaCen() {
        System.out.println("Poprawny URL strony HISTORIA CEN: " + poprawnyURLStronyHistoriaCen);
        return poprawnyURLStronyHistoriaCen;
    }







    //**********************************Operacje na webelementach KONIEC ******************************************/

}
