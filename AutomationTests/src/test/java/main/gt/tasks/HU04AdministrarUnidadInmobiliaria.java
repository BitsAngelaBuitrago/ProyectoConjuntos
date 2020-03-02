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

public class HU04AdministrarUnidadInmobiliaria {
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
}
