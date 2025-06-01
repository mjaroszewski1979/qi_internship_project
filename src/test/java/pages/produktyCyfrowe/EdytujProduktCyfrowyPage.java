package pages.produktyCyfrowe;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EdytujProduktCyfrowyPage {

    private WebDriver driver;
    private Waits wait;

    @FindBy(xpath = "//h1[text()='Edycja produktu cyfrowego: ']")
    private WebElement edycjaProduktuCyfrowegoNaglowek;

    @FindBy(id = "general")
    private WebElement zakladkaPodstawowe;

    @FindBy(id = "files")
    private WebElement zakladkaPliki;

    @FindBy(id = "link_generator")
    private WebElement zakladkaGeneratorLinkow;

    public EdytujProduktCyfrowyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getEdycjaProduktuCyfrowegoNaglowek() {
        return wait.waitForVisibility(edycjaProduktuCyfrowegoNaglowek);
    }

    public WebElement getZakladkaPodstawowe() {
        return zakladkaPodstawowe;
    }

    public WebElement getZakladkaPliki() {
        return zakladkaPliki;
    }

    public WebElement getZakladkaGeneratorLinkow() {
        return zakladkaGeneratorLinkow;
    }

    public List<WebElement> getNaglowkiSekcji() {
        return wait.waitForElementsPresent(By.xpath("//span[@class='fields-group__name']"));
    }
}
