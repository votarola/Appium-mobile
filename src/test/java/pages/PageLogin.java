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


public class PageLogin {
	
    public static WebDriver driver;
    
    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);
    
    
    
    @FindBy(id = "ry_login")
    private WebElement btningreso;

    @FindBy(id = "et_user_name") 
    private WebElement sendEmail;
    
    @FindBy(id = "et_password")
    private WebElement sendPass;
    
    @FindBy(id = "txtForgotPass")
    private WebElement forgotPass;
    
    @FindBy(id = ("tv_login"))
    private WebElement optionLogin;
    
    
    @FindBy(id = ("tv_register"))
    private WebElement optionRegister;
    
    @FindBy(id = ("etName"))
    private WebElement addName;
    
    @FindBy(id = ("etLastName"))
    private WebElement addLastName;
    
    @FindBy(id = ("etEmail"))
    private WebElement addEmail;
        
    @FindBy(id = "ry_registro")
    private WebElement btnregistro;
    
   

    /*----------------------Numeros de teclado para crear PIN--------------------------*/
    @FindBy(id = "key1")
    private WebElement key1;

    @FindBy(id = "key2")
    private WebElement key2;

    @FindBy(id = "key3")
    private WebElement key3;

    @FindBy(id = "key4")
    private WebElement key4;

    @FindBy(id = "key5")
    private WebElement key5;

    @FindBy(id = "key6")
    private WebElement key6;

    @FindBy(id = "key7")
    private WebElement key7;

    @FindBy(id = "key8")
    private WebElement key8;

    @FindBy(id = "key9")
    private WebElement key9;

    @FindBy(id = "key0")
    private WebElement key0;

    @FindBy(id = "clearButton")
    private WebElement clearButton;

    @FindBy(id = "et_pin")
    private WebElement clickNewPIN;   
    
    @FindBy(id = "et_confirm_pin")
    private WebElement clickRepitNewPIN;   
    
    @FindBy(id = "acceptBtn")
    private WebElement clickacceptBtn;   

    /*----------------------Factor Biometrico--------------------------*/
   
    @FindBy(id = "dismiss_button")
    private WebElement clickNOFBiometric;   
    


    public void ingresaEmailPass(String email, String contra) {
        wait.until(ExpectedConditions.visibilityOf(btningreso));
        sendEmail.clear();
        sendEmail.sendKeys(email);
        sendPass.clear();
        sendPass.sendKeys(contra);

    }
     
    
    public boolean ClickIngreso() throws InterruptedException {
        try {
        	wait.until(ExpectedConditions.visibilityOf(btningreso));
            btningreso.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void creaPIN() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOf(clickNewPIN));
    	clickNewPIN.click();
        key1.click();
        Thread.sleep(1000);
        key2.click();
        Thread.sleep(1000);
        key3.click();
        Thread.sleep(1000);
        key6.click();
        Thread.sleep(1000);
        key9.click();
        
        clickRepitNewPIN.click();
        key1.click();
        Thread.sleep(1000);
        key2.click();
        Thread.sleep(1000);
        key3.click();
        Thread.sleep(1000);
        key6.click();
        Thread.sleep(1000);
        key9.click();
    	wait.until(ExpectedConditions.visibilityOf(clickacceptBtn));
        clickacceptBtn.click();
        
        
        

    }
    
    
    public void NoFactorBiometric() {
        wait.until(ExpectedConditions.visibilityOf(clickNOFBiometric));
        clickNOFBiometric.click();


    }

/*
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
    */

}
