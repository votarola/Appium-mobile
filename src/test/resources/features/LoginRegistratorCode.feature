@LoginRegistratorCode
Feature: LoginTarjetas

  Scenario Outline: Login Onepay usuario con tarjetas enroladas
    Given quiero ingresar a Onepay para
    When con el <email> y <password> tenga tarjetas enroladas en la cuenta
    Then ingreso a onepay exitosamente

    Examples:
    
      | email          		| password |
      | "a1@emailna.co"  	|"Q1111111"|