package definitions;


import com.google.gson.internal.bind.util.ISO8601Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.ApplicationLauncher;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Def_pagoWebpayREST {

    private String[] codigo;
    public String codigoOnepay = "";


    @Given("^quiero realizar un pago por la \"([^\"]*)\" de webpay rest con el monto \"([^\"]*)\" desde Onepay$")
    public void quiero_realizar_un_pago_por_la_de_webpay_rest_con_el_monto_desde_Onepay(String url, String monto) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();

        ApplicationLauncher.setUpChrome();
        ApplicationLauncher.driverChrome.get(url);

        try {
            boolean btnTiendaPago = ApplicationLauncher.pageWebpayREST.clickTiendaNormal();
            Assert.assertTrue("Boton pago Webpay REST", btnTiendaPago);

            ApplicationLauncher.pageWebpayREST.clickAmount(monto);
            ApplicationLauncher.pageWebpayREST.clickbtnOnepay();


            System.out.println("#####################");


            codigo = ApplicationLauncher.pageWebpayREST.obtenerCodigoOnePay();
            System.out.println("#####################");
            System.out.println(Arrays.toString(codigo));

            System.out.println(Arrays.toString(codigo));
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%#####################");



        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @When("^confirmo con el medio de pago \"([^\"]*)\", por monto \"([^\"]*)\", cuotas \"([^\"]*)\", tarjeta \"([^\"]*)\" ingresando el pin \"([^\"]*)\" de onepay$")
    public void confirmo_con_el_medio_de_pago_por_monto_cuotas_tarjeta_ingresando_el_pin_de_onepay(String medioPago, String monto, String nCuotas, String tarjeta, String pin) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();



    }


    @Then("^se muestra el pago exitoso en la app, validando monto \"([^\"]*)\" y cuota \"([^\"]*)\"$")
    public void se_muestra_el_pago_exitoso_en_la_app_validando_monto_y_cuota(String monto, String nCuotas) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();




    }

}
