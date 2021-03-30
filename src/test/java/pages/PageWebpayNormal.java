package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import java.util.List;

public class PageWebpayNormal {

    public static WebDriver driver;

    @FindBy(xpath = "//*[@id='j_idt10:j_idt13']/span")
    private WebElement btnPagoNormal;

    @FindBy(id = "ewebpayTestForm:ewptdAmount")
    private WebElement Amount;

    @FindBy(id = "ewebpayTestForm:j_idt33")
    private WebElement initTransaction;

  //  @FindBy(xpath = "/html/body/app-root/app-home/main/app-home-normal/main/div/div/div/app-payment/a[3]")
  //  private WebElement btnPagoOnepay;
   
    @FindBy (xpath = "/html/body/app-root/app-home/main-panel/main/section/left-panel/div/app-payment-select/div/div/button[1]")
    private WebElement btnPagoOnepay;
    
 

    @FindBy(xpath = "/html/body/app-root/app-home/main/app-home-normal/main/div/div/div/app-onepay/div/div[2]/img" )
    private WebElement qr;

  //  @FindBy(xpath = "/html/body/app-root/app-home/main/app-home-normal/main/div/div/div/app-onepay/div/div[2]/ul")
  //  private WebElement codigoPagoOnepay;

    @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/p/strong")
    private WebElement codigoPagoOnepay;
    
    
       
    

    @FindBy(xpath = ("//*[@id=\"j_idt49:j_idt54\"]"))
    private WebElement btnACK;

    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 15);

    public boolean clickPagoNormal(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnPagoNormal));
            btnPagoNormal.click();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public void clickInitTransaction(){
        wait.until(ExpectedConditions.visibilityOf(initTransaction));
        initTransaction.click();
    }

    public void ingresarAmount(String monto){
        wait.until(ExpectedConditions.visibilityOf(Amount));
        Amount.clear();
        Amount.sendKeys(monto);
    }

    public String retornarCodigoPagoOnepay() throws InterruptedException {
        String codigoOnepay = "";
        Thread.sleep(6000);
        try {
            wait.until(ExpectedConditions.visibilityOf(codigoPagoOnepay));
            wait.until(ExpectedConditions.visibilityOf(qr));
            int size = 0;
            while (size < 5){
                List<WebElement> lista = ApplicationLauncher.driverChrome.findElements(By.tagName("li"));
                size = lista.size();
            }
            codigoOnepay = ApplicationLauncher.driverChrome.findElement(By.xpath(
                    "/html/body/app-root/app-home/main/app-home-normal/main/div/div/div/app-onepay/div/div[2]/ul"))
                    .getText();
        } catch (Exception e){
            e.printStackTrace();
        }
        return codigoOnepay;
    }

    public void clickBtnPagoOnepay(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnPagoOnepay));
            btnPagoOnepay.click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void clickbtnACK(){
        wait.until(ExpectedConditions.visibilityOf(btnACK));
        btnACK.click();
    }
}

