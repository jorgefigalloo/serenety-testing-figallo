@ComprarProducto
Feature: Comprar un producto desde el catálogo

  @CompraExitosa
  Scenario Outline: Comprar chaqueta desde Men → Tops → Jackets
    Given el usuario inicia sesion con email "<email>" y contrasenia "<contrasenia>"
    When navega a Men > Tops > Jackets
    And selecciona el producto "<nombreProducto>"
    And elige talla "<talla>" y color "<color>" y cantidad "<cantidad>"
    And agrega al carrito
    And procede a comprar
    And completa el formulario con company "<company>", direccion "<direccion>", ciudad "<ciudad>", estado "<estado>", zip "<zip>", pais "<pais>", telefono "<telefono>"
    And hace clic en "Place Order"
    Then ve el mensaje de confirmación "Thank you for your purchase!"
    And hace clic en el número de orden

    Examples:
      | email                   | contrasenia    | nombreProducto        | talla | color | cantidad | company  | direccion        | ciudad | estado | zip  | pais | telefono    |
      | figallojorge@gmail.com | Password123@   | Montana Wind Jacket   | L     | Black | 2        | NTTDATA  | Av. Siempre Viva | Piura  | Piura  | 2001 | Peru | 920025691   |
