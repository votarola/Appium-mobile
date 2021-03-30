package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.ApplicationLauncher;
import utils.ApplicationLauncher;

public class Def_AppOnepay {


    @Given("^quiero ingresar a Onepay$")
    public void quiero_ingresar_a_Onepay() throws Throwable {
        ApplicationLauncher.setUpAppium();
        Thread.sleep(5000);
      
       
      
 
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^ingreso a la app con mi \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_a_la_app_con_mi_y(String email, String contra) throws Throwable {
        // Write code here that turns the phrase above into concrete actions


    	ApplicationLauncher.pageLogin.ingresaEmailPass(email,contra);
       //	ApplicationLauncher.pageLogin.ClickIngreso();
       	
        boolean btnIngresoUsuario = ApplicationLauncher.pageLogin.ClickIngreso();
        Assert.assertTrue("Boton ingreso de usuario",btnIngresoUsuario);
        Thread.sleep(5000);
        
       	ApplicationLauncher.pageLogin.creaPIN();
        Thread.sleep(5000);
       	

       	ApplicationLauncher.pageLogin.NoFactorBiometric();
        
        
    /*
        ApplicationLauncher.pageLoginAppOnepay.clickbtnRegistro();
        ApplicationLauncher.pageLoginAppOnepay.clickbtnIngreso();
        ApplicationLauncher.pageLoginAppOnepay.ingresaEmailPass(email,contra);
        boolean btnIngresoUsuario = ApplicationLauncher.pageLoginAppOnepay.btnIngresoUser();
        Assert.assertTrue("Boton ingreso de usuario",btnIngresoUsuario);
        Thread.sleep(5000);
        ApplicationLauncher.pageLoginAppOnepay.creaPIN();
        Thread.sleep(2000);
        ApplicationLauncher.pageLoginAppOnepay.creaPIN();
        Thread.sleep(5000);
        boolean validaTextoOBHuella = ApplicationLauncher.pageLoginAppOnepay.validaTextoOBHuella();
        Assert.assertTrue("Valida que este el texto del onboarding",validaTextoOBHuella);
        System.out.println("validaTextoOBHuella"+validaTextoOBHuella);
        Thread.sleep(2000);
        boolean FBOnboardingNoxAhora = ApplicationLauncher.pageLoginAppOnepay.FBNoXAhora();
        Assert.assertTrue("Boton no por ahora en onboarding",FBOnboardingNoxAhora);

*/

    }

    @Then("^ingreso a onepay$")
    public void ingreso_a_onepay() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	ApplicationLauncher.setOff();

    }

}
