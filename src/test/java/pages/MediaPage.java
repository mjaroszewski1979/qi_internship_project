package pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MediaPage {

    private WebDriver driver;
    private Waits wait;

    public MediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Wideo")
    private WebElement zakladkaWideo;

    @FindBy(linkText = "Pozostałe media")
    private WebElement zakladkaPozostaleMedia;

    public void przejdzDoZakladkiWideo() {
        wait.waitForVisibility(zakladkaWideo).click();
    }

    public void przejdzDoZakladkiPozostaleMedia() {
        wait.waitForVisibility(zakladkaPozostaleMedia).click();
    }

}
