@AppTBK
Feature: Login

  Scenario Outline: Login AppTBK
    Given quiero ingresar a AppTBK
    When ingreso <rut> y <password>
    Then ingreso a la App

    Examples:
      | rut        | password |
      | "81263574" |"Tbk.2017"|