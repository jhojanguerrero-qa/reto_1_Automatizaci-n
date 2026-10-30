# language: es

Característica: Inicio de sesión

  Escenario: Acceso al catálogo después de autenticación válida
    Dado que el cliente se ubica en la página de inicio de sesión
    Cuando el cliente ingresa sus credenciales válidas
      | usuario       | contraseña   |
      | standard_user | secret_sauce |
    Entonces vera el titulo en pantalla.
      | titulo   |
      | Products |
