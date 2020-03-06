Feature: Un usuario ingresa a el sistema para crear el tipo de novedad

  Background: Administrar Usuarios
    Given   Un usuario ingresa a la url de la aplicación
    And     Ingresa las credenciales correctamente
  #  And     Ingresa a la pantalla de Administrar Usuarios


  Scenario Outline:   1.Realizar una búsqueda de Tarjeta de Ingreso
    Given  Se ubica el cursor en el campo de Consulta
    When   Un usuario ingresa una <palabra_clave> sobre el campo de consulta
    And    Da clic icono buscar1
    Then   El sistema realiza la búsqueda de Usuarios que contengan la <palabra_clave> en los siguientes campos, concatenados con el operador OR y en el orden establecido
    And    El sistema deberá traer los <resultados> de los datos que estén asociados a la palabra clave.

    Examples:
      | palabra_clave | resultados                                                               |
      | 129638        | Fecha de creacion, usuario, documento, nombres , apellidos, telefono,rol |
      | 27/12/2019    | Fecha de creacion, usuario, documento, nombres , apellidos, telefono,rol |
      | Barbosa       | Fecha de creacion, usuario, documento, nombres , apellidos, telefono,rol |
      | no existe     | Fecha de creacion, usuario, documento, nombres , apellidos, telefono,rol |


  Scenario Outline:  2.Comportamiento en cada uno de los filtros
    Given   Da clic sobre la opción Filtros
    When    Da clic en cada <filtro>
    Then    El sistema presenta un <resultado> en el campo
    And     Con un tipo de selección <tipo_selección> para el campo

    Examples:
      | filtro         | resultado                                                                              | tipo_selección  |
      | Fecha Creación | Presenta un calendario para seleccionar la Fecha De Creación de la búsqueda requerida. | selección única |
      | Usuario        | presenta un listado de Usuarios activos                                                | selección única |
      | Documento      | presenta un listado los números de documento asociados.                                | selección única |
      | Nombres        | presenta un listado con nombres de Usuariosque tienen Usuarios activas.                | selección única |
      | Apellidos      | presenta un listado con apellidos de Usuariosque tienen Usuarios activas.              | selección única |
      | Rol            | presenta un listado de Roles activos                                                   | selección única |


  Scenario Outline: 3.Autocomplete de cada filtro
    Given  Que se ejecutó el Escenario 2
    When   Se vayann registrando los <caracteres> en el <filtro>
    Then   Se debe mostrar la <lista> autocomplete de Usuarios asociados al <filtro> con los valores que contengan los <caracteres> registrados actualmente

    Examples:
      | filtro            | caracteres | lista                   |
      | Fecha De Creación | 02         | 02/12/2019   02/11/2019 |
      | Usuario           | I          | imorenoh                |
      | Documento         | 23         | 2343344    2387878      |
      | Nombre            | San        | Sandra Perez            |


  Scenario Outline:  4.Seleccionar un elemento de la lista presentada en el filtro
    Given   Que se ejecutó el Escenariio 3
    When    Se selecciiona un <elemento> de la <lista> presentada en el <filtro>
    Then    Se debe mostrar el <elemento> de la <lista> seleccionado en el mismo niivel que el <filtro> con la opción x para quitar éste.
    And     Debe mostar los <datos asociados al elemento seleccionado>

    Examples:
      | filtro            | lista      | elemento   | datos asociados al elemento seleccionado                                                     |
      | Fecha De Creación | 02/12/2019 | 02/11/2019 | Creación, usuario, Número de documento, nombres, apellidos, teléfono y rol                   |
      | Usuario           | imorenoh   | imorenoh   | Fecha de creación, usuario, Número de documento, usuario, nombres, apellidos, teléfono y rol |
      | Documento         | 2343344    | 2387878    | Fecha de creación, usuario, Número de, nombres, apellidos, teléfono y rol                    |


  Scenario Outline: 5.Realizar consulta de Usuarios por la opción de filtros
    Given   Que se ejecutó el Escenario 4
    When    Da cliic en el botón de buscarrr
    Then    El siistema presenta unn <resultado> que tenga la información del <filtro>
    And     En el campo de búsqueda se presenta la <elemento seleccionado> que se haya seleccionado en el fiiltro
    And     se deben separarr por punto y como ; la <elemento seleccionado> que se hayan seleccionado en más de un filtro

    Examples:
      | filtro            | elemento seleccionado | resultado                                                                                       |
      | Fecha De Creación | 02/12/2019            | Presenta los nombres y apellidos de los usuarios creados en esa fecha.                          |
      | Usuario           | imorenoh              | Presenta los nombres y apellidos de los usuarios con la coincidencia del elemento seleccionado. |
      | Documento         | 2343344               | Presenta los nombres y apellidos de los usuarios con la coincidencia del elemento seleccionado. |

  Scenario Outline: 6.Realizar consulta de Usuarios por las opciones de consulta y de filtros
    Given   Que se ejecutó el Escenario 1 <Búsqueda por consulta>
    And     Que se ejecutó el Escenario 5 <Búsqueda por filtros>
    When    Da clic en icono de buscarr
    Then     El sistema valida que al ingresar más de una <palabra clave> en el campo de consulta, éstas serán concatenadas con AND
    And     se deben separar por punto y coma la <Selección filtro> que se hayan seleccionado en más de un <filtro>
    And     El sistema presenta una lista con el <resultado> de los usuarios encontrados <resultado nombres y apellidos> luego de aplicar la consulta y filtrado respectivo

    Examples:
      | palabra clave | filtro       | Selección filtro | resultado nombres y apellidos |
      | 23            | usuario      | jhurtado         | Jose Hurtado                  |
      | Sandra        | 0 Id tarjeta | 4                | Sandra Barbosa                |

  Scenario Outline:  7.Visualización Tabla de Usuarios
    Given  Un usuario se en cuentra en la pagina de Administrar Usuarios
    When   Visualiza la tabla de Usuarios
    Then   Identifiica la columna <columna>
    And    Se <visualiza> en la columna Accion primero todos los usuarios de Ingreso y luego los de Salida.

    Examples:
      | columna           | visualiza |
      | Fecha De Creación | si        |
      | Usuario           | si        |
      | Documento         | si        |
      | Nombres           | si        |
      | Apellidos         | si        |
      | Teléfono          | si        |
      | Rol               | si        |
      | Acciones          | si        |


  Scenario Outline:    8.Elementos columna acciones
    Given    Se ejecuta el escenariiio 7
    When     Da clic en <Icono> de la columna Acciiiones
    Then     El sistema realiza la <Accion>

    Examples:
      | Nombres y apellidos persona | Accion                          | Resultado esperado                                                                                                                                                                                                                                                                                                        |
      | Sandra Barbosa              | Clic en Icono Activar/Inactivar | Si el check se encuentra marcado y se da clic en él, se mostrará el mensaje: “El usuario ha sido inactivado exitosamente” y el check se mostrará desmarcado.   Si el check no se encuentra marcado y se da clic en él, se mostrará el mensaje: “El usuario ha sido activado exitosamente” y el check se mostrará marcado. |
      | Sandra Barbosa              | Clic en Icono Ojo               | Redirecciona al usuario a la página de Consultar Usuario.                                                                                                                                                                                                                                                                 |
      | Sandra Barbosa              | Clic en Icono Lápiz             | Redirecciona al usuario a la página de Modificar Usuario.                                                                                                                                                                                                                                                                 |
      | Sandra Barbosa              | Clic en Icono Caneca            | Al dar clic en el icono el sistema mostrará un pop up con el mensaje: “¿Está seguro de que desea Eliminar este Usuario?    Con las opciones de SI y NO   Al dar clic en SI, el usuario ya no se muestra en la tabla.    Al dar clic en NO, se cerrará el pop up.                                                          |

  Scenario: 9.Botón Crear Usuario
    Given   Un usuariiio en la página de Administrar Usuarios
    When    Da cliiic en ell <botón Crear> Usuario
    Then    El sistema redirecciona al usuariiio a la pantalla de Creación de Usuarios


  Scenario Outline:  10.Paginador
    Given   Un usuario en la página de Administrar Usuario
    When    Exiisten <n> usuarios de De Usuarios
    And     Se visualiza el paginador en la parte inferiior de la página
    Then    Se mostraran los usuarios asignados por pagiina

    Examples:
      | n  | numero | Se muestran los resultados |
      | 20 | 2      | Si                         |
      | 40 | 4      | Si                         |

