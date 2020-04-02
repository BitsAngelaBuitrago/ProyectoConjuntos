Feature: Administrar Tarjetas de Ingreso
  Como usuario super administrador Quiero Administar las Tarjetas de Ingreso Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Tarjetas de Ingreso

  Scenario: Información que se presenta al ingresar la opción de administrar Tarjetas de Ingreso
    Then El sistema presenta la Ruta de navegacion
    And Label Administracion de Tarjetas
    And Tabla de registros
    And Boton carga masiva
    And El boton de Crear ID

  Scenario Outline: Realizar búsqueda de Agrupador de Unidad Inmobiliaria
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda   | resultado         |
      | Torre 1    | Torre 1, Torre 10 |
      | Edificio 2 | Edificio 2        |

  Scenario: Comportamiento en cada uno de los filtros
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre el filtro Agrupaciones de Unidad Inmobiliaria
    Then El sistema presenta el listado de las agrupaciones

  Scenario Outline: Autocomplete de cada filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre el filtro Agrupaciones de Unidad Inmobiliaria
    And En Agrupacion Se ingresa <informacion>
    Then En Agrupacion muestra el <resultado>
    Examples:
      | informacion | resultado |
      | Torre 2     | Torre 2   |
      | Torre 12    | Torre 12  |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre el filtro Agrupaciones de Unidad Inmobiliaria
    And En Agrupacion Se ingresa <informacion>
    And En Agrupacion muestra el <resultado>
    Then EL usuario seleccion el primer elemento
    And Se muestran los resultados en la tabla
    Examples:
      | informacion | resultado |
      | Torre 2     | Torre 2   |
      | Torre 12    | Torre 12  |

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

  Scenario: Seleccionar Botón Parqueaderos
    When Da clic en Parqueaderos
    And El sistema redirecciona a la pagina de Administrar Parqueaderos