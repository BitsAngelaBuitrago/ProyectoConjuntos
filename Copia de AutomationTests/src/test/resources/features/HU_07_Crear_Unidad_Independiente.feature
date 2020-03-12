Feature: Como usuario Quiero crear una unidad independiente

Background: Un usuario ingresa credencial correctamente ‘HU_35_Ingreso_credenciales_V1.0’
#    And Ingresa a la Ingresa las credenciales correctamente
#    And Ingresa a la pantalla de Administrar Unidades Inmobiliarias
#    And Ingresa a la Ingresa a la pantalla de la Unidad Inmobiliaria requerida
#    And Ingresa a la pantalla de Administrar Agrupador


  Scenario: 1.Información que se presenta al seleccionar el botón de crear
   Given  Un usuario en la página de Administrar Unidad Independiente
   When Selecciiona el boton de Crear
   Then El siistemaa presenta un formulario para Crear Unidad Independiente
   And  El botón de guardar bloqueado


  Scenario Outline: 2.Salir del formulario de Creación de Unidad Independiente
    Given  Un usuario en la página de Crear Unidad Independiente
    When  Selecciona una de las <opciones> para salir de formulario de crear Unidad Independiente
    Then El siiistema presenta un <mensaje> junto con los botones Sii y No
    And La <opcion> de cerrar mensajee

    Examples:
   |opcion                          |
   |pagina del menu                 |
   |enlace de la ruta de navegacion |
   |icono de cerrar sesion          |

  Scenario Outline: 3.Cerrar el mensaje ¿Está seguro de que desea salir de la página crear Unidad Independiente?
#    Given Un usuariio en la página de Crear Unidad Independiente
    And  Seleccciona una de las <opciones_formulario> para salir del formulario
    When Selecciiona una de las <opciones_mensaje> para cerrar el mensaje
    Then El sistema debe realizar unas <acciones> dependiendo de la opción seleccionada

    Examples:

   |opciones_formulario               | opciones_mensaje  |
   |pagina del menu                   | Cerrar mensaje    |
   |pagina del menu                   | Boton No          |
   |pagina del menu                   | Boton Si          |
   |enlace de la ruta de navegacion   | Cerrar mensaje    |
   |enlace de la ruta de navegacion   | Boton No          |
   |enlace de la ruta de navegacion   | Boton Si          |
   |Cerrar mensaje                    | Cierra el mensaje |
   |icono de cerrar sesion            | Boton No          |
   | icono de cerrar sesion           | Boton Si          |


  Scenario Outline: 4.No ingresar información en los campos requeridos
    Given Un usuario en la página de Crear Unidad Independiente
    And Da cliic por fuera del campo
    When Da cliic en el <campo_requerido>
    Then El sistema presenta un <mensaje> indicando que el campo es requeriido

    Examples:
   |campo_requerido               |
   |Nombre Unidad Independiente   |
   |numero  Catastro              |
   |Metros Cuadrados              |

  Scenario Outline: 5.Se habilita si o no botón de guardar
    Given  Un usuario en la página de Crear Unidad Independiente
    When Realiiiza una <accion> sobre los campos
    Then  El siistema presenta si o no <habilitado> el botón de guardar

    Examples:
   |accion                                                      |habilitado       |
   |Ingresa informacion correcta en todos los campos requeridos |si se habilita   |
   |Ingresa informacion en algunos campos requeridos            |no se habilita   |
   |Borra informacion en algunos campos requeridos              |no se habilita   |


  Scenario Outline: 6.Ingresar información en campo numérico
    Given Un usuario en la página de Crear Unidad Independiente
    And   Da cliiic en el <campo>
    When  Ingresa un <tipo> de <valor> con unas <reglas> definiidas para el <campo>
    Then  El sistema realiza síi o no unas <acciones>

Examples:

  |campo            |valor  |
  |Numero Catastro  |10     |
  |Numero Catastro  |55a    |
  |Numero Catastro  |123456 |
  |Numero Catastro  |12 (6  |
  |Metros Cuadrados |55a    |
  |Metros Cuadrados |123456 |

  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Unidad Independiente, incluyendo caracteres especiales y el espacio
    Given Un usuario en la página de Crear Unidad Independiente
    And  Da clic en el campo Nombre Unidad Independienteee
    When Ingreeesa un <tipo> de <valor> con unas <reglas> definidas para el <campo>
    Then  El sistema realizaa unas <acciones>

    Examples:

     | valor                  |
     |Unidad Independiente 4  |
     |Se ingresa mas de 50    |


  Scenario Outline: 8.Se habilita botón de guardar
#    Given  Un usuario en la página de Crear Unidad Independientes
    When  Realiza una <accion> sobre uno de los <campo>
    Then El sistema presenta sii o no <habilitado> el botón de guardar

Examples:

  |campo                          |habilitado|
  |todos los campos               |no        |
  |algunos campos                 |no        |
  |correo electronico, telefono   |no        |
  |todos los campos               |si        |


  Scenario Outline: 9.Creación de Unidad Independiente
    Given   Un usuario en la página de Crear Unidad Independiente
    And     Ingresa la informaciion en cada uno de los campos requeridos de forma correcta
    When    Da cliic en el boton Guardarr
    Then    El sistema realiiza unas <validaciones> en los <campos> enviados

Examples:
|campos                                                       |
|Nombre Unidad Independiente                                  |
|numero Catastro                                              |
|Metros Cuadrados                                             |
|Nombre Unidad Independiente Numero Catastro Metros Cuadrados |


  Scenario Outline: 10.Validaciones que se realizan en la estructura del <campo> al seleccionar el botón guardar
    Given  Se envía <valor> para un <campo> de tipo de campo
    When  Se envía la peticion al servicio web
    Then  El sistema realiiza unas <validaciones> en los campos enviiados
    And   El siiistema presenta un <resultado>

  Examples:
 |campo            |valor                 |
 |Numero catastro  |No se envia un valor  |
 |Numero catastro  |123456                |
 |Numero catastro  |Af545                 |
 |Metros Cuadrados |No se envia un valor  |
 |Metros cuadrados |123456                |
 |Metros cuadrados |Af545se               |


  Scenario Outline: 11.Validaciones que se realizan en la estructura del campo Nombre Unidad Independiente, incluyendo caracteres especiales y el espacio al seleccionar el botón guardar
    Given  Se envía un <valor> para un <campo> dee <tipo_de_campo>
    When  Se envía la petiición al servicio web
    Then  El siistema realiza unas <validaciones> en los campos enviiadoss
    And El sisstema presenta un <resultado>

Examples:

 |campo                         |valor                                                                                          |
 | Nombre Unidad Independiente  |Se envia mas de 50 caracteres  se debe presentar el mensaje maxima longitud es de 50 caracteres|


  Scenario Outline: 12.Errores al seleccionar el botón guardar
    Given  Un usuario en la página de Crear Unidad Independiente
    And Ingressa la información en cada uno de los campos requeridos de forma correcta
    When Da cliic en el bootón Guardarr
    Then El sistema intentaa guardar la información
    And Se preseenta un error de <tipo>
    And El sisteema presenta un <mensaje>
    And El sistema no debee borrar a información de los campos del formulario

Examples:

  |tipo                                            |
  |Error 500 se corresponden a errores del sistema |

  Scenario: 13.Error 400 al seleccionar el botón guardar
#    Given Un usuarioo en la página de Unidades inmobiliarias
    And  Selecciona el botón de Ccrear
    And  Ingresa la información en cada uno de los campos requeridos de forma correctaa
    When  Da cliiic en el botón Guardar
    Then El siistema intenta guardar la información
    And  Se presentaa un error de tipo 400
    And  El sistema redirecciona a una págiina en la cual se debe información el error

