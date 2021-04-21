package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

public class PageModal {
    public static WebDriver driver;

    @FindBy(xpath ="/html/body/form/div/div/div[2]/div/div[4]")
    private WebElement btnModalOnepay;

    @FindBy(xpath ="//*[@id=\"onepay-qr-target\"]/img")
    private WebElement vistaQR;


    @FindBy(xpath ="//*[@id=\"onepay-modal-close\"]")
    private WebElement cancelarPago;


    @FindBy(id = "onepay-payment-qr-code-text")
    private WebElement codigoOnePay;


    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 50);


    public String[] obtenerCodigoOnePayDesktop() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(codigoOnePay));
        String valor = "";
        String[] codigo = new String[8];
        while (valor.length() < 4){
            try{
                valor = codigoOnePay.getAttribute("innerText");
                valor = valor.replaceAll("[^0-9]", "");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(valor);
        codigo = valor.split("");

        return codigo;
    }



    public boolean btnModalOnepay(){
        try{
            wait.until(ExpectedConditions.visibilityOf(btnModalOnepay));
            btnModalOnepay.click();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean linkCancelar(){
        try{
            wait.until(ExpectedConditions.visibilityOf(vistaQR));
            vistaQR.click();
            cancelarPago.click();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
