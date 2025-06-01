 package pages.uzytkownicy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static helpers.Utils.generujLiczbeOd1Do100000JakoString;

 public class UzytkownicyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    private static final String nowyUzytkownikNazwa = PropertiesReader.read("nowyUzytkownikNazwa");
    private static final String nowyUzytkownikEmail = PropertiesReader.read("nowyUzytkownikEmail");
    private static final String nowyUzytkownikImie = PropertiesReader.read("nowyUzytkownikImie");
    private static final String nowyUzytkownikNazwisko = PropertiesReader.read("nowyUzytkownikNazwisko");

    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public UzytkownicyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/



     @FindBy(linkText ="test@test.pld") private WebElement linkTestUser;

     @FindBy(className = "filters-button")
     private WebElement lupaButton;

     @FindBy(xpath = "//input[@placeholder= 'Wpisz by wyszukać'][1]")
     private WebElement wpiaszByWyszukacNazweInput;

     @FindBy(xpath = "//span[contains(text(), '#')]")
     private List<WebElement> idUzytkownikow;

     @FindBy(xpath = "//table[contains(@class, 'dynamic-table loaded')]")
     private WebElement zaladowanieTabeli;

     @FindBy(xpath = "//a[contains(text(), 'Dodaj nowego użytkownika')]")
     private WebElement dodajNowegoUzytkownikaButton;

    @FindBy(xpath = "//td[contains(., 'Menedżer treści Publigo')]")
    private WebElement rolaMenadzerTresciPubligo;

    @FindBy(xpath = "//div[contains(text(), 'Nowe konto użytkownika zostało pomyślnie utworzone')]")
    private WebElement komunikatPomyslneUtworzenieUzytkownika;

    @FindBy(xpath = "//td[contains(@role, 'cell')]")
    private List<WebElement> wszystkieKomorkiTabeli;

     /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Klika przycisk edytujacy dane uzytkownika testowego
    public void kliknijLinkTestUser() {
        wait.waitForClickability(linkTestUser).click();
    }

    public void nacisnijPrzyciskLupy(){
        wait.waitForVisibility(lupaButton).click();
    }

    public void wpiszNazweDoPolaWpiszByWyszukacNazwe(){
        wait.waitForVisibility(wpiaszByWyszukacNazweInput).clear();
        wpiaszByWyszukacNazweInput.sendKeys(nowyUzytkownikNazwa);
    }

    public void nacisnijWIdWyswietlonegoUzytkownika(){
        wait.waitForVisibility(zaladowanieTabeli);
        wait.waitForClickability(idUzytkownikow.get(0)).click();
    }

    public void cofnijSieDoStronyUzytkownicy(){
        wait.waitForTextInPageSource("Konto użytkownika zostało zaktualizowane.");
        driver.navigate().back();
        driver.navigate().back();

    }

     public void nacisnijDodajNowegoUzytkownikaButton(){
         wait.waitForVisibility(dodajNowegoUzytkownikaButton).click();
     }

     public boolean sprawdzCzyUzytkownikPosiadaRoleMenadzerTresciPubligo(){
        boolean status = false;

        if(wait.waitForVisibility(rolaMenadzerTresciPubligo).isDisplayed()){
            status = true;
            System.out.println("Zmiana roli przebiegla prawidlowo.");
        }
        return status;
     }

     // Sprawdza, czy pojawił się komunikat o pomyślnym utworzeniu użytkownika
     public boolean sprawdzCzyWidacKomunikatUzytkownikUtworzonyPomyslnie(){
        boolean status = false;

        if(wait.waitForVisibility(komunikatPomyslneUtworzenieUzytkownika).isDisplayed()){
            status = true;
            System.out.println("Użytkownik został utworzony. Komunikat na stronie: " + komunikatPomyslneUtworzenieUzytkownika.getText());
        } else {
            System.out.println("Użytkownik nie został utworzony.");
        }
        return status;
     }

     // Sprawdza, czy użytkownik został poprawnie dodany do tabeli
     // -> czy w komórkach tabeli widać dane użytkownika: nazwa, email, imię, nazwisko
     public boolean sprawdzCzyWidacDaneNowegoUtworzonegoUzytkownikaWTabeli(){
        boolean status = false;

        // Czekamy na załadowanie tabeli
        wait.waitForVisibility(zaladowanieTabeli);

        // Zbieramy wszystkie komórki tabeli do listy
        // -> używamy streama, aby pobrać tekst z każdej komórki i złożyć je w jedną listę
        List<String> wartosci = wszystkieKomorkiTabeli
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // Lista oczekiwanych wartości, które mają być widoczne w tabeli
        List<String> oczekiwaneWartosci = Arrays.asList(nowyUzytkownikNazwa, nowyUzytkownikEmail,
                nowyUzytkownikImie + " " + nowyUzytkownikNazwisko);

        // Iterujemy po oczekiwanych wartościach i sprawdzamy, czy są obecne w liście z wartościami
        for (String wartosc : oczekiwaneWartosci) {
            if (wartosci.contains(wartosc)) {
                status = true;
                System.out.println("Znaleziono dane użytkownika w tabeli: " + wartosc);
            } else {
                System.out.println("Nie widać danych użytkownika: " + wartosc);
            }
        }

        return status;

    }





     /**********************************Operacje na webelementach KONIEC ******************************************/

}
