package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU04AdministrarUnidadInmobiliaria {
    Actor actor;


    @And("^Da clic sobre la unidad inmobiliaria Bits$")
    public void daClicSobreLaUnidadInmobiliariaBits() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre la unidad",
                "Botón Administrar Unidad",
                "/input[@id='password']"
        )));
    }

    @Then("^El sistema muestra la informacion de la Unidad Inmobiliaria$")
    public void elSistemaMuestraLaInformacionDeLaUnidadInmobiliaria() {
        // Filtro de búsqueda
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Etiqueta ‘Administración de Unidad Inmobiliaria’
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Botón Crear Agrupación
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Paginación
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));

    }

    @When("^Da clic en Crear Agrupacion$")
    public void daClicEnCrearAgrupacion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre crear Agrupación",
                "Botón Crear Agrupación",
                "/input[@id='password']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Crear Agrupacion$")
    public void elSistemaRedireccionaALaPaginaDeCrearAgrupacion() {
        actor.should(new QuestionValidate("Crear Agrupación").Execute(new GeneralParams(
                "Página crear agrupación",
                "pagina crear agrupación",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic sobre el filtro Agrupaciones de Unidad Inmobiliaria$")
    public void daClicSobreElFiltroAgrupacionesDeUnidadInmobiliaria() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre Filtro Agrupación",
                "Filtro Agrupación",
                "/input[@id='password']"
        )));
    }

    @Then("^El sistema presenta el listado de las agrupaciones$")
    public void elSistemaPresentaElListadoDeLasAgrupaciones() {
        actor.should(new QuestionValidate("listado Agrupación").Execute(new GeneralParams(
                " Listado agrupación",
                "listado agrupación",
                "//button[@name='action']"
        )));
    }

    @And("^En Agrupacion Se ingresa (.*)$")
    public void enAgrupacionSeIngresaInformacion(String informacion) {
        actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                "Ingresa información agrupación",
                "Ingresa agrupación",
                "//button[@name='action']"
        )));
    }

    @Then("^En Agrupacion muestra el (.*)$")
    public void enAgrupacionMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                " Resultado Listado agrupación",
                "Resultado listado agrupación",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en Parqueaderos$")
    public void daClicEnParqueaderos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Parqueaderos",
                "Administrar Parqueaderos",
                "/input[@id='password']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Administrar Parqueaderos$")
    public void elSistemaRedireccionaALaPaginaDeAdministrarParqueaderos() {
        actor.should(new QuestionValidate("Administrar Parqueaderos").Execute(new GeneralParams(
                " página Administrar parqueaderos",
                "Administrar parqueaderos",
                "//button[@name='action']"
        )));
    }
}
