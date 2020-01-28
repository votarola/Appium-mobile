package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import java.util.List;
import java.util.Set;

public class loginAppTBK {

    @FindBy (className = "android.widget.EditText")
    private List<WebElement> dniUser;

    @FindBy (className = "android.widget.Button")
    private List<WebElement> btn;

    @FindBy (xpath = "//*[@id='dniUser']/input")
    private WebElement rut;

    @FindBy (xpath = "//*[@id='password']/input")
    private WebElement pass;

    @FindBy (xpath = "//*[@id='loginBtn']/input")
    private WebElement btnLogin;

    @FindBy (xpath = "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/ion-grid/ion-row[2]/form/ion-row[3]/ion-col/p/a")
    private WebElement btnTyC;

    @FindBy (xpath = "/html/body/ion-app/ion-modal/div/page-terms-use/ion-header/div/ion-row/ion-col[1]/button")
    private WebElement xBtn;

    @FindBy (xpath = "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/ion-grid/ion-row[2]/form/ion-row[5]/ion-col/button")
    private WebElement solicitarContraseña;

    @FindBy (xpath = "//*[@id='btnSend']")
    private WebElement btnSend;

    @FindBy (xpath = "/html/body/ion-app/ng-component/ion-nav/page-forgotted-pwd/ion-content/div[2]/div/div/ion-row/ion-col/h3")
    private WebElement txtSContra;


    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 15);

    public void cambiarContexto() throws InterruptedException {
        //Thread.sleep(10000);
        Set<String> contextName = null;
        int c = 0;
        while(c<1){
            contextName = ApplicationLauncher.driverMobile.getContextHandles();
            c = contextName.size();
            System.out.println("c: " + c);
        }
        for (String s : contextName){
            ApplicationLauncher.driverMobile.context(s);
            System.out.println("Contexto: " + s);
        }
    }

    public void verTyC() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(btnTyC));
        btnTyC.click();
        wait.until(ExpectedConditions.visibilityOf(xBtn));
        xBtn.click();
    }

    public void solicitarContraseña(String dni){
        wait.until(ExpectedConditions.visibilityOf(solicitarContraseña));
        solicitarContraseña.click();
        wait.until(ExpectedConditions.visibilityOf(btnSend));
        wait.until(ExpectedConditions.visibilityOf(rut));
        rut.click();
        rut.sendKeys(dni);
        btnSend.click();
    }

    /* public void ingresarRut(String rut) throws InterruptedException {
        Thread.sleep(5000);
        int count= 0 ;
        //wait.until(ExpectedConditions.visibilityOf(btnLogin));
        System.out.println(dniUser.size());
        for(WebElement input : dniUser){

            System.out.println(count);
            //System.out.println(input.getAttribute("name"));
           // System.out.println(input.getAttribute("id"));
            System.out.println(input.getAttribute("class"));
            count++;
        }

        dniUser.get(0).sendKeys(rut);

        //dniUser.sendKeys(rut);
    }*/

    /*
    public void ingresarPass(String pass) throws InterruptedException {
        int count= 0 ;
        //wait.until(ExpectedConditions.visibilityOf(btnLogin));
        System.out.println(dniUser.size());
        for(WebElement input : dniUser){

            System.out.println(count);
            //System.out.println(input.getAttribute("name"));
            // System.out.println(input.getAttribute("id"));
            System.out.println(input.getAttribute("class"));
            count++;
        }

        dniUser.get(1).sendKeys(pass);
    }

    public void clickBtnLogin(){
        btn.get(1).click();
    }*/

    public void ingresarRut(String dni){
        wait.until(ExpectedConditions.visibilityOf(rut));
        rut.clear();
        rut.sendKeys(dni);
    }

    public void ingresarPass(String password){
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.clear();
        pass.sendKeys(password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }
}
