 package pages.seleniumShop;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

 public class MainPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/
    int poprawnaLiczbaPozycjiWMenuGlownym = 6;
    String poprawnyURLKoszyka = "http://www.selenium-shop.pl/koszyk/";
     String poprawnyTytulStronyKoszyk ="Koszyk – Selenium Shop Automatyzacja Testów";

    @FindBy(xpath = "//*[contains(@class,'menu-item')]")
    private List<WebElement> menuItems;

    @FindBy(xpath ="//a[contains(text(),'Koszyk')]" )
    private WebElement koszykMenu;

     @FindBy(xpath ="//a[contains(text(),'Moje konto')]" )
     private WebElement mojeKontoMenu;

     @FindBy(xpath ="//ul[@id='menu-menu-1']/li/a" )
     private List<WebElement> menuItemsName;




    /***************************Repozytorium webelementów KONIEC ******************************************/



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public int zworcLiczbePozycjiWMenuGlownym(){
        System.out.println("Aktualna liczba pozycji w menu głównego: " + menuItems.size());
        return menuItems.size();

    }

    public int zwrocPoprawnaLiczbePozycjiWMenuGlownym(){
        System.out.println("Poprawna liczba pozycji w menu głównego: " + poprawnaLiczbaPozycjiWMenuGlownym);
        return poprawnaLiczbaPozycjiWMenuGlownym;
    }

    public void przejdzDoKoszyka(){
      wait.waitForClickability(koszykMenu).click();
    }

     public void przejdzDoEkranuLogowania(){

       wait.waitForVisibility(mojeKontoMenu).click();
     }


    public String zwrocaktualnyUrlStronyNaKtorejJestes(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlKoszyka(){
        System.out.println("Poprawny URL koszyka: " + poprawnyURLKoszyka);
        return poprawnyURLKoszyka;
    }

    public String zwroctytulAktualnejStrony(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
       return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyKoszyk(){
        System.out.println("Poprawny tytuł strony koszyka: " + poprawnyTytulStronyKoszyk);
        return poprawnyTytulStronyKoszyk;
    }


    public List<String> zwrocNazwyPozycjiMenuGlownego(){
        wait.waitForVisibility(menuItemsName.get(0));

        List<String> menuNames = new ArrayList<>();

        for(WebElement element: menuItemsName){
            menuNames.add(element.getText().trim());
        }

        return menuNames;
    }

    public List<String> zwrocPoprawneNazywyPozycjiMenuGlownego(){
        return List.of("STRONA GŁÓWNA", "ANKIETA", "KOSZYK", "MOJE KONTO", "SKLEP", "ZAMÓWIENIE");

    }

    /**********************************Operacje na webelementach KONIEC ******************************************/

}
