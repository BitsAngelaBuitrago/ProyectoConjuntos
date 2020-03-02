Feature: Como usuario Quiero recuperar la contraseña Para ingresar a la aplicación

  Scenario: Un usuario ingresa a la aplicación de conjuntos
    When Que usuario ingresa a la pagina de inicio
    And Da clic en el enlace ¿Olvidaste tu contrasena?

  Scenario: Seleccionar el botón de volver
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    When Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación

  Scenario: Habilitación del botón de enviar
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de usuario en el campo de usuario
    Then El sistema presenta habilitado el botón Enviar

  Scenario Outline: Ingreso de información para recuperar la contraseña
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    When Da clic en el boton Enviar
    Then El sistema presenta el mensaje <Mensaje>
    And El sistema borra la información del campo usuario
    Examples:
      | Descripcion           | usuario | Mensaje                                                                                                       |
      | un usuario incorrecto |         | Usuario invalido                                                                                              |
      | un usuario inactivo   |         | El usuario no se encuentra activo                                                                             |
      | un usuario activo     |         | Debes tener un nuevo email en tu correo electronico admi...bits.com para que puedas restablecer la contrasena |

  Scenario: Selección del botón de volver al realizar la recuperación de contraseña
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    When Da clic en el boton Enviar
    And El usuario visualiza el mensaje de exito
    When Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación
