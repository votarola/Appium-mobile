package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationListener;
import utils.ApplicationLauncher;

import java.util.Arrays;



public class REST {

    private String[] codigo;
    private String[] codigoOnepay;


    @Given("^quiero realizar un pago desde la tienda rest por el monto \"([^\"]*)\" de la tienda desktop$")
    public void quiero_realizar_un_pago_desde_la_tienda_rest_por_el_monto_de_la_tienda_desktop(String monto) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        ApplicationLauncher.setUpChrome();
        ApplicationLauncher.driverChrome.get("https://web1qa.test.transbank.cl:8443/ewebpay/jsf/welcome.jsf");

        try {
            boolean btnPago = ApplicationLauncher.pagoRest.ClickTiendaNormal();
            Assert.assertTrue("Boton pago Webpay", btnPago);


            ApplicationLauncher.pagoRest.ingresoMonto(monto);
            ApplicationLauncher.pagoRest.btnPagoOnePay();

            System.out.println("#######################");

          codigo = ApplicationLauncher.pagoRest.obtenerCodigoOnepay();  //obtenerCodigoOnePayDesktop
            System.out.println(Arrays.toString(codigo));

            System.out.println("######################");







        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("######################");
        }
    }

    @When("^confirmar el medio de pago \"([^\"]*)\" por el monto \"([^\"]*)\" cuota \"([^\"]*)\" y tarjeta \"([^\"]*)\"$")
    public void confirmar_el_medio_de_pago_por_el_monto_cuota_y_tarjeta(String medioPago, String monto, String ncuota, String tarjeta) throws Throwable {
        // Write code here that turns the phrase above into concrete actions





    }

    @Then("^se muestra el pago exito en la app, por el \"([^\"]*)\" y cuota \"([^\"]*)\"$")
    public void se_muestra_el_pago_exito_en_la_app_por_el_y_cuota(String monto, String ncuota) throws Throwable {
        // Write code here that turns the phrase above into concrete actions



    }




}
