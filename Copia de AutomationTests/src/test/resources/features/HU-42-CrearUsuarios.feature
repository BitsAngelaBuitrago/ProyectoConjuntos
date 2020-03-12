Feature: Un usuario ingresa a el sistema para crear usuario

  Background: Administrar Usuarios
    Given   Un usuario ingresa a la url de la aplicación
   # And     Ingresa las credenciales correctamente
  #  And     Ingresa a la pantalla de Administrar Usuarios


  Scenario:   1.Información que se presenta al seleccionar el botón de Creación de Usuario
    Given Un usuario en la pagina de Administracion de Usuarios
    When  Selecciona el boton de creacion de Usuario
    Then El sistema presenta un formulario “Creación de Usuario”
    And El boton de guardar bloqueado

  Scenario Outline:   2.Salir del formulario de Crear Usuario
    Given  Un usuario en la pagina de Crear Usuario
    When   Selecciona una de las <opciones> para salir de formulario de Crear Usuario
    Then   El sistema presenta un <mensaje> junto con los botones Si y No
    And    La opcion cerrar mensaje

    Examples:
      | opciones                        | mensaje                                                   |
      | pagina del menu                 | Esta seguro de que desea salir de la pagina Crear Usuario |
      | enlace de la ruta de navegacion | Esta seguro de que desea salir de la pagina Crear Usuario |
      | boton cancelar                  | Esta seguro de que desea salir de la pagina Crear Usuario |

  Scenario Outline:   3.Cerrar el mensaje ¿Está seguro de que desea salir de la página Crear Usuario?
#    Given   Un usuario en la página de Crear Usuario
    When    Selecciona una de las <opciones_mensaje> para cerrar el mensaje
    Then    El sistema debe realizar unas <acciones> dependiendo de la opción seleccionada en las <opciones_formulario>

    Examples:
      | opciones_formulario             | opciones_mensaje |
      | pagina del menu                 | Cerrar mensaje   |
      | pagina del menu                 | Boton No         |
      | pagina del menu                 | Boton Si         |
      | enlace de la ruta de navegacion | Cerrar mensaje   |
      | enlace de la ruta de navegacion | Boton No         |
      | icono de cambiar de ID          | Boton Si         |
      | icono de cerrar sesion          | Cerrar mensaje   |
      | icono de cerrar sesion          | Boton No         |

  Scenario Outline:   4.No ingresar o seleccionar información en los campos requeridos
#    Given   Un esta usuario en la pagina de Crear Usuario
    When    Da clic en el <campo_requerido>
    And     Da clic por fuera del campo
    Then    El sistema presenta un <mensaje> indicando que el campo es requerido
    And     El sistema debe indicar a nivel visual que el campo es obligatorio

    Examples:
      | campo_requerido          | mensaje               |
      | Tipo de Identificacion   | El campo es requerido |
      | Numero de Identificacion | El campo es requerido |
      | Nombres                  | El campo es requerido |
      | Apellidos                | El campo es requerido |
      | Telefono                 | El campo es requerido |
      | Rol                      | El campo es requerido |

  Scenario Outline:  5.Se habilita sí o no botón de guardar
#    Given se encuentra en Crear Usuario
    When  Realiza una <accion> sobre los campos
    Then El sistema presenta sí o no <habilitado> el botón de guardar

    Examples:
      | accion                                                      | habilitado     |
      | Ingresa informacion correcta en todos los campos requeridos | si se habilita |
      | Ingresa informacion en algunos campos requeridos            | no se habilita |
      | Borra informacion en algunos campos requeridos              | no se habilita |


  Scenario:   6.Ingresar información en campo tipo Selección
#    Given    Un usuario se encuentra en la pagina de Crear Usuario
    And      Da clic en el1 campo
    When     Selecciona del <listado> una <opcion>
    Then     El sistema realiza las <validaciones> y la <acciones> consecuente


  Scenario Outline:   7.Ingresar información en los campos tipo texto
#    Given       Un usuario en la pagina de Crear Usuarios
    And         Da clic en el <campo>
    When        Ingresa un <valor> el sistema valida las <reglas> definidas para el Campo <campo>
    Then        El sistema realiza sí o no unas <acciones>

    Examples:
      | campo     | valor           |
      | Nombres   | Sandra          |
      | Apellidos | Barbosa Ramirez |
      | Nombres   | fabian          |

  Scenario Outline:   8.Ingresar información en campo numérico
#    Given    Un usuario en la pagina de Crear Usuari
    And      Da clic en el campo numerico
    When     Ingresa un <valor> el sistema valida las <reglas> definidas para el Campo # Documento
    Then     El sistema realiza si o no unas <acciones>

    Examples:
      | valor                                                    |
      | 34743847                                                 |
      | AB23###%&                                                |
      | 83298493849389048329084902384923809085904830958309584390 |


  Scenario:   9.Enlace agregar foto
#    Given  Un usuario en la página de Crear Usuario
    When  Da clic en el enlace tomar foto
    Then El sistema presenta un pop up el cual permitirá tomar una foto frontal de la persona o cargarla desde el computador.


  Scenario:   10.Opciones Agregar Foto
#    Given  Un usuario en la página de Crear Usuario
    When   Da clic en el Enlace Agregar Foto
    And   Da clic en la <opción>
    Then  El sistema realiza la <acción>


  Scenario:   11.Carga de Foto
#    Given  Un usuario en la página de Crear Usuario
    And  Agrega una Foto
    When Sube una Foto
    Then Se muestra un pop up de carga
    And El botón de Guardar inhabilitado


  Scenario:  12.Girar Foto
#    Given Un usuario en la página de Crear Usuario
    And Agrega una Foto
#    And Esta cargada la foto
    When Se da clic en el <sentido> del giro
    Then  Se muestra la foto rotada 90 grados hacía el sentido seleccionado


  Scenario:   13.Enlace Tomar Foto
#    Given  ingresa a la de pagina de Crear Usuario
    And    Esta cargada la foto
    When   Se da clic en la foto
    And    Se selecciona una <opción>
    Then  Se realiza la <acción>


  Scenario:   14.Enlace eliminar foto
#    Given  Un usuario en la página de Crear Usuario
    And    Esta cargada la foto
    And    Se guardó
    When   da clic en la foto
    And    Se selecciona Eliminar Foto
    And    Selecciona la <opción>
    Then   Se realiza la <acción>


   Scenario:   15.Se habilita botón de guardar
#    Given    Un usuario en la página de Administrar Usuarios
    When Realiza una acción sobre un campo
    Then El sistema presenta sí o no habilitado el botón de guardar


  Scenario Outline: 16.Crear Usuario
#  Given  Un usuario en la página de Crear Usuario
  And  Ingresa la información en cada uno de los <campos> requeridos de forma correcta
  When Da clic en el botón Guardar
  Then El sistema realiza el registro de Ingreso del Usuario exitosamente y muestra el mensaje “los <registros> <ingresados> ha sido creado exitosamente”
  And  El sistema debera realizar unas <acciones>

    Examples:
    |campos                     |registros     | ingresados   | acciones                        |
    |Numero de identificacion   |Registro 1    | 1023654789   | Valida que el dato no exista en base de datos|
    |Numero de identificacion   |Registro 2    | 1023654789   | El sistema debera retornar un mensaje que diga el numero de identificacion ya existe|


   Scenario:   17.Errores al seleccionar el botón guardar
#     Given Un usuario en la página de Crear Usuario
     And  Ingresa la información en cada uno de los campos requeridos de forma correcta
     When Da clic en el Botón_Guardar
     Then El sistema intenta guardar la información
     And  Se presenta un error de <tipo>
     And  El sistema presenta un <mensaje> 
     And  El sistema no debe borrar a información de los campos del formulario


  Scenario:  18.Error 400 al seleccionar el botón guardar
#     Given  Un usuario en la página de Unidades inmobiliarias
     And  Selecciona el botón de Crear
     And  Ingresa la información en cada uno de los campos requeridos de forma correcta
     When Da clic en el botón Guardar
     Then El sistema guardar la información
     And Se presenta un error de tipo 400
     And El sistema redirecciona a una página en la cual se debe información el error