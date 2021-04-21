@pagoREST
  Feature: pagoRestDesktop

    Scenario Outline: Pago REST desktop

      Given quiero realizar un pago desde la tienda rest por el monto <monto> de la tienda desktop
      When confirmar el medio de pago <medioPago> por el monto <monto> cuota <ncuota> y tarjeta <tarjeta>
      Then se muestra el pago exito en la app, por el <monto> y cuota <ncuota>

      Examples:
      | monto  |  medioPago | ncuota |  tarjeta|
      | "990"  |  "Credito" | "2"    |  "Prepago" |