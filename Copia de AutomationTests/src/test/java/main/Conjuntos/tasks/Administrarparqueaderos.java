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

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class Administrarparqueaderos {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

///Escenario 1

    @Given("^Se ubica el cursor en el campo de Consultaa$")
    public void cursorConsulta() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ubica el cursor en el campo consulta",
                "Ubica cursor",
                "Elemento")));

    }

    @When("^Un usuario ingresa una (.*) sobre el campo de consultaa$")
    public void unCampoConsult() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa la palabra clave",
                "Palabra clave",
                "Eleemento")));

    }

    @And("^Da cliic en el icono de buscarr$")
    public void clicBuuscarr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "el usuario hace clilc en el boton buscar",
                "Hace clic en buscar",
                "Elemento")));

    }

    @Then("^El sistema realiza la búsqueda de Parqueaderos que contengan la (.*) en los siguientes campos, concatenados con el operador OR y en el orden establecido$")
    public void sistemaBusqueda() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "formulario crear",
                "Elemento")));

    }

    @And("^Cargar en la lista del buscador de Parqueaderos el número de los Parqueaderos obtenidos en la consulta en el orden definido según los campos del \"Entonces” anterior$")
    public void obtenidosConsulta() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "muestra el listado",
                "Elemento")));
    }

///Escenario 2

    @Given("^Da cliic sobre la opción Filtross$")
    public void administarHacerClic() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc enl a opcion de filtros",
                "da clilc en la opciion de filtros",
                "Elemento")));

    }

    @When("^Da cliic en cadaa (.*)$")
    public void parqueaderoFiltro() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "clilc en cada filtro",
                "Eleemento")));

    }

    @Then("^El siistema presentaa un (.*) en el campoo$")
    public void campoUnCampo() {
        actor.should(new QuestionValidate(
                "El sistema presenta debe presentar un resultado").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));

    }

    @And("^Con un tiipo de selección (.*) para el campoo$")
    public void elCampoTipoSeleccion() {
        actor.should(new QuestionValidate(
                "El sistema muestra el tipo de seleccion en el campo").Execute(new GeneralParams(
                "Tipo de seleccion ene l campo",
                "Elemento")));
    }

    ///Escenario 3

    @When("^Se vayann registrando (.*) en el (.*)$")
    public void caracteresEnElFiltro() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario debera ingresar los caracteres en el filtro",
                "ingresar caracteres",
                "Eleemento")));

    }
    @Then("^Se debe mostrar la <lista> autocomplete de De Parqueaderos asociados al <filtro> con los valores que contengan los <caracteres> registrados actualmente$")
    public void mostarListaAuto() {
        actor.should(new QuestionValidate(
                "El sistema debera presentar una lista de parqueaderos asociados").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));
    }


    ///Escenario 4


    @When("^Se selecciona uun elemento de la lista presentada en el (.*)$")
    public void presentaUnElemenentoYloSelecciona() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario debera ingresar los caracteres en el filtro",
                "ingresar caracteres",
                "Eleemento")));
    }

    @Then("^Se debe mostrar el elemento de la lista seleccionado en el mismo nivel que el (.*) con la opcion x para quitar este$")
    public void SeleccionadoParaQuitarElemento() {
        actor.should(new QuestionValidate(
                "El sistema debera presentar una lista de parqueaderos asociados").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));
    }

///Escenario 5

    @When("^Da clic ssobre el botón de buscar$")
    public void userClickBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clic en el boton guardar",
                "Hace clilc en guardar",
                "Eleemento")));
    }

    @Then("^El sistema presentaa un (.*) que tenga la (.*) del (.*)$")
    public void presentResult() {
        actor.should(new QuestionValidate(
                "El sistema debera presentar la informacion de los filtros").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));
    }

    @And("^En el campo de búsquedaa se presenta la <elemento_seleccionado> que se haya seleccionaado en el filtro$")
    public void optionDelFiltro() {
        actor.should(new QuestionValidate(
                "El sistema presenta el elemento seleccionado").Execute(new GeneralParams(
                "Tipo de seleccion ene l campo",
                "Elemento")));

    }

    @And("^separar por punto y coma (;) la <elemento_seleccionado> que se hayan seleccionado en mas de un filtro$")
    public void separarHayanElemento() {
        actor.should(new QuestionValidate(
                "El sistema muestra el elemento seleccionad").Execute(new GeneralParams(
                "Tipo de seleccion ene l campo",
                "Elemento")));

    }

///Escenario 6

    @When("^Da clic sobre el icono de buscarr$")
    public void bucasPalabrasClaves() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clic en el boton guardar",
                "Hace clilc en guardar",
                "Eleemento")));
    }

    @Then("^Al ingresar mas de una <palabra_clave> en el campo de consulta, estas seran concatenadas con AND, Al seleccionar mas de un registro en el mismo <filtro> se concatenaran con OR, Al ingresar la <palabra_clave> en la consulta y seleccionar los registros en uno o mas filtros$")
    public void filtroSeConcatena() {
        actor.should(new QuestionValidate(
                "El sistema debera presentar la informacion de los filtros").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));
    }

///Escenario 7

    @When("^Visualiza la tabla de Parqueaderos$")
    public void verTablaParqueadero() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotVisible()));

    }

    @Then("^Identifica lla columna (.*)$")
    public void identificarColumnas() {
        actor.should(new QuestionValidate(
                "El sistema debera presentar la informacion de los filtros").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));
    }

    ///Escenario 8


    @When("^Da clic en <Icono> de la columna Acciones$")
    public void clicColumna() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en la columna acciones",
                "columna accion",
                "Elemento")));
    }

    @Then("^El sistema realiza la <Acción>$")
    public void elementoColumnaAccion() {
        actor.should(new QuestionValidate(
                "El sistema realizara la accion").Execute(new GeneralParams(
                "realiza la accion",
                "Elemento")));
    }

    ///Escenario 9

    @When("^Se encuentra con Parqueaderos por crear$")
    public void botonCrearParqueadero() {
        actor.should(new QuestionValidate(
                "El usuario da clic en la columna acciones").Execute(new GeneralParams(
                "columna accion",
                "Elemento")));
    }

    @And("^El botón Crear se encuentra Activo$")
    public void botonSeEncuntraAct() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotVisible()));

    }

    @And("^Da clic en el botón de Crear Persona$")
    public void deCrearPersona() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema muestra el elemento seleccionad",
                "Tipo de seleccion ene l campo",
                "Elemento")));
    }

    @Then("^El sistema redirecciona al usuario a la pantalla de Crear Persona asociada a la Parqueaderos$")
    public void redireccionaCrearparqueaderos() {
        actor.should(new QuestionValidate(
                "El sistema realizara la accion").Execute(new GeneralParams(
                "realiza la accion",
                "Elemento")));
    }

    ///Escenario 10

    @When("^Existen <n> registros de De Parqueaderos$")
    public void registroDeparqueaderos() {
        actor.should(new QuestionValidate(
                "El usuario da clic en la columna acciones").Execute(new GeneralParams(
                "columna accion",
                "Elemento")));
    }

    @And("^Se visualiza el paginador en la parte inferior de la página$")
    public void inferiorDeLaPagina() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema muestra el elemento seleccionad",
                "Tipo de seleccion ene l campo",
                "Elemento")));
    }
    @And("^Se da clic en <número>$")
    public void inferiorPagina() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema muestra el elemento seleccionad",
                "Tipo de seleccion ene l campo",
                "Elemento")));

    }
    @Then("^Se mostrarán los registros asignados por página$")
    public void registrosAsignados () {
        actor.should(new QuestionValidate(
                "El sistema realizara la accion").Execute(new GeneralParams(
                "realiza la accion",
                "Elemento")));

    }

 }
