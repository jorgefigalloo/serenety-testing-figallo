@RegistrarUsuarios
Feature: Registrar un usuario

  @RegistrarUsuario @HappyPath
  Scenario Outline: Registrar de manera existosa a un usuario con credenciales validas
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de registro
    And ingresa nombre "<nombre>" apellido "<apellido>" email "<email>" y contrasenia "<contrasenia>"
    When selecciona el boton registrar
    Then se realiza el registro de manera exitosa

    Examples:
      | nombre | apellido | email                | contrasenia  |
      | Romulo | Leon     | abc12344@hotmail.com | Password123& |


  @RegistrarUsuario @UnhappyPath
  Scenario Outline: Registrar un usuario ya existente
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de registro
    And ingresa nombre "<nombre>" apellido "<apellido>" email "<email>" y contrasenia "<contrasenia>"
    When selecciona el boton registrar
    Then no se realiza el registro de manera exitosa

    Examples:
      | nombre | apellido | email                | contrasenia  |
      | Romulo | Leon     | abc12344@hotmail.com | Password123& |


