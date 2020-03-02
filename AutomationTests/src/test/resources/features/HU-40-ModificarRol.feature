Feature: Modificar rol y asignar permisos
  Como usuario super administrador Quiero Modificar los roles con sus permisos Para que los usuarios tengan los permisos que son en el sistema de inmobiliarias

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Configuracion
    And Da clic en Roles
    And Da clic en el boton Modificar Rol

  Scenario: Informacion que se presenta al seleccionar el boton Crear rol
    Given Da clic en el boton Modificar Rol
    Then El sistema presenta una ventana con la informacion de Modificar rol

  Scenario: Habilitación del botón guardar
    When Edita la informacion del nombre del Rol
    Then El sistema presenta habilitado el boton de guardar

  Scenario Outline: Ingresar información en el campo Nombre rol
    When Ingresa un <nombre> en el campo nombre de rol
    Then Se muestra el resultado esperado <resultado>
    Examples:
      | nombre                              | resultado                      |
      | Admin                               | Admin                          |
      | Admin 28.%&/                        | Admin 28.                      |
      | 12345678901234567890123456789012345 | 123456789012345678901234567890 |

  Scenario Outline: Realizar la creación de rol
    When Ingresa un <nombre> en el campo nombre de rol
    And Da clic en el boton guardar
    Then El sistema presente el mensaje <mensaje>
    Examples:
      | nombre | mensaje                          |
      | Admin       | El rol ya se encuentra creado    |
      | Admin 28.   | Se ha creado el rol exitosamente |
      |             | Campo Obligatorio                |

  Scenario: Seleccionar permisos
    When Se da clic en Configuracion
    And Se da clic en Unidades Inmobiliarias
    And Se da clic en Crear
    Then Se visualizan seleccionados cada check
