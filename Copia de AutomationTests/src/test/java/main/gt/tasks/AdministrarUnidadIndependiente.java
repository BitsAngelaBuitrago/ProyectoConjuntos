package main.gt.tasks;

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
import net.serenitybdd.screenplay.actions.EnterValueIntoElement;
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

    @Given("^$")
    public void NuevaPaginau() {
        actor.should(new QuestionValidate(
                "El usuario se encuentra en la pagina administracion").Execute(new GeneralParams(
                "Pagina administracion",
                "Elemento")));

    }

    @When("^$")
    public void BotondeCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton crear",
                "clic en boton crear",
                "Eleemento")));
    }

    @Then("^$")
    public void presentaformulario() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "formulario crear",
                "Elemento")));

    }

    @And("^$")
    public void botonbloqueadoo() {
        actor.should(new QuestionValidate(
                "El sistema presenta el boton guardar bloqueado").Execute(new GeneralParams(
                "boton guardar bloqueado",
                "Elemento")));
    }

