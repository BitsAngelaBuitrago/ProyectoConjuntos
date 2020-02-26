Feature: Como usuario Quiero crear un Agrupador Para iniciar su gestión.

 # Background: Un usuario ingresa credencial correctamente ‘HU_35_Ingreso_credenciales_V1.0’
 #  Given Ingresa a la pantalla de Administrar Unidades Inmobiliarias
 # And Da clic sobre la Unidad Inmobiliaria deseada
 # And Da clicc en el Botón Crear Agrupador

  Scenario: 1.Información que se presenta al seleccionar el botón de crear
    Given  Un usuario en la pagina de Unidades inmobiliarias
    When   Sselecciona el botón de Crear
    Then   El sistema presenta un formulario “Crear Agrupador”
    And    El boton de guardar bloqueadoo

  Scenario Outline: 2.Salir del formulario de Creación de Agrupador
    Given    Un usuario en la pagina de Crear Agrupador
    When     Selecciona una de las <opciones> para salir de formulario de crear agrupador
    Then     El sistema presenta un <mensaje> junto con los botones Si y no
    And      La <Opcion> cerrar mensaje

    Examples:
      | Opcion                       | mensaje                                                     |
      | pagina del menu              | Esta seguro de que desea salir de la pagina crear Agrupador |
      | Enlace de ruta de navegacion | Esta seguro de que desea salir de la pagina crear Agrupador |
      | Iconoo de cerar cesion       | Esta seguro de que desea salir de la pagina crear Agrupador |


  Scenario Outline: 3.Cerrar el mensaje ¿Esta seguro de que desea salir de la pagina crear Agrupador?
    Given Un usuario en la pagina de Crear agrupadores
    And   Sellecciona una de las <opciones_formulario> para salir del formulario
    When  Sellecciona una de las <opciones_mensaje> para cerrar el mensaje
    Then  El sistema debe realizar un <acciones> dependiendo de la opción seleccionada

    Examples:
      | opciones_formulario             | opciones_mensaje | acciones                                                                                                                                                |
      | pagina del menu                 | Cerrar mensaje   | Cierra el mensaje dejando al usuario en el formulario de crear Agrupador sin borrar ningun dato                                                         |
      | pagina del menu                 | Boton No         | Cierra el mensaje dejando al usuario en el formulario de crear Agrupador sin borrar ningun dato                                                         |
      | pagina del menu                 | Boton Si         | * Cierra el mensaje    * Presenta la pagina seleccionada      * No conserva los datos del formulario de crear Agrupador                                 |
      | enlace de la ruta de navegacion | Cerrar mensaje   | Cierra el mensaje dejando al usuario en el formulario de crear Agrupador sin borrar ningun dato                                                         |
      | enlace de la ruta de navegacion | Boton No         | Cierra el mensaje dejando al usuario en el formulario de crear Agrupador sin borrar ningun dato                                                         |
      | enlace de la ruta de navegacion | Boton Si         | * Cierra el mensaje      * Presenta la pagina seleccionada       * No conserva los datos del formulario de crear Agrupador                              |
      | icono de cambiar de Agrupador   | Cerrar mensaje   | Cierra el mensaje dejando al usuario en el formulario de crear Agrupador sin borrar ningun dato                                                         |
      | icono de cerrar sesion          | Boton No         | Cierra el mensaje dejando al usuario en el formulario de crear Agrupador sin borrar ningun dato                                                         |
      | icono de cerrar sesion          | Boton Si         | Cierra el mensaje,  Cierra la sesion,  resenta la pagina de autenticacion,  No conserva los datos del formulario de crear Agrupador                     |


  Scenario Outline: 4.No ingresar información en los campos requeridos
    Given Un usuario en la pagina de Crearr Agrupador
    When  Da clicc en el <campo_requerido>
    And   da clic por fuera del campo
    Then  El siistema presenta un <mensaje> indicando que el campo es requerido
    And   El sistema debera indicar a nivel visual que el campo es obligatorio

    Examples:
      | campo_requerido                   | mensaje               |
      | Nombre Agrupador                  | El campo es requerido |
      | numero de Unidades Independientes | El campo es requerido |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    Given  Un usuario en la pagina de Crear Agrupadorr
    When   Realizar una <accion> sobre los campos
    Then   sistema presenta sí o no <habilitado> el boton de guardar

    Examples:
      | accion                                                      | habilitado     |
      | Ingresa informacion correcta en todos los campos requeridos | si se habilita |
      | Ingresa informacion en algunos campos requeridos            | no se habilita |
      | norra informacion en algunos campos requeridos              | no se habilita |


  Scenario Outline: 6.Ingresar informacion en campo # de Unidades Independientess
    Given   Un usuario en la pagina de Crearr Agrupadorr
    When    Ingresa un <tipo> de <valor> con unas <reglas> definidas para el <campo>
    Then    Ell sistema realiza si o no unas <acciones>

    Examples:
      | tipo                              | valor  | reglas                                                   | acciones                                                 |
      | valido                            | 10     | Minimo 1 caracter, Maximo 5 caracteres, Numerico         | no realiza ninguna accion el campo cumple con las reglas |
      | caracteres alfanumericos          | 55a    | solo admite numeros                                      | solo presenta en el campo los caracteres numericos    55 |
      | mas de 5 numeros                  | 123456 | solo admite 5 numeros como maximo                        | solo presenta en el campo hasta los 5 numeros     12345  |
      | caracteres especiales con espacio | 12 (6  | no admite caracteres especiales ni espacio               | solo presenta en el campo los caracteres numericos   126 |


  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Agrupador, incluyendo caracteres especiales y el espacio
    Given  Un usuario en la página de Crear Agrupador
    And    el usuario Da clic en el campo Nombre Agrupador
    When   Ingressa un <tipo> de <valor> con unas <reglas> definidas para el <campo>
    Then   El sistema realiza unas <acciones>

    Examples:
      | tipo                 | valor                | reglas                                                                                                                  | acciones                                                     |
      | Valido               | Agrupacion 4         | Minimo 1 caracter, Maximo 50 caracteres, Caracteres alfanumericos incluyendo caracteres especiales y el espacio         | no realiza ninguna accion el campo cumple con las reglas     |
      | mas de 50 caracteres | Se ingresa mas de 50 | solo admite 50 caracteres como maximo                                                                                   | solo presenta en el campo hasta los 50 caracteres ingresados |


  Scenario Outline: 8.Se habilita botón de guardar
    Given  Un usuario en la página de Crear Agrupadores
    When   Realiza una <Accion> sobre un <campo>
    Then   El sistema presenta si o no <habilitado> el botón de guardar

    Examples:
      | Accion                                              | campo                        | habilitado |
      | borra toda la informacion                           | todos los campos             | no         |
      | ingresa informacion                                 | algunos campos               | no         |
      | Ingresa informacion que no cumple con la estructura | correo electronico, telefono | no         |


  Scenario Outline:  9.Creación de Agrupador
    Given  Un usuario en la página de Crear Agrrupador
    And   Ingresa la información en cada uno de los campos requeridos de forma correcta
    When  Da cliic en el botón Guardar
    Then  El siistema realiza unas <validaciones> en los <campos> enviados

    Examples:
     # | campos                                      | validaciones                                                                                                                                                                                                                                                 | Accion                                         | acciones                                                                                                                                        |
     # | Nombre Agrupador                            | El nombre del Agrupador no debe existir en la base de datos de la Unidad Inmobiliaria.                                                                                                                                                                       | Ya existe el nombre ingresado                  | Debe presentar el siguiente mensaje <El nombre de la Agrupación ya está en uso, por favor ingresar uno diferente>                               |
     # | # Unidades Independientes                   | Al sumar el número ingresado en <Numero de Unidades Independientes> con el total de Unidades Independientes de las demás agrupaciones ya existentes, no exceda el número de unidades independientes contratadas desde la creación de la unidad inmobiliaria. | El número ingresado excede el número permitido | <Ha superado el número máximo de Unidades Independientes contratadas> No crea la Agrupador No borra la información de los campos del formulario |
    #  | Nombre Agrupador   #Unidades Independientes | Ambos campos deben cumplir con las validaciones del sistema                                                                                                                                                                                                  | Si las cumplen                                 | Se Crea el Agrupador y el sistema redirige al usuario a la página de “Administrar Unidad Inmobiliaria”                                          |


  Scenario Outline:  10.Validaciones que se realizan en la estructura del campo # Unidades Independientes al seleccionar el botón guardar
    Given   Se envía un <valor> para un <campo> de <tipo_de_campo>
    When    Se envía la petición al servicio web
    Then    El sistema realiza uunas <validaciones> en los campos enviados
    And     El sistema presenta un <resultado>

    Examples:
      | tipo_de_campo        | campo                           | validaciones                                                      | valor                | resultado                                            |
      | Numericos            | nuemero Unidades Independientes | Minimo 1 caracter                                                 | No se envia un valor | se debe presentar el mensaje El campo es requerido    |
#      | *Máximo 5 caracteres | 123456                    | se debe presentar el mensaje ‘máxima longitud es de 5 caracteres’ |
#      | *Numérico            | Af545                     | se debe presentar el mensaje ‘solo admite números’                |

  Scenario Outline:  11.Validaciones que se realizan en la estructura del campo Nombre Agrupador, incluyendo caracteres especiales y el espacio al seleccionar el botón guardar
    Given     Se enviía un <valor> para un <campo> de <tipo_de_campo>
    When      See envía la petición al servicio web
    Then      El siistema realiza unas <validaciones> en los campos enviiados
    And       El siistema presenta un <resultado>

    Examples:
      | tipo_de_campo                                               | campo            | validaciones                  | valor                                                              | resultado                                            |
      | alfanumericos incluyendo caracteres especiales y el espacio | Nombre Agrupador | Minimo 1 caracter             | No se envia un valor                                               | se debe presentar el mensaje El campo es requerido   |
#      |                                                             | *Máximo 50       | Se envía más de 50 caracteres | se debe presentar el mensaje ‘máxima longitud es de 50 caracteres’ |


  Scenario Outline:  12.Errores al seleccionar el botón guardar
    Given Un usuario en la págiina de Crear Agrupador
    And   Ingresa la información en cada uno de los campos requeriidos de forma correcta
    When  Da clic en ell botón Guardar
    Then  El sistema intenta guardar la información
    And  Se presenta un error de <tipo> 
    And  El sistema presenta un <mensaje> 
    And  El sistema no debe borrar a información de los campos del formulario

    Examples:
      | tipo                                            | mensaje                                                                                                             |
      | Error 500 se corresponden a errores del sistema | Se presenta el siguiente mensaje El proceso no se termino  satisfactoriamente. Intente nuevamente en unos segundos  |

  Scenario:  13. Error 400 al seleccionar el botón guardar
    Given Un usuario en la página de Unidades inmobiliarias
    And Seleccionaa el botón de Crearr
    And  Ingresa lla información en cada uno de los campos requeridos de forma correcta
    When  Da cliic en el botón Guardarr
    Then El sistema iintenta guardar la información
    And  Se prresenta un error de tiipo 400
    And  El sistema redirecciona a una página en la cual se debe información el error