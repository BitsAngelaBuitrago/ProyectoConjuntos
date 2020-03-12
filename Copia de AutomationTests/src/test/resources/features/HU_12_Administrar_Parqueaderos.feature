Feature: Como usuario Quiero Administrar los Parqueaderos Para iniciar su gestión.

 # Background  Un usuario ingresa a la url de la aplicación
 # And
 # And

  Scenario Outline: 1.Realizar una búsqueda de Parqueaderos
    Given Se ubica el cursor en el campo de Consultaa
    When  Un usuario ingresa una <palabra_clave> sobre el campo de consultaa
    And   Da cliic en el icono de buscarr
    Then El sistema realiza la búsqueda de Parqueaderos que contengan la <palabra_clave> en los siguientes campos, concatenados con el operador OR y en el orden establecido
    And Cargar en la lista del buscador de Parqueaderos el número de los Parqueaderos obtenidos en la consulta en el orden definido según los campos del "Entonces” anterior

    Examples:

    |palabra_clave    |
    |Parqueadero H    |
    |Torre 4          |
    |Apartamento 102  |
    |Propio           |
    |Visitante        |
    |Carro            |
    |Activo           |
    |no existe        |


  Scenario Outline: 2.Comportamiento en cada uno de los filtross
    Given Da cliic sobre la opción Filtross
    When Da cliic en cadaa <filtro>
    Then El siistema presentaa un <resultado> en el campoo
    And  Con un tiipo de selección <tipo_seleccion> para el campoo

    Examples:

    |filtro                 |
    |Agrupacion             |
    |Unidad Independiente   |
    |Numero de parqueadero  |
    |Tipo de Parqueadero    |
    |Tipo de Vehiculo       |

  Scenario Outline: 3.Autocomplete de cada filtro
#   Given Que se ejecutó el Escenarioo 2
   When Se vayann registrando <caracteres> en el <filtro>
   Then Se debe mostrar la <lista> autocomplete de De Parqueaderos asociados al <filtro> con los valores que contengan los <caracteres> registrados actualmente

    Examples:
    |filtro                     |
    |Agrupacion                 |
    |Numero de parqueadero      |
    |Tipo de Parqueadero        |
    |Tipo de Vehiculo           |
    |Activo                     |
    |Agrupacion                 |
    |Unidad Independiente       |
    |Numero de parqueadero      |
    |Tipo de Parqueadero        |
    |Tipo de Vehiculo           |
    |Activo                     |

  Scenario Outline: 4.Seleccionar un elemento de la lista presentada en el filtro
#    Given Quee se ejecutó el Escenario 3
    When  Se selecciona uun elemento de la lista presentada en el <filtro>
    Then  Se debe mostrar el elemento de la lista seleccionado en el mismo nivel que el <filtro> con la opcion x para quitar este

    Examples:

    |filtro                      |
    |Agrupacion                  |
    |Unidad Independiente        |
    |Numero de parqueadero       |
    |Tipo de Parqueadero         |
    |Tipo de Vehiculo            |
    |Activa                      |

  Scenario Outline: 5.Realizar consulta de Parqueaderos por la opción de filtros
#    Given  Que sse ejecutó el Escenario 4
    When Da clic ssobre el botón de buscar
    Then  El sistema presentaa un <resultado> que tenga la <información> del <filtro>
    And En el campo de búsquedaa se presenta la <elemento_seleccionado> que se haya seleccionaado en el filtro
    And separar por punto y coma (;) la <elemento_seleccionado> que se hayan seleccionado en mas de un filtro

   Examples:

    |filtro                           |
    |Agrupacion                       |
    |Unidad Independiente             |
    |Numero de parqueadero            |
    |Tipo de Parqueadero              |
    |Tipo de Vehiculo                 |
    |Activo                           |
    |Agrupacion; Unidad Independiente |
    |Agrupacion; Tipo de Vehiculo     |
    |Agrupacion; Activo               |


  Scenario Outline: 6.Realizar consulta de Parqueaderos por las opciones de consulta y de filtros
#   Given Que se ejecutó el Escenario 1 (Búsqueda por consulta)
#   And  Que se ejecutó el Escenario 5 (Búsqueda por filtros)
   When  Da clic sobre el icono de buscarr
   Then  Al ingresar mas de una <palabra_clave> en el campo de consulta, estas seran concatenadas con AND, Al seleccionar mas de un registro en el mismo <filtro> se concatenaran con OR, Al ingresar la <palabra_clave> en la consulta y seleccionar los registros en uno o mas filtros


    Examples:

    |palabra_clave  | filtro              |
    |Propi          | Agrupacion          |
    |Activo         | Tipo de Vehiculo    |

  Scenario Outline: 7.Visualización Tabla de Parqueaderos
#   Given  Un usuario en la página de Administrar Parqueaderos
   When   Visualiza la tabla de Parqueaderos
   Then   Identifica lla columna <Columna>

    Examples:

    |Columna                 |
    |Agrupacion              |
    |Unidad Independiente    |
    |Numero de Parqueadero   |
    |Tipo de Parqueadero     |
    |Tipo de Vehiculo        |
    |Acciones                |

  Scenario: 8.Elementos columna Acciones
    Given Se eejecuta el escenario 7
    When Da clicc en <Icono> de la columna Acciones
    Then El sistema realiza la <Acción>

  Scenario: 9.Botón Crear Parqueadero
    Given Un usuario en la página de Administrar Parqueaderos
    When Se encuentra con Parqueaderos por crear
    And El botón Crear se encuentra Activo
    And Da cliic en el botón de Crearr Personaa
    Then El ssistema redirecciona al usuario a la pantalla de Crear Persona asociada a la Parqueaderos

  Scenario Outline: 10.Paginador
    Given Un usuario en la página de Administrar Parqueaderos
    When Existen <n> registros de De Parqueaderos
    And Se visualiza el paginador een la parte inferior de la páginaa
    And  Se da cliic en <numero>
    Then  Se mostrarán los registros asignados por páginaa

   Examples:
  |n    | numero|
  |20   | 2     |
  |40   | 4     |












