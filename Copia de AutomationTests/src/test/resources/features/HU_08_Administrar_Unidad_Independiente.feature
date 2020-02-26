Feature: Administrar Unidad Independiente

  Background: Como usuario Quiero Administrar la Unidad Independiente seleccionada Para iniciar su gestión.
#    And Ingresa a la
#    And Ingresa a la pantalla de Administrar Unidades Inmobiliarias
#    And Ingresa a la


  Scenario: 1.Realizar una búsqueda de Personas asociadas a la Unidad Independiente
     Given  Se ubica el cursor en el campo de Consulta
     When  Un usuario ingresa una <palabra_clave> sobre el campo de consulta
     And  Da clic en el icono de buscar
     Then El sistema realiza la búsqueda de las Personas asociadas a la Unidad Independiente que contengan la <palabra_clave>
     And  Cargar en la lista del buscador de Personas asociadas a la Unidad Independiente el nombre de las Personas obtenidas en la consulta en el orden definido según los campos del "Entonces” anterior.


  Scenario Outline: 2.Comportamiento en cada uno de los filtros
    Given Da clic sobre la opción Filtros
    When Da clic en cada <filtro>
    Then El sistema presenta un <resultado> en el campo
    And  Con un tipo de selección <tipo_seleccion> para el campo

    Examples:

   |filtro            |   resultado                                                                                                                                    | tipo_seleccion   |
   | Nombre           |  presenta un listado con los nombres de las Personas asociadas a la Unidad Independiente asociadas a la agrupacion seleccionada.               | seleccion unica  |
   |numero Documento  |  presenta un listado con los numeros de Documento de las Personas asociadas a la Unidad Independiente asociadas a la agrupacion seleccionada.  | seleccion unica  |
   |Celular           |  presenta un listado con los Numeros de celular de las Personas asociadas a la Unidad Independiente asociadas a la agrupacion seleccionada.    | seleccion unica  |
   |Activa            |  presenta un listado con las Personas asociadas a la Unidad Independiente activas en la agrupacion seleccionada.                               | seleccion unica  |


  Scenario Outline: 3.Autocomplete de cada filtro
    Given  Que se ejecutó el Escenario 2
    When  Se vayan registrando <caracteres> en el <filtro>
    Then  Se debe mostrar la <lista> autocomplete de Personas asociadas a la Unidad Independiente asociadas al <filtro> con los valores que contengan los <caracteres> registrados actualmente.

Examples:

      |filtro            |caracteres       |lista                              |
      |Nombre            | Jose            | Jose Barbosa  Jose Ignacio Suarez |
      |Nombre            | No existe       | No se presenta lista              |
      |numero Documento  | 500900          | 500900  5009001                   |
      |numero Documento  | 0000            | No se presenta lista              |
      |Celular           | 5               | 5435435435  5933453543            |
      |Celular           | 0000            | No se presenta lista              |
      |Activa            | San             | Sandra Velandia                   |
      |Activa            | No existe       | No se presenta lista              |
      |Propietario       | Jose            | Jose Barbosa                      |

  Scenario Outline: 4.Seleccionar un elemento de la lista presentada en el filtro
    Given  Que se ejecutó el Escenario 3
    When   Se selecciona un <elemento> de la <lista> presentada en el <filtro>
    Then   Se debe mostrar el <elemento> de la <lista> seleccionado en el mismo nivel que el <filtro> con la opción (x) para quitar éste.

    Examples:

   | filtro            |lista                                                           | elemento                |
   | Nombre            | Jose Barbosa    Alex Salcedo    Carlos Morales    Sandra Cojo  | Jose Barbosa            |
   | Nombre            | No se presenta lista                                           |  No se presenta lista   |
   | numero Documento  | 500900    5009001                                              |  5009001                |
   | numero Documento  | No se presenta lista                                           |  No se presenta lista   |
   | Celular           | 543445678    591111111                                         |  591111111              |
   | Celular           | No se presenta lista                                           |  No se presenta lista   |
   | Activa            | Jose Barbosa    Alex Salcedo    Carlos Morales    Sandra Cojo  |  Alex Salcedo           |
   | Activa            | No se presenta lista                                           |  No se presenta lista   |
   | Propietario       | Jose Barbosa    Juanita Acosta                                 |  Juanita Acosta         |

  Scenario Outline: 5.Realizar consulta de Personas asociadas a la Unidad Independiente por la opción de filtros
    Given  Que se ejecutó el Escenario 4
    When   Da clic sobre el botón de buscar
    Then  El sistema presenta un <resultado> que tenga la <información> del <filtro>
    And   En el campo de búsqueda se presenta la <elemento_seleccionado> que se haya seleccionado en el filtro
    And  se deben separar por punto y coma (;) la <elemento_seleccionado> que se hayan seleccionado en más de un filtro

    Examples:
    |filtro                        | Elemento seleccionado            | resultado                                                                         |
    |Nombre                        | Jose Barbosa                     | Presenta el nombre de la persona asociada a la Unidad Independiente, Jose Barbosa |
    |numero Documento              | 9000500                          | Presenta el nombre de la persona con el número de documento asociado a la Unidad Independiente, Jose Barbosa|
    |Celular                       | 59345434                         | Presenta el nombre de las Personas asociadas a la Unidad Independiente:    Sandra Jimenez    Activa    Jose Barbosa    Alex Salcedo    Carlos Morales    Sandra Cojo    Presenta el nombre de las personas activas asociadas a la Unidad Independiente:    Jose Barbosa    Alex Salcedo    Carlos Morales    Sandra Cojo|
    |Nombre y Documento            | Jose Barbosa; 9000500            | Presenta el nombre de las Personas asociadas a la Unidad Independiente:    Jose Barbosa  |
    |Documento, Celular y Activa   | 9000500; 32145645; Activa        | Presenta el nombre de las Personas asociadas a la Unidad Independiente:    Jose Barbosa  |

  Scenario Outline: 6.Realizar consulta de Personas asociadas a la Unidad Independiente por las opciones de consulta y de filtros
    Given Que se ejecutó el Escenario 1 (Búsqueda por consulta)
    And   Que se ejecutó el Escenario 5 (Búsqueda por filtros)
    When  Da clic sobre el icono de buscar
    Then  El sistema valida que: Al ingresar más de una <Palabra Clave> en el campo de consulta, éstas serán concatenadas con AND.  Al seleccionar más de un registro en el mismo filtro se concatenarán con OR. Al ingresar la <palabra_clave> en la consulta y seleccionar los registros en uno o más filtro
    And   se deben separar por punto y coma (;) la <Selección_filtro> que se hayan seleccionado en más de un <filtro>
    And   El sistema presenta una lista con el <Resultado> de los registros encontrados (Nombres de Personas asociadas a la Unidad Independiente) luego de aplicar la consulta y filtrado respectivo

    Examples:
   | Palabra Clave   | filtro   | Selección_filtro    |Resultado    |
   | 3543343         | nombre   | Jose Barbosa        |Jose Barbosa |
   | Jose            | celular  | 9000500             |Jose Barbosa |


  Scenario Outline: 7.Visualización de Parqueaderos asignados
    Given  Un usuario en la página de Administrar Unidad Independiente
    When   <Visualiza> la tabla de Personas asociadas a la Unidad Independiente
    Then   Identifica el label <PARQUEADEROS ASIGNADOS>
    And    El parqueadero asignado

    Examples:

   | PARQUEADEROS ASIGNADOS  |  Visualiza  |
   |  H4                     |  si         |
   |  P5; F9                 |  si         |

  Scenario Outline: 8.Elementos columna Acciones
   Given  Se ejecuta el escenario 7
   When   Da clic en <Accion> de la columna Acciones
   Then  El sistema redirecciona al usuario a la pantalla de <redirección>

Examples:

  |Persona         |Accion           | Resultado esperado|
  |Jose Barbosa    |Clic Icono Lápiz | Redirección URL Modificar Datos Persona |


  Scenario : 9.Botón Crear Persona
    Given Un usuario en la página de Administrar Unidad Independiente
    When  Da clic en el botón de Crear Persona
    Then  El sistema redirecciona al usuario a la pantalla de Crear Persona asociada a la Unidad Independiente

  Scenario Outline: 10. Paginador
     Given   Un usuario en la página de Administrar Unidad Independiente
     When  Existen <n> registros de Personas asociadas a la Unidad Independiente
     And   Se visualiza el paginador en la parte inferior de la página
     Then  Se mostrarán los registros asignados por página

    Examples:
   |n      |   Número    | Se muestran los resultados|
   | 20    |  2          | Si                        |
   | 40    |   4         | Si                        |

  Scenario Outline: 11.Acción Modificar Unidad Independiente
    Given  Un usuario en la página de Administrar Unidad Independiente
    When  Da clic en el icono de lápiz
    And   El sistema abre un pop up para Modificar los datos de la Persona seleccionada
    And   Se visualizan los campos para Editar el Tipo de Persona, el Nombre de la Persona, el Número de Documento y el Número de Celular
    And   Se ingresa información en <Campo>
    And   Se da clic en el botón Guardar
    Then  El sistema validará que el Nombre de la Persona asociada sea único en la Unidad Independiente
    And   Si se ingresa un <Nombre> ya existente el sistema mostrará el mensaje: <El nombre de la Persona ya está en uso, por favor ingresar uno diferente>
    And   Si se ingresa un <Número de Documento> ya existente el sistema mostrará el mensaje: El <numero documento> de la Persona ya está en uso, por favor ingresar uno diferente
    And   Se habilitará el botón Guardar cuando el usuario haya ingresado correctamente los registros en los campos de Tipo de Persona, Nombre de Persona, Número de documento y número de <celular>.
    And   El pop up se cerrará al dar clic en Guardar o en el icono (x) ubicado en el costado izquierdo del pop up.

    Examples:
   | Nombre de Agrupación| numero documento    |  celular      | Resultado                                                                                 | Se Habilita botón Guardar|
   | José Popayán        | 104534345           |  4534535435   | Exitoso                                                                                   | SI                       |
   | José Popayán        | 104353              |  56           | El nombre de la Persona ya está en uso, por favor ingresar uno diferente                  | NO                       |
   | Sandra Cojo         | 1543433443          | 603453        | El número de Documento de la Persona ya está en uso, por favor ingresar uno diferente     | NO                       |

