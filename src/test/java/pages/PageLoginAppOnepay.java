package pages;

import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import java.util.List;
import java.util.Set;


public class PageLoginAppOnepay {
    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);
    @FindBy(id = "ly_ingreso")
    private WebElement btningreso;
    @FindBy(id = "ly_registro")
    private WebElement btnregistro;
    @FindBy(xpath = ("//*[@text='Ingresar']"))
    private WebElement btnIngresar;
    @FindBy(id = "et_user_name")
    private WebElement sendEmail;
    @FindBy(id = "et_password")
    private WebElement sendPass;
    @FindBy(id = "txtForgotPass")
    private WebElement forgotPass;
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
    @FindBy(id = "dismiss_button")
    private WebElement NoxAhora;
    @FindBy(linkText = "Inicia sesiÃ³n con\n" +
            "tu huella")
    private WebElement txtOBHuella;
    @FindBy(id = "et_password")
    private WebElement inputPass;
    @FindBy(id = "login_password")
    private WebElement btnIngresarConContraseña;
    @FindBy(xpath = "//*[@text='Digitar cÃ³digo de compra']")
    private WebElement ingresarCodigo;
    @FindBy(xpath = "//*[@id='visa-card-show']")
    private WebElement PAN;
    @FindBy(xpath = "//*[@id='password-invalid']")
    private WebElement CVV;

    @FindBy(xpath = "//*[@text='Continuar']")
    private WebElement ContinEnrolment;


    @FindBy(xpath = "//*[@text='01']")
    private WebElement MesEnrolment;
    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    private WebElement Mes1Enrolment;
    @FindBy(xpath = "//*[@text='Credit Card']")
    private WebElement LogoCard;
    @FindBy(xpath = "//*[@text='Aceptar']")
    private WebElement AceptarAddCard;
    @FindBy(xpath = "//*[@text='Seguir (setResultAut)']")
    private WebElement SeguirAddCard;
    @FindBy(xpath = "//*[@text='Seguir (retorno a Transbank)']")
    private WebElement RetornTBK;
    @FindBy(id = "credit_card_button")
    private WebElement addcredit_card_button;

    @FindBy(id = "ok_btn")
    private WebElement ContinuarAñadidaOK;

    @FindBy(id = "debit_card_button")
    private WebElement adddebit_card_button;
    @FindBy(id = "btnReject")
    private WebElement btnRejectMediosPago;
    private WebElement HidesKeyboard;

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

    public void ingresarContraseña(String pass) {
        try {
            wait.until(ExpectedConditions.visibilityOf(inputPass));
            inputPass.sendKeys(pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickBtnIngresarConContraseña() {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnIngresarConContraseña));
            btnIngresarConContraseña.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean clickbtnRegistro() throws InterruptedException {
        try {
            btnregistro.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickbtnIngreso() throws InterruptedException {
        try {
        	wait.until(ExpectedConditions.visibilityOf(btningreso));
            btningreso.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean btnIngresoUser() throws InterruptedException {
        try {
            btnIngresar.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void ingresaEmailPass(String email, String pass) {
        wait.until(ExpectedConditions.visibilityOf(forgotPass));
        sendEmail.clear();
        sendEmail.sendKeys(email);
        sendPass.clear();
        sendPass.sendKeys(pass);

    }

    public void creaPIN() throws InterruptedException {
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

    }

    public boolean validaTextoOBHuella() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(NoxAhora));
            String txtOBHuellaa = driver.findElement(By.id("cl.transbank.onepay:id/title")).getText();
            Assert.assertNotEquals(txtOBHuellaa, "Inicia sesiÃ³n con\n" +
                    "tu huella");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean FBNoXAhora() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(NoxAhora));
            NoxAhora.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cambiarContexto() throws InterruptedException {
        Set<String> contextName = null;
        int c = 0;
        while (c < 1) {
            contextName = ApplicationLauncher.driverMobile.getContextHandles();
            c = contextName.size();
            System.out.println("c: " + c);
        }
        for (String s : contextName) {
            ApplicationLauncher.driverMobile.context(s);
            System.out.println("Contexto: " + s);
        }
    }


}
