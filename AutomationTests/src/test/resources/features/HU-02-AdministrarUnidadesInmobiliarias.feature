Feature: Administrar Unidades Inmobiliarias
  Como usuario super administrador Quiero Administar las Unidades Inmobiliarias Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias

  Scenario: Información que se presenta al ingresar la opción de administrar Unidades Inmobiliarias
    Then El sistema muestra la informacion de las Unidades Inmobiliarias

  Scenario Outline: Realizar búsqueda de una Unidad Inmobiliaria
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
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear Unidad Inmobiliaria
    When Da clic en  Crear Unidad Inmobiliaria
    And El sistema redirecciona a la pagina de Crear Unidad Inmobiliaria

