package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

public class PageMohmal {
    public static WebDriver driver;

    @FindBy(id = "choose")
    private WebElement EscogerEmail;

    @FindBy(xpath = "//*[@id='enterEmail']/div[1]/input")
    private WebElement InputEmail;

    @FindBy(id = "next")
    private WebElement Next;

    @FindBy(id = "create")
    private WebElement CreaEmail;

    @FindBy(xpath = "//*[@id='refresh']/i")
    private WebElement RefreshEmail;



    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 50);

    //ApplicationLauncher.setUpChrome();
    //ApplicationLauncher.driverChrome.get("https://www.mohmal.com/es");

    public void escogerEmail() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(EscogerEmail));
        EscogerEmail.click();
    }


    public boolean IngresaEmail(String email) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(InputEmail));
            InputEmail.click();
            Thread.sleep(1500);
            InputEmail.sendKeys(email);
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void next() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(Next));
        Next.click();
    }

    public void crearEmail() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(CreaEmail));
        CreaEmail.click();
    }

    public void reloadEmail() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(RefreshEmail));
        RefreshEmail.click();
    }


}
