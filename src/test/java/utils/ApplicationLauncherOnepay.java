package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.PageLoginAppOnepay;


import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationLauncherOnepay {

    public static PageLoginAppOnepay pageLoginAppOnepay;

    public static AppiumDriver driverMobile;

    public static void setUp() throws MalformedURLException {

        driverMobile = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities());
        pageLoginAppOnepay = PageFactory.initElements(driverMobile, PageLoginAppOnepay.class);
    }


    public static DesiredCapabilities capabilities() {
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
        capabilities.setCapability("autoGrantPermissions",true);
        return capabilities;
    }

    public static void setOff(){
        driverMobile.quit();
    }
}
