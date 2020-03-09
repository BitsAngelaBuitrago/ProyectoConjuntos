Feature: Administrar Personas Asociadas a Unidad Independiente
  Como usuario Quiero Administrar las Personas Asociadas a Unidad Independiente Para iniciar su gestión

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Administrar Personas Asociadas a Unidad Independiente

  Scenario: Información que se presenta al ingresar la opción de Administrar Personas Asociadas
    Then El sistema muestra la informacion de las Personas Asociadas a Unidad Independiente

  Scenario Outline: Realizar búsqueda de una Persona Asociada a Unidad Independiente
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda | resultado             |
      | Jose     | Jose Barbosa          |
      | NoExiste | No existe informacion |

  Scenario Outline: Comportamiento en cada uno de los filtros
    Given El usuario Da clic sobre la opción Filtros
    When Da clic en cada <filtro>
    Then El sistema presenta el listado del filtro seleccionado
    Examples:
      | filtro          |
      | Tipo de Persona |
      | # Documento     |
      | Nombre          |

  Scenario Outline: Autocomplete de cada filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic en cada <filtro>
    And Se ingresa <informacion> en el <filtro>
    Then se muestra el <resultado>
    Examples:
      | filtro          | informacion | resultado    |
      | Tipo de Persona | prop        | propietario  |
      | # Documento     | 34          | 345678       |
      | Nombre          | jo          | jose barbosa |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic en cada <filtro>
    And Se ingresa <informacion> en el <filtro>
    And se muestra el <resultado>
    Examples:
      | filtro          | informacion | resultado    |
      | Tipo de Persona | prop        | propietario  |
      | # Documento     | 34          | 345678       |
      | Nombre          | jo          | jose barbosa |

  Scenario Outline: Seleccionar icono de acciones
    When Selecciona una <opcion>
    Then El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | consultar | Pagina consultar |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear Persona asociada
    When Da clic en  Crear Persona asociada
    And El sistema redirecciona a la pagina de Crear Persona asociada

