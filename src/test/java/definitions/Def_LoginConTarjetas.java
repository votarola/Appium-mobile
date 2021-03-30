package definitions;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ApplicationLauncher;

public class Def_LoginConTarjetas {

	String userEmail= "a1";
	
	@Given("^quiero ingresar a Onepay para$")
	public void quiero_ingresar_a_Onepay_para() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

        ApplicationLauncher.setUpChrome();        
        ApplicationLauncher.driverChrome.get("https://www.mohmal.com/es");
        WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 15);

        try {
        	
        ApplicationLauncher.pageMohmal.escogerEmail();
        boolean btnSendEmail = ApplicationLauncher.pageMohmal.IngresaEmail(userEmail);
        Assert.assertTrue("Boton envio de email", btnSendEmail);
        ApplicationLauncher.pageMohmal.next();
        ApplicationLauncher.pageMohmal.crearEmail();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@When("^con el \"([^\"]*)\" y \"([^\"]*)\" tenga tarjetas enroladas en la cuenta$")
	public void con_el_y_tenga_tarjetas_enroladas_en_la_cuenta(String email, String pass) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		ApplicationLauncher.setUpAppium();
        WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 15);
        
        try {
        	
        
        boolean btnIngreso = ApplicationLauncher.pageLoginAppOnepay.clickbtnIngreso();
        Assert.assertTrue("Boton de ingreso", btnIngreso);
        ApplicationLauncher.pageLoginAppOnepay.ingresaEmailPass(email,pass);
        ApplicationLauncher.pageLoginAppOnepay.btnIngresoUser();
        boolean creaPIN = ApplicationLauncher.pageHome.creaPIN();
        Assert.assertTrue("Boton de ingreso", creaPIN);
        boolean repitePIN = ApplicationLauncher.pageHome.creaPIN();
        Assert.assertTrue("Boton de ingreso", repitePIN);
	
        }catch (Exception e) {
		e.printStackTrace();
        }
	}
	

	@Then("^ingreso a onepay exitosamente$")
	public void ingreso_a_onepay_exitosamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	    
	    
	}
	
		
}
