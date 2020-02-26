Feature: Como usuario de la aplicación de conjuntos deseo iniciar sesión para gestionar unidades inmobiliarias.

Background: Ingresar a la aplicación
Given Que usuario ingresa a la pagina de inicio

Scenario Outline: : Habilitación del botón ingresar a la aplicación
Given Que usuario ingresa a la pagina de inicio
When Ingresa información de usuario de <usuario>
And Ingresa la información de contrasena <Contrasena>
Then El sistema <Habilitado> presenta habilitado el botón de ingresar

Examples:
| usuario | Contrasena | Habilitado |
|              |            | False      |
|              | 3498438    | False      |
| jabarbosa    |            | False      |
| jabarbosa    | 234324     | True       |

Scenario Outline: Ingreso exitoso a la aplicación
Given Que usuario ingresa a la pagina de inicio
When Ingresa información de usuario de <Tipo_usuario>
  And Ingresa la información de contrasena <Contrasena>
And Da clic sobre el botón Ingresar
Then El sistema presenta la página después del ingreso con la <Informacion>
Examples:
| Descripcion                   | Tipo_usuario | Contrasena | Informacion          |
| Usuario con mas de una Unidad | jabarbosa    | 23432432   | Selector de Unidades |
| Usuario con una unidad        | jabarbosa    | 243242     | Pagina principal     |

Scenario: Bloqueo de Usuario con 5 intentos de ingreso
Given Que usuario ingresa a la pagina de inicio
When Ingresa 5 veces información de usuario y de contrasena errada
And Da clic sobre el botón Ingresar
Then El sistema presenta el mensaje de Usuario bloqueado

