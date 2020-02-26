package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AdministrarAgrupaciónUnidadesIndependientes {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }
//Escenario 1

    @Given("^Se ubiica el cursor en el campo de Consulta$")
    public void CursorCampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Un usuariio ingresa una (.*) sobre el campo de consulta$")
    public void Ingresarpalabra() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }
    @And("^el usuario Da clic en el icono de buscar$")
    public void BuscarIcono() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    @Then("^El sistema realiza la búsqueda de las Unidades Independientes que contengan la (.*) en los siguientes campos, concatenados con el operador OR y en el orden establecido$")
    public void CamposConcatenados() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^Carga en la pantalla todos los registros de la tabla que estén relacionados o asociados con la palabra clave ingresada.$")
    public void PalabraIngresada() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

///Escenario 2


    @Given("^Da clic sobre la opciión Filtros$")
    public void Sobrelaopcion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Da cliic en cada (.*)$")
    public void CadaFiltro() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema prresenta un (.*) en el campo$")
    public void Enelcampo() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^Con un tipo de selección (.*) para el campo$")
    public void TSeleccion() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    ///Escenario 3

    @Given("^Que se ejecutó el Escenario 2$")
    public void SeEjecuto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Se vayan registrando (.*) en el <filtro>$")
    public void Registrodecaracteres() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^Se debe mostrar la (.*) autocomplete de Unidades Independientes asociadas al <filtro> con los valores que contengan los <caracteres> registrados actualmente.$")
    public void Enelc() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 4

    @Given("^Que se ejecutó el Escenario 3$")
    public void Sescenariotres() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Se selecciona un (.*) de la (.*) presentada en el (.*)$")
    public void Registrodecaractere() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^Se debe mostrar el (.*) de la (.*) seleccionado en el mismo nivel que el (.*) con la opción (x) para quitar éste.$")
    public void nelca() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 5

    @Given("^Que se ejecutó el Escenario 4$")
    public void CuatroEjecuto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Da clic sobre el botón de buscar$")
    public void buscarBottton() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^Ell sistema presenta un (.*) que tenga la (.*) del (.*)$")
    public void EllPresenta() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^En el campo de búsqueda se presenta la (.*) que se haya seleccionado en el filtro$")
    public void EnelfiltroSeleccionado() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));

    }
    @And("^se deben separar por punto y como (;) la (.*) que se hayan seleccionado en más de un filtro$")
    public void Enmmasfiiltro() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

///Escenario 6

    @Given("^Que se ejecutó el Escenario 1 (Búsqueda por consulta)$")
    public void Con() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }


    @And("^Que se ejecutó el Escenario 5 (Búsqueda por filtros)$")
    public void Cinco() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));

    }
    @When("^Da clic sobre el iicono de buscar$")
    public void coono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^ Al ingresar más de una (.*) en el campo de consulta, éstas serán concatenadas con AND. Al seleccionar más de un registro en el mismo filtro se concatenarán con OR. Al ingresar la (.*) en la consulta y seleccionar los registros$")
    public void Seleccionar () {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^se deben separar por punto y coma (;) la <Selección_filtro> que se hayan seleccionado en más de un <filtro>.$")
    public void En() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));

    }
    @And("^El sistema presenta una lista con el (.*) de los registros encontrados (Nombres de Unidades Independientes) luego de aplicar la consulta y filtrado respectivo.$")
    public void lalista() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }
///Escenario 7

    @Given("^Un usuario en la página de Administrar Agrupador$")
    public void PaginaAgrupa() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Visualiza la tabla de Unidades Independientes$")
    public void Indepe() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^Identifica la columna (.*)$")
    public void Column() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 8

    @Given("^Se ejecuta el escenario 7$")
    public void Pagadmin() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Da clic en <Unidad> de la columna Unidad Independiente$")
    public void Unid() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @And("^La Unidad se encuentra activa$")
    public void Enla() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    @Then("^El sistema redirecciona al usuario a la pantalla de Personas asociadas a Unidad Independiente$")
    public void Coolum() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

///Escenario 9

    @Given("^Se ejecuta el escenariio 7$")
       public void ESiete() {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
            "El usuario ingresa a la pagina de administrar usuarios",
            "pagina de administracion de usuarios",
            "")));
}

    @When("^Da clic en (.*) de la columna Acciones$")
    public void CliAcciones() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema redirecciona al usuario a la pantalla de (.*)$")
    public void Sistemaredirecciona() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 10

    @Given("^Un usuario en la pagina de Administrar Agrupador$")
    public void EjecutaSiete() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Da cliic en el boton de Crear Unidad Independiente$")
    public void ClicAcciones() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema redirecciona a la pantalla de Crear Unidad Independiente$")
    public void AlaPantalla() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 11


    @Given("^Un usuarioo en la página de Administrar Agrupador$")
    public void addministrar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Existen <n> registros de Unidades Independiente$")
    public void Existeenregistros() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @And("^Se visualiza el paginador en la parte inferior de la página$")
    public void visualizarPaginaInferior() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }
    @Then("^Se mostrarán los registros asignados por página$")
    public void Asigna() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 12

    @Given("^Un usuario en la página de Administrar Unidad Inmobiliaria$")
    public void UnidadPagina() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Da cliic en el icono de lápiz$")
    public void CliicLapiz() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));

    }
    @And("^El sistema abre un pop up para Modificar los datos de la Unidad Independiente seleccionada$")
    public void abrepopup() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }
    @And("^Se visualizan los campos para Editar el Nombre de la Unidad Independiente, el Número de Catastro y el Número de Metros cuadrados$")
    public void Metroscuadrados() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }
    @And("^Se ingresa información en <Campo>$")
    public void CampoInforma() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

      @And("^Se da cliic en el botón Guardar$")
        public void Botonguardar() {
            actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                    "El usuario da clic en cada filtro  ",
                    "Da clic en filtro",
                    "Elemento")));
        }

      @Then("^El sistema validará que el Nombre de la Unidad Independiente sea único en la Unidad Inmobiliaria$")
      public void ValidaraNombresC() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
        }
      @And("^Si se ingresa un <Nombre de Unidad Independiente> ya existente el sistema mostrará el mensaje: <El nombre de la Unidad Independiente ya está en uso, por favor ingresar uno diferente>$")
      public void NombreUnidadIndepend() {
          actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                  "El usuario da clic en cada filtro  ",
                  "Da clic en filtro",
                  "Elemento")));
      }

      @And("^Si se ingresa un <Número de Catastro> ya existente el sistema mostrará el mensaje: <El Número de Catastro de la Unidad Independiente ya está en uso, por favor ingresar uno diferente>$")
      public void Numero() {
          actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                  "El usuario da clic en cada filtro  ",
                  "Da clic en filtro",
                  "Elemento")));
      }

      @And("^Se habilitará el botón Guardar cuando el usuario haya ingresado correctamente los registros en los campos de Nombre de Agrupación y Número de Unidades Independientes$")
       public void Ingresocorre() {
          actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                  "El sistema presenta formulario",
                  "visualiza formulario",
                  "Elemento")));
      }
       @And("^El pop up se cerrará al dar clic en Guardar o en el icono (x) ubicado en el costado izquierdo del pop up.$")
       public void PopPup() {
           actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                   "El sistema presenta formulario",
                   "visualiza formulario",
                   "Elemento")));

       }

}

