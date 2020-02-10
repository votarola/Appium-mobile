package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

public class Def_WebpayNormalOnepay {

    public String codigoOnepay = "";
    String monto = "990";
    String pan = "36000000001006";
    String cvv = "322";

    @Given("^quiero realizar un pago por webpay normal con Onepay$")
    public void quiero_realizar_un_pago_por_webpay_normal_con_Onepay() throws Throwable {

        ApplicationLauncher.setUpChrome();
        ApplicationLauncher.driverChrome.get("https://web1qa.test.transbank.cl:8443/ewebpay/jsf/welcome.jsf");

        WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverChrome, 15);

        try {
            boolean btnPago = ApplicationLauncher.pageWebpayNormal.clickPagoNormal();
            Assert.assertTrue("Boton pago Webpay nomrmal", btnPago);

            Thread.sleep(3000);
            ApplicationLauncher.pageWebpayNormal.ingresarAmount(monto);
            ApplicationLauncher.pageWebpayNormal.clickInitTransaction();
            Thread.sleep(3000);
            ApplicationLauncher.pageWebpayNormal.clickBtnPagoOnepay();

            codigoOnepay = ApplicationLauncher.pageWebpayNormal.retornarCodigoPagoOnepay();
            System.out.println("codigoOnepay: " + codigoOnepay);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @When("^realizo el pago con el \"([^\"]*)\" y \"([^\"]*)\"$")
    public void realizo_el_pago_con_el_y(String arg1, String pass) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //ApplicationLauncher.setUpAppium();
        ApplicationLauncher.pageLoginAppOnepay.ingresarContraseña(pass);
        ApplicationLauncher.pageLoginAppOnepay.clickBtnIngresarConContraseña();

        ApplicationLauncher.pageMain.clickIngresarCodigo();
        ApplicationLauncher.pageMain.ingresarCodigo(codigoOnepay.split(""));

        //    boolean SelectorTarjetas = ApplicationLauncher.pageMain.clickSelectorTarjetas();
        //    Assert.assertTrue("Selector de tarjetas",SelectorTarjetas);


        //    boolean SelectorCuotas = ApplicationLauncher.pageMain.clickSelectorCuotas();
        //    Assert.assertTrue("Selector de cuotas",SelectorCuotas);


        boolean btnAddCArd = ApplicationLauncher.pageMain.clickAddCard();
        Assert.assertTrue("Boton Agregar tarjeta desde modal", btnAddCArd);

        ApplicationLauncher.pageMain.clickAddCardCredit();
        Thread.sleep(5000);
        ApplicationLauncher.pageLoginAppOnepay.cambiarContexto();
        Thread.sleep(3000);


        boolean sendpan = ApplicationLauncher.pageLoginAppOnepay.sendPAN(pan);
        Assert.assertTrue("Envio PAN", sendpan);
        boolean sendcvv = ApplicationLauncher.pageLoginAppOnepay.sendCVV(cvv);
        Assert.assertTrue("Envio cvv", sendcvv);
        boolean ContiEnrolment = ApplicationLauncher.pageLoginAppOnepay.ContiEnrolment();
        Assert.assertTrue("Continuar enrolamiento", ContiEnrolment);

        ApplicationLauncher.driverMobile.context("NATIVE_APP");

        ApplicationLauncher.pageLoginAppOnepay.AddCard();
        ApplicationLauncher.pageLoginAppOnepay.SeguirAddCard();
        ApplicationLauncher.pageLoginAppOnepay.RetornTBK();
        ApplicationLauncher.pageLoginAppOnepay.ContinuarAñadida();

        Thread.sleep(3000);
        boolean btnpay = ApplicationLauncher.pageMain.clickBotonPago();
        Assert.assertTrue("Boton continuar en revisa los datos", btnpay);

        Thread.sleep(5000);
        boolean pin = ApplicationLauncher.pageMain.creaPIN();
        Assert.assertTrue("PIN en proceso de autorizacion de pago", pin);
        Thread.sleep(1000);
        ApplicationLauncher.pageMain.clickAuthPay();
        Thread.sleep(5000);

        boolean irInicio = ApplicationLauncher.pageMain.clickIrInicio();
        Assert.assertTrue("Boton Ir la Inicio en estado de pago", irInicio);

    }


    @Then("^se realiza el pago con onepay exitosamente y se cierra la sesion del usuario$")
    public void se_realiza_el_pago_con_onepay_exitosamente_y_se_cierra_la_sesion_del_usuario() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ApplicationLauncher.pageWebPay.clickbtnACK();

    }


}
