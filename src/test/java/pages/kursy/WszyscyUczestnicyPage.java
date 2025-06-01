 package pages.kursy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

 public class WszyscyUczestnicyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

     //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

     //konstruktor tworzący nową instancję strony
     //inicjalizacja drivera oraz obiektów klasy Waits
     //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public WszyscyUczestnicyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium Webelementów START *****************************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLKursyWszyscyUczestnicy = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-students";

     //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyKursyWszyscyUczestnicy  ="Wszyscy uczestnicy ‹ Platforma kursów online — WordPress";

    /***************************Repozytorium Webelementów KONIEC ******************************************/


    /****************************Operacje na Webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Wszyscy uczestnicy' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlKursyWszyscyUczestnicy(){
        System.out.println("Poprawny URL strony 'Wszyscy uczestnicy' : " + poprawnyURLKursyWszyscyUczestnicy);
        return poprawnyURLKursyWszyscyUczestnicy;
    }
     //zwrócenie aktualnego url strony i wypisanie go w konsoli
     public String zwrocUrlAktualnejStrony(){
         System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
         return driver.getCurrentUrl();
     }
     //zwrócenie poprawnego tytułu strony 'Wszyscy uczestnicy' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyKursyWszyscyUczestnicy(){
        System.out.println("Poprawny tytuł strony 'Wszyscy uczestnicy': " + poprawnyTytulStronyKursyWszyscyUczestnicy);
        return poprawnyTytulStronyKursyWszyscyUczestnicy;
    }
     //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
     public String zwroctTytulAktualnejStrony(){
         System.out.println("Aktualny tytuł strony: " + driver.getTitle());
         return driver.getTitle();
     }

    /**********************************Operacje na Webelementach KONIEC ******************************************/

}
