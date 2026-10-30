# language: es

Característica: Inicio de sesion

  Escenario: Acceso al catalogo despues de autenticacion valida
    Dado que el cliente se ubica en la página de inicio de sesión
    Cuando el cliente ingresa sus credenciales válidas
      | usuario       | password     |
      | standard_user | secret_sauce |
    Entonces vera el titulo en pantalla
      | titulo   |
      | Products |
