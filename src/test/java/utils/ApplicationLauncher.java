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

    public static loginAppTBK pageLoginAppTBK;
    public static PageWebPay pageWebPay;
    public static loginAppOnepay pageLoginAppOnepay;
    public static homePage pageMain;
    public static PageWebpayNormal pageWebpayNormal;

    public static PageTabHome pageHome;
    public static PageTabPagos pagePagos;
    public static PageTabTarjetas pageTarjetas;
    public static PageTabMas pageMas;



    public static AppiumDriver driverMobile;
    public static WebDriver driverChrome;

    public static void setUpChrome() throws MalformedURLException {
        String Path = "src/test/resources/driver/windows/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", Path);
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        pageWebPay = PageFactory.initElements(driverChrome, PageWebPay.class);
        pageWebpayNormal = PageFactory.initElements(driverChrome, PageWebpayNormal.class);
        //pasar todas las clases con los objetos que se necesitan ocupar
    }

    public static void setUpAppium() throws MalformedURLException {
        driverMobile = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesOnePay());
        pageLoginAppOnepay = PageFactory.initElements(driverMobile, loginAppOnepay.class);
        pageMain = PageFactory.initElements(driverMobile, homePage.class);
    }

    public static void setUpChromeMobile() throws MalformedURLException {
        driverMobile = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesChromeMobile());
        pageLoginAppOnepay = PageFactory.initElements(driverMobile, loginAppOnepay.class);
        pageMain = PageFactory.initElements(driverMobile, homePage.class);
    }


    public static DesiredCapabilities capabilitiesAppTBK() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "BPN0218625007244");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "cl.transbank.apppyme");
        capabilities.setCapability("appActivity", "cl.transbank.apppyme.MainActivity");
        capabilities.setCapability("chromedriverExecutable",
                "C:/Users/Victor.Otarola/IdeaProjects/Appium-mobile/src/test/resources/driver/windows/chromedriver.exe");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    public static DesiredCapabilities capabilitiesChromeMobile() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "93PAX09H3F");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "Chrome");

        capabilities.setCapability("chromedriverExecutable",
                "C:/Users/Victor.Otarola/IdeaProjects/Appium-mobile/src/test/resources/driver/windows/chromedriver.exe");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    public static DesiredCapabilities capabilitiesOnePay() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "93PAX09H3F");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "cl.transbank.onepay");
        capabilities.setCapability("appActivity", "cl.transbank.onepay.ui.splash.EWSplashActivity_");
        capabilities.setCapability("chromedriverExecutable",
                "C:/Users/Victor.Otarola/IdeaProjects/Appium-mobile/src/test/resources/driver/windows/chromedriver.exe");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    public static void setOff() {
        // driverChrome.quit();
        //driverMobile.quit();
    }
}


