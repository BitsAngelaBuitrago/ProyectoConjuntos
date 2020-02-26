Feature: Un usuario ingresa a el sistema para Modificar usuario

  Background: Administrar Usuarios
    Given   Un usuario ingresa a la url de la aplicación
   # And     Ingresa las credenciales correctamente
  #  And     Ingresa a la pantalla de Administrar Usuarios


  Scenario:  1.Información que se presenta al seleccionar el botón de Modificación de Usuario
    Given    Un usuario en la pagina de Administración de Usuarios
    When     hace clic en boton de Modificar de Usuario
    Then     El sistema presenta un formulario Modificación de Usuario
    And      El boton de guardar bloqueado en modificar

  Scenario Outline:   3.Cerrar el mensaje ¿Está seguro de que desea salir de la página Crear Usuario?
    Given   Un usuario en la página de Crear Usuario
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
    Given   Un esta usuario en la pagina de Crear Usuario
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

  Scenario Outline: 5.Se habilita sí o no botón de guardar
    Given se encuentra en Crear Usuario
    When Realiza una <accion> sobre los campos
    Then El sistema presenta sí o no <habilitado> el botón de guardar

    Examples:
      | accion                                                      | habilitado     |
      | Ingresa informacion correcta en todos los campos requeridos | si se habilita |
      | Ingresa informacion en algunos campos requeridos            | no se habilita |
      | Borra informacion en algunos campos requeridos              | no se habilita |


  Scenario: 6.Ingresar información en campo tipo Selección
    Given  Un usuario se encuentra en la pagina de Crear Usuario
    And Da clic en elññ <campo>
    When Selecciona del <listado> una <opcion>
    Then El sistema realiza las <validaciones> y la <acciones> consecuente

  #  Examples:

   #   | campo                     | listado                                                              | opcion                              |validaciones    |                                                       |         |
   #   | Tipo de Identificación    |  CC,TI ,NIT,RC,CE                                                    | CC                                  |ninguna         |
    #  | Rol                       |  Administrador,   Super Admin,   Residente,    Administrador recibos | Resiendente, Administrador recibos  |ninguna         |

  Scenario Outline:   7.Ingresar información en los campos tipo texto
    Given Un usuario en la pagina de Crear Usuarios
    And Da clic en el <campo>
    When Ingresa un <valor> el sistema valida las <reglas> definidas para el Campo <campo>
    Then El sistema realiza sí o no unas <acciones>

    Examples:
      | campo     | valor           |
      | Nombres   | Sandra          |
      | Apellidos | Barbosa Ramirez |
      | Nombres   | fabian          |

  Scenario Outline:   8.Ingresar información en campo numérico
    Given    Un usuario en la pagina de Crear Usuari
    And      Da clic en el campo numerico
    When     Ingresa un <valor> el sistema valida las <reglas> definidas para el Campo # Documento
    Then     El sistema realiza si o no unas <acciones>

    Examples:
      | valor                                                    |
      | 34743847                                                 |
      | AB23###%&                                                |
      | 83298493849389048329084902384923809085904830958309584390 |

  Scenario:   9.Enlace Tomar Foto
    Given  ingresa a la de pagina de Crear Usuario
    When   Da clic en tomar foto
    Then   El sistema presenta un pop up el cual permitira tomar una foto frontal de la persona o cargarla desde el computador
    And    El sistema carga la foto en la base de datos al dar clic en aceptar


  Scenario Outline:   10.Se habilita botón de guardar
    Given    Un usuario en la página de Administrar Usuarios
    When     Existen <n> usuarios de De Usuarios
    And      Se visualiza el paginador en la parte inferior de la pagina
    And      Se da clic en <numero>
    Then     Se mostraran los usuarios asignados por pagina

    Examples:
      | n  | numero |
      | 20 | 2      |
      | 40 | 4      |