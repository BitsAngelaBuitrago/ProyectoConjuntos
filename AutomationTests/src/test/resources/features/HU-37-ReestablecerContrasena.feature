Feature: Reestablecer Contraseña
  Como usuario Quiero reestablecer la contraseña Para ingresar a la aplicación

  Scenario: Seleccionar el botón de volver
    Given Un usuario en la página de reestablecer contrasena
    When Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación

  Scenario Outline: No ingresar información en los campos requeridos
    Given Un usuario en la página de reestablecer contrasena
    When Da clic en el campo requerido <campo_requerido>
    And Da clic por fuera del campo
    Then El sistema presenta un mensaje indicando que el campo es requerido
    Examples:
      | campo_requerido         |
      | Nueva contrasena        |
      | Confirmacion contrasena |

  Scenario Outline: Ingresar una nueva contraseña
    Given Un usuario en la página de reestablecer contrasena
    When Ingresa la <contrasena> en el campo nueva contrasena
    Then El sistema informa que la nueva contraseña ingresada cumple con las reglas
    Examples:
      | contrasena |
      | Bits2019   |

  Scenario Outline: Ingresar la confirmación de la contraseña
    Given Un usuario en la página de reestablecer contrasena
    When Ingresa la confirmación de la <confirmacionContrasena>
    Then El sistema informa que la confirmación de la contraseña ingresada cumple con las reglas
    Examples:
      | confirmacionContrasena |
      | Bits2019               |

  Scenario Outline: Mensaje que se debe presentar al colocar el cursor en el icono de correcto (chek) o de incorrecto(x) en el campo Nueva contraseña
    Given Un usuario en la página de reestablecer contrasena
    And Ingresa la <contrasena> en el campo nueva contrasena
    And Ingresa la confirmación de la <confirmacionContrasena>
    When Coloca el cursor encima del icono de check o x
    Then El sistema muestra el mensaje <mensaje>
    Examples:
      | contrasena | confirmacionContrasena | mensaje                                                     |
      | Bits2019   | Bits2019               | "Cumple las reglas"                                         |
      | Bits20     | Bits20                 | "Minimo debe tener 1 mayuscula, 1 minuscula y 6 caracteres" |
      | Bits2019   | Bits201                | "Las contrasenas no coinciden"                              |

  Scenario Outline: Realizar restablecimiento de contraseña exitosamente
    Given Un usuario en la página de reestablecer contrasena
    And Ingresa la <contrasena> en el campo nueva contrasena
    And Ingresa la confirmación de la <confirmacionContrasena>
    When Da clic en el botón reestablecer
    Then El sistema muestra el mensaje <mensaje>
    Examples:
      | contrasena | confirmacionContrasena | mensaje                                        |
      | Bits2019   | Bits2019               | "La contrasena fue restablecida correctamente" |

  Scenario Outline: Se selecciona el botón de ingresar después de realizar el restablecimiento
    Given Un usuario en la página de reestablecer contrasena
    And Ingresa la <contrasena> en el campo nueva contrasena
    And Ingresa la confirmación de la <confirmacionContrasena>
    And Da clic en el botón reestablecer
    And Da clic en el botón Ingresar
    Then El sistema presenta la página de autenticación de la aplicación
    Examples:
      | contrasena | confirmacionContrasena |
      | Bits2019   | Bits2019               |
      | Bits20     | Bits20                 |