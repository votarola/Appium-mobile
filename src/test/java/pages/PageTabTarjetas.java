package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import java.util.List;

public class PageTabTarjetas {

    @FindBy(id = "action_card")
    private WebElement tabTarjetas;

    @FindBy(id = "add_card_button_action")
    private WebElement btnAddCard;

    @FindBy(id = "credit_card_button")
    private WebElement addcredit_card_button;

    @FindBy(id = "debit_card_button")
    private WebElement adddebit_card_button;

    @FindBy(xpath = "//*[@text='Medios de pago']")
    private WebElement backMediosPago;

//-------------------------------MODULO SIN TARJETAS-----------------------
    @FindBy(id = "card_dialog_add_card")
    private WebElement addCard;

    @FindBy(id = "reject_tv")
    private WebElement RejectPagoModal;

    @FindBy(id = "close_dialog_image_view")
    private WebElement ClosePagoModal;

//-------------------------------MODULO SIN TARJETAS-----------------------


    @FindBy(id = "btnReject")
    private WebElement btnRejectMediosPago;

    @FindBy(xpath = "//*[@id='visa-card-show']")
    private WebElement PAN;

    @FindBy(xpath = "//*[@id='password-invalid']")
    private WebElement CVV;

    @FindBy(xpath = "//*[@text='Continuar']")
    private WebElement ContinEnrolment;

    @FindBy(xpath = "//*[@text='Aceptar']")
    private WebElement AceptarAddCard;

    @FindBy(xpath = "//*[@text='Seguir (setResultAut)']")
    private WebElement SeguirAddCard;

    @FindBy(xpath = "//*[@text='Seguir (retorno a Transbank)']")
    private WebElement RetornTBK;

    @FindBy(id = "ok_btn")
    private WebElement ContinuarAñadidaOK;

    @FindBy(xpath = "//*[@text='Seleccione banco']")
    private WebElement cbxRedcompra;


    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);

    public void clickTabMas() {
        wait.until(ExpectedConditions.visibilityOf(tabTarjetas));
        tabTarjetas.click();
    }

    public void clickAddCardCredit() {
        wait.until(ExpectedConditions.visibilityOf(addcredit_card_button));
        addcredit_card_button.click();
    }

    public boolean sendPAN(String pan) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(PAN));
            PAN.click();
            Thread.sleep(1500);
            PAN.sendKeys(pan);
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendCVV(String cvv) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(CVV));
            Thread.sleep(1500);
            CVV.click();
            CVV.sendKeys(cvv);
            ApplicationLauncher.driverMobile.hideKeyboard();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ContiEnrolment() throws InterruptedException {
        try {
            List<WebElement> buttons = ApplicationLauncher.driverMobile.findElements(By.tagName("button"));
            System.out.println("buttons.size" + buttons.size());
            buttons.get(0).click();
            //wait.until(ExpectedConditions.visibilityOf(tagBtnContinEnrolment));
            //tagBtnContinEnrolment.click();
            //wait.until(ExpectedConditions.visibilityOf(ContinEnrolment));
            //ContinEnrolment.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void AddCard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(AceptarAddCard));
        AceptarAddCard.click();
    }

    public void SeguirAddCard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(SeguirAddCard));
        SeguirAddCard.click();
    }

    public void RetornTBK() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(RetornTBK));
        RetornTBK.click();
    }

    public boolean ContinuarAñadida() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(ContinuarAñadidaOK));
            ContinuarAñadidaOK.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
