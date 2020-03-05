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


    @When("^Se selecciona uun <elemento> de la <lista> presentada en el <filtro>$")
    public void caracteresEnElFiltro() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario debera ingresar los caracteres en el filtro",
                "ingresar caracteres",
                "Eleemento")));
    }

    @Then("^Se debe mostrar el <elemento> de la <lista> seleccionado en el mismo nivel que el <filtro> con la opción (x) para quitar éste$")
    public void mostarListaAuto() {
        actor.should(new QuestionValidate(
                "El sistema debera presentar una lista de parqueaderos asociados").Execute(new GeneralParams(
                "el sistema presenta resultado",
                "Elemento")));
    }










}



















