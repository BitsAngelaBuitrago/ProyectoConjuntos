Feature: Como usuario Quiero crear una unidad independiente

Background: Un usuario ingresa credencial correctamente ‘HU_35_Ingreso_credenciales_V1.0’
#    And Ingresa a la
#    And Ingresa a la pantalla de Administrar Unidades Inmobiliarias
#    And Ingresa a la


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
   |opcion                          |mensaje|
   |pagina del menu                 | ¿Esta seguro de que desea salir de la pagina crear Unidad Independiente?|
   |enlace de la ruta de navegacion | ¿Esta seguro de que desea salir de la pagina crear Unidad Independiente?|
   |icono de cerrar sesion          | ¿Esta seguro de que desea salir de la pagina crear Unidad Independiente?|

  Scenario Outline: 3.Cerrar el mensaje ¿Está seguro de que desea salir de la página crear Unidad Independiente?
    Given  Un usuariio en la página de Crear Unidad Independiente
    And  Seleccciona una de las <opciones_formulario> para salir del formulario
    When Selecciiona una de las <opciones_mensaje> para cerrar el mensaje
    Then El sistema debe realizar unas <acciones> dependiendo de la opción seleccionada

Examples:

|opciones_formulario               | opciones_mensaje  | acciones|
|pagina del menu                   | Cerrar mensaje    | Cierra el mensaje dejando al usuario en el formulario de crear Unidad Independiente sin borrar ningun dato|
|pagina del menu                   | Boton No          | Cierra el mensaje dejando al usuario en el formulario de crear Unidad Independiente sin borrar ningun dato|
|pagina del menu                   | Boton Si          | Cierra el mensaje       Presenta la pagina seleccionada       No conserva los datos del formulario de crear Unidad Independiente|
|enlace de la ruta de navegacion   | Cerrar mensaje    | Cierra el mensaje dejando al usuario en el formulario de crear Unidad Independiente sin borrar ningun dato             |
|enlace de la ruta de navegacion   | Boton No          | Cierra el mensaje dejando al usuario en el formulario de crear Unidad Independiente sin borrar ningun dato              |
|enlace de la ruta de navegacion   | Boton Si          | Cierra el mensaje    Presenta la pagina seleccionada    No conserva los datos del formulario de crear Unidad Independiente   icono de cambiar de Unidad Independiente|
|Cerrar mensaje                    | Cierra el mensaje | dejando al usuario en el formulario de crear Unidad Independiente sin borrar ningun dato  |
|icono de cerrar sesion            | Boton No          | Cierra el mensaje dejando al usuario en el formulario de crear Unidad Independiente sin borrar ningun dato|
|icono de cerrar sesion            | Boton Si          | Cierra el mensaje  Cierra la sesion   Presenta la pagina de autenticacion  No conserva los datos del formulario de crear Unidad Independiente|


  Scenario Outline: 4.No ingresar información en los campos requeridos
    Given Un usuario en la página de Crear Unidad Independiente
    And Da cliic por fuera del campo
    When Da cliic en el <campo_requerido>
    Then El sistema presenta un <mensaje> indicando que el campo es requeriido

    Examples:
   |campo_requerido               |mensaje|
   |Nombre Unidad Independiente   |El campo es requerido |
   |numero  Catastro              |El campo es requerido |
   |Metros Cuadrados              |El campo es requerido |

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

  |campo            |valor  |reglas                                                                                    |acciones|
  |Numero Catastro  |10     |Minimo 1 caracter  Maximo 5 caracteres Numerico                                           | no realiza ninguna accion el campo cumple con las reglas |
  |Numero Catastro  |55a    |solo admite numeros                                                                       | solo presenta en el campo los caracteres numericos  55   |
  |Numero Catastro  |123456 |solo admite 5 numeros como maximo                                                         | solo presenta en el campo hasta los 5 numeros  12345     |
  |Numero Catastro  |12 (6  |no admite caracteres especiales ni espacio                                                | solo presenta en el campo los caracteres numericos  126  |
  |Metros Cuadrados |10     |Minimo 1 caracter  Maximo 5 caracteres  Numerico                                          | no realiza ninguna accion el campo cumple con las reglas |
  |Metros Cuadrados |55a    |solo admite numeros                                                                       | solo presenta en el campo los caracteres numericos  55   |
  |Metros Cuadrados |123456 |solo admite 5 numeros como maximo  solo presenta en el campo hasta los 5 numeros  12345   | solo presenta en el campo los caracteres numericos  126  |

  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Unidad Independiente, incluyendo caracteres especiales y el espacio
    Given Un usuario en la página de Crear Unidad Independiente
    And  Da clic en el campo Nombre Unidad Independienteee
    When Ingreeesa un <tipo> de <valor> con unas <reglas> definidas para el <campo>
    Then  El sistema realizaa unas <acciones>

Examples:

|tipo| valor| reglas| acciones|
|Valido | Unidad Independiente 4 | Minimo 1 caracter  Maximo 50 caracteres Caracteres alfanumericos incluyendo caracteres especiales y el espacio | no realiza ninguna accion el campo cumple con las reglas     |
|mas de 50 caracteres | Se ingresa mas de 50 | solo admite 50 caracteres como maximo                                                              | solo presenta en el campo hasta los 50 caracteres ingresados |


  Scenario Outline: 8.Se habilita botón de guardar
    Given  Un usuario en la página de Crear Unidad Independientes
    When  Realiza una <accion> sobre uno de los <campo>
    Then El sistema presenta sii o no <habilitado> el botón de guardar

Examples:

  |accion                                                |campo                          |habilitado|
  |borra toda la informacion                             |todos los campos               |no        |
  |ingresa informacion                                   |algunos campos                 |no        |
  |Ingresa informacion que no cumple con la estructura   |correo electronico, telefono   |no        |
  |ingresa informacion de forma correcta                 |todos los campos               |si        |


  Scenario Outline: 9.Creación de Unidad Independiente
    Given   Un usuario en la página de Crear Unidad Independiente
    And     Ingresa la informaciion en cada uno de los campos requeridos de forma correcta
    When    Da cliic en el boton Guardarr
    Then    El sistema realiiza unas <validaciones> en los <campos> enviados

Examples:
|campos                                                       |validaciones
|Nombre Unidad Independiente                                  |El nombre de la Unidad Independiente no debe existir en la base de datos de la Unidad Inmobiliaria.           Ya existe el nombre ingresado                               Debe presentar el siguiente mensaje <El nombre de la Unidad Independiente ya está en uso, por favor ingresar uno diferente> No crea la Unidad Independiente  No borra la información de los campos del formulario|
|numero Catastro                                              |El # de catastro de la Unidad Independiente no debe existir en la base de datos de la Unidad Inmobiliaria.    Ya existe el nombre ingresado                               Debe presentar el siguiente mensaje <El número de Catastro de la Unidad Independiente ya está en uso, por favor ingresar uno diferente> No crea la Unidad Independiente No borra la información de los campos del formulario|
|Metros Cuadrados                                             |El campo debe estar diligenciado  Se valida que el campo no esté vacío                                        Debe presentar el siguiente mensaje <Campo requerido>       No crea la Unidad Independiente|
|Nombre Unidad Independiente Numero Catastro Metros Cuadrados |Todos los campos deben cumplir con las validaciones del sistema                                               Si las cumplen Se Crea el Unidad Independiente              el sistema redirige al usuario a la página de “Administrar Unidad Independiente”|


  Scenario Outline: 10.Validaciones que se realizan en la estructura del <campo> al seleccionar el botón guardar
    Given  Se envía <valor> para un <campo> de tipo de campo
    When  Se envía la peticion al servicio web
    Then  El sistema realiiza unas <validaciones> en los campos enviiados
    And   El siiistema presenta un <resultado>

Examples:

 |campo            | validaciones                 |valor                 |resultado                                                          |
 |Numero catastro  |Catastro  *Minimo 1 caracter  |No se envia un valor  |se debe presentar el mensaje El campo es requerido                 |
 |Numero catastro  |*Maximo 5 caracteres          |123456                |se debe presentar el mensaje maxima longitud es de 5 caracteres    |
 |Numero catastro  |*Numerico                     |Af545                 |se debe presentar el mensaje solo admite numeros                   |
 |Metros Cuadrados |*Minimo 1 caracter            |No se envia un valor  |se debe presentar el mensaje El campo es requerido                 |
 |Metros cuadrados |*Maximo 5 caracteres          |123456                |se debe presentar el mensaje maxima longitud es de 5 caracteres    |
 |Metros cuadrados |*Numerico                     |Af545se               |Se debe presentar el mensaje solo admite numeros                   |


  Scenario Outline: 11.Validaciones que se realizan en la estructura del campo Nombre Unidad Independiente, incluyendo caracteres especiales y el espacio al seleccionar el botón guardar
    Given  Se envía un <valor> para un <campo> dee <tipo_de_campo>
    When  Se envía la petiición al servicio web
    Then  El siistema realiza unas <validaciones> en los campos enviiadoss
    And El sisstema presenta un <resultado>

Examples:

|tipo_de_campo                                              |campo                        |validaciones                                                                                            |valor|
|alfanumericos incluyendo caracteres especiales y el espacio| Nombre Unidad Independiente |Minimo 1 caracter No se envia un valor se debe presentar el mensaje ‘El campo es requerido Maximo 50    | Se envia más de 50 caracteres  se debe presentar el mensaje ‘maxima longitud es de 50 caracteres’ |


  Scenario Outline: 12.Errores al seleccionar el botón guardar
    Given  Un usuario en la página de Crear Unidad Independiente
    And Ingressa la información en cada uno de los campos requeridos de forma correcta
    When Da cliic en el bootón Guardarr
    Then El sistema intentaa guardar la información
    And Se preseenta un error de <tipo>
    And El sisteema presenta un <mensaje>
    And El sistema no debee borrar a información de los campos del formulario

Examples:

  |tipo                                            | mensaje|
  |Error 500 se corresponden a errores del sistema | Se presenta el siguiente mensaje ‘El proceso no se termino satisfactoriamente. Intente nuevamente en unos segundos |

  Scenario: 13.Error 400 al seleccionar el botón guardar
    Given Un usuarioo en la página de Unidades inmobiliarias
    And  Selecciona el botón de Ccrear
    And  Ingresa la información en cada uno de los campos requeridos de forma correctaa
    When  Da cliiic en el botón Guardar
    Then El siistema intenta guardar la información
    And  Se presentaa un error de tipo 400
    And  El sistema redirecciona a una págiina en la cual se debe información el error

