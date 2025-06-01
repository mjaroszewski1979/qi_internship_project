package pages.narzedzia;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogiPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public LogiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // URL strony "Logi"
    String poprawnyURLZakladkiLogi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-logs";
    // Tytuł strony "Logi"
    String poprawnyTytulZakladkiLogi = "Logi ‹ Platforma kursów online — WordPress";


    // ELEMENTY NA STRONIE:



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiLogi(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiLogi(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiLogi);
        return poprawnyURLZakladkiLogi;
    }

    public String zwrocAktualnyTytulZakladkiLogi(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiLogi(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiLogi);
        return poprawnyTytulZakladkiLogi;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
