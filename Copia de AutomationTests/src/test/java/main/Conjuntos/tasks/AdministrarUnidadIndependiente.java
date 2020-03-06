package main.Conjuntos.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


public class AdministrarUnidadIndependiente {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

//Escenario 1

    @Given("^Se ubiiica el cursor en el campo de Consulta$")
    public void CampoConsulta() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ubica el cursor en el campo consulta",
                "Ubica cursor",
                "Elemento")));

    }

    @When("^Un usuario ingresa una (.*) sobre el campo de consullta$")
    public void IngresaCampoConsulta() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa la palabra clave",
                "Palabra clave",
                "Eleemento")));

    }

    @And("^Daa clic en el icono de buscar$")
    public void ClicbotonBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "el usuario hace clilc en el boton buscar",
                "Hace clic en buscar",
                "Elemento")));

    }

    @Then("^El sistema realiza la búsqueda de las Personas asociadas a la Unidad Independiente que contengan la (.*)$")
    public void Ingresarpalabra() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "formulario crear",
                "Elemento")));

    }

    @And("^Cargar en la lista del buscador de Personas asociadas a la Unidad Independiente el nombre de las Personas obtenidas en la consulta en el orden definido según los campos del \"Entonces” anterior.$")
    public void AsocoUnidad() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }


    //Escenario 2


    @Given("^Da clic sobre la opción Filtross$")
    public void DaClicFiltros() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en la opcion de filtros",
                "da clilc en filtro",
                "Elemento")));

    }

    @When("^Daa clic en cadaa (.*)$")
    public void CadaOpcion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clilc en filtro",
                "Eleemento")));

    }

    @Then("^El sistemaa presenta un (.*) en el campo$")
    public void PresentaCampo() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "formulario crear",
                "Elemento")));

    }

    @And("^Con un tiipo de selección (.*) para el campo$")
    public void TipoDeselector() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));

    }
    //Escenario 3


    @When("^See vayan registrando (.*) en el (.*)$")
    public void RegistraValor() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario registra caracteres en el campo",
                "Caraceres en el campo",
                "Eleemento")));
    }

    @Then("^Se debe mostrar la (.*) autocomplete de Personas asociadas a la Unidad Independiente asociadas al (.*) con los valores que contengan los (.*) registrados actualmente.$")
    public void UnidadIndependiene() {
        actor.should(new QuestionValidate(
                "El sistema muestra lista de autocompletar").Execute(new GeneralParams(
                "Autocompletar lista",
                "Elemento")));
    }
    //Escenario 4

    @When("^See selecciona un (.*) de la (.*) presentada en el (.*)$")
    public void RegistrarValor() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona el elemento de la lista",
                "ingresa elemento ",
                "Eleemento")));
    }

    @Then("^Se debe mostrar el (.*) de la (.*) seleccionado en el mismo nivel que el (.*) con la opcion x para quitar este.$")
    public void UnidadIndependiente() {
        actor.should(new QuestionValidate(
                "El sistema debera mostar el elemento").Execute(new GeneralParams(
                "Muestra el elemento",
                "Elemento")));
    }

    //Escenario 5


    @When("^Daa clic sobre el botón de buscar$")
    public void DeBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clilc en filtro",
                "Eleemento")));

    }

    @Then("^Ell siistema presenta un (.*) que tenga la (.*) del (.*)$")
    public void PresInformacion() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "formulario",
                "Elemento")));

    }

    @And("^En el campo de búsquedaa se presenta la (.*) que se haya seleccionado en el filtro$")
    public void QuesehayaSeleccionado() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }

    @And("^se deben separar por punto y coma ; la <elemento_seleccionado> que se hayan seleccionado en mas de un filtro$")
    public void DebenSepararPunto() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));

    }
    ///Escenario 6

    @When("^Da clic sobre el icono de buscar$")
    public void Buscrelemento() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el icono buscar ",
                "Da clilc en filtro",
                "Eleemento")));

    }

    @Then("^El sistema valida que: Al ingresar más de una (.*) en el campo de consulta, éstas serán concatenadas con AND.  Al seleccionar más de un registro en el mismo filtro se concatenarán con OR. Al ingresar la (.*) en la consulta y seleccionar los registros en uno o más filtro$")
    public void Concatenados() {
        actor.should(new QuestionValidate(
                "El sistema elementos ingresados").Execute(new GeneralParams(
                "valida",
                "Elemento")));

    }

    @And("^se deben separar por punto y coma ; la (.*) que se hayan seleccionado en más de un (.*)$")
    public void Separarpuntoycoma() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }

    @And("^ El sistema presenta una lista con el (.*) de los registros encontrados luego de aplicar la consulta y filtrado respectivo$")
    public void listaResultado() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));

    }

    ///Escenario 7


    @When("^(.*) la tabla de Personas asociadas a la Unidad Independiente$")
    public void TablaUnidadIndependiente() {
        actor.should(new QuestionValidate(
                "El usuario visualiza tabla con personas asociadas a unidad independiente").Execute(new GeneralParams(
                "visualiza tabla ",
                "Eleemento")));

    }

    @Then("^Identifica el label (.*)$")
    public void Identificar() {
        actor.should(new QuestionValidate(
                "El sistema elementos ingresados").Execute(new GeneralParams(
                "valida",
                "Elemento")));

    }

    @And("^El parqueadero asignado$")
    public void Asignado() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }


    ///Escenario 8


    @When("^Da cliic en (.*) de la columna Acciones$")
    public void AccionesColumna() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en acciones",
                "clic en acciones",
                "Eleemento")));

    }

    @Then("^El siistema redirecciona al usuario a la pantalla de (.*)$")
    public void siistemaredi() {
        actor.should(new QuestionValidate(
                "El sistema redirecciona al usuario").Execute(new GeneralParams(
                "valida",
                "Elemento")));
    }


///Escenario 9

    @When("^Da cliic en el botón de Crear Persona$")
    public void CrearPersona() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el icono buscar ",
                "Da clilc en filtro",
                "Eleemento")));

    }

    @Then("^El siistema redirecciona al usuario a la pantalla de Crear Persona asociada a la Unidad Independiente$")
    public void Usuario() {
        actor.should(new QuestionValidate(
                "El sistema elementos ingresados").Execute(new GeneralParams(
                "valida",
                "Elemento")));

    }

///Escenario 10

    @When("^Existen (.*) registros de Personas asociadas a la Unidad Independiente$")
    public void RRegiitrosasoci() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el icono buscar ",
                "Da clilc en filtro",
                "Eleemento")));
    }

    @And("^Se visualiza el paginador en la parte inferior de la páginaa$")
    public void PaginadorInferior() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }

    @Then("^See mostraran los (.*) de los registros asignados por pagina$")
    public void SistemamuestraRegistros() {
        actor.should(new QuestionValidate(
                "El sistema elementos ingresados").Execute(new GeneralParams(
                "valida",
                "Elemento")));

    }
///Escenario 11

    @When("^Daa cliic en el icono de lápiz$")
    public void iconolapiz() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da cliic en el icono lapiz ",
                "Da clilc en filtro",
                "Eleemento")));
    }

    @And("^El sistema abre un pop up para Modificar los datos de la Persona seleccionada$")
    public void modificardatos() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));

    }

    @And("^Se visualizan los campos para Editar el Tipo de Persona, el Nombre de la Persona, el Número de Documento y el Número de Celular$")
    public void Tipopersona() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }

    @And("^Se ingresaa información en (.*)$")
    public void Informacioncampo() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "muestra resultado",
                "Resultado",
                "Elemento")));
    }

    @And("^Se daa clic en el botón Guardar$")
    public void gurdarcampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema muestra el resultado de la busqueda",
                "Dar clic en guardar",
                "Elemento")));
    }

    @Then("^El sistema validará que el Nombre de la Persona asociada sea único en la Unidad Independiente$")
    public void Personaasociada() {
        actor.should(new QuestionValidate(
                "El sistema elementos ingresados").Execute(new GeneralParams(
                "valida",
                "Elemento")));
    }

    @And("^Si se ingresa un (.*) ya existente el sistema mostrará el mensaje: <El nombre de la Persona ya está en uso, por favor ingresar uno diferente>$")
    public void Sistemamuestramensaje() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));

    }

    @And("^Si se ingresa un (.*) ya existente el sistema mostrará el mensaje: El <numero documento> de la Persona ya está en uso, por favor ingresar uno diferente$")
    public void personaenuso () {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));

    }

    @And("^Se habilitará el botón Guardar cuando el usuario haya ingresado correctamente los registros en los campos de Tipo de Persona, Nombre de Persona, Número de documento y número de (.*).$")
    public void Habilitarausuario() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }

    @And("^El pop up se cerrara al dar clic en Guardar o en el icono x ubicado en el costado izquierdo del pop up.$")
    public void CerrarIcono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
              "El usuario da clic en guardar",
              "Guarda informacion",
              "Elemento")));

    }
}