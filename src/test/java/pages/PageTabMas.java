package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationLauncher;

public class PageTabMas {


    @FindBy(id = "action_more")
    private WebElement tabMas;

    @FindBy(id = "activated_devices_layout")
    private WebElement opcionDispoActivos;

        @FindBy(id = "btnEdit")
        private WebElement editDispositivo;

        @FindBy(id = "etAlias")
        private WebElement editAliasMobile;

        @FindBy(id = "btnUnlink")
        private WebElement desvincularDispositivo;

        @FindBy(id = "button1")
        private WebElement desvinAceptar;

        @FindBy(id = "button2")
        private WebElement desvinCancelar;

        @FindBy(id = "back")
        private WebElement desvinBackPIN;

    @FindBy(id = "user_account_layout")
    private WebElement opcionCtaUsuario;

        @FindBy(id = "btnPersonalInformation")
        private WebElement datosPersonales;

            @FindBy(id = "etName")
            private WebElement editName;

            @FindBy(id = "etLastName")
            private WebElement editApellido;

            @FindBy(id = "btnAccept")
            private WebElement modificarDatos;

        @FindBy(id = "btnUpdatePassword")
        private WebElement cambiaContraseña;

        @FindBy(id = "btnRestorePassword")
        private WebElement restableceContraseña;


    @FindBy(id = "pin_layout")
    private WebElement opcionPIN;

    @FindBy(id = "help_layout")
    private WebElement opcionAyuda;

    @FindBy(id = "biometic_layout")
    private WebElement activarFBiometrico;

    @FindBy(id = "close_layout")
    private WebElement cerrarSesion;





    WebDriverWait wait = new WebDriverWait(ApplicationLauncher.driverMobile, 50);

    public void clickTabMas() {
        wait.until(ExpectedConditions.visibilityOf(tabMas));
        tabMas.click();


    }

}
