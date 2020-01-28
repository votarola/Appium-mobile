package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import static utils.ApplicationLauncher.driverMobile;

public class mainPage {


    /*----------------------Numeros de teclado para crear PIN--------------------------*/
    @FindBy(id = "lyKey1")
    private WebElement key1;

    @FindBy(id = "lyKey2")
    private WebElement key2;

    @FindBy(id = "lyKey3")
    private WebElement key3;

    @FindBy(id = "lyKey4")
    private WebElement key4;

    @FindBy(id = "lyKey5")
    private WebElement key5;

    @FindBy(id = "lyKey6")
    private WebElement key6;

    @FindBy(id = "lyKey7")
    private WebElement key7;

    @FindBy(id = "lyKey8")
    private WebElement key8;

    @FindBy(id = "lyKey9")
    private WebElement key9;

    @FindBy(id = "lyKey0")
    private WebElement key0;

    @FindBy(xpath = "//*[@text='Digitar código de compra']")
    private WebElement ingresarCodigo;

    @FindBy(id = "select_card_container")
    private WebElement selecTar;

    @FindBy(id = "close_selector_image_view")
    private WebElement closeMisTarjetas;

    @FindBy(id = "selector_title")
    private WebElement selector_MisTarjetas_title;

    @FindBy(id = "select_installments_container")
    private WebElement selecCuotas;

    @FindBy(xpath = "//*[@text='3 cuotas']")
    private WebElement Cuota3;

    @FindBy(xpath = "//*[@text='Revisa los datos']")
    private WebElement txtRLDatos;

    @FindBy(id = "card_dialog_add_card")
    private WebElement addCard;

    @FindBy(id = "reject_tv")
    private WebElement RejectPagoModal;

    @FindBy(id = "close_dialog_image_view")
    private WebElement ClosePagoModal;

    @FindBy(id = "btnPay")
    private WebElement btnPay;

    @FindBy(id = "link_text")
    private WebElement IrAlInicio;

    @FindBy(id = "btnAccept")
    private WebElement btnAcceptPay;

    @FindBy(id = "credit_card_button")
    private WebElement addcredit_card_button;

    @FindBy(id = "debit_card_button")
    private WebElement adddebit_card_button;

    @FindBy(id = "btnReject")
    private WebElement btnRejectMediosPago;


    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 50);


    public void clickAddCardDebit() {
        wait.until(ExpectedConditions.visibilityOf(adddebit_card_button));
        adddebit_card_button.click();
    }

    public void clickAddCardCredit() {
        wait.until(ExpectedConditions.visibilityOf(addcredit_card_button));
        addcredit_card_button.click();
    }

    public void clickRejectMediosPago() {
        wait.until(ExpectedConditions.visibilityOf(btnRejectMediosPago));
        btnRejectMediosPago.click();
    }


    public boolean clickAddCard() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addCard));
            addCard.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickRejectPagoModal() {
        try {
            wait.until(ExpectedConditions.visibilityOf(RejectPagoModal));
            RejectPagoModal.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickClosePagoModal() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ClosePagoModal));
            ClosePagoModal.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickIngresarCodigo() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ingresarCodigo));
            ingresarCodigo.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void ingresarCodigo(String[] arrg) {
        WebDriverWait wait = new WebDriverWait(driverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("key1")));
        for (int i = 0; i < arrg.length; i++) {
            WebElement btn = driverMobile.findElement(By.id("key" + arrg[i]));
            btn.click();
        }
    }


    public boolean clickSelectorTarjetas() {
        try {
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(txtRLDatos));
            selecTar.click();
            wait.until(ExpectedConditions.visibilityOf(selector_MisTarjetas_title));
            closeMisTarjetas.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean clickSelectorCuotas() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selecCuotas));
            selecCuotas.click();
            Cuota3.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickBotonPago() {
        try {
            btnPay.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean creaPIN() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(key9));
            key9.click();
            Thread.sleep(1000);
            key6.click();
            Thread.sleep(1000);
            key3.click();
            Thread.sleep(1000);
            key8.click();
            Thread.sleep(1000);
            key5.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean clickAuthPay() {
        try {
            wait.until(ExpectedConditions.visibilityOf(key9));
            btnAcceptPay.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean clickIrInicio() {
        try {
            wait.until(ExpectedConditions.visibilityOf(IrAlInicio));
            Thread.sleep(3000);
            IrAlInicio.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
