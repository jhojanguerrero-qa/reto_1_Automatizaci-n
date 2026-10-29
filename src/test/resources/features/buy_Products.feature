# language: es

  Característica: Compra de productos

    Antecedentes:
      Dado que el cliente se ubica en la página de inicio de sesión
      Y ha iniciado sesión exitosamente.

    Escenario: Agregar producto al carrito de compras
      Cuando el cliente agrega un producto al carro
      Entonces vera una unidad en el icono del carrito

    Escenario: Vizualizar el producto agregado en el carrito de compras
      Cuando el cliente accede al carrito de compras
      Entonces vera el producto agregado al carrito

    Escenario: Finalizar el proceso de compras
      Cuando el cliente ingrese los datos solicitados para el proceso de compras
      Entonces podrá completar el flujo de compras