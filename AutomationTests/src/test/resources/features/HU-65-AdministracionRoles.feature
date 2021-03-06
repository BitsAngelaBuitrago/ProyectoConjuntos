Feature: Administrar roles y permisos
  Como usuario super administrador Quiero Administar los roles con sus permisos Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Configuracion
    And Da clic en Roles

  Scenario: Información que se presenta al ingresar la opción de administrar roles
    Then El sistema muestra la informacion de los roles existentes

  Scenario Outline: Realizar búsqueda de un rol
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda | resultado             |
      | Admin    | Administrador         |
      | NoExiste | No existe informacion |


  Scenario Outline: Seleccionar icono de acciones
    When Selecciona una <opcion>
    Then El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | consultar | Pagina consultar |
      | Eliminar  | presenta mensaje |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |

  Scenario Outline: Inactivar Rol
    When Da clic en inactivar rol
    And El sistema presenta un mensaje de inactivacion
    Then El usuario da clic en <opcion> de inactivacion y se realiza una accion
    Examples:
      | opcion |
      | si     |
      | no     |


  Scenario Outline: Activar rol
    When Da clic en activar rol
    And El sistema presenta un mensaje de activacion
    Then El usuario da clic en <opcion> de activacion y realiza una accion
    Examples:
      | opcion |
      | si     |
      | no     |

  Scenario Outline: Eliminar Rol
    When Da clic sobre el icono de Eliminar rol de Admin
    And Presenta un pop up de Eliminación
    And El sistema presenta mensaje de eliminación
    And Las opciones de Si y no
    And  Da clic sobre la <opcion>
    Then El sistema tiene el <resultado>

    Examples:
      | opcion | resultado        |
      | si     | Elimina el rol   |
      | no     | Cierra el pop up |

