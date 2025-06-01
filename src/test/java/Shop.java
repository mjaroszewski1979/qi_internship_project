import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

import java.util.List;

public class Shop extends TestBase {

    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
 private static final String login =  PropertiesReader.read("login");
 private static final String haslo =  PropertiesReader.read("password");


@Test
    public void weryfikacjaPrzejsciaDoKoszyka() {
    String poprawnyURLKoszyka = "http://www.selenium-shop.pl/koszyk/";

    //zlokalizowaliśmy element koszyka w menu głównego
    WebElement koszykMenu = driver.findElement(By.xpath("//a[contains(text(),'Koszyk')]"));
    koszykMenu.click();

    System.out.println("URL sprawdzaany poprawny = " + poprawnyURLKoszyka);

    Assert.assertEquals(driver.getCurrentUrl(), poprawnyURLKoszyka, "Adres url nie jest poprawny po przejściu do koszyka");


    }

    @Test
    public void weryfikacjaTutuluStronyKoszyk() {
        String poprawnyTytulStronyKoszyk ="Koszyk – Selenium Shop Automatyzacja Testów";
        //zlokalizowaliśmy element koszyka w menu głównego
        WebElement koszykMenu = driver.findElement(By.xpath("//a[contains(text(),'Koszyk')]"));
        koszykMenu.click();

        System.out.println("Tytuł sprawdzaany poprawny = " + poprawnyTytulStronyKoszyk);

        System.out.println("Tytuł strony: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), poprawnyTytulStronyKoszyk, "Tytuł strony nie jest poprawny po przejściu do koszyka");


    }

    @Test
    public void weryfikacjaLogowaniaDoAplikacji(){



        Assert.assertTrue(driver.getPageSource().contains("Witaj"), "Nie znaleziono tekstu Witaj na stronie");


    }

    @Test
    public void weryfikacjaZmianyAdresuDoWysylki(){

        WebElement mojeKontoMenu = driver.findElement(By.xpath("//a[contains(text(),'Moje konto')]"));
        mojeKontoMenu.click();

        WebElement loginInput = driver.findElement(By.id("username"));
        loginInput.sendKeys(login);

        WebElement hasloInput = driver.findElement(By.id("password"));
        hasloInput.sendKeys(haslo);

        WebElement zalogujSieButton = driver.findElement(By.name("login"));
        zalogujSieButton.click();

        WebElement adresyMenuBoczne = driver.findElement(By.xpath("//*[contains(text(),'Adresy')]"));
        adresyMenuBoczne.click();

        WebElement edytujAdresWysylki = driver.findElement(By.xpath("//*[contains(text(),'Adres do wysyłki')]/following-sibling::a"));
        edytujAdresWysylki.click();

        WebElement ulicaInput = driver.findElement(By.id("shipping_address_1"));
        ulicaInput.clear();
        ulicaInput.sendKeys("Nowa ulica 123");

        WebElement zapiszAdresButton = driver.findElement(By.name("save_address"));
        zapiszAdresButton.click();
        Assert.assertTrue(driver.getPageSource().contains("Adres został zmieniony."), "Nie znaleziono tekstu 'Adres został zmienbiony'");
    }

    @Test
    public void werfikacjaFormularzaZamianyhasla(){
        boolean status = false;

        WebElement mojeKontoMenu = driver.findElement(By.xpath("//a[contains(text(),'Moje konto')]"));
        mojeKontoMenu.click();

        WebElement loginInput = driver.findElement(By.id("username"));
        loginInput.sendKeys(login);

        WebElement hasloInput = driver.findElement(By.id("password"));
        hasloInput.sendKeys(haslo);

        WebElement zalogujSieButton = driver.findElement(By.name("login"));
        zalogujSieButton.click();

        WebElement szczegolyKontaMenuBoczne = driver.findElement(By.xpath("//*[contains(text(),'Szczegóły konta')]"));
        szczegolyKontaMenuBoczne.click();


        WebElement aktualneHasloinput = driver.findElement(By.id("password_current"));
        WebElement noweHasloinput = driver.findElement(By.id("password_1"));
        WebElement potwierdzHasloinput = driver.findElement(By.id("password_2"));


        if(aktualneHasloinput.isDisplayed() && noweHasloinput.isDisplayed() && potwierdzHasloinput.isDisplayed() ){
            status = true;
            System.out.println("Formularz zmiany hasła jest widoczny");
        }else {
            System.out.println("Formularz zmiany hasła nie jest widoczny!!");
        }

        Assert.assertTrue(status, "Nie znaleziono formularza zmiany hasła"  );

    }



    @Test
    public void weryfikacjaLiczyPozycjiWMenuGlownym(){
        int poprawnaLiczbaPozycjiWMenuGlownym = 6;

        try {
            Thread.sleep(2000); // wymagane aby przeglądarka mogła załadować wszystkie elementy menu
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> menuItems = driver.findElements(By.xpath("//*[contains(@class,'menu-item')]"));

        System.out.println("aktulna liczba pozycji w menu głównego: " + menuItems.size());

        Assert.assertEquals(menuItems.size(), poprawnaLiczbaPozycjiWMenuGlownym, "Liczba pozycji w menu głównego jest nieprawidłowa"  );
    }


    @Test
    public void weryfikacjaProcesuZakupowego_KupowanieProduktu(){


        WebElement sklepMenu = driver.findElement(By.xpath("//a[contains(text(),'Sklep')]"));
        sklepMenu.click();

        WebElement produktKoszulkaArsenalLondyn = driver.findElement(By.xpath("//h2[contains(text(),'Koszulka Arsenal London')]"));
        produktKoszulkaArsenalLondyn.click();

        WebElement iloscProduktuInput = driver.findElement(By.name("quantity"));
        iloscProduktuInput.clear();
        iloscProduktuInput.sendKeys("5");

        WebElement dodajDoKoszykaButton = driver.findElement(By.name("add-to-cart"));
        dodajDoKoszykaButton.click();

        try {
            Thread.sleep(2000); // wymagane aby przeglądarka mogła załadować wszystkie elementy koszyka
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement koszykMenu = driver.findElement(By.xpath("//a[contains(text(),'Koszyk')]"));
        koszykMenu.click();

        try {
            Thread.sleep(2000); // wymagane aby przeglądarka mogła załadować wszystkie elementy koszyka
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement metodaWysylki_StalaKwota = driver.findElement(By.id("shipping_method_0_flat_rate1"));
        metodaWysylki_StalaKwota.click();

//        WebElement przejdzDoKasyButton = driver.findElement(By.xpath("//*[contains(text(),'Przejdź do kasy')]"));
//        przejdzDoKasyButton.click();

        driver.get("http://www.selenium-shop.pl/zamowienie/");

        WebElement imieInput = driver.findElement(By.id("billing_first_name"));
        imieInput.clear();
        imieInput.sendKeys("Jan");

        WebElement nazwiskoInput = driver.findElement(By.id("billing_last_name"));
        nazwiskoInput.clear();
        nazwiskoInput.sendKeys("Kowalski");

        WebElement ulicaInput = driver.findElement(By.id("billing_address_1"));
        ulicaInput.clear();
        ulicaInput.sendKeys("Nowa ulica 123");

        WebElement miastoInput = driver.findElement(By.id("billing_city"));
        miastoInput.clear();
        miastoInput.sendKeys("Warszawa");

        WebElement kodPocztowyInput = driver.findElement(By.id("billing_postcode"));
        kodPocztowyInput.clear();
        kodPocztowyInput.sendKeys("00-001");

        WebElement telefonInput = driver.findElement(By.id("billing_phone"));
        telefonInput.clear();
        telefonInput.sendKeys("+48 123 456 789");


        WebElement adresMailInput = driver.findElement(By.id("billing_email"));
        adresMailInput.clear();
        adresMailInput.sendKeys("jan.kowalski@example.com");

        WebElement kupujeIPlaceButton = driver.findElement(By.id("place_order"));
        kupujeIPlaceButton.click();

        try {
            Thread.sleep(2000); // wymagane aby przeglądarka mogła załadować wszystkie elementy koszyka
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(driver.getPageSource().contains("Dziękujemy. Otrzymaliśmy Twoje zamówienie."), "NIe udalo się poprawnie zrealizowac zamówienia!");

    }


}
