@LoginOnepay
Feature: Login

  Scenario Outline: Login Onepay
    Given quiero ingresar a Onepay
    When ingreso a la app con mi <email> y <contrasena>
    Then ingreso a onepay

    Examples:
      | email                             | contrasena |
      | "v.otarolamorales@gmail.com"  	  |"Q1111111"|