package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

public class tabPagosPage {

    @FindBy(id = "action_payment")
    private WebElement tabPagos;



    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 50);

    public void clickTabPagos() {
        wait.until(ExpectedConditions.visibilityOf(tabPagos));
        tabPagos.click();
    }


}
