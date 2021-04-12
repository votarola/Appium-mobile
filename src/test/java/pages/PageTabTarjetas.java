package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

import java.util.List;
import java.util.Set;

public class PageTabTarjetas {
	
//-------------------------------AGREGAR TARJETAS Y MEDIOS DE PAGO-----------------------	
	@FindBy(id = "txtAddCards")
	private WebElement addCard;
	
	@FindBy(id = "add_card_button_action")
	private WebElement addCardST;
	  
	@FindBy(id = "action_card")
	private WebElement tabPagos;
	    
	@FindBy(id = "credit_card_button")
	private WebElement addCredit;
	    
	@FindBy(id = "debit_card_button")
	private WebElement addDebit;
	    
	@FindBy(id = "prepaid_card_button")
	private WebElement addPrepaid;
	    
    @FindBy(xpath = "//*[@text='Medios de pago']")
    private WebElement backPaymentMethods;
    
//-------------------------------AGREGAR TARJETA CREDITO-----------------------
    @FindBy(xpath ="//*[@id='card-number']")
    private WebElement cardNumber;

    @FindBy(xpath ="//*[@id='card-exp']")
    private WebElement cardExp;
    
    @FindBy(xpath ="//*[@id='card-cvv']")
    private WebElement cardCVV;
    
    @FindBy(xpath = "//*[@text='Inscribir tarjeta']")
    private WebElement initIncription;
      
    @FindBy(xpath = "//*[@text='Aceptar']")
    private WebElement ContinEnrolment;  
  
    @FindBy(xpath = "//*[@text='Seguir (setResultAut)']")
    private WebElement SeguirAddCard;
        
    @FindBy(xpath = "//*[@text='Seguir (retorno a Transbank)']")
    private WebElement RetornTBK;
      
    @FindBy(id = "ok_btn")
    private WebElement ContinuarAddOK;

    
    @FindBy(xpath = "//*[@text='Seleccione banco']")
    private WebElement cbxRedcompra;


    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);

    public void clicktabPagos() {
        wait.until(ExpectedConditions.visibilityOf(tabPagos));
        tabPagos.click();
    }
    
    
    public void clickAddCardST() {
        wait.until(ExpectedConditions.visibilityOf(addCardST));
        addCardST.click();
    }
    
    public void clickAddCard() {
        wait.until(ExpectedConditions.visibilityOf(addCard));
        addCard.click();
    }
    
    public void clickAddCardCredit() {
        wait.until(ExpectedConditions.visibilityOf(addCredit));
        addCredit.click();
    }
        
    public boolean sendPAN(String pan) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardNumber));
            cardNumber.click();
            Thread.sleep(1500);
            cardNumber.sendKeys(pan);
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean sendExpirationDate(String expDate) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardExp));
            Thread.sleep(1500);
            cardExp.click();
            cardExp.sendKeys(expDate);
            ApplicationLauncher.driverMobile.hideKeyboard();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean sendCVV(String cvv) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardCVV));
            Thread.sleep(1500);
            cardCVV.click();
            cardCVV.sendKeys(cvv);
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
    

    public void initIncription() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(initIncription));
        initIncription.click();
    }

    public void ContinEnrolment() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ContinEnrolment));
        ContinEnrolment.click();
    }
    
    
    public void SeguirAddCard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(SeguirAddCard));
        SeguirAddCard.click();
    }

    


    public void RetornTBK() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(RetornTBK));
        RetornTBK.click();
    }

    public boolean ContinuaraddOK() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(ContinuarAddOK));
            ContinuarAddOK.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}



    

