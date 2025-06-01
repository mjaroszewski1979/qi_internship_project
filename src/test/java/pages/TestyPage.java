package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public TestyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiTesty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-tests";
    String poprawnyTytulZakladkiTesty = "Zakończone testy ‹ Platforma kursów online — WordPress";
    int niezaznaczoneCheckboxy = 0;
    int zaznaczoneCheckboxy = 0;

    List<String> oczekiwaneNazwyWTabeli = Arrays.asList("Id", "Kurs", "Test", "Imię i nazwisko", "Punkty", "Wynik", "Data wypełnienia", "Więcej");


    @FindBy(xpath = "//td[contains(@class, 'type-id')]/a")
    private List<WebElement> pozycjeZakonczonychTestow;

    @FindBy(xpath = "//span[contains(text(), '#')]")
    private WebElement hashtagPrzyIDTestow;

    @FindBy(xpath = "//span[contains(text(), 'Wyników na stronę')]")
    private WebElement liczbaWynikowNaStrone;

    @FindBy(xpath = "//button[contains(text(), 'Typy danych')]")
    private WebElement typyDanychButton;

    @FindBy(xpath = "//p[contains(text(), 'Wybierz które kolumny mają być widoczne w tabeli')]")
    private WebElement sekcjaWybierzKtoreKolumnyMajaBycWidoczneWTabeli;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> listaCheckboxowWTypachDanych;

    @FindBy(xpath = "//div[contains(text(), 'Kurs')]")
    private WebElement kolumnaKursWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Test')]")
    private WebElement kolumnaTestWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Imię i nazwisko')]")
    private WebElement kolumnaImieINazwiskoWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Punkty')]")
    private WebElement kolumnaPunktyWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Wynik')]")
    private WebElement kolumnaWynikWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Data wypełnienia')]")
    private WebElement kolumnaDataWypelnieniaWTabeli;

    @FindBy(xpath = "//th[contains(text(), 'Więcej')]")
    private WebElement kolumnaWiecejWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Id')]")
    private WebElement kolumnaIdWTabeli;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiTesty(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiTesty(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiTesty);
        return poprawnyURLZakladkiTesty;
    }

    public String zwrocAktualnyTytulZakladkiTesty(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiTesty(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiTesty);
        return poprawnyTytulZakladkiTesty;
    }

    public void nacisnijPierwszyZakonczonyTestWZakladceTesty(){
        wait.waitForVisibility(hashtagPrzyIDTestow);
        pozycjeZakonczonychTestow.getFirst().click();
    }

    public boolean zweryfikujCzyNapisWynikowNaStroneIstnieje(){
        boolean status = false;

        if(liczbaWynikowNaStrone.isDisplayed()){
            status = true;

            System.out.println("Na stronie testy znajduje sie lista 'Wynikow na strone'.");
        }else{
            System.out.println("Lista 'Wynikow na strone' nie znajduje sie w zakladce testy.");
        }

        return status;

    }

    public boolean zweryfikujCzyButtonTypyDanychIstnieje(){
        boolean status = false;

        if(typyDanychButton.isDisplayed()){
            status = true;

            System.out.println("Na stronie testy znajduje sie przycisk 'Typy danych'.");
        }else{
            System.out.println("Przycisk 'Typy danych' nie znajduje sie w zakladce testy.");
        }

        return status;

    }

    public void nacisnijPrzyciskTypyDanychWZakladceTesty(){
        wait.waitForVisibility(typyDanychButton).click();
    }

    public boolean zweryfikujCzySekcjaWybierzKtoreKolumnyMajaBycWidoczneWTabeliIstnieje(){
        boolean status = false;

        if(sekcjaWybierzKtoreKolumnyMajaBycWidoczneWTabeli.isDisplayed()){
            status = true;

            System.out.println("Sekcja 'Wybierz które kolumny mają być widoczne w tabeli' pojawia sie poprawnie.");
        }else{
            System.out.println("Sekcja 'Wybierz które kolumny mają być widoczne w tabeli' nie pojawia sie po kliknieciu w przycisk 'Typy danych'.");
        }

        return status;

    }

    public boolean zweryfikujCzyPoNacisnieciuTypyDanychButtonPojawiaSiePoprawnaLiczbaCheckboxow(){
        boolean status = false;

        if(listaCheckboxowWTypachDanych.size() == 8){
            status = true;

            System.out.println("Liczba checkboxow jest prawidlowa, wynosi " + listaCheckboxowWTypachDanych.size());
        }else{
            System.out.println("Liczba checkboxow jest nieprawidlowa, wynosi " + listaCheckboxowWTypachDanych.size());
        }

        return status;

    }

    public boolean zweryfikujCzyLiczbaNiezaznaczonychCheckboxowJestPoprawna(){
        boolean status = false;

        for(WebElement checkbox : listaCheckboxowWTypachDanych){
            if(!checkbox.isSelected()){
                niezaznaczoneCheckboxy++;
            }else{
                zaznaczoneCheckboxy++;
            }
        }

        if(niezaznaczoneCheckboxy == 1){
            status = true;
            System.out.println("Liczba niezaznaczonych checkboxow jest poprawna i wynosi: " + niezaznaczoneCheckboxy);
            System.out.println("Liczba zaznaczonych checkboxow wynosi: " + zaznaczoneCheckboxy);
        }else{
            System.out.println("Liczba niezaznaczonych checkboxow nie jest poprawna, wynosi: " + niezaznaczoneCheckboxy);
        }

        return status;

    }

    public boolean zweryfikujCzyTabelaWZakladceTestyPosiadaPoprawneKolumny(){
        boolean status = false;

        if(kolumnaDataWypelnieniaWTabeli.isDisplayed() && kolumnaWiecejWTabeli.isDisplayed() && kolumnaWynikWTabeli.isDisplayed() && kolumnaPunktyWTabeli.isDisplayed() && kolumnaImieINazwiskoWTabeli.isDisplayed() && kolumnaKursWTabeli.isDisplayed() && kolumnaTestWTabeli.isDisplayed() && kolumnaIdWTabeli.isDisplayed()){
            status = true;
            System.out.println("Tabela w zakladce testy posiada wszystkie kolumny.");
        }

        return status;
    }




    /**********************************Operacje na webelementach KONIEC ******************************************/


}
