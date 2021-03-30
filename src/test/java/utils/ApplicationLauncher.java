package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationLauncher {

    public static PageWebPay pageWebPay;
    public static PageLoginAppOnepay pageLoginAppOnepay;
    public static PageLogin pageLogin;
    public static homePage pageMain;
    public static PageWebpayNormal pageWebpayNormal;
    public static PageTabHome pageHome;
    public static PageTabPagos pagePagos;
    public static PageTabTarjetas pageTarjetas;
    public static PageTabMas pageMas;
    public static PageMohmal pageMohmal;
    



    public static AppiumDriver driverMobile;
    public static WebDriver driverChrome;

    public static void setUpChrome() throws MalformedURLException {
        String Path = "src/test/resources/driver/windows/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", Path);
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        pageWebPay = PageFactory.initElements(driverChrome, PageWebPay.class);
        pageWebpayNormal = PageFactory.initElements(driverChrome, PageWebpayNormal.class);
        pageMohmal = PageFactory.initElements(driverChrome, PageMohmal.class);
                 
        
        //pasar todas las clases con los objetos que se necesitan ocupar
    }

    public static void setUpAppium() throws MalformedURLException {
        driverMobile = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesOnePay());
      //  "http://0.0.0.0:4723/wd/hub"   "http://127.0.0.1:4723/wd/hub"
        
        
        pageLogin = PageFactory.initElements(driverMobile, PageLogin.class);
        //pageMain = PageFactory.initElements(driverMobile, homePage.class);
        pageHome = PageFactory.initElements(driverMobile, PageTabHome.class);
        pageMas = PageFactory.initElements(driverMobile, PageTabMas.class);
        pagePagos = PageFactory.initElements(driverMobile, PageTabPagos.class);
        pageTarjetas = PageFactory.initElements(driverMobile, PageTabTarjetas.class);

              
    }

    public static void setUpChromeMobile() throws MalformedURLException {
        driverMobile = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesChromeMobile());
        pageLogin = PageFactory.initElements(driverMobile, PageLogin.class);
        //        pageLoginAppOnepay = PageFactory.initElements(driverMobile, PageLoginAppOnepay.class);
        pageMain = PageFactory.initElements(driverMobile, homePage.class);
    }


    public static DesiredCapabilities capabilitiesChromeMobile() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "fb5bb49c");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "Chrome");

        capabilities.setCapability("chromedriverExecutable",
                "C:/Users/Victor.Otarola/Documents/Appium-mobile/src/test/resources/driver/windows/chromedriver.exe");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    public static DesiredCapabilities capabilitiesOnePay() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "fb5bb49c");//R58MA02X82D - fb5bb49c
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "cl.transbank.onepay.testqa");
        capabilities.setCapability("appActivity", "cl.transbank.onepay.activities.splash.SplashActivity"); 
      //"cl.transbank.onepay.ui.splash.SplashActivity"  	//EWSplashActivity_ - SplashActivity
        
        capabilities.setCapability("chromedriverExecutable",
        		"C:/Users/Victor.Otarola/Documents/Appium-mobile/src/test/resources/driver/windows/chromedriver.exe");      
        //"C:/Users/Victor.Otarola/IdeaProjects/Appium-mobile/src/test/resources/driver/windows/chromedriver.exe");
                  
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    public static void setOff() {
        driverChrome.quit();
        driverMobile.quit();
    }
}


