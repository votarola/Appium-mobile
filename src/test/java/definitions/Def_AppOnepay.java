package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.ApplicationLauncher;
import utils.ApplicationLauncherOnepay;

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

        ApplicationLauncherOnepay.pageLoginAppOnepay.clickbtnRegistro();
        ApplicationLauncherOnepay.pageLoginAppOnepay.clickbtnIngreso();
        ApplicationLauncherOnepay.pageLoginAppOnepay.ingresaEmailPass(email,contra);
        boolean btnIngresoUsuario = ApplicationLauncherOnepay.pageLoginAppOnepay.btnIngresoUser();
        Assert.assertTrue("Boton ingreso de usuario",btnIngresoUsuario);
        Thread.sleep(5000);
        ApplicationLauncherOnepay.pageLoginAppOnepay.creaPIN();
        Thread.sleep(2000);
        ApplicationLauncherOnepay.pageLoginAppOnepay.creaPIN();
        Thread.sleep(5000);
        boolean validaTextoOBHuella = ApplicationLauncherOnepay.pageLoginAppOnepay.validaTextoOBHuella();
        Assert.assertTrue("Valida que este el texto del onboarding",validaTextoOBHuella);
        System.out.println("validaTextoOBHuella"+validaTextoOBHuella);
        Thread.sleep(2000);
        boolean FBOnboardingNoxAhora = ApplicationLauncherOnepay.pageLoginAppOnepay.FBNoXAhora();
        Assert.assertTrue("Boton no por ahora en onboarding",FBOnboardingNoxAhora);



    }

    @Then("^ingreso a onepay$")
    public void ingreso_a_onepay() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //ApplicationLauncherOnepay.setOff();

    }

}
