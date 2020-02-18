@PagoWebpayNormalOnepay
Feature: PagoWebPayNormal con Onepay

  Scenario Outline: PagoWebPayNormal
    Given quiero realizar un pago por webpay normal con Onepay
    When realizo el pago con el <usuario> y <password>
    Then se realiza el pago con onepay exitosamente y se cierra la sesion del usuario

    Examples:
      | usuario                             | password |
      | "victor.otarola@tsoftglobal.com"    |"Q1111111"|
