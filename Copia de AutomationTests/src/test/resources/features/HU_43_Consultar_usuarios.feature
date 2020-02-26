Feature: Un usuario ingresa a el sistema para crear el tipo de novedad

  Background: Administrar Usuarios
    Given   Un usuario ingresa a la url de la aplicación
   # And     Ingresa las credenciales correctamente
  #  And     Ingresa a la pantalla de Administrar Usuarios


  Scenario: Información que se presenta al seleccionar el botón de Consulta de Usuario
    Given Un usuario en la pagina de Administracion de Usuarios
    When  Selecciona el boton de consulta de Usuario
    Then  El sistema presenta un formulario ya diligenciado “Consulta de Usuario” sin opción de edicion

  Scenario Outline: 1.Salir del formulario de Consultar Usuario
    Given  Un usuario en la pagina de Consultar Usuario
    When   Selecciona una de las <opcion> para salir de formulario de Consultar Usuario
    Then   El sistema envia al usuario a la <pagina de redireccionada>

    Examples:
      |  opcion                           |    pagina de redireccionada          |
      |  pagina del menu                  |    Inicio                            |
      |  enlace de la ruta de navegacion  |    Enlace de la ruta de navegacion   |
      |  Boton Regresar                   |    Administracion de Usuarios        |



