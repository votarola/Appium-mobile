package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

public class PageTabPagos {
    public static WebDriver driver;

    @FindBy(id = "action_payment")
    private WebElement tabPagos;


    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);

    public void clickTabPagos() {
        wait.until(ExpectedConditions.visibilityOf(tabPagos));
        tabPagos.click();
    }


}
