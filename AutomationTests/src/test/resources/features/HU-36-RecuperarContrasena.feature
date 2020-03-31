Feature: Como usuario Quiero recuperar la contraseña Para ingresar a la aplicación

  Scenario: Un usuario ingresa a la aplicación de conjuntos
    When Que usuario ingresa a la pagina de inicio
    And Da clic en el enlace ¿Olvidaste tu contrasena?

  Scenario: Seleccionar el botón de volver
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    When Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación

  Scenario: No ingresar información en el campo usuario
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    When Da clic en usuario
    And Da clic por fuera del campo
    Then Se muestra el mensaje de campo obligatorio
    And El sistema presenta inhabilitado el botón Enviar

  Scenario Outline: Habilitación del botón de enviar
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    Then El sistema presenta habilitado el botón Enviar
    Examples:
      | usuario  |
      | usuario  |
      | usuario1 |
      | usuario2 |

  Scenario Outline: Ingreso de información para recuperar la contraseña
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    When Da clic en el boton Enviar
    Then El sistema presenta el mensaje <Mensaje>
    And El sistema borra la información del campo usuario
    Examples:
      | usuario | Mensaje                                                                                                       |
      |         | Usuario invalido                                                                                              |
      |         | El usuario no se encuentra activo                                                                             |
      |         | Debes tener un nuevo email en tu correo electronico admi...bits.com para que puedas restablecer la contrasena |

  Scenario Outline: Selección del botón de volver al realizar la recuperación de contraseña
    Given Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    When Da clic en el boton Enviar
    And El usuario visualiza el mensaje de exito
    When Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación
    Examples:
      | usuario  |
      | usuario  |
      | usuario1 |
      | usuario2 |