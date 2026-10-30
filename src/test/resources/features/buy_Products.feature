# language: es

Característica: Compra de productos

  Antecedentes:
    Dado que el cliente se ubica en la página de inicio de sesión
    Y ha iniciado sesión exitosamente

  Esquema del escenario: Agregar producto al carrito de compras
    Cuando el cliente agrega el producto <producto> al carrito
    Entonces vera una unidad en el icono del carrito
    Ejemplos:
      | producto            |
      | Sauce Labs Backpack |


  Esquema del escenario: Visualizar el producto agregado en el carrito de compras
    Cuando agrega el producto <producto> al carrito
    Y el cliente accede al carrito de compras
    Entonces vera el producto <producto> agregado al carrito
    Ejemplos:
      | producto            |
      | Sauce Labs Backpack |

  Esquema del escenario: Completar informacion de envio del pedido

    Dado que el cliente ha agregado el producto <producto> al carrito
    Cuando accede al carrito de compras
    Y continua con el checkout
    Y ingresa la informacion solicitada para el pedido
      | primerNombre | apellido | codigoPostal |
      | Prueba       | Qa       | 10101        |
    Entonces podra continuar con el resumen de la compra
    Ejemplos:
      | producto            |
      | Sauce Labs Backpack |