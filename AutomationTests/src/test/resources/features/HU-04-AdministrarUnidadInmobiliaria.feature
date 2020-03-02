Feature: Administrar Unidad Inmobiliari
  Como usuario super administrador Quiero Administar la Unidad Inmobiliaria Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias
    And Da clic sobre la unidad inmobiliaria Bits

  Scenario: Información que se presenta al ingresar la opción de administrar Unidad Inmobiliaria
    Then El sistema muestra la informacion de la Unidad Inmobiliaria

  Scenario Outline: Realizar búsqueda de Agrupador de Unidad Inmobiliaria
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda | resultado             |
      | Torre 1    | Torre 1, Torre 10         |
      | Edificio 2 | Edificio 2 |

  Scenario Outline: Seleccionar icono de acciones
    When Selecciona una <opcion>
    Then El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear Agrupación
    When Da clic en Crear Agrupacion
    And El sistema redirecciona a la pagina de Crear Agrupacion