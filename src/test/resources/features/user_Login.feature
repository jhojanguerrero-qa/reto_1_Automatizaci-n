# language: es

Característica: Inicio de sesión

  Esquema del escenario: Acceso al catálogo después de autenticación válida
    Dado que el cliente se ubica en la página de inicio de sesión
    Cuando el cliente ingresa sus credenciales válidas
      | usuario   | contraseña   |
      | <usuario> | <contraseña> |
    Entonces vera el titulo <titulo> en pantalla.
    Ejemplos:
      | usuario       | contraseña   | titulo   |
      | standard_user | secret_sauce | Products |
