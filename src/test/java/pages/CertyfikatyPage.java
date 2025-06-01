package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CertyfikatyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public CertyfikatyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiCertyfikaty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-certificates";
    String poprawnyTytulZakladkiCertyfikaty = "Certyfikaty ‹ Platforma kursów online — WordPress";
    int zaznaczoneCheckboxy = 0;
    int niezaznaczoneCheckboxy = 0;

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

    @FindBy(xpath = "//div[contains(text(), 'Imię i nazwisko')]")
    private WebElement kolumnaImieINazwiskoWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Email')]")
    private WebElement kolumnaEmailWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Numer certyfikatu')]")
    private WebElement kolumnaNumerCertyfikatuWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Data utworzenia')]")
    private WebElement kolumnaDataUtworzeniaWTabeli;

    @FindBy(xpath = "//th[contains(text(), 'Więcej')]")
    private WebElement kolumnaWiecejWTabeli;

    @FindBy(xpath = "//div[contains(text(), 'Id')]")
    private WebElement kolumnaIdWTabeli;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiCertyfikatyt(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiCertyfikaty(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiCertyfikaty);
        return poprawnyURLZakladkiCertyfikaty;
    }

    public String zwrocAktualnyTytulZakladkiCertyfikatyt(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiCertyfikaty(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiCertyfikaty);
        return poprawnyTytulZakladkiCertyfikaty;
    }

    public boolean zweryfikujCzyNapisWynikowNaStroneIstniejeWZakladceCertyfikaty(){
        boolean status = false;

        if(liczbaWynikowNaStrone.isDisplayed()){
            status = true;

            System.out.println("W zakladce certyfikaty znajduje sie lista 'Wynikow na strone'.");
        }else{
            System.out.println("Lista 'Wynikow na strone' nie znajduje sie w zakladce certyfikaty.");
        }

        return status;

    }

    public boolean zweryfikujCzyButtonTypyDanychIstniejeWZakladceCertyfikaty(){
        boolean status = false;

        if(typyDanychButton.isDisplayed()){
            status = true;

            System.out.println("Na stronie certyfikaty znajduje sie przycisk 'Typy danych'.");
        }else{
            System.out.println("Przycisk 'Typy danych' nie znajduje sie w zakladce certyfikaty.");
        }

        return status;

    }

    public void nacisnijPrzyciskTypyDanychWZakladceCertyfikaty(){
        wait.waitForVisibility(typyDanychButton).click();
    }

    public boolean zweryfikujCzySekcjaWybierzKtoreKolumnyMajaBycWidoczneWTabeliIstniejeWZakladceCertyfikaty(){
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

        if(listaCheckboxowWTypachDanych.size() == 6){
            status = true;

            System.out.println("Liczba checkboxow jest prawidlowa, wynosi " + listaCheckboxowWTypachDanych.size());
        }else{
            System.out.println("Liczba checkboxow jest nieprawidlowa, wynosi " + listaCheckboxowWTypachDanych.size());
        }

        return status;

    }

    public boolean zweryfikujCzyLiczbaZaznaczonychCheckboxowJestPoprawna(){
        boolean status = false;

        for(WebElement checkbox : listaCheckboxowWTypachDanych){
            if(checkbox.isSelected()){
                zaznaczoneCheckboxy++;
            }else{
                niezaznaczoneCheckboxy++;
            }

        }

        if(zaznaczoneCheckboxy == 6){
            status = true;
            System.out.println("Liczba zaznaczonych checkboxow jest poprawna, wynosi: " + zaznaczoneCheckboxy);
        }else{
            System.out.println("Liczba zaznaczonych checkboxow jest niepoprawna, wynosi: " + zaznaczoneCheckboxy);
        }
        return status;

    }

    public boolean zweryfikujCzyTabelaWZakladceCertyfikatyPosiadaPoprawneKolumny(){
        boolean status = false;

        if(kolumnaIdWTabeli.isDisplayed() && kolumnaKursWTabeli.isDisplayed() && kolumnaEmailWTabeli.isDisplayed() && kolumnaNumerCertyfikatuWTabeli.isDisplayed() && kolumnaDataUtworzeniaWTabeli.isDisplayed() && kolumnaWiecejWTabeli.isDisplayed() && kolumnaImieINazwiskoWTabeli.isDisplayed()){
            status = true;
            System.out.println("Tabela w zakladce certyfikaty posiada wszystkie kolumny.");
        }

        return status;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
