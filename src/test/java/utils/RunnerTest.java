package utils;


import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "definitions",
        tags = "@LoginRegistratorCode",
        plugin = { "pretty", "html:target/cucumber" ,
                "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:"})

public class RunnerTest {
    public static SimpleDateFormat sdf;

    @AfterClass
    public static void setup() {
        //Carga la config del xml
        System.out.println("CARGA CONFIGURACIÓN DEL XML");
        Reporter.loadXMLConfig(new File("./src/test/resources/config/extent-config.xml"));

        // Detalle características
        Reporter.setSystemInfo("Nombre Proyecto","BDD - Selenium");
        Reporter.setSystemInfo("Zona Horaria", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Ubicacion Usuario", System.getProperty("user.country"));
        Reporter.setSystemInfo("Nombre SO", System.getProperty("os.name"));

    }

    @BeforeClass
    public static void setupPath() {
        sdf = new SimpleDateFormat("dd-MM-YYYY_hh-mm-ss");

        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("src/test/resources/reportes/html/Reporte_Selenium_"

                //extentProperties.setReportPath("src/test/resources/reportes/html/html/Reporte_Selenium_"
                + sdf.format(new Date()) + ".html");
    }
}
