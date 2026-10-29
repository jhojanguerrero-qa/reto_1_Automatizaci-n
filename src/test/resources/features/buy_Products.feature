# language: es

Característica: Compra de productos

  Antecedentes:
    Dado que el cliente se ubica en la página de inicio de sesión
    Y ha iniciado sesión exitosamente.

  Esquema del escenario: Agregar producto al carrito de compras
    Cuando el cliente agrega el producto <producto> al carrito
    Entonces vera una unidad en el icono del carrito
    Ejemplos:
      | producto                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |


  Escenario: Vizualizar el producto agregado en el carrito de compras
    Cuando el cliente accede al carrito de compras
    Entonces vera el producto agregado al carrito

  Escenario: Finalizar el proceso de compras
    Cuando el cliente ingrese los datos solicitados para el proceso de compras
    Entonces podrá completar el flujo de compras