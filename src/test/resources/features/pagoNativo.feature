@pagoNativo
  Feature: pagoNativoOnepay

    Scenario Outline: pago nativo

      Given quiero realizar un pago por la url <url> de modal
      When confirmo el pago por el monto <monto> y medio de pago <medioPago> en la app
      Then se confirma el pago ingresando el pin y se muestra exitoso

      Examples:
        |url                                  | monto | medioPago |
        |"http://18.216.122.230/wl12/qa/modal/"| "2000"  | "Credito" |