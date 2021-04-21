package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;
import java.util.Arrays;


public class Def_pagoNativo {

    private String[] codigo;
    String pass = "Q1111111";

    @Given("^quiero realizar un pago por la url \"([^\"]*)\" de modal$")
    public void quiero_realizar_un_pago_por_la_url_de_modal(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        ApplicationLauncher.setUpChrome();
        ApplicationLauncher.driverChrome.get(url);
        ApplicationLauncher.pageModal.btnModalOnepay();

        codigo = ApplicationLauncher.pageModal.obtenerCodigoOnePayDesktop();
        System.out.println(Arrays.toString(codigo));

        System.out.println("######################");


    }

    @When("^confirmo el pago por el monto \"([^\"]*)\" y medio de pago \"([^\"]*)\" en la app$")
    public void confirmo_el_pago_por_el_monto_y_medio_de_pago_en_la_app(String monto, String medioPago) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        ApplicationLauncher.setUpAppium();
        WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 10);

        try {

            //cuando se pasa por el pre login con contraseña//
           ApplicationLauncher.pagePreLogin.ingresaPass(pass);

           boolean clickclickIngresarCodigo = ApplicationLauncher.pageHome.clickclickIngresarCodigo();
           Assert.assertTrue("Boton de ingreso", clickclickIngresarCodigo);

           ApplicationLauncher.pageHome.ingresarCodigo(codigo);


        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Then("^se confirma el pago ingresando el pin y se muestra exitoso$")
    public void se_confirma_el_pago_ingresando_el_pin_y_se_muestra_exitoso() throws Throwable {
        // Write code here that turns the phrase above into concrete actions



    }





}
