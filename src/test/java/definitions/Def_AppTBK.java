package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ApplicationLauncher;

public class Def_AppTBK {

    @Given("^quiero ingresar a AppTBK$")
    public void quiero_ingresar_a_AppTBK() throws Throwable {
        ApplicationLauncher.setUpAppium();
        Thread.sleep(5000);
    }

    @When("^ingreso \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_y(String rut, String pass ) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ApplicationLauncher.pageLoginAppTBK.cambiarContexto();
        ApplicationLauncher.pageLoginAppTBK.verTyC();
        ApplicationLauncher.pageLoginAppTBK.solicitarContraseña(rut);
        Thread.sleep(5000);
        ApplicationLauncher.pageLoginAppTBK.ingresarRut(rut);
        ApplicationLauncher.pageLoginAppTBK.ingresarPass(pass);
        ApplicationLauncher.pageLoginAppTBK.clickBtnLogin();
    }


    @Then("^ingreso a la App$")
    public void ingreso_a_la_App() throws Throwable {
       // ApplicationLauncher.setOff();
    }

}
