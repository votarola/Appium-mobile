$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginOnepay.feature");
formatter.feature({
  "line": 2,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@LoginOnepay"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Login Onepay",
  "description": "",
  "id": "login;login-onepay",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "quiero ingresar a Onepay",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "ingreso a la app con mi \u003cemail\u003e y \u003ccontrasena\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "ingreso a onepay",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "login;login-onepay;",
  "rows": [
    {
      "cells": [
        "email",
        "contrasena"
      ],
      "line": 10,
      "id": "login;login-onepay;;1"
    },
    {
      "cells": [
        "\"v.otarolamorales@gmail.com\"",
        "\"Q1111111\""
      ],
      "line": 11,
      "id": "login;login-onepay;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Login Onepay",
  "description": "",
  "id": "login;login-onepay;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@LoginOnepay"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "quiero ingresar a Onepay",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "ingreso a la app con mi \"v.otarolamorales@gmail.com\" y \"Q1111111\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "ingreso a onepay",
  "keyword": "Then "
});
formatter.match({
  "location": "Def_AppOnepay.quiero_ingresar_a_Onepay()"
});
formatter.result({
  "duration": 16927349740,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "v.otarolamorales@gmail.com",
      "offset": 25
    },
    {
      "val": "Q1111111",
      "offset": 56
    }
  ],
  "location": "Def_AppOnepay.ingreso_a_la_app_con_mi_y(String,String)"
});
formatter.result({
  "duration": 28854303020,
  "status": "passed"
});
formatter.match({
  "location": "Def_AppOnepay.ingreso_a_onepay()"
});
formatter.result({
  "duration": 55878419840,
  "error_message": "java.lang.AssertionError: Envio PAN\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat definitions.Def_AppOnepay.ingreso_a_onepay(Def_AppOnepay.java:85)\r\n\tat ✽.Then ingreso a onepay(LoginOnepay.feature:7)\r\n",
  "status": "failed"
});
});