Feature: Administrar Unidad Independiente

  Background: Como usuario Quiero Administrar la Unidad Independiente seleccionada Para iniciar su gestión.
#    And Ingresa a la
#    And Ingresa a la pantalla de Administrar Unidades Inmobiliarias
#    And Ingresa a la


  Scenario: 1.Realizar una búsqueda de Personas asociadas a la Unidad Independiente
    Given  Se ubiiica el cursor en el campo de Consulta
    When  Un usuario ingresa una <palabra_clave> sobre el campo de consullta
    And  Daa clic en el icono de buscar
    Then El sistema realiza la búsqueda de las Personas asociadas a la Unidad Independiente que contengan la <palabra_clave>
    And  Cargar en la lista del buscador de Personas asociadas a la Unidad Independiente el nombre de las Personas obtenidas en la consulta en el orden definido según los campos del "Entonces” anterior.


  Scenario Outline: 2.Comportamiento en cada uno de los filtross
    Given Da clic sobre la opción Filtross
    When Daa clic en cadaa <filtro>
    Then El sistemaa presenta un <resultado> en el campo
    And  Con un tiipo de selección <tipo_seleccion> para el campo

    Examples:

      | filtro           |
      | Nombre           |
      | numero Documento |
      | Celular          |
      | Activa           |

  Scenario Outline: 3.Autocomplete de cada filtrro
    Given  Quee se ejecutó el Escenario 2
    When  See vayan registrando <caracteres> en el <filtro>
    Then  Se debe mostrar la <lista> autocomplete de Personas asociadas a la Unidad Independiente asociadas al <filtro> con los valores que contengan los <caracteres> registrados actualmente.

    Examples:

      | filtro           | caracteres |
      | Nombre           | Jose       |
      | Nombre           | No existe  |
      | numero Documento | 500900     |
      | numero Documento | 0000       |
      | Celular          | 5          |
      | Celular          | 0000       |
      | Activa           | San        |
      | Activa           | No existe  |
      | Propietario      | Jose       |

  Scenario Outline: 4.Seleccionar un elemento de la lista presentada en el filtro
#    Given  Quee se ejecutó el Escenario 3
    When   See selecciona un <elemento> de la <lista> presentada en el <filtro>
    Then   Se debe mostrar el <elemento> de la <lista> seleccionado en el mismo nivel que el <filtro> con la opcion x para quitar este.

    Examples:

      | filtro           | elemento             |
      | Nombre           | Jose Barbosa         |
      | Nombre           | No se presenta lista |
      | numero Documento | 5009001              |
      | numero Documento | No se presenta lista |
      | Celular          | 591111111            |
      | Celular          | No se presenta lista |
      | Activa           | Alex Salcedo         |
      | Activa           | No se presenta lista |
      | Propietario      | Juanita Acosta       |

  Scenario Outline: 5.Realizar consulta de Personas asociadas a la Unidad Independiente por la opción de filtros
#    Given  Quee se ejecutó el Escenario 4
    When   Daa clic sobre el botón de buscar
    Then  Ell siistema presenta un <resultado> que tenga la <información> del <filtro>
    And   En el campo de búsquedaa se presenta la <elemento_seleccionado> que se haya seleccionado en el filtro
    And  se deben separar por punto y coma ; la <elemento_seleccionado> que se hayan seleccionado en mas de un filtro

    Examples:
      | filtro                      | elemento_seleccionado     |
      | Nombre                      | Jose Barbosa              |
      | numero Documento            | 9000500                   |
      | Celular                     | 59345434                  |
      | Nombre y Documento          | Jose Barbosa; 9000500     |
      | Documento, Celular y Activa | 9000500; 32145645; Activa |

  Scenario Outline: 6.Realizar consulta de Personas asociadas a la Unidad Independiente por las opciones de consulta y de filtros
#    Given Que se ejecutó el Escenario 1 (Búsqueda por consulta)
#    And   Que se ejecutó el Escenario 5 (Búsqueda por filtros)
    When  Da clic sobre el icono de buscar
    Then  El sistema valida que: Al ingresar más de una <Palabra Clave> en el campo de consulta, éstas serán concatenadas con AND.  Al seleccionar más de un registro en el mismo filtro se concatenarán con OR. Al ingresar la <palabra_clave> en la consulta y seleccionar los registros en uno o más filtro
    And   se deben separar por punto y coma ; la <Seleccion_filtro> que se hayan seleccionado en más de un <filtro>
    And   El sistema presenta una lista con el <resultado> de los registros encontrados Nombres de Personas asociadas a la Unidad Independiente luego de aplicar la consulta y filtrado respectivo

    Examples:
      | Palabra Clave | filtro  | Seleccion_filtro | resultado    |
      | 3543343       | nombre  | Jose Barbosa     | Jose Barbosa |
      | Jose          | celular | 9000500          | Jose Barbosa |


  Scenario Outline: 7.Visualización de Parqueaderos asignados
#    Given  Un usuario en la págiina de Administrar Unidad Independiente
    When   <Visualiza> la tabla de Personas asociadas a la Unidad Independiente
    Then   Identifica el label <PARQUEADEROS ASIGNADOS>
    And    El parqueadero asignado

    Examples:

      | PARQUEADEROS ASIGNADOS | Visualiza |
      | H4                     | si        |
      | P5; F9                 | si        |

  Scenario Outline: 8.Elementos columna Acciones
#   Given  Se ejeecuta el escenario 7
    When   Da cliic en <Accion> de la columna Acciones
    Then  El siistema redirecciona al usuario a la pantalla de <redirección>

    Examples:

      | Accion           |
      | Clic Icono Lapiz |


  Scenario: 9.Botón Crear Persona
#    Given Un usuario en la página de Administrar Unidad Independiiente
    When  Da cliic en el botón de Crear Persona
    Then  El siistema redirecciona al usuario a la pantalla de Crear Persona asociada a la Unidad Independiente

  Scenario Outline: 10. Paginador
#     Given Unn usuario en la página de Administrar Unidad Independiente
    When  Existen <n> registros de Personas asociadas a la Unidad Independiente
    And   Se visualiza el paginador en la parte inferior de la páginaa
    Then  See mostraran los <numeros> de los registros asignados por pagina

    Examples:
      | n  | numeros |
      | 20 | 2       |
      | 40 | 4       |

  Scenario Outline: 11.Acción Modificar Unidad Independiente
#    Given  Un usuario en la página de Administrar Unidad Independientee
    When  Daa cliic en el icono de lápiz
    And   El sistema abre un pop up para Modificar los datos de la Persona seleccionada
    And   Se visualizan los campos para Editar el Tipo de Persona, el Nombre de la Persona, el Número de Documento y el Número de Celular
    And   Se ingresaa información en <Campo>
    And   Se daa clic en el botón Guardar
    Then  El sistema validará que el Nombre de la Persona asociada sea único en la Unidad Independiente
    And   Si se ingresa un <Nombre> ya existente el sistema mostrará el mensaje: <El nombre de la Persona ya está en uso, por favor ingresar uno diferente>
    And   Si se ingresa un <Número de Documento> ya existente el sistema mostrará el mensaje: El <numero documento> de la Persona ya está en uso, por favor ingresar uno diferente
    And   Se habilitará el botón Guardar cuando el usuario haya ingresado correctamente los registros en los campos de Tipo de Persona, Nombre de Persona, Número de documento y número de <celular>.
    And   El pop up se cerrara al dar clic en Guardar o en el icono x ubicado en el costado izquierdo del pop up.

    Examples:
      | numero documento | celular    |
      | 104534345        | 4534535435 |
      | 104353           | 56         |
      | 1543433443       | 603453     |

