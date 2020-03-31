Feature: Crear agrupador
  Como usuario Quiero crear un Agrupador Para iniciar su gestión.

  Background: Información que se debe presentar en el selector
    Given Que usuario ingresa a la pagina de inicio
    When Inicia sesión con un usuario
    Then El sistema presenta la ventana emergente de Selector
    And Da clic sobre la Unidad Inmobiliaria deseada

  Scenario: 1.Información que se presenta al seleccionar el botón de crear
    Given  Un usuario en la pagina de Unidades inmobiliarias
    When  Usuario da clic en el boton crear
    Then  El sistema presenta formulario Crear Agrupador
    And  el usuario voisualiza la ruta de navegacion
    And campo nombre agrupador
    And campo numero de unidades independientes
    And boton de guardar bloqueado

  Scenario Outline: 2.Salir del formulario de Creación de Agrupador
    Given Un usuario en la pagina de Crear Agrupador
    When Selecciona una <Opcion> para salir de formulario
    Then El sistema presenta pop up de confirmacion de salida
    And  El sistema presenta mensaje junto con los botones Si y no
    And  opcion cerrar mensaje

    Examples:

      | Opcion                 |
      | Parqueaderos           |
      | Unidades inmobiliarias |
      | Iconoo de cerar sesion |

  Scenario Outline: 3.Cerrar el mensaje Está seguro de que desea salir de la página crear Agrupador
    Given Un usuario en la pagina de Crear Agrupador
    And  Selecciona una <Opcion> para salir de formulario
    And  El sistema presenta pop up de confirmacion de salida
    And  El sistema presenta mensaje junto con los botones Si y no
    When Selecciona una <opciones_mensaje> para cerrar el mensaje
    Then El sistema debe realiza <acciones> dependiendo de la opción seleccionada

    Examples:

      | Opcion                 | opciones_mensaje | acciones                                                 |
      | Paqueaderos            | Si               | El sistema debera direccionarlo a la pagina seleccionada |
      | Unidades inmobiliarias | No               | El sistema debera dejarlo en la misma pagina             |
      | Iconoo de cerar sesion | X                | El sistema debera dejarlo en la misma pagina             |

  Scenario Outline: 4.No ingresar información en los campos requeridos
    Given Un usuario en la pagina de Crear Agrupador
    When  Da clic en <campo_requerido>
    And   da clic por fuera del campo
    Then  El sistema presenta mensaje indicando que el campo es requerido
    And   El sistema debera indicar a nivel visual que el campo es obligatorio

    Examples:
      | campo_requerido                   |
      | Nombre Agrupador                  |
      | numero de Unidades Independientes |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    Given  Un usuario en la pagina de Crear Agrupador
    When  ingresa al campo <nombre> agrupacion
    And   ingresa al campo <numero> de unidades
    Then  sistema presenta <habilitado> el boton de guardar

    Examples:
      | nombre      | numero | habilitado |
      | Agrupacion1 | 2      | Si         |
      | Agrupacion2 |        | No         |
      |             | 3      | No         |

  Scenario Outline: 6.Ingresar informacion en campo # de Unidades Independientess
    Given  Un usuario en la pagina de Crear Agrupador
    When Ingresa un <valor> para el campo numero de unidades independientes
    Then El sistema muestra el <resultado>
    And muestra un mensaje en caso de que el usuario ingrese letras en el campo

    Examples:
      | valor  | resultado |
      | 10     | 10        |
      | 55ab   | 55        |
      | 123456 | 123456    |
      | 12(6   | 126       |

  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Agrupador, incluyendo caracteres especiales y el espacio
    Given  Un usuario en la pagina de Crear Agrupador
    And  el usuario Da clic en el campo Nombre Agrupador
    When Ingresa un <valor> para el campo nombre de agrupador
    Then El sistema muestra <resultado>

    Examples:

      | valor                                                           | resultado                                             |
      | Agrupador 4                                                     | agrupador 4                                           |
      | 123456789123456789123456789123456789123456789123456789123456789 | 12345678912345678912345678912345678912345678912345678 |


  Scenario Outline:  9.Creación de Agrupador
    Given Un usuario en la pagina de Crear Agrupador
    When  ingresa al campo <nombre> agrupacion
    And   Ingresa <numero> para el campo nombre de agrupador
    And   da clic en boton guardar
    Then  sistema presenta el mensaje

    Examples:
      | nombre      | numero |
      | Agrupacion1 | 2      |
      | Agrupacion1 | 2      |
      | Agrupacion2 | 50     |
      |             | 3      |

  Scenario Outline:  12.Errores al seleccionar el botón guardar
    Given Un usuario en la pagina de Crear Agrupador
    And ingresa al campo <nombre> agrupacion
    And Ingresa <numero> para el campo nombre de agrupador
    When  da clic en boton guardar
    Then  El sistema presenta un <tipo_de_error>
    And   presenta un <mensaje>
    And   El sistema no debe borrar la información de los campos del formulario

    Examples:
      | tipo_de_error | mensaje                                                                                                            |
      | 500             | Se presenta el siguiente mensaje El proceso no se termino  satisfactoriamente. Intente nuevamente en unos segundos |
      | 400             | Se presenta el siguiente mensaje El proceso no se termino  satisfactoriamente. Intente nuevamente en unos segundos |
