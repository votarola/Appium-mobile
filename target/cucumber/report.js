$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("pagoRest.feature");
formatter.feature({
  "line": 2,
  "name": "pagoRestDesktop",
  "description": "",
  "id": "pagorestdesktop",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@pagoREST"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Pago REST desktop",
  "description": "",
  "id": "pagorestdesktop;pago-rest-desktop",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "quiero realizar un pago desde la tienda rest por el monto \u003cmonto\u003e de la tienda desktop",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "confirmar el medio de pago \u003cmedioPago\u003e por el monto \u003cmonto\u003e cuota \u003cncuota\u003e y tarjeta \u003ctarjeta\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "se muestra el pago exito en la app, por el \u003cmonto\u003e y cuota \u003cncuota\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "pagorestdesktop;pago-rest-desktop;",
  "rows": [
    {
      "cells": [
        "monto",
        "medioPago",
        "ncuota",
        "tarjeta"
      ],
      "line": 11,
      "id": "pagorestdesktop;pago-rest-desktop;;1"
    },
    {
      "cells": [
        "\"990\"",
        "\"Credito\"",
        "\"2\"",
        "\"Prepago\""
      ],
      "line": 12,
      "id": "pagorestdesktop;pago-rest-desktop;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "Pago REST desktop",
  "description": "",
  "id": "pagorestdesktop;pago-rest-desktop;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@pagoREST"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "quiero realizar un pago desde la tienda rest por el monto \"990\" de la tienda desktop",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "confirmar el medio de pago \"Credito\" por el monto \"990\" cuota \"2\" y tarjeta \"Prepago\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "se muestra el pago exito en la app, por el \"990\" y cuota \"2\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "990",
      "offset": 59
    }
  ],
  "location": "REST.quiero_realizar_un_pago_desde_la_tienda_rest_por_el_monto_de_la_tienda_desktop(String)"
});
formatter.result({
  "duration": 43564897449,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Credito",
      "offset": 28
    },
    {
      "val": "990",
      "offset": 51
    },
    {
      "val": "2",
      "offset": 63
    },
    {
      "val": "Prepago",
      "offset": 77
    }
  ],
  "location": "REST.confirmar_el_medio_de_pago_por_el_monto_cuota_y_tarjeta(String,String,String,String)"
});
formatter.result({
  "duration": 145746,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "990",
      "offset": 44
    },
    {
      "val": "2",
      "offset": 58
    }
  ],
  "location": "REST.se_muestra_el_pago_exito_en_la_app_por_el_y_cuota(String,String)"
});
formatter.result({
  "duration": 108743,
  "status": "passed"
});
});