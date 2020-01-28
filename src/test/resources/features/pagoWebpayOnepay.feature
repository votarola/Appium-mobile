@PagoWebPayOnepay
Feature: PagoWebPayMall con Onepay

  Scenario Outline: PagoWebPayMall
    Given quiero realizar un pago por webpay mall con Onepay
    When ingreso los montos y pago con onepay <usuario> y <password>
    Then se realiza el pago con onepay

    Examples:
      | usuario                             | password |
      | "victor.otarola@tsoftglobal.com"  |"Q1111111"|
