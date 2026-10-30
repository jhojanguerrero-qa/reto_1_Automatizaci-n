# language: es

Característica: Compra de productos

  Antecedentes:
    Dado que el cliente se ubica en la página de inicio de sesión
    Y ha iniciado sesión exitosamente
      | usuario       | password     |
      | standard_user | secret_sauce |

  Escenario: Agregar producto al carrito de compras
    Cuando el cliente agrega el producto al carrito
      | producto            |
      | Sauce Labs Backpack |
    Entonces vera una unidad en el icono del carrito


  Escenario: Visualizar el producto agregado en el carrito de compras
    Cuando el cliente agrega productos al carrito
      | producto            |
      | Sauce Labs Backpack |
    Y accede al carrito de compras
    Entonces vera el(los) producto(s) agregado(s) al carrito
      | producto            |
      | Sauce Labs Backpack |


  Escenario: Completar informacion de envio del pedido

    Dado que el cliente ha agregado el(los) producto(s) al carrito
      | producto            |
      | Sauce Labs Backpack |
    Cuando accede al carrito de compras
    Y continua con el checkout
    Y ingresa la informacion solicitada para el pedido
      | primerNombre | apellido | codigoPostal |
      | Prueba       | Qa       | 10101        |
    Entonces podra continuar con la pagina titulada de detalle del pedido
      | titulo             |
      | Checkout: Overview |


  Esquema del escenario: Finalizar la compra exitosamente

    Dado que el cliente ha agregado el(los) producto(s) al carrito
      | producto            |
      | Sauce Labs Backpack |
    Cuando accede al carrito de compras
    Y continua con el checkout
    Y ingresa la informacion solicitada para el pedido
      | primerNombre | apellido | codigoPostal |
      | Prueba       | Qa       | 10101        |
    Y confirma la compra
    Entonces visualizara el mensaje "<mensaje>" de compra realizada exitosamente
    Ejemplos:
      | mensaje                   |
      | Thank you for your order! |
