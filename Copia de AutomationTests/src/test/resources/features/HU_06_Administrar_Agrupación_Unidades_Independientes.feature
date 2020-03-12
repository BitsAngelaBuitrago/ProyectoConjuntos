Feature: Como usuario Quiero ingresar al sistema para administar las agrupaciónes de unidades independientes

  Background: Un usuario ingresa a la url de la aplicación
#    And Ingresa las credenciales correctamente
#    And Ingresa a la pantalla de Administrar Unidades Inmobiliarias
#    And Ingresa a la pantalla de la Unidad Inmobiliaria requerida
#    And Ingresa a la pantalla de Administrar Agrupador


  Scenario: 1.Realizar una busqueda de Unidades Independientes
    Given Se ubiica el cursor en el campo de Consulta
    When  Un usuariio ingresa una <palabra clave> sobre el campo de consulta
    And   el usuario Da clic en el icono de buscar
    Then  El sistema realiza la búsqueda de las Unidades Independientes que contengan la <palabra clave> en los siguientes campos, concatenados con el operador OR y en el orden establecido
    And   Carga en la pantalla todos los registros de la tabla que estén relacionados o asociados con la palabra clave ingresada.


#    Examples:
#      |palabra clave               | valor resultado                                                                                    |
#      |Apartamento 10              | Apartamento 101 Apartamento 102 Apartamento 103 Apartamento 104                                    |
#      |3453453                     | Apartamento 203                                                                                    |
#      |101                         | Apartamento 101                                                                                    |
#      |Activa                      | Apartamento 101 Apartamento 103 Apartamento 201  Apartamento 204  Apartamento 301 Apartamento 405  |
#      |no existe                   | No se encontraron resultados                                                                       |


  Scenario Outline: 2.Comportamiento en cada uno de los filtros
    Given Da clic sobre la opciión Filtros
    When Da cliic en cada <filtro>
    Then El sistema prresenta un <resultado> en el campo
    And Con un tipo de selección <tipo_seleccion> para el campo

    Examples:
      | filtro                      | resultado                                                                                                              | tipo_seleccion  |
      | Nombre Unidad Independiente | presenta un listado con los nombres de las Unidades Independientes asociadas a la agrupacion seleccionada.             | seleccion unica |
      | # Catastro                  | presenta un listado con los numeros de Catastro de las Unidades Independientes asociadas a la agrupacion seleccionada. | seleccion onica |
      | Metros Cuadrados            | presenta un listado con los metros cuadrados de las unidades independientes asociadas a la agrupacion seleccionada.    | seleccion unica |
      | Activa                      | presenta un listado con las unidades independientes activas en la agrupacion seleccionada.                             | seleccion unica |

  Scenario Outline: 3.Autocomplete de cada filtro
#    Given  Que se ejecutó el Escenario 2
    When   Se vayan registrando <caracteres> en el <filtro>
    Then   Se debe mostrar la <lista> autocomplete de Unidades Independientes asociadas al <filtro> con los valores que contengan los <caracteres> registrados actualmente.

    Examples:
      | filtro                      | caracteres     | lista                                                                                            |
      | Nombre Unidad Independiente | Apartamento 01 | Apartamento 101      Apartamento 201     Apartamento 301     Apartamento 401     Apartamento 501 |
      | Nombre Unidad Independiente | No existe      | No se presenta lista                                                                             |
      | # Catastro                  | 500900         | 500900      5009001                                                                              |
      | # Catastro                  | 0000           | No se presenta lista                                                                             |
      | Metros Cuadrados            | 5              | 54     59                                                                                        |
      | Metros Cuadrados            | 0000           | No se presenta lista                                                                             |
      | Activa                      | Apar           | Apartamento 102    Apartamento 301      Apartamento 405                                          |
      | Activa                      | No existe      | No se presenta lista                                                                             |


  Scenario Outline: 4.Seleccionar un elemento de la lista presentada en el filtro
#    Given  Que se ejecutó el Escenario 3
    When   Se selecciona un <elemento> de la <lista> presentada en el <filtro>
    Then   Se debe mostrar el <elemento> de la <lista> seleccionado en el mismo nivel que el <filtro> con la opción (x) para quitar éste.

    Examples:
      | filtro                      | lista                                                                                          | elemento             |
      | Nombre Unidad Independiente | Apartamento 101      Apartamento 201     Apartamento 301    Apartamento 401    Apartamento 501 | Apartamento 201      |
      | Nombre Unidad Independiente | No se presenta lista                                                                           | No se presenta lista |
      | Numero Catastro             | 500900    5009001    5009001                                                                   | 5009001              |
      | Numero catastro             | No se presenta lista                                                                           | No se presenta lista |
      | Metros Cuadrados            | 54      59                                                                                     | 59                   |
      | Metros Cuadrados            | No se presenta lista                                                                           | No se presenta lista |
      | Activa                      | Apartamento 102      Apartamento 301     Apartamento 405                                       | Apartamento 102      |
      | Activa                      | No se presenta lista                                                                           | No se presenta lista |

  Scenario Outline: 5.Realizar consulta de Unidades Independientes por la opción de filtros
    Given  Que se ejecutó el Escenario 4
    When   Da clic sobre el botón de buscar
    Then   Ell sistema presenta un <resultado> que tenga la <información> del <filtro>
    And    En el campo de búsqueda se presenta la <elemento seleccionado> que se haya seleccionado en el filtro
    And    se deben separar por punto y como (;) la <elemento_seleccionado> que se hayan seleccionado en más de un filtro

    Examples:
#      | filtro                                            | elemento seleccionado                 |
#      |Nombre Unidad Independiente                        | Apartamento 203                       |
#      |Numero Catastro                                    | 9000500                               |
#      |Metros Cuadrados                                   | 59                                    |
#      |Activa                                             | Apartamento 203                       |
#      |Nombre y Catastro                                  | Apartamento 102; 9000500              |
#      |Nombre y Catastro                                  | Apartamento 102; 9000501              |
#      |Nombre, Catastro y Metros cuadrados                | Apartamento 102; 9000500; 45          |
#      |Nombre, NIT, Catastro, Metros cuadrados            | Apartamento 102; 9000500; 50          |
#      |Nombre, Catastro, Metros cuadrados y Activa        | Apartamento 102; 9000500; 45;         |
#      |Nombre, NIT y Catastro, Metros cuadrados y Activa  | Apartamento 102; 9000500; 50; Activa  |
#      |Catastro y Metros Cuadrados                        | 9000500; 45                           |
#      |Catastro y Metros Cuadrados                        | 9000500; 40                           |
#      |Catastro, Metros Cuadraros y Activa                | 9000500; 45; Activa                   |
#      |Catastro, Metros Cuadraros y Activa                | 9000500; 50; Activa                   |
#      |Metros cuadrados y Activa                          | 45; Activa                            |
#      |Metros cuadrados y Activa                          | 40; Activa                            |

  Scenario Outline: 6.Realizar consulta de Unidades Independientes por las opciones de consulta y de filtros
    Given Que se ejecuto el Escenario 1 (Busqueda por consulta)
    And   Que se ejecuto el Escenario 5 (Busqueda por filtros)
    When Da clic sobre el iicono de buscar
    Then  Al ingresar más de una <Palabra Clave> en el campo de consulta, éstas serán concatenadas con AND. Al seleccionar más de un registro en el mismo filtro se concatenarán con OR. Al ingresar la <palabra_clave> en la consulta y seleccionar los registros
    And se deben separar por punto y coma (;) la <Selección_filtro> que se hayan seleccionado en más de un <filtro>.
    And El sistema presenta una lista con el <Resultado> de los registros encontrados (Nombres de Unidades Independientes) luego de aplicar la consulta y filtrado respectivo. 

    Examples:
      | Palabra Clave | filtro            | Selección_filtro         |
      | 3543343       | nombre            | Apartamento 102          |
      | Apar          | NIT               | 9000500                  |
      | 45            | Catastro          | 8373483                  |
      | No existe     | Nombre y Catastro | Apartamento 102; 9000501 |


  Scenario Outline: 7.Tabla de Unidades Independientes
    Given  Un usuario en la página de Administrar Agrupador
    When   Visualiza la tabla de Unidades Independientes
    Then   Identifica la columna <columna>

    Examples:
      | columna              | Encontrada |
      | Unidad Independiente | si         |
      | numero Catastro      | si         |
      | Metros Cuadrados     | Si         |
      | Activa               | Si         |
      | Acciones             | Si         |

  Scenario Outline: 8.Enlace columna Unidad Independienta
    Given  Se ejecuta el escenario 7
    When   Da clic en <Unidad> de la columna Unidad Independiente
    And   La Unidad se encuentra activa
    Then  El sistema redirecciona al usuario a la pantalla de Personas asociadas a Unidad Independiente

    Examples:
      | Unidad          | Activa | Resultado esperado                                        |
      | Apartamento 102 | Si     | Redirección URL Personas Asociadas a Unidad Independiente |
      | Apartamento 504 | No     | Ninguna acción                                            |

  Scenario Outline: 9.Elementos columna Acciones
    Given  Se ejecuta el escenariio 7
    When   Da clic en <Acción> de la columna Acciones
    Then El sistema redirecciona al usuario a la pantalla de <redirección>

    Examples:
      | Unidad          | Acción            | Resultado esperado                             |
      | Apartamento 102 | Clic Icono Lápiz  | Redirección URL Modificar Unidad Independiente |
      | Conjunto Bits   | Clic en Icono Ojo | Redirección URL Consultar Agrupador            |

  Scenario:  10.Boton Crear Unidad Independiente
    Given   Un usuario en la pagina de Administrar Agrupador
    When   Da cliic en el boton de Crear Unidad Independiente
    Then   El sistema redirecciona a la pantalla de Crear Unidad Independiente

  Scenario Outline: 11.Paginador
    Given Un usuarioo en la página de Administrar Agrupador
    When  Existen <n> registros de Unidades Independiente
    And   Se visualiza el paginador en la parte inferior de la página
    Then  Se mostrarán los registros asignados por página

    Examples:

      | n  | Número | Se muestran los resultados |
      | 20 | 2      | Si                         |
      | 40 | 4      | Si                         |

  Scenario Outline: 12.Acción Modificar Unidad Independiente
    Given Un usuario en la página de Administrar Unidad Inmobiliaria
    When Da cliic en el icono de lápiz
    And  El sistema abre un pop up para Modificar los datos de la Unidad Independiente seleccionada
    And  Se visualizan los campos para Editar el Nombre de la Unidad Independiente, el Número de Catastro y el Número de Metros cuadrados
    And  Se ingresa información en <Campo>
    And  Se da cliic en el botón Guardar
    Then El sistema validará que el Nombre de la Unidad Independiente sea único en la Unidad Inmobiliaria
    And  Si se ingresa un <Nombre de Unidad Independiente> ya existente el sistema mostrará el mensaje: <El nombre de la Unidad Independiente ya está en uso, por favor ingresar uno diferente>
    And  Si se ingresa un <Número de Catastro> ya existente el sistema mostrará el mensaje: <El Número de Catastro de la Unidad Independiente ya está en uso, por favor ingresar uno diferente>
    And  Se habilitará el botón Guardar cuando el usuario haya ingresado correctamente los registros en los campos de Nombre de Agrupación y Número de Unidades Independientes
    And  El pop up se cerrará al dar clic en Guardar o en el icono (x) ubicado en el costado izquierdo del pop up.

    Examples:
      | Nombre de Agrupación | # Catastro | Metros Cuadrados | Resultado                                                                                         | Se Habilita botón Guardar |
      | Agrupación 1         | 104534     | 45               | Exitoso                                                                                           | SI                        |
      | Agrupación 1         | 104353     | 56               | El nombre de la Unidad Independiente ya está en uso, por favor ingresar uno diferente             | NO                        |
      | Agrupación 2         | 154343     | 60               | El número de catastro de la Unidad Independiente ya está en uso, por favor ingresar uno diferente | NO                        |
