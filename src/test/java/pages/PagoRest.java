package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;
import java.util.List;

public class PagoRest {

    public static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"j_idt10:j_idt13\"]")
    private WebElement btnTiendaNormal;


    @FindBy(xpath = "//*[@id=\"ewebpayTestForm:ewptdAmount\"]")
    private WebElement montoTRX;

    @FindBy(xpath = "//*[@id=\"ewebpayTestForm:j_idt33\"]")
    private WebElement initTransaction;

    @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/left-panel/div/app-payment-select/div/div/button[1]")
    private WebElement btnPagoOnePay;
    

	@FindBy(xpath = "/html/body/app-root/app-home/main/div/div/div/app-onepay/div/h1")
	private WebElement vistaPagoOnePay;



	@FindBy(tagName = "li")
	private List<WebElement> codigoOnePay;

	@FindBy(xpath = "/html/body/app-root/app-home/main/div/div/div/app-onepay/div/div[2]")
	private WebElement contenedor;

    @FindBy(xpath = "/html/body/app-root/app-home/main/div/div/div/app-onepay/div/div[2]/img")
    private WebElement waitCodigoOnepay; // espera codigo QR

	
    @FindBy(tagName = "li")
    private List<WebElement> codigoOnepay;

    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 30);


    public void waitCodigoOnepay()  {
        System.out.println("espernado qr");
        wait.until(ExpectedConditions.visibilityOf(waitCodigoOnepay));
        int array = 0;
        while (array < 8){
            array = codigoOnepay.size();
            System.out.println("Array: " + array);
        }
    }
    public String [] obtenerCodigoOnepay()  {
        String[] codigo = new String[8];
        waitCodigoOnepay();
        try{
            for ( int i = 0; i < 8; i++){
                codigo[i] = codigoOnepay.get(i+1).getText();
            }
        }catch (Exception e){
            codigo[0] = e.getMessage();
        }
        return codigo;
    }


    public boolean ClickTiendaNormal(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnTiendaNormal));
            btnTiendaNormal.click();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void ingresoMonto(String monto){
        wait.until(ExpectedConditions.visibilityOf(montoTRX));
        montoTRX.clear();
        montoTRX.sendKeys(monto);
        initTransaction.click();
    }

    public void btnPagoOnePay() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(btnPagoOnePay));
        JavascriptExecutor executor = (JavascriptExecutor) ApplicationLauncher.driverChrome;
        executor.executeScript("arguments[0].click();", btnPagoOnePay);
    }










}
