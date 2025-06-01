package pages.raporty;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RaportyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstrukotor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public RaportyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLRaportow = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-sales-report";
    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyRaporty  ="Raporty ‹ Platforma kursów online — WordPress";



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Raporty' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlRaportow(){
        System.out.println("Poprawny URL strony raportów: " + poprawnyURLRaportow);
        return poprawnyURLRaportow;
    }
    //zwrócenie aktualnego url strony i wypisanie go w konsoli
    public String zwrocUrlAktualnejStrony(){
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    //zwrócenie poprawnego tytułu strony 'Raporty' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyRaporty(){
        System.out.println("Poprawny tytuł strony raportów: " + poprawnyTytulStronyRaporty);
        return poprawnyTytulStronyRaporty;
    }
    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/

}
