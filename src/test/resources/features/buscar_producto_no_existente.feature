  @BuscarProductoNoExistente
  Feature: Buscar un producto que no existe

    @ProductoNoEncontrado @Happypath
    Scenario Outline: Buscar un producto inexistente y validar el mensaje de no resultados
      Given el usuario inicia sesión con email "<email>" y contraseña "<contrasenia>"
      When busca un producto inexistente "<nombreProducto>"
      Then se muestra el mensaje de que no se encontraron resultados

      Examples:
        | email                | contrasenia    | nombreProducto |
        | figallojorge@gmail.com | Password123@ | abc1231        |