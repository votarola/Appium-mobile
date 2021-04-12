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


public class PagePreLoginContrasena {
	
    public static WebDriver driver;
    
    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);
    
       
    @FindBy(id = "et_password")
    private WebElement txtPass;

	@FindBy(id = "login_password")
	private WebElement btnPass;
	    
	@FindBy(id = "txtNoUser")
	private WebElement btnNoSoy;
	    
	@FindBy(id = "txtForgotPass")
	private WebElement btnForgotPass;	    
	
	@FindBy(id = "link_account_trouble")
	private WebElement linkHelpAccount;
	    

    

    public void ingresaPass(String pass) {
        wait.until(ExpectedConditions.visibilityOf(btnNoSoy));
    	//txtPass.click();
    	//txtPass.clear();
        txtPass.sendKeys(pass);
        btnPass.click();

    }
     
    

}
