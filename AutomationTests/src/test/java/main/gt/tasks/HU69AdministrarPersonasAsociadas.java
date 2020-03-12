package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU69AdministrarPersonasAsociadas {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://selfcarecvgt-stg-gt.tigocloud.net/")));

    }

    @And("^Inicia sesión$")
    public void iniciarSesion() {
        actor.attemptsTo(new EnterTextAction("jbarbosam").Execute(new GeneralParams(
                "Usuario ingresa texto en el campo usuario",
                "Campo usuario",
                "//input[@id='idEmail']"
        )));

        actor.attemptsTo(new EnterTextAction("TigoTest123#").Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@id='password']"
                )
        ));

    }

    @And("^Da clic en Administrar Personas Asociadas a Unidad Independiente$")
    public void daClicEnAdministrarPersonasAsociadasAUnidadIndependiente() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Administrar personas asociadas",
                "Administrar personas asociadas",
                "//input[@id='password']"
        )));
    }

    @Then("^El sistema muestra la informacion de las Personas Asociadas a Unidad Independiente$")
    public void elSistemaMuestraLaInformacionDeLasPersonasAsociadasAUnidadIndependiente() {
        //campo de búsqueda
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Tabla de personas asociadas
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Botón crear persona
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Acción COnsultar
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Acción Editar
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Paginador
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @Given("^El usuario Da clic sobre la opción Filtros$")
    public void elUsuarioDaClicSobreLaOpcionFiltros() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en filtros",
                "Ingreso filtros",
                "//input[@id='password']"
        )));
    }

    @When("^Da clic en cada (.*)$")
    public void daClicEnCadaFiltro(String filtro) {
        switch (filtro) {
            case "Tipo de persona":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@id='password']"
                )));
                break;
            case "Documento":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//inpu t[@id='password']"
                )));
                break;
            case "Nombre":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@id='passw ord']"
                )));
                break;
        }
    }

    @Then("^El sistema presenta el listado del (.*) seleccionado$")
    public void elSistemaPresentaElListadoDelFiltroSeleccionado(String filtro) {
        switch (filtro) {
            case "Tipo de persona":
                actor.should(new QuestionValidate(filtro).Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@id='password']"
                )));
                break;
            case "Documento":
                actor.should(new QuestionValidate(filtro).Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@id='pa sword']"
                )));
                break;
            case "Nombre":
                actor.should(new QuestionValidate(filtro).Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@id='passw ord']"
                )));
                break;
        }
    }

    @And("^Se ingresa <informacion> en el (.*)$")
    public void seIngresaInformacionEnElFiltro(String filtro, String informacion) {
        switch (filtro) {
            case "Tipo de persona":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@id='password']"
                )));
                break;
            case "Documento":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//inp ut[@id='password']"
                )));
                break;
            case "Nombre":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da clic en filtros",
                        "Ingreso filtros",
                        "//input[@ id='password']"
                )));
                break;
        }
    }

    @And("^se muestra el (.*)$")
    public void seMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Usuario da clic en filtros",
                "Ingreso filtros",
                "//input[@id='password']"
        )));
    }

    @When("^Da clic en Crear Persona asociada$")
    public void daClicEnCrearPersonaAsociada() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en crear persona",
                "crear persona",
                "//input[@id='password']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Crear Persona asociada$")
    public void elSistemaRedireccionaALaPaginaDeCrearPersonaAsociada() {
        actor.should(new QuestionValidate("Crear Persona Asociada").Execute(new GeneralParams(
                "Página Crear persona Asociada",
                "Crear Persona Asociada",
                "//input[@id='password']"
        )));
    }

}
