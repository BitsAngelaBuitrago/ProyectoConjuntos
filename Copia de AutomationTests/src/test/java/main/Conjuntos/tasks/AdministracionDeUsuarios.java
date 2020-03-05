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

public class AdministracionDeUsuarios {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }
    //Escenario 1

    @Given("^Se ubica el cursor en el campo de Consulta$")
    public void consultapalabra() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clic en el campo consulta",
                "hace clic en el campo",
                "//input[@placeholder='Buscar']")));
    }

    @When("^Un usuario ingresa una (.*) sobre el campo de consulta$")
    public void ingresarAUrlcampo() {
        actor.attemptsTo(new EnterTextAction("yoselin").Execute(new GeneralParams(
                "El usuario ingresa la palabra clave en el campo de consulta ",
                "Ingresa la palabra clave",
                "//input[@placeholder='Buscar']")));
    }

    @And("^Da clic icono buscar1$")
    public void buscarIcono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en icono lupa",
                "Icono lupa",
                "//button[@class='ms-Button ms-Button--icon _33tO85F3n_fu7qMMmS4oN3 root-59']//i[@class='ms-Icon root-32 css-53 ms-Button-icon icon-48']")));
    }

    // Escenario 2


    @Given("^se ubica el cursor en el campo de comsulta$")
    public void ubicarCursor() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clic en el campo consulta",
                "hace clic en el campo",
                "//input[@placeholder='Buscar']")));
    }

    @When("^Da clic sobre la opción Filtros$")
    public void filtros() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en la opción de filtros ",
                "clic en la opción filtros",
                "//i[@class='Jx4bHvtJ0c1edTu-0ULVd root-62']")));
    }

    @And("^Da clic en cada(.*)$")
    public void ingresarAlaUrl() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    @Then("^El sistema presenta un (.*) en el campo y un tipo de (.*)$")
    public void resultadoSeleccion() {
        actor.should(new QuestionValidate(
                "El sistema presenta un campo y un tipo de seleccion").Execute(new GeneralParams(
                "El sistema presenta filtro",
                "elemento")));
    }
//escenario 3

    @When("^Se vayann registrando los (.*) en el (.*)$")
    public void registrarCaracteres() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema visualiza resultado registrado",
                "resultado registrado",
                "Elemento")));

    }

    @Then("^Se debe mostrar la (.*) autocomplete de Usuarios asociados al (.*) con los valores que contengan los (.*) registrados actualmente$")
    public void autocomplete() {
        actor.should(new QuestionValidate(
                "El sistema autocompleta filtro").Execute(new GeneralParams(
                "Autocompletar filtro",
                "elemento")));
    }

//escenario 4


    @When("^Se selecciiona un (.*) de la (.*) presentada en el (.*)$")
    public void PessentaElemento() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona un elemento en la lista",
                "Selecciona elemento",
                "elemento")));
    }

    @Then("^Se debe mostrar el (.*) de la (.*) seleccionado en el mismo niivel que el (.*) con la opción x para quitar éste.$")
    public void resultadoSel() {
        actor.should(new QuestionValidate(
                "El sistema muestra lista").Execute(new GeneralParams(
                "Muestra lista",
                "elemento")));
    }

    @And("^Debe mostar los (.*)$")
    public void elementos() {
        actor.should(new QuestionValidate(
                "El sistema muestra datos del elemento").Execute(new GeneralParams(
                "Muestra datos",
                "elemento")));
    }
//escenario 5

    @When("^Da cliic en el botón de buscarrr$")
    public void daBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton buscar",
                "Selecciona elemento",
                "elemento")));
    }

    @Then("^El siistema presenta unn (.*) que tenga la información del (.*)$")
    public void resulgtadoFiltro() {
        actor.should(new QuestionValidate(
                "El sistema presenta resultado").Execute(new GeneralParams(
                "Muestra lista",
                "elemento")));
    }

    @And("^En el campo de búsqueda se presenta la (.*) que se haya seleccionado en el fiiltro$")
    public void busquedaPresenta() {
        actor.should(new QuestionValidate(
                "El sistema muestra el elemento seleccionado").Execute(new GeneralParams(
                "Muestra datos",
                "elemento")));
    }

    @And("^se deben separarr por punto y como ; la (.*) que se hayan seleccionado en más de un filtro$")
    public void seppararpor() {
        actor.should(new QuestionValidate(
                "El sistema muestra datos del elemento").Execute(new GeneralParams(
                "Muestra datos",
                "elemento")));
    }

//escenario 6

    @When("^Da clic en icono de buscarr$")
    public void daClilcIBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el icono buscar",
                "Dar clic buscar",
                "elemento")));
    }

    @Then("^El sistema valida que al ingresar más de una (.*) en el campo de consulta, éstas serán concatenadas con AND$")
    public void seranconcatenadas() {
        actor.should(new QuestionValidate(
                "El sistema presenta palabra clave").Execute(new GeneralParams(
                "Muestra lista",
                "elemento")));
    }

    @And("^se deben separar por punto y coma la (.*) que se hayan seleccionado en más de un (.*)$")
    public void seleccionFiltro() {
        actor.should(new QuestionValidate(
                "El usuario debe separar por ; la busqueda").Execute(new GeneralParams(
                "Separar por ;",
                "elemento")));
    }

    @And("^El sistema presenta una lista con el (.*) de los usuarios encontrados (.*) luego de aplicar la consulta y filtrado respectivo$")
    public void elsistemaPresentaLista() {
        actor.should(new QuestionValidate(
                "El sistema muestra el resultado de la busqueda").Execute(new GeneralParams(
                "Muestra el resultado busqueda",
                "elemento")));
    }

//escenario 7

    @When("^Visualiza la tabla de Usuarios$")
    public void daC() {
        actor.should(new QuestionValidate(
                "El usuario visualiza la tabla de usuarios").Execute(new GeneralParams(
                "Muestra tabla",
                "elemento")));
    }

    @Then("^Identifiica la columna (.*)$")
    public void identificaColumna() {
        actor.should(new QuestionValidate(
                "El sistema identifica columna").Execute(new GeneralParams(
                "Muestra lista",
                "elemento")));
    }

    @And("^Se (.*) en la columna Accion primero todos los usuarios de Ingreso y luego los de Salida.$")
    public void visualizarIngresoSalida() {
        actor.should(new QuestionValidate(
                "El usuario visualiza ingreso y salida").Execute(new GeneralParams(
                "visualiza;",
                "elemento")));
    }

//escenario 8

    @When("^Da clic en (.*) de la columna Acciiiones$")
    public void daClilcI() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el icono en la columna acciones",
                "Dar clic columna",
                "elemento")));
    }

    @Then("^El sistema realiza la (.*)$")
    public void seranco() {
        actor.should(new QuestionValidate(
                "El sistema presenta la accion").Execute(new GeneralParams(
                "Presenta Accion",
                "elemento")));
    }
    //escenario 9


    @When("^Da cliiic en ell (.*) Usuario$")
    public void botonCrearr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en en boton crear",
                "Dar clic boton crear",
                "elemento")));

    }

    @Then("^El sistema redirecciona al usuariiio a la pantalla de Creación de Usuarios$")
    public void PantallaCreacion() {
        actor.should(new QuestionValidate(
                "El sistema presenta pantalla de usuario").Execute(new GeneralParams(
                "Presenta Accion",
                "elemento")));
    }

    //escenario 10


    @When("^Exiisten (.*) usuarios de De Usuarios$")
    public void ExistenUsuario() {
        actor.should(new QuestionValidate(
                "El usuario visualiza usuarios").Execute(new GeneralParams(
                "visualiza usuarios;",
                "elemento")));
    }
    @And("^Se visualiza el paginador en la parte inferiior de la página$")
    public void paginadorInferior() {
        actor.should(new QuestionValidate(
                "El usuario visualiza paginador").Execute(new GeneralParams(
                "visualiza paginador;",
                "elemento")));
    }

    @Then("^Se mostraran los usuarios asignados por pagiina$")
    public void asigancionPagina() {
        actor.should(new QuestionValidate(
                "El sistema presenta usuarios").Execute(new GeneralParams(
                "Presenta usuaarios",
                "elemento")));
    }


}