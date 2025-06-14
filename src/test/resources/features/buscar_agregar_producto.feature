@AgregarProductos
Feature: Buscar un producto y agregarlo al carrito

  @AgregarProducto @Happypath
  Scenario Outline: Buscar un producto, elegir talla, color y agregarlo al carrito de manera exitosa
    Given el usuario inicia sesion con email "<email>" y contrasenia "<contrasenia>"
    And busca un producto "<nombreProducto>"
    And selecciona la talla "<talla>" y color "<color>"
    When agrega al carrito
    Then se actualiza el item "<item>" del carrito de manera exitosa

    Examples:
      | email                | contrasenia  | nombreProducto | talla | color | item |
      | abc12344@hotmail.com | Password123& | jackshirt      | L     | Blue  | 1    |


