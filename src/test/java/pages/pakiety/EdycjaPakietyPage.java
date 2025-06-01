package pages.pakiety;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EdycjaPakietyPage {

    /************************ Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login = PropertiesReader.read("login");
    private static final String haslo = PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstruktor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public EdycjaPakietyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/


    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyEdycjaPakietu = "Edycja pakietu ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//h1[contains(text(),'Edycja pakietu:')]")
    private WebElement oknoEdycjaPakietu;

    @FindBy(xpath = "//span[contains(text(),'Umiejscowienie')]")
    private WebElement sekcjaUmiejscowienie;

    @FindBy(xpath = "//button[contains(text(),'Konfiguruj')]")
    private List<WebElement> konfigurujEdycjaPakiety;

    @FindBy(xpath = "//h2[contains(text(),'Kategorie')]")
    private WebElement oknoKategorieEdycjaPakietu;

    @FindBy(xpath = "//label[contains(text(),'Wybierz kategorie')]")
    private WebElement wybierzKategorieOknoKategorie;

    @FindBy(xpath = "//input[contains(@class, 'single-field checkbox-double')]")
    private List<WebElement> wybierzKategorieCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Zapisz')]")
    private List<WebElement> zapiszButtonKategorie;

    @FindBy(xpath = "//label[contains(text(),'Tagi')]")
    private WebElement elementTagiEdycjaPakietu;

    @FindBy(xpath = "//button[contains(text(),'Konfiguruj')]")
    private List<WebElement> konfigurujTagiPakiety;

    @FindBy(xpath = "//h2[contains(text(),'Tagi')]")
    private WebElement oknoTagiEdycjaPakietu;

    @FindBy(xpath = "//input[contains(@data-default,'Dodaj tag')]")
    private WebElement dodajNowyTagInput;

    @FindBy(xpath = "//button[contains(text(),'Zapisz')]")
    private List<WebElement> zapiszButtonTagi;

    @FindBy(xpath = "//span[contains(text(),'Cena')]")
    private WebElement sekcjaCena;

    @FindBy(xpath = "//label[contains(text(),'Promocja')]")
    private WebElement elementPromocjaEdycjaPakietu;

    @FindBy(xpath = "//button[contains(text(),'Konfiguruj')]")
    private List<WebElement> konfigurujPromocjaPakiety;

    @FindBy(xpath = "//h2[contains(text(),'Promocja')]")
    private WebElement oknoPromocjaEdycjaPakietu;

    @FindBy(xpath = "//input[contains(@name,'sale_price')]")
    private WebElement cenaPromocyjnaInput;

    @FindBy(xpath = "//button[contains(text(),'Zapisz')]")
    private List<WebElement> zapiszButtonPromocja;

    @FindBy(xpath = "//span[contains(text(),'Sprzedaż')]")
    private WebElement sekcjaSprzedaz;

    @FindBy(xpath = "//label[contains(text(),'Włącz sprzedaż')]")
    private WebElement elementWlaczSprzedaz;

    @FindBy(xpath = "//input[@id='sales_disabled']/following-sibling::span[@class='slider']")
    private WebElement wlaczSprzedazToggle;

    @FindBy(xpath = "//a[contains(@id,'general')]")
    private WebElement zakladkaPodstawowePakiety;

    @FindBy(xpath = "//*[contains(text(), 'Zawartość pakietu')]")
    private WebElement zakladkaZawartoscPakietu;

    @FindBy(xpath = "//a[contains(text(), 'Generator linków')]")
    private WebElement generatorLinkowZakladkaPakiety;


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //zwrócenie aktualnego url strony
    public boolean zwrocUrlAktualnejStronyEdycjaPakietu(){
        System.out.println("Adres strony 'Edycja pakietu' jest poprawny, status: " + driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/" ));
        return driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/");
    }

    //zwrócenie poprawnego tytułu strony 'Edycja pakietu' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyEdycjaPakietu() {
        System.out.println("Poprawny tytuł strony 'Edycja pakietu': " + poprawnyTytulStronyEdycjaPakietu);
        return poprawnyTytulStronyEdycjaPakietu;
    }

    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony() {
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }
    //odświeżenie strony
    public void odswiezenieStrony(){
        driver.navigate().refresh();
    }

    //oczekiwanie na okno 'Edycja pakietu'
    public void poczekajNaOknoEdycjaPakietu(){
        wait.waitForVisibility(oknoEdycjaPakietu);
    }

    //oczekiwanie na sekcję 'Umiejscowienie'
    public void poczekajNaSekcjeUmiejscowienie(){
        wait.waitForVisibility(sekcjaUmiejscowienie);
    }

    //dodanie trzech kategorii do pakietu
    public void dodajTrzyKategorie(){
        kliknijWKonfigurujKategorie();
        poczekajNaOknoKategorieEdycjaPakietu();
        wybierzCheckbox1KategoriePakietu();
        wybierzCheckbox2KategoriePakietu();
        wybierzCheckbox3KategoriePakietu();
        kliknijWZapiszKategorie();
    }

    //kliknięcie w zakładkę 'Kategorie' konfiguruj
    public void kliknijWKonfigurujKategorie(){
        konfigurujEdycjaPakiety.get(1).click();
    }

    //oczekiwanie na okno 'Kategorie' okna 'Edycja pakietu'
    public void poczekajNaOknoKategorieEdycjaPakietu(){
        wait.waitForVisibility(oknoKategorieEdycjaPakietu);
    }

    //zaznaczenie pierwszego checkboxa 'Kategorie' konfiguruj
    public void wybierzCheckbox1KategoriePakietu() {
        wybierzKategorieCheckbox.get(0).click();
        System.out.println("Pierwszy checkbox kategorii wybrany");
    }

    //zaznaczenie drugiego checkboxa 'Kategorie' konfiguruj
    public void wybierzCheckbox2KategoriePakietu() {
        wybierzKategorieCheckbox.get(1).click();
        System.out.println("Drugi checkbox kategorii wybrany");
    }

    //zaznaczenie trzeciego checkboxa 'Kategorie' konfiguruj
    public void wybierzCheckbox3KategoriePakietu() {
        wybierzKategorieCheckbox.get(2).click();
        System.out.println("Trzeci checkbox kategorii wybrany");
    }

    //kliknięcie w 'Zapisz' zakładka 'Kategorie' konfiguruj
    public void kliknijWZapiszKategorie(){
        zapiszButtonKategorie.get(7).click();
    }

    //sprawdzenie czy ustawienia zostały zapisane
    public boolean sprawdzCzyTekstUstawieniaZostalyZapisaneWZrodleStronyIstnieje(){
        boolean status = false;
        if(wait.waitForTextInPageSource("Ustawienia zostały zapisane!")){
            status = true;
            System.out.println( "Ustawienia zostały zapisane!");
        }
        return status;
    }

    //przewinięcie strony do sekcji 'Umiejscowienie'
    public void przewinStroneDoSekcjiUmiejscowienie(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",sekcjaUmiejscowienie);
    }

    //dodanie trzech tagów: 'promocja', 'rabat', nowy'
    public void dodajTrzyTagiDoPakietu(){
        kliknijWKonfigurujTagi();
        poczekajNaOknoTagiEdycjaPakietu();
        przewinStroneDoDodajNowyTag();
        wpiszTrzyTagi();
        kliknijWZapiszTagi();
    }

    //kliknięcie w 'Tagi' konfiguruj
    public void kliknijWKonfigurujTagi()  {
        konfigurujTagiPakiety.get(2).click();
    }

    //oczekiwanie na okno 'Tagi' okna 'Edycja pakietu'
    public void poczekajNaOknoTagiEdycjaPakietu(){
        wait.waitForVisibility(oknoTagiEdycjaPakietu);
    }

    //przewinięcie strony do 'Dodaj nowy tag'
    public void przewinStroneDoDodajNowyTag(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",dodajNowyTagInput);
    }

    //wpisanie tagów: 'promocja', 'rabat', nowy'
    public void wpiszTrzyTagi() {
        wait.waitForClickability(dodajNowyTagInput).clear();
        wait.waitForVisibility(dodajNowyTagInput).sendKeys("promocja, rabat, nowy");
    }

    //kliknięcie w 'Zapisz' zakładka 'Kategorie' konfiguruj
    public void kliknijWZapiszTagi(){
        zapiszButtonTagi.get(10).click();
    }

    //przewinięcie strony do sekcji 'Cena'
    public void przewinStroneDoSekcjiCena(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",sekcjaCena);
    }

    //oczekiwanie na sekcję 'Cena' okna 'Edycja pakietu'
    public void poczekajNaSekcjeCenaEdycjaPakietu() {
        wait.waitForVisibility(sekcjaCena);
    }

    //dodanie ceny promocji 799zł
    public void dodajCenePromocyjnaPakietu(){
        kliknijWKonfigurujPromocja();
        poczekajNaOknoPromacjaEdycjaPakietu();
        wpiszCenePromocyjna();
        kliknijWZapiszPromocja();
    }

    //kliknięcie w 'Promocja' konfiguruj
    public void kliknijWKonfigurujPromocja()  {
        konfigurujPromocjaPakiety.get(3).click();
    }

    //oczekiwanie na okno 'Promocja' okna 'Edycja pakietu'
    public void poczekajNaOknoPromacjaEdycjaPakietu(){
        wait.waitForVisibility(oknoPromocjaEdycjaPakietu);
    }

    //wpisanie ceny promocji 799zł
    public void wpiszCenePromocyjna() {
        wait.waitForClickability(cenaPromocyjnaInput).clear();
        wait.waitForVisibility(cenaPromocyjnaInput).sendKeys("799");
    }

    //kliknięcie w 'Zapisz' zakładka 'Promocja' konfiguruj
    public void kliknijWZapiszPromocja(){
        zapiszButtonPromocja.get(16).click();
    }

    //oczekiwanie na sekcję 'Sprzedaż'
    public void poczekajNaSekcjeSprzedaz(){
        wait.waitForVisibility(sekcjaSprzedaz);
    }

    //przewinięcie strony do sekcji 'Sprzedaż'
    public void przewinStroneDoSekcjiSprzedaz(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",sekcjaSprzedaz);
    }

    //włączenie sprzedaży
    public void wlaczSprzedazPakiety(){
       wlaczSprzedazToggle.click();
    }

    //przewinięcie strony do zakładki 'Zawartość pakietu'
    public void przewinStroneDoZakladkiZawartoscPakietu(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",zakladkaZawartoscPakietu);
    }

    //przejscie do zakładki 'Zawartość pakietu'
    public void przejdzDoZakladkiZawartoscPakietu(){
        wait.waitForClickability(zakladkaZawartoscPakietu).click();
    }

/********************************** Operacje na Webelementach KONIEC ******************************************/

}
