package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;
import utils.UtilsDriver;

public class Def_WebPayOnepay {

    public static Object[][] compras = {
            {"597038357948", "11", "1500"},
            {"597038357948", "21", "2000"},
            {"597038357921", "31", "2500"},
            {"597038357921", "41", "8500"},
    };


    public String codigoOnepay = "";
    public String SelectCuotas = "";

    @Given("^quiero realizar un pago por webpay mall con Onepay$")
    public void quiero_realizar_un_pago_por_webpay_mall_con_Onepay() throws Throwable {
        ApplicationLauncher.setUpChrome();
        ApplicationLauncher.driverChrome.get("https://web1qa.test.transbank.cl:8443/ewebpay/jsf/welcome.jsf");

        String commerceCode = "";
        String buyOrder = "";
        String amount = "";

        WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 15);

        try {
            boolean btnPago = ApplicationLauncher.pageWebPay.clickPagoMall();
            Assert.assertTrue("Boton pago Webpay", btnPago);
            for (int i = 0; i < compras.length; i++) {
                commerceCode = (String) compras[i][0];
                buyOrder = (String) compras[i][1];
                amount = (String) compras[i][2];

                ApplicationLauncher.pageWebPay.ingresarCodigoComercio(commerceCode);
                ApplicationLauncher.pageWebPay.ingresarBuyOrder(buyOrder);
                ApplicationLauncher.pageWebPay.ingresarAmount(amount);

                ApplicationLauncher.pageWebPay.clickBtnSave();
                Thread.sleep(1500);
            }
            UtilsDriver.screenshot(ApplicationLauncher.driverChrome,"Print");
            ApplicationLauncher.pageWebPay.clickInitTransaction();

            ApplicationLauncher.pageWebPay.clickBtnPagoOnepay();

            codigoOnepay = ApplicationLauncher.pageWebPay.retornarCodigoPagoOnepay();

            System.out.println("codigoOnepay: " + codigoOnepay);


        } catch (Exception e) {
            e.printStackTrace();
            UtilsDriver.screenshot(ApplicationLauncher.driverChrome,"NoSuchElementException");
        }
    }

    @When("^ingreso los montos y pago con onepay \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_los_montos_y_pago_con_onepay_y(String arg1, String pass) throws Throwable {
        ApplicationLauncher.setUpAppium();
        ApplicationLauncher.pageLoginAppOnepay.ingresarContraseña(pass);
        ApplicationLauncher.pageLoginAppOnepay.clickBtnIngresarConContraseña();

        ApplicationLauncher.pageMain.clickIngresarCodigo();
        ApplicationLauncher.pageMain.ingresarCodigo(codigoOnepay.split(""));

        boolean SelectorTarjetas = ApplicationLauncher.pageMain.clickSelectorTarjetas();
        Assert.assertTrue("Selector de tarjetas",SelectorTarjetas);

        boolean SelectorCuotas = ApplicationLauncher.pageMain.clickSelectorCuotas();
        Assert.assertTrue("Selector de cuotas",SelectorCuotas);

        boolean btnpay = ApplicationLauncher.pageMain.clickBotonPago();
        Assert.assertTrue("Boton continuar en revisa los datos",btnpay);

        Thread.sleep(5000);
        boolean pin = ApplicationLauncher.pageMain.creaPIN();
        Assert.assertTrue("PIN en proceso de autorizacion de pago",pin);
        Thread.sleep(1000);
        ApplicationLauncher.pageMain.clickAuthPay();
        Thread.sleep(5000);

        boolean irInicio = ApplicationLauncher.pageMain.clickIrInicio();
        Assert.assertTrue("Boton Ir la Inicio en estado de pago",irInicio);

    }

    @Then("^se realiza el pago con onepay$")
    public void se_realiza_el_pago_con_onepay() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        ApplicationLauncher.pageWebPay.clickbtnACK();


//        https://web1qa.test.transbank.cl:8443/ewebpay/initReturnMnorm
    }
}
