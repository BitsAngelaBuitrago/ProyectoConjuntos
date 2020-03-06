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


  Scenario: 3.Cerrar el mensaje ¿Esta seguro de que desea salir de la pagina crear Agrupador?
    Given Un usuario en la pagina de Crear agrupadores
    And   Sellecciona una de las <opciones_formulario> para salir del formulario
    When  Sellecciona una de las <opciones_mensaje> para cerrar el mensaje
    Then  El sistema debe realizar un <acciones> dependiendo de la opción seleccionada



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
      | tipo                              | valor  |
      | valido                            | 10     |
      | caracteres alfanumericos          | 55a    |
      | mas de 5 numeros                  | 123456 |
      | caracteres especiales con espacio | 12 (6  |


  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Agrupador, incluyendo caracteres especiales y el espacio
    Given  Un usuario en la página de Crear Agrupador
    And    el usuario Da clic en el campo Nombre Agrupador
    When   Ingressa un <tipo> de <valor> con unas <reglas> definidas para el <campo>
    Then   El sistema realiza unas <acciones>

    Examples:
      | tipo                 | valor                |
      | Valido               | Agrupacion 4         |
      | mas de 50 caracteres | Se ingresa mas de 50 |

  Scenario Outline: 8.Se habilita botón de guardar
    Given  Un usuario en la página de Crear Agrupadores
    When   Realiza una <Accion> sobre un <campo>
    Then   El sistema presenta si o no <habilitado> el botón de guardar

    Examples:
      | Accion                                              | campo                        | habilitado |
      | borra toda la informacion                           | todos los campos             | no         |
      | ingresa informacion                                 | algunos campos               | no         |
      | Ingresa informacion que no cumple con la estructura | correo electronico, telefono | no         |


  Scenario:  9.Creación de Agrupador
    Given  Un usuario en la página de Crear Agrrupador
    And   Ingresa la información en cada uno de los campos requeridos de forma correcta
    When  Da cliic en el botón Guardar
    Then  El siistema realiza unas <validaciones> en los <campos> enviados


  Scenario Outline:  10.Validaciones que se realizan en la estructura del campo # Unidades Independientes al seleccionar el botón guardar
    Given   Se envía un <valor> para un <campo> de <tipo_de_campo>
    When    Se envía la petición al servicio web
    Then    El sistema realiza uunas <validaciones> en los campos enviados
    And     El sistema presenta un <resultado>

    Examples:
          | campo                          | validaciones                                                      |
          | numero Unidades Independientes | Minimo 1 caracter                                                 |
          | 123456                         | se debe presentar el mensaje maxima longitud es de 5 caracteres   |
          | Af545                          | se debe presentar el mensaje solo admite numeros                  |

  Scenario:  11.Validaciones que se realizan en la estructura del campo Nombre Agrupador, incluyendo caracteres especiales y el espacio al seleccionar el botón guardar
    Given     Se enviía un <valor> para un <campo> de <tipo_de_campo>
    When      See envía la petición al servicio web
    Then      El siistema realiza unas <validaciones> en los campos enviiados
    And       El siistema presenta un <resultado>


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