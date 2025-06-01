package pages.sprzedaz;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZamowieniaPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login = PropertiesReader.read("login");
    private static final String haslo = PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public ZamowieniaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    //************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Zamówienia"
    String poprawnyTytulStronyZamowienia = "Zamówienia ‹ Platforma kursów online — WordPress";
    // URL strony "Zamówienia"
    String poprawnyURLStronyZamowienia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-payment-history";
    // Tekst informacji w sekcji po kliknięciu przycisku "Typy danych"
    String poprawnaInformacjaWSekcjiTypyDanych = "Wybierz, które kolumny mają być widoczne w tabeli:";
    // Liczba checkboxów w polu "Typy danych"
    int prawidlowaLiczbaChecboxowTypyDanych = 17;


    // ELEMENTY NA STRONIE:

    // Przyciski:
    @FindBy(xpath = "//*[contains(text(),'Dodaj zamówienie')]")
    private WebElement dodajZamowienieButton;

    @FindBy(xpath = "//button[contains(text(),'Typy danych')]")
    private WebElement typyDanychButton;

    @FindBy(xpath = "//button[@class='filters-button ']")
    private WebElement filtrujButton;


    // Tekst informacji w polu "Typy danych":
    @FindBy(className = "dynamic-table__column-visibility-checkboxes__hint")
    private WebElement informacjaWSekcjiTypyDanych;

//    Xpath zamienny/alternatywny po poprawie błędu interpunkcyjnego w tekście informacji w sekcji "Typy danych"
//    @FindBy(xpath = "//*[contains(text(),'Wybierz, które kolumny mają być widoczne w tabeli')]")
//    private WebElement informacjaWSekcjiTypyDanych;


    // Wszystkie checkboxy w polu "Typy danych":
    @FindBy(xpath = "//*[contains(@class,'checkbox-replacement')]")
    private List<WebElement> wszytkieCheckboxyTypyDanych;


    // Nazwy checkboxów w polu "Typy danych":
    @FindBy(xpath = "//label[contains(text(),'ID')]")
    private WebElement idTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Imię i nazwisko')]")
    private WebElement imieINazwiskoTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Email')]")
    private WebElement emailTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Numer telefonu')]")
    private WebElement numerTelefonuTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Adres dostawy')]")
    private WebElement adresDostawyTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Data')]")
    private WebElement dataTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Kwota')]")
    private WebElement kwotaTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Kod zniżkowy')]")
    private WebElement kodZnizkowyTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Produkty')]")
    private WebElement produktyTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Zwiększenie sprzedaży')]")
    private WebElement zwiekszenieSprzedazyTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Status')]")
    private WebElement statusTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Metoda płatności')]")
    private WebElement metodaPlatnosciTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Płatności cykliczne')]")
    private WebElement platnosciCykliczneTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Państwo')]")
    private WebElement panstwoTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'NIP')]")
    private WebElement nipTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Nazwa firmy')]")
    private WebElement nazwaFirmyTypyDanych;

    @FindBy(xpath = "//label[contains(text(),'Zaznaczone checkboxy')]")
    private WebElement zaznaczoneCheckboxyTypyDanych;



    public WebElement getPoleKolumnySortowaniaProdukty() {
        return driver.findElement(By.xpath("//tr/th[8]//input"));
    }


    public String getWczytujeTekstXpath() {
        return "//td[contains(text(), 'Wczytuję')]";
    }


    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyZamowienia() {
        System.out.println("Aktualny tytuł strony ZAMÓWIENIA: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyZamowienia() {
        System.out.println("Poprawny tytuł strony ZAMÓWIENIA: " + poprawnyTytulStronyZamowienia);
        return poprawnyTytulStronyZamowienia;
    }

    // Zwraca aktualny adres URL strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyZamowienia() {
        System.out.println("Aktualny URL strony ZAMÓWIENIA: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyZamowienia() {
        System.out.println("Poprawny URL strony ZAMÓWIENIA: " + poprawnyURLStronyZamowienia);
        return poprawnyURLStronyZamowienia;
    }

    // Klika przycisk "Dodaj zamówienie" i wypisuje go w konsoli
    public void kliknijDodajZamowienieButton() {
        System.out.println("Kliknięcie przycisku: " + dodajZamowienieButton.getText());
        wait.waitForVisibility(dodajZamowienieButton).click();
    }

    // Sprawdza, czy przycisk "Dodaj zamówienie" jest widoczny i wypisuje go w konsoli
    public boolean zweryfikujCzyPrzyciskDodajZamowienieIstnieje() {
        boolean status = false;

        if (dodajZamowienieButton.isDisplayed()) {
            status = true;
            System.out.println("Widać przycisk: " + dodajZamowienieButton.getText());
        } else {
            System.out.println("Nie widać przycisku DODAJ ZAMÓWIENIE");
        }

        return status;
    }

    // Sprawdza, czy przycisk "Typy danych" jest widoczny i wypisuje go w konsoli
    public boolean zweryfikujCzyPrzyciskTypyDanychIstnieje() {
        boolean status = false;

        if (typyDanychButton.isDisplayed()) {
            status = true;
            System.out.println("Widać przycisk: " + typyDanychButton.getText());
        } else {
            System.out.println("Nie widać przycisku TYPY DANYCH");
        }

        return status;
    }

    // Klika przycisk "Typy danych" i wypisuje go w konsoli
    public void kliknijTypyDanychButton() {
        System.out.println("Kliknięcie przycisku: " + typyDanychButton.getText());
        wait.waitForVisibility(typyDanychButton).click();
    }

    // Zwraca aktualny tekst informacji w sekcji "Typy danych" i wypisuje go w konsoli
    public String zwrocAktualnyTekstInformacjiWSekcjiTypyDanych() {
        System.out.println("Aktualna informacja w sekcji 'Typy danych': " + informacjaWSekcjiTypyDanych.getText());
        return informacjaWSekcjiTypyDanych.getText();
    }

    // Zwraca oczekiwany (poprawny) tekst informacji w sekcji "Typy danych" i wypisuje go w konsoli
    public String zwrocPoprawnyTekstInformacjiWSekcjiTypyDanych() {
        System.out.println("Oczekiwana informacja w sekcji 'Typy danych': " + poprawnaInformacjaWSekcjiTypyDanych);
        return poprawnaInformacjaWSekcjiTypyDanych;
    }

    // Zwraca tekst informacji w sekcji "Typy danych" i wypisuje w konsoli.
    // Oczekiwany tekst: "Wybierz, które kolumny mają być widoczne w tabeli:"
    public boolean zweryfikujCzyInformacjaWSekcjiTypyDanychIstnieje() {
        boolean status = false;

        if (informacjaWSekcjiTypyDanych.isDisplayed()) {
            status = true;
            System.out.println("Widać informację w sekcji TYPY DANYCH: " + informacjaWSekcjiTypyDanych.getText());
        } else {
            System.out.println("Nie widać informacji w sekcji TYPY DANYCH. " +
                    "Oczekiwany tekst: " + poprawnaInformacjaWSekcjiTypyDanych);
        }

        return status;
    }

    // Zwraca aktualną liczbę checkboxów w polu "Typy danych"
    public int zwrocAktualnaLiczbeCheckboxowTypyDanych() {
        System.out.println("Aktualna liczba checkboxów w polu TYPY DANYCH: " + wszytkieCheckboxyTypyDanych.size());
        return wszytkieCheckboxyTypyDanych.size();
    }

    // Zwraca oczekiwaną (poprawną) liczbę checkboxów w polu "Typy danych"
    public int zwrocPoprawnaLiczbeCheckboxowTypyDanych() {
        System.out.println("Oczekiwana checkboxów w polu TYPY DANYCH: " + prawidlowaLiczbaChecboxowTypyDanych);
        return prawidlowaLiczbaChecboxowTypyDanych;
    }

    // Sprawdza, czy aktualne nazwy checkboxów w polu "Typy danych" są takie same, jak oczekiwane
    public boolean zweryfikujNazwyCheckboxowTypyDanych() {

        // Mapa z nazwami checkboxów (oczekiwana, obecna)
        // W przypadku zmian w nazwach checkboxów należy wprowadzić tu odpowiednie zmiany:
        // (zmienić tekst / dodać nowy checkbox i jego nazwę)
        Map<String, WebElement> nazwyPozycji = new HashMap<>();
        nazwyPozycji.put("ID", idTypyDanych);
        nazwyPozycji.put("Imię i nazwisko", imieINazwiskoTypyDanych);
        nazwyPozycji.put("Email", emailTypyDanych);
        nazwyPozycji.put("Numer telefonu", numerTelefonuTypyDanych);
        nazwyPozycji.put("Adres dostawy", adresDostawyTypyDanych);
        nazwyPozycji.put("Data", dataTypyDanych);
        nazwyPozycji.put("Kwota", kwotaTypyDanych);
        nazwyPozycji.put("Kod zniżkowy", kodZnizkowyTypyDanych);
        nazwyPozycji.put("Produkty", produktyTypyDanych);
        nazwyPozycji.put("Zwiększenie sprzedaży", zwiekszenieSprzedazyTypyDanych);
        nazwyPozycji.put("Status", statusTypyDanych);
        nazwyPozycji.put("Metoda płatności", metodaPlatnosciTypyDanych);
        nazwyPozycji.put("Płatności cykliczne", platnosciCykliczneTypyDanych);
        nazwyPozycji.put("Państwo", panstwoTypyDanych);
        nazwyPozycji.put("NIP", nipTypyDanych);
        nazwyPozycji.put("Nazwa firmy", nazwaFirmyTypyDanych);
        nazwyPozycji.put("Zaznaczone checkboxy", zaznaczoneCheckboxyTypyDanych);

        boolean status = true;

        // Iterujemy po mapie z nazwami checkboxów
        for (Map.Entry<String, WebElement> entry : nazwyPozycji.entrySet()) {
            String oczekiwanaNazwaPozycji = entry.getKey();
            WebElement aktualnaNazwaPozycji = entry.getValue();

            // Sprawdzamy, czy nazwa checkboxa jest widoczna i zgodna z oczekiwaną
            try {
                WebElement obecnyElement = wait.waitForVisibility(aktualnaNazwaPozycji);

                boolean nazwaWidoczna = obecnyElement.isDisplayed();
                boolean nazwaZgodna = obecnyElement.getText().trim().equals(oczekiwanaNazwaPozycji);

                if (!nazwaWidoczna || !nazwaZgodna) {
                    if (!nazwaWidoczna) {
                        System.out.println("Nazwa checkboxa w polu TYPY DANYCH nie jest widoczna: " + oczekiwanaNazwaPozycji);
                    }
                    if (!nazwaZgodna) {
                        System.out.println("Nazwa checkboxa w polu TYPY DANYCH jest niezgodna. "
                                + "Oczekiwano: '" + oczekiwanaNazwaPozycji + "' "
                                + "Znaleziono: '" + obecnyElement.getText().trim() + "' ");
                    }
                    status = false;
                } else {
                    System.out.println("Nazwy checkboxów w polu TYPY DANYCH są widoczne i mają zgodne nazwy : " + oczekiwanaNazwaPozycji);
                }

            } catch (Exception e) {
                System.out.println("W polu TYPY DANYCH nie ma nazwy checkboxa: " + oczekiwanaNazwaPozycji);
                e.printStackTrace();
                status = false;
            }
        }

        return status;
    }

    public void kliknijFiltrujButton() {
        wait.waitForVisibility(filtrujButton).click();
    }

    // Filtrujemy produkty za pomocą nazwy produktu podanej jako argument
    public void przeflitrujWynikPoNazwieProduktu(String produkt) {
        kliknijFiltrujButton();

        // Czekamy aż załaduje się strona i zniknie tekst "Wczytuję..." aby wszystko było klikalne
        wait.waitForInvisibility(By.xpath(getWczytujeTekstXpath()));

        getPoleKolumnySortowaniaProdukty().clear();
        getPoleKolumnySortowaniaProdukty().sendKeys(produkt);
        getPoleKolumnySortowaniaProdukty().sendKeys(Keys.ENTER);

        // Czekamy aż przeładuje się wynik wyszukiwania (tekst "Wczytuję..." musi się pojawić a następnie zniknąć)
        wait.waitForPresent(By.xpath(getWczytujeTekstXpath()));
        wait.waitForInvisibility(By.xpath(getWczytujeTekstXpath()));
    }

    public WebElement getPierwszeZamowienieZListy() {
        return wait.waitForPresent(By.xpath("//tr//td[@class='type-id']"));
    }


    //**********************************Operacje na webelementach KONIEC ******************************************/

}

