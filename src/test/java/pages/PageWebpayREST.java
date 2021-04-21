package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;



public class PageWebpayREST<codigoPagoOnepay> {

    public static WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/a[1]")
    private WebElement btnTiendaNormal;

    @FindBy(xpath = "//*[@id=\"amount\"]")
    private WebElement amount;

    @FindBy(xpath = "/html/body/div/div[2]/div/form/div[3]/input")
    private WebElement btnContinuar;

    @FindBy(xpath = "/html/body/div/div[2]/div/form/div/input[2]")
    private WebElement btnContinuar2;

    @FindBy(xpath = "//*[@id=\"onepay\"]")
    private WebElement btnOnepay;


   // @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/p/strong")
  //  private WebElement codigoPagoOnepay;

    @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/img")
    private WebElement qr;

    @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/div/div/p/a")
    private WebElement stores;

    @FindBy(xpath = "/html/body/app-root/app-home/main/app-home-normal/main/div/div/div/app-onepay/div/div[2]/img")
    private WebElement waitCodigoOnepay;






    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 15);



    public boolean clickTiendaNormal(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnTiendaNormal));
            btnTiendaNormal.click();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickAmount(String monto){
        try{
            wait.until(ExpectedConditions.visibilityOf(amount));
            amount.click();
            amount.clear();
            amount.sendKeys(monto);
            btnContinuar.click();
            btnContinuar2.click();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickbtnOnepay(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnOnepay));
            btnOnepay.click();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String retornarCodigoPagoOnepay() throws InterruptedException {
        String codigoOnepay = "";
        Thread.sleep(4000);

        try {
              //  wait.until(ExpectedConditions.visibilityOf(codigoPagoOnepay));
                wait.until(ExpectedConditions.visibilityOf(stores));
            int size = 0;
            while (size < 5){
                List<WebElement> lista2 = ApplicationLauncher.driverChrome.findElements(By.tagName("li"));
                size = lista2.size();
            }
            codigoOnepay = ApplicationLauncher.driverChrome.findElement(By.xpath(
                            "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/h3")).getText();
                    //"/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/p/ul")).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigoOnepay;
    }

    public boolean clickbtnPrepago(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnPrepago));
            btnPrepago.click();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @FindBy(xpath = "//*[@id=\"prepago\"]")
    private WebElement btnPrepago;


    public void waitCodigoOnePay() {
        wait.until(ExpectedConditions.visibilityOf(waitCodigoOnepay));
        int array = 0;
        while (array < 8) {
            array = codigoOnePay.size();
            System.out.println("Array: " + array);
        }
    }



//    @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/p/strong")
       @FindBy(tagName = "li")
   // private WebElement codigoOnePay;
   private List<WebElement> codigoOnePay; // Codigo



    public String[] obtenerCodigoOnePay() {
        String[] codigo = new String[8];
       // waitCodigoOnePay();
        try {
            for (int i = 0; i < 8; i++) {
                codigo[i] = codigoOnePay.get(i+1).getText();
            }
        } catch (Exception e) {
            codigo[0] = e.getMessage();
        }
        return codigo;

    }




    @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/p/strong")
    private WebElement codigoPagoOnepay;



 @FindBy(xpath = "/html/body/app-root/app-home/main-panel/main/section/right-panel/app-onepay/div[2]/div/div[1]/p/strong") //li
    private List<WebElement> codigoOnePayaaaaaa;





    public String[] obteneCodigoOnePay() throws InterruptedException {
             String[] codigo = new String[4];
        try {

            for (int i = 0; i < 8; i++) {
                codigo[i] = codigoOnePayaaaaaa.get(i).getText();

            }
        } catch (Exception e) {
            codigo[0] = e.getMessage();


        }
        return codigo;
    }


}

