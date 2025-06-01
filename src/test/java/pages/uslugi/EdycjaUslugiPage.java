package pages.uslugi;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.IFactoryAnnotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;

public class EdycjaUslugiPage {

    //parametry klasy EdycjaUslugiPage
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony Edycja Uslugi
    public EdycjaUslugiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //zmienne pomocnicze:

    private final String poprawnyURLStronyEdycjaUslugi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-editor-service&edit_service_id=1205&autofocus=general";

    private final String poprawnyTytulStronyEdycjaUslugi = "Edycja usługi ‹ Platforma kursów online — WordPress";

    private final String krotkiOpisZadanie = "4. Utworzyć usługę na kwotę 2999 zł. Dodać krótki opis na 120 znaków. Dodać 10 kategorii oraz 5 tagów (obojętnie jakie).";

    private int cenaPromocyjnaZadanie = 499;

    //sposob wprowadzania tagow pozwala na odzielenie ich przecinkiem, stad jeden string z przecinkami wprowadzi 5 tagow
    private String tagi = "Test1,Test2,Test3,Test4,Test5";

    //zmienne pomocnicze KONIEC


    //listy sekcji strony 'Edycja usługi' w zakladce Podstawowe

    private List<String> poprawneSekcje = Arrays.asList("Nazwa i opis", "Umiejscowienie",
            "Cena", "Dostępne ilości", "Graficzne", "Sprzedaż");

    @FindBy(xpath = "//span[@class='fields-group__name']")
    private List<WebElement> aktualneSekcje;
    //listy sekcji strony 'Edycja usługi' w zakladce Podstawowe KONIEC


    //elementy menu bocznego

    @FindBy(id = "general")
    private WebElement podstawoweMenuBoczne;

    @FindBy(id = "link_generator")
    private WebElement generatorLinkowMenuBoczne;


    //elementy opcji 'Krotki opis' w sekcji 'Nazwa i opis':

    @FindBy(xpath = "//button[@data-popup-id='short_description_popup-additional-settings-popup']")
    private WebElement konfigurujKrotkiOpisButton;

    @FindBy(xpath = "//div[@id='short_description_popup-additional-settings-popup']")
    private WebElement krotkiOpisOkno;

    @FindBy(xpath = "//textarea[@id='short_description']")
    private WebElement krotkiOpisInput;

    @FindBy(xpath = "//button[@id='save-short_description_popup-additional-settings-popup']")
    private WebElement krotkiOpisZapiszButton;


    //elementy opcji 'Promocja' w sekcji 'Cena':

    @FindBy(xpath = "//button[@data-popup-id='special_offer-additional-settings-popup']")
    private WebElement konfigurujPromocjaButton;

    @FindBy(xpath = "//div[@id='special_offer-additional-settings-popup']")
    private WebElement promocjaOkno;

    @FindBy(xpath = "//input[@id='sale_price']")
    private WebElement cenaPromocyjnaInput;

    @FindBy(xpath = "//button[@id='save-special_offer-additional-settings-popup']")
    private WebElement cenaPromocyjnaZapiszButton;

    @FindBy(xpath = "//button[@id='save-special_offer-additional-settings-popup']")
    private WebElement promocjaOknoZapiszButton;

    @FindBy(xpath = "//input[@id='sale_price_date_from_date']")
    private WebElement rozpoczeciePromocjiInput;

    @FindBy(xpath = "//input[@id='sale_price_date_to_date']")
    private WebElement zakonczeniePromocjiInput;


    //elementy w sekcji 'Dostępne ilości':

    @FindBy(xpath = "//input[@id='purchase_limit']")
    private WebElement liczbaSztDoZakupuInput;

    @FindBy(xpath = "//button[@class='single-field-save-button' and @data-related-field='purchase_limit']")
    private WebElement liczbaSztDoZakupuZapiszButton;

    @FindBy(xpath = "//input[@id='purchase_limit_items_left']")
    private WebElement pozostaloSztukInput;

    @FindBy(xpath = "//button[@class='single-field-save-button' and @data-related-field='purchase_limit_items_left']")
    private WebElement pozostaloSztukZapiszButton;


    //elementy do opcji 'Kategorie' w sekcji 'Umiejscowienie':

    @FindBy(xpath = "//button[@data-popup-id='categories_popup-additional-settings-popup']")
    private WebElement konfigurujKategorieButton;

    @FindBy(xpath = "//div[@id='categories_popup-additional-settings-popup']")
    private WebElement kategorieOkno;

    @FindBy(xpath = "//button[@id='save-categories_popup-additional-settings-popup']")
    private WebElement kategorieZapiszButton;

    //dodaje checkboxy wszystkich kategorii do listy
    @FindBy(xpath = "//input[@type='checkbox' and @name='categories[]']")
    private List<WebElement> kategorieLista;


    //elementy do opcji "Tagi w sekcji 'Umiejscowienie':

    @FindBy(xpath = "//button[@data-popup-id='tags_popup-additional-settings-popup']")
    private WebElement konfigurujTagiButton;

    @FindBy(xpath = "//div[@id='tags_popup-additional-settings-popup']")
    private WebElement tagiOkno;

    @FindBy(xpath = "//input[@data-default='Dodaj tag']")
    private WebElement tagiInput;

    @FindBy(xpath = "//button[@id='save-tags_popup-additional-settings-popup']")
    private WebElement tagiZapiszButton;


    //pozostale elementy

    //button znajdujacy sie u gory strony, przenosi do strony uslugi w katalogu
    @FindBy(className = "product-offer-preview-button")
    private WebElement zobaczUslugeButton;

    //slider włączający sprzedaż (domyślnie wyłączony)
    @FindBy(xpath = "//input[@id='sales_disabled']/following-sibling::span[@class='slider']")
    private WebElement wlaczSprzedazSlider;

    //input zawierajacy wygenerowany link zakupowy uslugi
    @FindBy(xpath = "//input[@id='bpmj-eddcm-add-to-cart-link']")
    private WebElement linkZakupowyInput;

    //nagłowek sekcji 'Nazwa i Opis', uzywany do stworzenia waita na pelne zaladowanie okna ustawien w zakladce 'Podstawowe'
    @FindBy(xpath = "//span[@class='fields-group__name' and text()='Nazwa i opis']")
    private WebElement sekcjaNazwaIOpis;

    //element sekcji 'Generator linków', uzywany do stworzenia waita na pelne zaladowanie okna ustawien w zakladce 'Generator linkow'
    @FindBy(xpath = "//span[@class='fields-group__name' and text()='Generator linków']")
    private WebElement sekcjaGeneretorLinkow;

    //element ten znajduje sie na stronie zamowienia i powinien sie znalezc w klasie ZamowieniaPage, jako ze nie ma takiej klasy
    //to dla ulatwienia znajduje sie w tej
    @FindBy(xpath = "//input[@id='edd-purchase-button']")
    private WebElement zamawiamIPlaceButton;



    //misc

    //skrypt JS executor scrollujacy do elementow i umieszczajacy ich w centrum strony,
    //niweluje zaslanianie elementow przez popup 'Ustawienia zostaly zapisane'
    //metoda powinna byc w BasePage, ale nie ma takiej klasy
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    //random number generator od 1 do 50
    public int zwrocLosowyInt() {
        Random random = new Random();
        int losowyInt = random.nextInt(50) + 1;
        return losowyInt;
    }

    //oczekiwanie na zaladowanie sie ustawień poprzez czekanie na naglowek sekcji "Nazwa i opis"
    public void poczekajNaUstawienia() {
        wait.waitForVisibility(sekcjaNazwaIOpis);
    }


    //Gettery

    //zwraca url otwartej strony
    public String zwrocAktualnyURLStronyEdycjaUslugi() {
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //zwraca wzorowy adres url (ze zmiennej pomocniczej)
    public String zwrocPoprawnyURLStronyEdycjaUslugi() {
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLStronyEdycjaUslugi);
        return poprawnyURLStronyEdycjaUslugi;
    }

    //zwraca tytul otwartej strony
    public String zwrocAktualnyTytulStronyEdycjaUslugi() {
        wait.waitForTextInPageSource("Edycja usługi");
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    //zwraca wzorowy tytul strony (ze zmiennej pomocniczej)
    public String zwrocPoprawnyTytulStronyEdycjaUslugi() {
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulStronyEdycjaUslugi);
        return poprawnyTytulStronyEdycjaUslugi;
    }

    //zwraca liste wzorowych sekcji ustawien
    public List<String> zwrocPoprawneSekcje() {
        return poprawneSekcje;
    }

    //zwraca liste pobranych sekcji ustawien, wyciagajac tekst z WebElementow i dodajac je do nowej listy
    public List<String> zwrocAktualneSekcje() {
        List<String> sekcjeArrayList = new ArrayList<String>();

        for (WebElement sekcja : aktualneSekcje) {
            sekcjeArrayList.add(sekcja.getText());
        }
        return sekcjeArrayList;
    }


    //metody weryfikujące

    public boolean zweryfikujCzyOtwartaStronaToEdycjaUslugi() {
        return wait.waitForTextInPageSource("Edycja usługi:");
    }

    public boolean zweryfikujCzyWMenuBocznymIstniejaPodstawoweIGeneratorLinkow() {
        boolean status = false;

        if (podstawoweMenuBoczne.isDisplayed() && generatorLinkowMenuBoczne.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean zweryfikujCzyIstniejeZobaczUslugeButton() {
        wait.waitForVisibility(zobaczUslugeButton);
        return zobaczUslugeButton.isDisplayed();
    }

    public boolean zweryfikujCzyIstniejeZamawiamIPlaceButton() {
        wait.waitForVisibility(zamawiamIPlaceButton);
        return zamawiamIPlaceButton.isDisplayed();
    }


    //Krótki opis

    public void kliknijKonfigurujKrotkiOpisButton() {
        scrollToElement(konfigurujKrotkiOpisButton);
        wait.waitForClickability(konfigurujKrotkiOpisButton).click();
    }

    public void poczekajNaOknoKrotkiOpis() {
        wait.waitForVisibility(krotkiOpisOkno);
    }

    public void poczekajAzOknoKrotkiOpisZniknie() {
        wait.waitForInvisibility(krotkiOpisOkno);
    }

    public void wprowadzKrotkiOpis() {
        poczekajNaOknoKrotkiOpis();
        krotkiOpisInput.clear();
        krotkiOpisInput.sendKeys(krotkiOpisZadanie);
    }

    public void kliknijKrotkiOpisZapiszButton() {
        wait.waitForClickability(krotkiOpisZapiszButton).click();
    }

    public void ustawKrotkiOpis() {
        kliknijKonfigurujKrotkiOpisButton();
        poczekajNaOknoKrotkiOpis();
        wprowadzKrotkiOpis();
        kliknijKrotkiOpisZapiszButton();
        poczekajAzOknoKrotkiOpisZniknie();
    }


    //Promocja

    public void kliknijKonfigurujPromocjaButton() {
        scrollToElement(konfigurujPromocjaButton);
        wait.waitForClickability(konfigurujPromocjaButton).click();
    }

    public void poczekajNaOknoPromocja() {
        wait.waitForVisibility(promocjaOkno);
    }

    public void poczekajAzOknoPromocjaZniknie() {
        wait.waitForInvisibility(promocjaOkno);
    }

    public void wprowadzCenePromocyjna() {
        poczekajNaOknoPromocja();
        cenaPromocyjnaInput.clear();
        cenaPromocyjnaInput.sendKeys(valueOf(cenaPromocyjnaZadanie));
    }

    public void wprowadzDateRozpoczeciaPromocji() {
        poczekajNaOknoPromocja();
        rozpoczeciePromocjiInput.clear();
        rozpoczeciePromocjiInput.sendKeys("16.06.2025");
    }

    public void wprowadzDateZakonczeniaPromocji() {
        poczekajNaOknoPromocja();
        zakonczeniePromocjiInput.clear();
        zakonczeniePromocjiInput.sendKeys("02.07.2025");
    }

    public void kliknijPromocjaZapiszButton() {
        wait.waitForClickability(promocjaOknoZapiszButton).click();
    }

    //metoda przechodzi przez caly proces konfiguracji promocji
    public void ustawCeneOrazDatePromocji() {
        kliknijKonfigurujPromocjaButton();
        poczekajNaOknoPromocja();
        wprowadzCenePromocyjna();
        wprowadzDateRozpoczeciaPromocji();
        wprowadzDateZakonczeniaPromocji();
        kliknijPromocjaZapiszButton();
        poczekajAzOknoPromocjaZniknie();
    }


    //Dostępne ilości

    //metoda wprowadza losowa liczbe calkowita w zakresie od 1 do 50 w pole 'Łączna liczba szt. do zakupu'
    public void wprowadzLiczbeSztukDoZakupu() {
        scrollToElement(liczbaSztDoZakupuInput);
        liczbaSztDoZakupuInput.clear();
        liczbaSztDoZakupuInput.sendKeys(valueOf(zwrocLosowyInt()));
    }
    //metoda ustawia ilosc dostepnych sztuk do zakupu w pole 'Pozostało szt.' na 1, poniewaz wartosc ta nie moze byc wyzsza niz łączna liczba sztuk dostępnych do zakupu
    //ktora w tym przypadku jest ustawiana losowo w zakresie od 1 do 50
    public void wprowadzLiczbePozostalychSztuk() {
        scrollToElement(pozostaloSztukInput);
        pozostaloSztukInput.clear();
        pozostaloSztukInput.sendKeys("1");
    }

    public void kliknijPozostaloSztukZapiszButton() {
        wait.waitForVisibility(pozostaloSztukZapiszButton).click();
    }

    public void kliknijLiczbaSztDoZakupuZapiszButton() {
        wait.waitForVisibility(liczbaSztDoZakupuZapiszButton).click();
    }

    //metoda przechodzi przez proces ustawiania limitu sztuk dostepnych do zakupu
    public void ustawLiczbeSztukDoZakupu() {
        wprowadzLiczbeSztukDoZakupu();
        kliknijLiczbaSztDoZakupuZapiszButton();
    }

    //metoda przechodzi przez proces ustawiania ilosci sztuk pozostalych do zakupu
    public void ustawLiczbePozostalychSztuk(){
        wprowadzLiczbePozostalychSztuk();
        kliknijPozostaloSztukZapiszButton();
    }


    //Kategorie

    public void kliknijKonfigurujKategorieButton() {
        scrollToElement(konfigurujKategorieButton);
        wait.waitForClickability(konfigurujKategorieButton).click();
    }

    public void poczekajNaOknoKategorie() {
        wait.waitForVisibility(kategorieOkno);
    }

    public void poczekajAzOknoKategorieZniknie() {
        wait.waitForInvisibility(kategorieOkno);
    }

    //metoda korzysta z listy checkboxow wszystkich dostepnych kategorii, a nastepnie zaznacza pierwsze 10 z nich
    public void zaznacz10CheckboxowKategorii() {
        for (int i = 0; i < 10; i++) {
            WebElement kategoria = kategorieLista.get(i);
            if (!kategoria.isSelected()) {
                kategoria.click();
            }
        }
    }

    public void kliknijKategorieZapiszButton() {
        wait.waitForClickability(kategorieZapiszButton).click();
    }

    //metoda przechodzi przez caly proces dodawania kategorii do usługi, iterując po liscie dostepnych kategorii i zaznacza pierwsze 10
    public void ustaw10Kategorii() {
        kliknijKonfigurujKategorieButton();
        poczekajNaOknoKategorie();
        zaznacz10CheckboxowKategorii();
        kliknijKategorieZapiszButton();
        poczekajAzOknoKategorieZniknie();
    }


    //Tagi

    public void kliknijKonfigurujTagiButton() {
        scrollToElement(konfigurujTagiButton);
        wait.waitForClickability(konfigurujTagiButton).click();
    }

    public void poczekajNaOknoTagi() {
        wait.waitForVisibility(tagiOkno);
    }

    //metoda wprowadza 5 tagów przy pomocy jednego stringa
    public void wprowadzTagi() {
        tagiInput.click();
        tagiInput.sendKeys(tagi);
    }

    public void kliknijTagiZapiszButton() {
        wait.waitForClickability(tagiZapiszButton).click();
    }

    public void poczekajAzOknoTagiZniknie() {
        wait.waitForInvisibility(tagiOkno);
    }

    //metoda przechodzi przez caly proces dodawania tagow do uslugi
    public void ustaw5Tagow() {
        kliknijKonfigurujTagiButton();
        poczekajNaOknoTagi();
        wprowadzTagi();
        kliknijTagiZapiszButton();
        poczekajAzOknoTagiZniknie();
    }


    //Sprzedaż

    //metoda wlacza sprzedaz przesuwajac slider
    public void wlaczSprzedaz() {
        scrollToElement(wlaczSprzedazSlider);
        if (!wlaczSprzedazSlider.isSelected()) {
            wlaczSprzedazSlider.click();
        }
    }


    //Generator linków

    //metoda przechodzi z zakladki 'Podstawowe' do zakladki 'Generator linkow'
    public void kliknijGeneratorLikow() {
        scrollToElement(generatorLinkowMenuBoczne);
        wait.waitForClickability(generatorLinkowMenuBoczne).click();
    }

    public void poczekajNaUstawieniaGeneratorLinkow() {
        wait.waitForVisibility(sekcjaGeneretorLinkow);
    }

    //metoda przechodzi do zakupu uslugi pobierajac atrybut value (tutaj jest to potrzebny link) z pola tekstowego
    public void przejdzDoZakupuUslugi() {
        driver.get(linkZakupowyInput.getAttribute("value"));
    }


}

