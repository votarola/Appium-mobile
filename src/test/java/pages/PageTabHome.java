package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import static utils.ApplicationLauncher.driverMobile;

public class PageTabHome {


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

    @FindBy(id = "lyT")
    private WebElement keyT;

    @FindBy(id = "tvInputOtt")
    private WebElement clickclickIngresarCodigo;

    @FindBy(id = "rlQrReader")
    private WebElement escanearQR;

    @FindBy(id = "lyPayments")
    private WebElement ultimoPagoCard;

    @FindBy(xpath = "//*[@text='Detalle de compra']")
    private WebElement backDetalleCompra;

    @FindBy(xpath = "//*[@text='Código de compra']")
    private WebElement backCodigoCompra;

    @FindBy(xpath = "//*[@text='Escanear código']")
    private WebElement backEscanerQR;

    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);


    public boolean clickultimoPagoCard() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ultimoPagoCard));
            ultimoPagoCard.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickEscanerQR() {
        try {
            wait.until(ExpectedConditions.visibilityOf(escanearQR));
            escanearQR.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickclickIngresarCodigo() {
        try {
            wait.until(ExpectedConditions.visibilityOf(clickclickIngresarCodigo));
            clickclickIngresarCodigo.click();
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



}


