@EditarCuenta
Feature: Editar nombre y apellido de un usuario

  Scenario: Editar correctamente el nombre y apellido después del login
    Given el usuario ha iniciado sesión con email "figallojorge@gmail.com" y contraseña "Password123@"
    When edita su nombre a "JorgeAngel" y su apellido a "FigalloMesta"
    Then se muestra un mensaje de confirmación de edición
